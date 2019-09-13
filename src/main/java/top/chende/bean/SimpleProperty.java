package top.chende.bean;

/**
 * @author: chende
 * @date: 2019/5/8 10:02
 * @description: 简单属性
 */
public class SimpleProperty {

    String name;
    Object value; //Object对象

    public SimpleProperty() {
    }

    public SimpleProperty(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getSetMethodName(){
        if (name==null || name.equals("")) return null;
        char firstChar=this.name.charAt(0);
        if ( firstChar>='A' && firstChar<='Z')
            return  "set"+name;
        return "set"+ Character.toUpperCase(firstChar)+name.substring(1);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
