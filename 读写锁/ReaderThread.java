package concurrent.读写锁;

/**
 * Created by zhangcy on 2018/1/31
 */
public class ReaderThread extends Thread{
    private final Data data;

    public ReaderThread(Data data){
        this.data = data;
    }

    public void run(){
        for(int i=0;i<1000;i++){
            data.read();
        }
    }
}
