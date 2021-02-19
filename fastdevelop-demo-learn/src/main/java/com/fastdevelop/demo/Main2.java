package com.fastdevelop.demo;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import sun.plugin.dom.css.Counter;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main2 {


    @Test
    public void t4(){
    }

    @Test
    public void t3(){
        Properties props=System.getProperties(); //系统属性
        System.out.println("Java的运行环境版本："+props.getProperty("java.version"));
        System.out.println("Java的运行环境供应商："+props.getProperty("java.vendor"));
        System.out.println("Java供应商的URL："+props.getProperty("java.vendor.url"));
        System.out.println("Java的安装路径："+props.getProperty("java.home"));
        System.out.println("Java的虚拟机规范版本："+props.getProperty("java.vm.specification.version"));
        System.out.println("Java的虚拟机规范供应商："+props.getProperty("java.vm.specification.vendor"));
        System.out.println("Java的虚拟机规范名称："+props.getProperty("java.vm.specification.name"));
        System.out.println("Java的虚拟机实现版本："+props.getProperty("java.vm.version"));
        System.out.println("Java的虚拟机实现供应商："+props.getProperty("java.vm.vendor"));
        System.out.println("Java的虚拟机实现名称："+props.getProperty("java.vm.name"));
        System.out.println("Java运行时环境规范版本："+props.getProperty("java.specification.version"));
        System.out.println("Java运行时环境规范供应商："+props.getProperty("java.specification.vender"));
        System.out.println("Java运行时环境规范名称："+props.getProperty("java.specification.name"));
        System.out.println("Java的类格式版本号："+props.getProperty("java.class.version"));
        System.out.println("Java的类路径："+props.getProperty("java.class.path"));
        System.out.println("加载库时搜索的路径列表："+props.getProperty("java.library.path"));
        System.out.println("默认的临时文件路径："+props.getProperty("java.io.tmpdir"));
        System.out.println("一个或多个扩展目录的路径："+props.getProperty("java.ext.dirs"));
        System.out.println("操作系统的名称："+props.getProperty("os.name"));
        System.out.println("操作系统的构架："+props.getProperty("os.arch"));
        System.out.println("操作系统的版本："+props.getProperty("os.version"));
        System.out.println("文件分隔符："+props.getProperty("file.separator"));  //在 unix 系统中是＂／＂
        System.out.println("路径分隔符："+props.getProperty("path.separator"));  //在 unix 系统中是＂:＂
        System.out.println("行分隔符："+props.getProperty("line.separator"));  //在 unix 系统中是＂/n＂
        System.out.println("用户的账户名称："+props.getProperty("user.name"));
        System.out.println("用户的主目录："+props.getProperty("user.home"));
        System.out.println("用户的当前工作目录："+props.getProperty("user.dir"));

    }

    @Test
    public void t1() {
        Properties properties = System.getProperties();
        System.out.println(JSONUtil.toJsonPrettyStr(properties));
        System.out.println(properties.getProperty("user.dir"));
    }

    @Test
    public void t2() {
        AtomicInteger ai = new AtomicInteger(0);
        System.out.println(ai.get());
        System.out.println(ai.getAndAdd(1));
    }

    static AtomicInteger ai = new AtomicInteger(1);
    static AtomicInteger ai1 = new AtomicInteger();

    public static void main(String[] args) {
        // 获取当前值。
        System.out.println(ai1.get());
        // 以原子方式将给定值与当前值相加，返回更新后的值
        System.out.println(ai1.addAndGet(1));
        // 如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值,返回值为波尔类型 当前值 == 预期值
        System.out.println(ai1.compareAndSet(12, 100));
        System.out.println(ai1.get());
        //  以原子方式将当前值减 1。返回更新值
        System.out.println(ai1.decrementAndGet());
        // 以 double 形式返回指定的数值。
        System.out.println(ai1.doubleValue());
        //以 float 形式返回指定的数值。
        System.out.println(ai1.floatValue());

        // 以原子方式将给定值与当前值相加。返回以前的值
        System.out.println(ai1.getAndAdd(100));
        System.out.println(ai1.get());
        // 以原子方式将当前值减 1。返回以前的值
        System.out.println(ai1.getAndDecrement());
        System.out.println(ai1.get());

        // 以原子方式将当前值加 1。
        Console.log("{} , {} ", ai1.getAndIncrement(), ai1.get());


//
//        System.out.println(ai.get());
//        System.out.println(ai.getAndIncrement());
//        System.out.println(ai.get());
        try {
            TimeUnit.SECONDS.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
