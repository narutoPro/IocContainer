package top.chende.factory;

import com.google.gson.Gson;
import top.chende.bean.BeanDescription;
import top.chende.jsonconf.JsonBeansConf;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
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

    //加载beans 配置文件
    public void loadBeansConf(String beansPath) {
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
        Class beanClass;
        Object bean;
        try {
             beanClass = Class.forName(beanDescription.getClassname());
             bean = beanClass.getConstructor().newInstance();
            //注入属性 先注入基本普通属性

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
