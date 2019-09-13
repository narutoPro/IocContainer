package top.chende.demo;

import com.google.gson.Gson;
import top.chende.bean.BeanDescription;
import top.chende.bean.SimpleProperty;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: chende
 * @date: 2019/5/8 10:12
 * @description:
 */
public class TestBeanDescription {

    public static void main(String[] args) throws IOException {
        BeanDescription b = new BeanDescription();
        b.setClassname("top.chende.demo.Demo");
        b.setId("didiguo");
        b.addSimpleProperty(new SimpleProperty("name", "吴迪"));
        b.addSimpleProperty(new SimpleProperty("age", "18"));
        b.addSimpleProperty(new SimpleProperty("sex",new Character('f')));
        Gson gson = new Gson();
        String demoStr = gson.toJson(b);
        System.out.println(demoStr);
        FileWriter fileWriter = new FileWriter("/Users/chende/Desktop/jsonconf2.txt");
        fileWriter.write(demoStr);
        fileWriter.close();
    }
}
