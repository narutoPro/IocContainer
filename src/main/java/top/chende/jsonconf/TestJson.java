package top.chende.jsonconf;

import com.google.gson.Gson;
import top.chende.demo.Demo;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author: chende
 * @date: 2019/5/4 16:15
 * @description: 测试json配置文件
 */

/*
ok 这样解析是可以的
{
"name":"chende123",
"age":17
}
* */

public class TestJson {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setAge(27);
        demo.setName("chende");
        Gson gson = new Gson();

        String demoStr = gson.toJson(demo);
        try {
            System.out.println(demoStr);
            StringBuilder sb = new StringBuilder();
            char[] buff = new char[100];
            FileReader fr = new FileReader("/Users/chende/Desktop/jsonconf.txt");


            Demo d = gson.fromJson(fr, Demo.class);
            System.out.println("demo d name:" + d.getName());
            System.out.println("demo d age:" + d.getAge());

            //    FileWriter fileWriter = new FileWriter("/Users/chende/Desktop/jsonconf.txt");
            //   fileWriter.write(demoStr);
            //  fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
