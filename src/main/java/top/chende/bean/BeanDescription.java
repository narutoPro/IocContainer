package top.chende.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chende
 * @date: 2019/5/8 10:04
 * @description:
 */
public class BeanDescription {

    String id;  //bean id
    String classname;
    List<SimpleProperty> simpleProperties;
    List<BeanDescription> refProperties; //引用类型

    // 先不考虑单例吧  默认都是单例

    public BeanDescription() {

    }

    public void addSimpleProperty(SimpleProperty simpleProperty) {
        if (this.simpleProperties==null)
            this.simpleProperties=new ArrayList<>();
        simpleProperties.add(simpleProperty);
    }

    public void addRefProperty(BeanDescription ref){
        if (this.refProperties==null)
            this.refProperties=new ArrayList<>();
        refProperties.add(ref);
    }
    public List<SimpleProperty> getSimpleProperties() {
        return simpleProperties;
    }

    public void setSimpleProperties(List<SimpleProperty> simpleProperties) {
        this.simpleProperties = simpleProperties;
    }

    public List<BeanDescription> getRefProperties() {
        return refProperties;
    }

    public void setRefProperties(List<BeanDescription> refProperties) {
        this.refProperties = refProperties;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
