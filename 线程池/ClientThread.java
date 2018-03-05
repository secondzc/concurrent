package concurrent.线程池;

import java.util.Random;
import java.util.concurrent.ExecutorService;

/**
 * Created by zhangcy on 2018/2/4
 */
public class ClientThread extends Thread{
    private final ExecutorService  executorService;
    private static final Random random = new Random();

    public ClientThread(String name,ExecutorService executorService){
        super(name);
        this.executorService = executorService;
    }

    public void run(){
        for(int i=0;true;i++){
            Request request = new Request(getName(),i);
            executorService.execute(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
