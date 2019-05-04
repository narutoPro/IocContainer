package top.chende.jsonconf;

import java.util.Date;

/**
 * @author: chende
 * @date: 2019/5/4 18:55
 * @description: 测试。。。
 */
public class Person {
    int id;
    String name;
    Date birthday;
    boolean isMarried;

    Person son;//儿子

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public Person getSon() {
        return son;
    }

    public void setSon(Person son) {
        this.son = son;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setIsMarried(boolean married) {
        isMarried = married;
    }
}
