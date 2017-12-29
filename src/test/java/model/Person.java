package model;

import sun.reflect.Reflection;

import java.io.Serializable;

/**
 * Person类
 *
 * @author xch
 * @version 1.00
 * @date 2017-12-28
 */
public class Person implements Serializable{

    private Son son = new Son();

    public void printCallClass() {
        System.out.println(Reflection.getCallerClass());
    }

    public class Son {
        public void printClass() {
            System.out.println(Reflection.getCallerClass());
        }
    }
}
