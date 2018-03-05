package concurrent.WaitNotify;


import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by zhangcy on 2018/1/31
 */
public class MyQueue {
    //使用BlockingQueue时，若是阻塞，则用put 、take方法
    //若是超时，则用offer、poll方法
    //使用了线程安全的容器之后就不需要对add方法上锁
    private  final BlockingQueue<Request> queue = new LinkedBlockingDeque<>();


    public void put(Request request){
        try {
            queue.put(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void take(){
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized String toString(){
        StringBuilder sb = new StringBuilder();
        for(Request r:queue){
            sb.append(r.getMsg()+" ");
        }
        return sb.toString();
    }
}
