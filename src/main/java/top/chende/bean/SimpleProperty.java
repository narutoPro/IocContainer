package top.chende.bean;

/**
 * @author: chende
 * @date: 2019/5/8 10:02
 * @description:
 */
public class SimpleProperty {

    String name;
    String value;

    public SimpleProperty() {
    }

    public SimpleProperty(String name, String value) {
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

    public static void main(String[] args) {
        String name="name";
        char c1='n';
        char c2='N';
        StringBuilder sb=new StringBuilder(name);
        System.out.println("c1"+Character.toUpperCase(c1));
        System.out.println('N'+name.substring(1));
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
