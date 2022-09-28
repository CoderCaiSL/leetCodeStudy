package com.example.leetcodestudy.algorithm.simple;

import java.lang.reflect.Field;

/**
 * @author: CaiSongL
 * @date: 2022/5/11 10:48
 */
class UserJava {

    public static String DEX_NAME = "测试";
    private final String name = "BOB";
    private final UserJava userJava = new UserJava();


    public String getName() {
        return name;
    }

    public UserJava getUserJava() {
        return userJava;
    }


    public static void main(String[] args) {

        UserJava userJava = new UserJava();
        Class clz = UserJava.class;
        Field field = null;
        try {
            field = clz.getDeclaredField("name");
            field.setAccessible(true);
            field.set(userJava,"测试");
            //正常方式获取修改final值后的参数
            System.out.print("反射测试"+userJava.name);
            //正确获取修改final值后的参数
            System.out.print("反射测试"+field.get(null));
            field = clz.getDeclaredField("userJava");
            field.setAccessible(true);
            field.set(userJava,new UserJava());
            System.out.print("反射测试"+userJava.userJava);
            //修改静态字段
            field = clz.getDeclaredField("DEX_NAME");
            field.setAccessible(true);
            System.out.print("静态反射修改前"+field.get(null)+"//"+UserJava.DEX_NAME);
            field.set(null,"修改值");
            System.out.print("静态反射修改后"+UserJava.DEX_NAME);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}



