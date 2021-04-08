package com.xf.project.admin.controller.test.demo01;

import com.xf.project.admin.controller.test.proxy.ProxyInvocationHandler;

/**
 * @author xf
 * @version 1.0
 * @date 2021/3/29 17:35
 */
public class client {

    public static void main(String[] args) {
        //被代理的对象
        UserServiceImpl userService = new UserServiceImpl();
        //代理对象
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        //设置需要代理的对象
        handler.setTrager(userService);
        //返回代理对象
        UserService proxy = (UserService) handler.getProxy();

        proxy.add();
    }

}
