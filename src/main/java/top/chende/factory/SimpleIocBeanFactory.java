package top.chende.factory;

import com.google.gson.Gson;
import top.chende.bean.BeanDescription;
import top.chende.bean.SimpleProperty;
import top.chende.jsonconf.JsonBeansConf;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author: chende
 * @date: 2019/5/4 19:08
 * @description:
 */
public class SimpleIocBeanFactory {

    Map<String, Object> instances = new HashMap<>();
    // key beanName即bean id  value对应的BeanDescription
    Map<String, BeanDescription> beanDefinitionHolder = new HashMap<>();

    public SimpleIocBeanFactory(String beansPath) {
        loadBeansConf(beansPath);
    }

    public void initBeans(){
        Iterator<BeanDescription> iterator  =beanDefinitionHolder.values().iterator();
        while (iterator.hasNext()){
            BeanDescription bd=iterator.next();
            initBean(bd);
        }
    }

    //加载beans 配置文件
    public void loadBeansConf(String beansPath) {
        System.out.println("conf file:"+beansPath+ " initBeans");
        Gson gson = new Gson();
        try {
            FileReader fr = new FileReader(beansPath);
            JsonBeansConf beansConf = gson.fromJson(fr, JsonBeansConf.class);
            for (BeanDescription bd : beansConf.getBeanDescriptions()) {
                beanDefinitionHolder.put(bd.getId(), bd);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从容器中获取Bean
     *
     * @param id Bean的id
     * @return
     */
    public Object getBean(String id) {
        if (!instances.containsKey(id)) {
            initBean(beanDefinitionHolder.get(id));
        }
        return instances.get(id);
    }

    public void initBean(BeanDescription beanDescription) {
        Class beanClass=null;
        Object bean=null;

        try {
            beanClass = Class.forName(beanDescription.getClassname());
            bean = beanClass.getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //注入属性 先注入基本普通属性
        for (SimpleProperty simpleProperty : beanDescription.getSimpleProperties()) {
            Field field = null;
            try {
                field = beanClass.getDeclaredField(simpleProperty.getName());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            Method method = null;
            try {
                method = beanClass.getDeclaredMethod(simpleProperty.getSetMethodName(), field.getType());

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            Type type = field.getType();
            System.out.println("注入属性" + simpleProperty.getName() + "  " + type.getTypeName() + "  " + simpleProperty.getValue());
            method.setAccessible(true);
            doSet(method, bean, type, simpleProperty.getValue());
        }
        //注入引用类型
        List<BeanDescription> refPropertys = beanDescription.getRefProperties();
        if (refPropertys != null) {
            for (BeanDescription refProperty : refPropertys) {
                //先从容器中直接获取引用类型的实例；并注入
                // 若没有实例 则寻找对应ref的描述 --> 初始化对应应用类型的实例
                System.out.println(refProperty.getClassname());
            }
        }
    }

    /**
     * 注入简单属性
     * @param method
     * @param bean
     * @param type
     * @param value
     */
    public  void doSet(Method method, Object bean, Type type, Object value)  {
        method.setAccessible(true);
        //硬编码注入基础属性
        try {
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
                default:

            }
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

}