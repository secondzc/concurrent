package concurrent.读写锁;

/**
 * Created by zhangcy on 2018/1/31
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data(10);
        for(int i=0;i<4;i++){
            new ReaderThread(data).start();
        }
        new WriterThead(data,'A').start();
        new WriterThead(data,'B').start();
    }
}
