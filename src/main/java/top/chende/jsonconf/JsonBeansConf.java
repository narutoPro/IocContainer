package top.chende.jsonconf;

import top.chende.bean.BeanDescription;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chende
 * @date: 2019/5/8 23:05
 * @description:
 */
public class JsonBeansConf {

    List<BeanDescription> beanDescriptions;

    public void addBeanDes(BeanDescription beanDescription) {
        if (this.beanDescriptions == null) {
            beanDescriptions = new ArrayList<BeanDescription>();
        }
        beanDescriptions.add(beanDescription);
    }

    public List<BeanDescription> getBeanDescriptions() {
        return this.beanDescriptions;
    }

//    public static void main(String[] args) throws IOException{
//        JsonBeansConf jsonBeansConf=new JsonBeansConf();
//        BeanDescription b = new BeanDescription();
//        b.setClassname("top.chende.demo.Demo");
//        b.setId("迪迪锅");
//        b.addSimpleProperty(new SimpleProperty("name", "吴迪"));
//        b.addSimpleProperty(new SimpleProperty("age", "18"));
//        jsonBeansConf.addBeanDes(b);
//        BeanDescription b2=new BeanDescription();
//        b2.setId("德德锅");
//        b2.setClassname("top.chende.demo.Demo22");
//        b2.addSimpleProperty(new SimpleProperty("name", "陈德"));
//        b2.addSimpleProperty(new SimpleProperty("age", "18"));
//        b2.addRefProperty(new RefProperty("ref","迪迪锅"));
//        jsonBeansConf.addBeanDes(b2);
//        Gson gson = new Gson();
//        String demoStr = gson.toJson(jsonBeansConf);
//        System.out.println(demoStr);
//        FileWriter fileWriter = new FileWriter("/Users/chende/Desktop/jsonconf.txt");
//        fileWriter.write(demoStr);
//        fileWriter.close();
//    }
}
