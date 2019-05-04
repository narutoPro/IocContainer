package chende.top.bean;


import java.util.Map;

public interface BeanDefinition {

    boolean isSingleton();

  //  String getBeanName();

    String getBeanClassName();

    void setBeanClassName(String beanClassName);

    //引用类型依赖
    String[] getDependences();

    void  setDependence(String dependence);

    //对于基本数据类型 ，直接读取 key（字段名） value  （从文件中读取的元素数据 String  可以转化吧）
    void setProperty(String key,String value);

    Map getProperties();
}
