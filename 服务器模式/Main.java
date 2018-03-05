package concurrent.服务器模式;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangcy on 2018/2/3
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Host host = new Host(executorService);
        System.out.println("main start");
        host.request(3,'a');
        host.request(5,'b');
        host.request(10,'c');
        System.out.println("main end");
    }
}
