package concurrent.读写锁;

/**
 * Created by zhangcy on 2018/1/31
 */
public class WriterThead extends Thread{
    private final Data data;
    private final char c;
    public WriterThead(Data data,char c){
        this.data = data;
        this.c = c;
    }

    public void run(){
        for(int i=0;i<1000;i++){
            data.write(c);
        }
    }
}
