package com.xf.project.admin.controller.test.dome02;

/**
 * 反射学习
 * @author xf
 * @version 1.0
 * @date 2021/3/30 16:54
 */
public class ReflectionTest01 extends Object{

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        一个类在内存中只有一个class对象
//        一个类被加载后，类的整个结构都封装在一个class中
        Class c1 = Class.forName("com.xf.project.admin.controller.test.dome02.User");
        c1.getAnnotations();//获的所有的注解、
        c1.newInstance();

    }
}

class User{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
