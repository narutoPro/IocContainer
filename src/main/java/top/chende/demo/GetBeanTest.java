package top.chende.demo;

import com.google.gson.Gson;
import top.chende.bean.BeanDescription;
import top.chende.bean.RefProperty;
import top.chende.bean.SimpleProperty;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: chende
 * @date: 2019/5/8 10:25
 * @description: 读配置文件 并初始化bean
 */
public class GetBeanTest {

    Map<String,Object> instances=new HashMap<>();
    // key beanName即bean id  value对应的BeanDescription
    Map<String,BeanDescription> beanDefinitionHolder=new HashMap<>();

    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("/Users/chende/Desktop/jsonconf.txt");
        Gson gson = new Gson();
        BeanDescription bd = gson.fromJson(fr, BeanDescription.class);
       //从BeanDescription对象  构建bean
        //1. 获取class对象
        try {
            System.out.println("id: "+bd.getId()+"  className:"+bd.getClassname());
            Class beanclass = Class.forName(bd.getClassname());
            Object bean = null;
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
            for (SimpleProperty simpleProperty : bd.getSimpleProperties()) {
                Field field = null;
                try {
                    field = beanclass.getDeclaredField(simpleProperty.getName());
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                Method method = null;
                try {
                    method = beanclass.getDeclaredMethod(simpleProperty.getSetMethodName(), field.getType());

                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                Type type = field.getType();

                System.out.println("注入属性" + simpleProperty.getName() + "  " + type.getTypeName() + "  " + simpleProperty.getValue());

                method.setAccessible(true);
             //   method.invoke(bean,simpleProperty.getValue());

                doSet(method, bean, type, simpleProperty.getValue());
                }
            System.out.println("完成bean普通属性注入：" + bean.toString());
           //在搞引用类型属性的注入
            List<BeanDescription> refPropertys=bd.getRefProperties();
            if (refPropertys!=null){
                for( BeanDescription refProperty :refPropertys) {
                    //先从容器中直接获取引用类型的实例；并注入
                    // 若没有实例 则寻找对应ref的描述 --> 初始化对应应用类型的实例
                    System.out.println(refProperty.getClassname());
                }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void doSet(Method method, Object bean, Type type, Object value) throws Exception {
          method.setAccessible(true);
        //硬编码注入基础属性
        switch (type.getTypeName()) {
            case "java.lang.String":
                method.invoke(bean, value);
                break;
            case "int":
                method.invoke(bean, Integer.parseInt((String) value));
                break;
            case "char" :
                method.invoke(bean,((String)value).charAt(0));
                break;
        }

    }
}
