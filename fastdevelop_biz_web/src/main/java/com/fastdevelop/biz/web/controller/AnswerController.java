package com.fastdevelop.biz.web.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.fastdevelop.common.res.JsonResult;
import com.fastdevelop.db.mapper.AnswerMapper;
import com.fastdevelop.db.model.Answer;
import com.fastdevelop.db.model.AnswerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerMapper mapper;


    /**
     * 根据答案id列表和问题id,删除答案
     * {
     *   "ids": "fd3882e4073c4b09a41dff6355a08f98",
     *   "qId":"ffdfd"
     * }
     * @param jsonObject
     * @return
     */
    @PostMapping("/deleteAnswer")
    public JsonResult<Boolean> deleteAnswer(@RequestBody JSONObject jsonObject){
        String qId = jsonObject.getString("qId");
        List<String> idList = Arrays.stream(jsonObject.getString("ids").split(",")).filter(StrUtil::isEmpty).distinct().collect(Collectors.toList());
        AtomicInteger idCount = new AtomicInteger(idList.size());
        AnswerExample example = new AnswerExample();
        AnswerExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(idList);
        criteria.andQIdEqualTo(qId);
        int i = mapper.deleteByExample(example);
        return idCount.compareAndSet(i,idCount.get()) ? JsonResult.<Boolean>builder().success().build() : JsonResult.<Boolean>builder().failure().build();
    }

    @GetMapping("/listAnswers")
    public JsonResult<List<Answer>> listAnswers( @RequestParam(value = "projectId") String projectId){
        AnswerExample example = new AnswerExample();
        example.setOrderByClause("num asc");
        AnswerExample.Criteria criteria = example.createCriteria();
        criteria.andQIdEqualTo(projectId);
        List<Answer> answerList = mapper.selectByExample(example);
        answerList.forEach(answer -> {
            byte[] content = answer.getContent();
            if (ObjectUtil.isNotEmpty(content))
            {
                String str = StrUtil.str(content, Charset.defaultCharset());
                answer.setContentStr(str);
                answer.setContent(null);
            }
        });
        return JsonResult.<List<Answer>>builder().success(answerList).build();

    }

    @PostMapping("/save")
    public JsonResult<Boolean> save(@RequestBody Answer answer) {
        int i;
        String id = answer.getId();
        String contentStr = answer.getContentStr();
        if (StrUtil.isEmpty(contentStr)) {
            return JsonResult.<Boolean>builder().failure("多少写一点儿吧").build();
        }
        if (StrUtil.isEmpty(id)) {
            /*新增*/
            String uuid = IdUtil.fastSimpleUUID();
            answer.setId(uuid);
            answer.setContent(StrUtil.bytes(contentStr, Charset.defaultCharset()));
            i = mapper.insertSelective(answer);
        } else {
            i = mapper.updateByPrimaryKeySelective(answer);
        }
        return i > 0 ? JsonResult.<Boolean>builder().success(true).build() : JsonResult.<Boolean>builder().failure(
                StrUtil.isEmpty(id) ? "新增失败":"更新失败"
        ).build();

    }

}
