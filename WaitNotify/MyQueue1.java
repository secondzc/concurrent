package concurrent.WaitNotify;

import com.sun.org.apache.regexp.internal.RE;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhangcy on 2018/1/31
 * 不使用线程安全容器而是用锁实现方法，用wait/nofify实现阻塞的队列
 * wait/notify方式是防止线程一直在进行while里面的判断操作
 */
public class MyQueue1 {
    private Queue<Request> queue = new LinkedList<>();

    public synchronized  void put(Request request){
        queue.offer(request);
        notifyAll();
    }

    public synchronized Request take(){
        while(queue.isEmpty()){
            try {
                //wait和notify的调用者是this，就是指的Main中的MyQueue1的实例，
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.poll();
    }
}
