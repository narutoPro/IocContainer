package top.chende.bean;

/**
 * @author: chende
 * @date: 2019/5/4 19:59
 * @description: 描述依赖

 <bean id="ehcacheManagerFactory" class="org.springframework.cache.ehcache.EhCacheManagerFactoryBean">
        <property name="configLocation" value="classpath:config/ehcache.xml" />
    </bean>
    <-- 声明cacheManager -->
    <bean id="ehcacheManager" class="org.springframework.cache.ehcache.EhCacheCacheManager">
        <property name="cacheManager" ref="ehcacheManagerFactory" />
    </bean>
    */
public class Dependence {

    String key;
    String className;
    String ref;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
