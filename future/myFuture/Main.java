package concurrent.future.myFuture;

import java.util.concurrent.ExecutionException;

/**
 * Created by zhangcy on 2018/2/5
 * 将setContent中出现的异常放在main线程中显示
 */
public class Main {
    public static void main(String[] args) {
        Host host = new Host();
        MyFuture myFuture1 = host.request(5,'a');
        MyFuture myFuture2 = host.request(10,'b');
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(myFuture1.getContent());
            System.out.println(myFuture2.getContent());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
