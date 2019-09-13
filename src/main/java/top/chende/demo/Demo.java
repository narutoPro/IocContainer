package top.chende.demo;

import java.io.Serializable;

/**
 * @author: chende
 * @date: 2019/5/4 16:42
 * @description:
 */
public class Demo  {

    public  String name;

    public  int age;

    private char sex;

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Demo(){};

    public Demo(String name,int age){
        this.name=name;
        this.age=age;
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
        return "name:"+name+"  age:"+age+"sex:"+sex;
    }
}
