package concurrent.threadLocal;

/**
 * Created by zhangcy on 2018/2/7
 */
public class JDK线程本地 {
    public static void main(String[] args) {
        ThreadLocal<String> x = new ThreadLocal<>();
        Thread t1 = new Thread(){
            public void run(){
                x.set("zhang");
                System.out.println(x.get());
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                x.set("chu");
                System.out.println(x.get());
            }
        };
        t1.start();
        t2.start();
        System.out.println(x.get());
    }
}
