package com.fastdevelop.biz.web.controller;

import cn.hutool.core.util.IdUtil;
import com.fastdevelop.common.res.JsonResult;
import com.fastdevelop.db.mapper.ChapterDOMapper;
import com.fastdevelop.db.model.ChapterDO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Resource
    ChapterDOMapper chapterDOMapper;

    @PostMapping("/insertSelective")
    public JsonResult<Boolean> insertSelective(@RequestBody ChapterDO chapterDO) {
        chapterDO.setId(IdUtil.simpleUUID());
        return chapterDOMapper.insertSelective(chapterDO) > 0 ? JsonResult.<Boolean>builder().success().build(): JsonResult.<Boolean>builder().failure().build();
    }
}
