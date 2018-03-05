package concurrent.future.jdkFuture;

import java.util.concurrent.ExecutionException;

/**
 * Created by zhangcy on 2018/2/5
 */
public class Main {
    public static void main(String[] args) {
        Host host = new Host();
        FutureData myFuture1 = host.request(5,'a');
        FutureData myFuture2 = host.request(10,'b');
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
