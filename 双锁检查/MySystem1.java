package concurrent.双锁检查;

import java.util.Date;

/**
 * Created by zhangcy on 2018/2/8
 * 针对双锁检查的改进：使用Initialization on Demand Holer模式实现
 * 使用Holder的“类的初始化” 来创建唯一实例，并保证线程安全。因为在java规范中，类的初始化是线程安全的。
 * Holer类是延迟初始化的，在调用MySystem.getInstance方法前，Holder类不会被初始化。
 */
public class MySystem1 {
    private static class Holer{
        public static MySystem1 instance = new MySystem1();
    }

    private  Date date = new Date();
    private MySystem1(){

    }
    public Date getDate(){
        return date;
    }
    public static MySystem1 getInstance(){
        return Holer.instance;
    }
}
