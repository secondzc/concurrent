package concurrent.actor模式.自己的实现.activeObject;

/**
 * Created by zhangcy on 2018/2/7
 * 将调用和执行分离
 * 调用invoke方法的线程和调用execute方法的线程时不同的线程，
 * 前者是调用了Proxy类的makeString和displayString方法的线程，即 与MakerClientThread和DisplayClientThread对应的线程
 * 后者是与SchedulerThread类对应的线程
 */
public class SchedulerThread extends Thread{
    private final ActivationQueue queue;
    public SchedulerThread(ActivationQueue queue){
        this.queue = queue;
    }

    public void invoke(MethodRequest request){
        queue.putRequest(request);
    }

    public void run(){
        while(true){
            MethodRequest request = queue.takeRequest();
            request.execute();
        }
    }
}
