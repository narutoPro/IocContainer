package top.chende.inject;

import top.chende.demo.Demo;
import top.chende.demo.Demo22;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: chende
 * @date: 2019/5/5 20:26
 * @description: 利用java反射API注入属性
 */
public class InjectByReflection {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class demoClass=Class.forName("top.chende.demo.Demo22");
       // System.out.println(demoClass.getSimpleName());
        try {
           // Class d=Demo.class;
            Demo22 dd= (Demo22) demoClass.getConstructor().newInstance();
            Field[] fields=demoClass.getDeclaredFields();
            Method  m=demoClass.getDeclaredMethod("setName",String.class);
            m.setAccessible(true);
            m.invoke(dd,"吴迪");
            for (Field f:fields
                 ) {
                System.out.println(f.getName());
            }
            dd.setAge(27);
            dd.setName("chende");
            dd.setRef(new Demo());
            System.out.println(dd.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
