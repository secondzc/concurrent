package concurrent.future.myFuture;

import java.util.concurrent.ExecutionException;

/**
 * Created by zhangcy on 2018/2/5
 */
public class MyFuture {
    private String content;
    private ExecutionException executionException;

    public String getContent() throws ExecutionException{
        while(content==null){
            synchronized (this){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        if(executionException != null){
            throw executionException;
        }
        return content;
    }
    public MyFuture(){
    }
    public void setContent(int count,char c){

        char[] ch = new char[count];
        for(int i=0;i<count;i++){
            ch[i] = c;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        content = new String(ch);
        synchronized (this){
            notifyAll();
        }
    }

    public void setException(Throwable e){
        this.executionException = new ExecutionException(e);
        synchronized (this){
            notifyAll();
        }
    }
}
