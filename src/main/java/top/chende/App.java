package top.chende;


import top.chende.factory.SimpleIocBeanFactory;

public class App
{
    public static void main( String[] args )
    {
        String confPath="/Users/chende/Desktop/jsonconf.txt";
        SimpleIocBeanFactory factory=new SimpleIocBeanFactory(confPath);
        factory.initBeans();

    }
}
