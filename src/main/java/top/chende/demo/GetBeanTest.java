package top.chende.demo;

import com.google.gson.Gson;
import top.chende.bean.BeanDescription;
import top.chende.bean.SimpleProperty;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author: chende
 * @date: 2019/5/8 10:25
 * @description: 读配置文件 并初始化bean
 */
public class GetBeanTest {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("/Users/chende/Desktop/jsonconf.txt");
        Gson gson = new Gson();
        BeanDescription bd = gson.fromJson(fr, BeanDescription.class);
        System.out.println(bd.getClassname());
        System.out.println("id:" + bd.getId());
        System.out.println(" pro:name-->" + bd.getSimpleProperties().get(1).getName() + " pro:value--> " + bd.getSimpleProperties().get(1).getValue());
        //从BeanDescription对象  构建bean
        //1. 获取class对象
        try {
            Class beanclass=Class.forName(bd.getClassname());
            Object bean= null;
            //2.注入属性 先搞普通属性
            try {
                bean = beanclass.getConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            for( SimpleProperty simpleProperty:bd.getSimpleProperties()){
                Field field= null;
                try {
                    field = beanclass.getDeclaredField(simpleProperty.getName());
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                Method method= null;
                try {
                    method = beanclass.getDeclaredMethod(simpleProperty.getSetMethodName(),field.getType());
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                //需要类型转换

                //先搞编码
                Type type=field.getType();
                
                System.out.println(type.getTypeName());
                method.invoke(bean,simpleProperty.getValue());
            }
            System.out.println("完成bean注入："+bean.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
