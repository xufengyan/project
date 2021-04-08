package com.xf.project.admin.controller.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xf
 * @version 1.0
 * @date 2021/3/29 17:21
 */

/**
 * 代理类，
 * 实现InvocationHandler接口，实现代理方法
 */
public class ProxyInvocationHandler implements InvocationHandler {

    //需要代理的类 Object通用类
    private Object trager;

    public void setTrager(Object trager) {
        this.trager = trager;
    }

    /**
     * 生成代理类
     * @return
     */
    public Object getProxy(){
        /**
         * 参数一：当前代理对象的class
         * 参数二：要代理的接口
         * 参数三：当前代理对象
         */
       return Proxy.newProxyInstance(this.getClass().getClassLoader(),trager.getClass().getInterfaces(),this);
    }

    //处理代理实例，返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("挡当前代理的方法："+method.getName());
        //代理的本质就是使用反射
        Object invoke = method.invoke(trager, args);
        log();
        //返回代理对象的调用
        return invoke;
    }

    public void log(){
        System.out.println("执行日志操作");
    }
}
