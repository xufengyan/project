package com.xf.project.admin.controller.test.dome02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xf
 * @version 1.0
 * @date 2021/3/30 16:37
 */
public class test {

    @myAnnoaction
    public void test01(){

    }
}


@Target({ElementType.TYPE,ElementType.METHOD})//作用域ElementType.TYPE作用在类上，ElementType.METHOD作用在方法上
@Retention(RetentionPolicy.RUNTIME)
@interface myAnnoaction{
    //注解的参数：
    String name() default "";
    int id() default -1;//默认值为-1，代表不存在
}
