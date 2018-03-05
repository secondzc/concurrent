package concurrent.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangcy on 2018/2/4
 * 对应书上第8章，使用jdk的线程池就不需要WorkThread和Channel（存放线程数组和存取线程操作）类
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try{
            new ClientThread("alice",executorService).start();
            new ClientThread("Bobby",executorService).start();
            new ClientThread("chris",executorService).start();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally{
            executorService.shutdown();
        }

    }
}
