package top.chende.jsonconf;

import top.chende.demo.Demo;
import com.google.gson.Gson;

/**
 * @author: chende
 * @date: 2019/5/4 16:15
 * @description: 测试json配置文件
 */
public class TestJson {
    public static void main(String[] args) {
        Demo demo=new Demo();
        demo.setAge(27);
        demo.setName("chende");
        Gson gson=new Gson();
        String demoStr=gson.toJson(demo);
        System.out.println(demoStr);
    }
}
