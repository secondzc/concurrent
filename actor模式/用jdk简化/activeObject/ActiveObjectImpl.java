package concurrent.actor模式.用jdk简化.activeObject;

import java.util.concurrent.*;

/**
 * Created by zhangcy on 2018/2/8
 */
public class ActiveObjectImpl implements ActiveObject{
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public Future<String> makeString(int count, char fillchar) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call(){
                char[] ch = new char[count];
                for(int i=0;i<count;i++){
                    ch[i] = fillchar;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                    }
                }
                return new String(ch);
            }
        };
        Future<String> future = executorService.submit(callable);
        return future;
    }

    @Override
    public void displayString(String string) {
        Runnable runnable = new Runnable(){
            public void run(){
                try{
                    System.out.println("displayString: "+ string);
                    Thread.sleep(10);
                }catch (InterruptedException e){

                }
            }
        };
        executorService.execute(runnable);
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }
}
