package top.chende.bean;


import java.util.Map;

/**
 * bean的name/id 唯一  与一个确定的BeanDefinition对应
 */

public interface BeanDefinition {

    boolean isSingleton();

  //  String getBeanName();

    String getBeanClassName();

    void setBeanClassName(String beanClassName);

    //引用类型依赖
    String[] getDependences();

    //todo 关键在于怎样通过反射或者cglib 生成对于的bean  dependence可以是bean的id
/*
 <bean id="ehcacheManagerFactory" class="org.springframework.cache.ehcache.EhCacheManagerFactoryBean">
        <property name="configLocation" value="classpath:config/ehcache.xml" />
    </bean>
    <!-- 声明cacheManager -->
    <bean id="ehcacheManager" class="org.springframework.cache.ehcache.EhCacheCacheManager">
        <property name="cacheManager" ref="ehcacheManagerFactory" />
    </bean>
    */

    void  setDependence(String dependence);

    //对于基本数据类型 ，直接读取 key（字段名） value  （从文件中读取的元素数据 String  可以转化吧）
    void setProperty(String key,String value);

    Map getProperties();
}
