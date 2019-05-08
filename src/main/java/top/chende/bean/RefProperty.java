package top.chende.bean;

/**
 * @author: chende
 * @date: 2019/5/8 10:01
 * @description:
 */
public class RefProperty {
    String name;//引用类型域的名字
    String ref; //引用类型域的值 即对应ref id

    public RefProperty() {
    }

    public RefProperty(String name, String ref) {
        this.name = name;
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
