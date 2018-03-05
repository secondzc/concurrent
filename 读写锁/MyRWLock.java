package concurrent.读写锁;

/**
 * Created by zhangcy on 2018/1/31
 * 能否把readingThread、writingThread换成原子类，去掉synchronized呢？
 */
public class MyRWLock {
    private int readingThread = 0;
    private int writingThead = 0;

    public synchronized void readLock(){
         //写的时候不能读
        while(writingThead==1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        readingThread++;
    }

    public synchronized void readUnLock(){
        readingThread--;
        notifyAll();
    }

    public synchronized  void writeLock(){
        //读的时候不能写，写的时候不能写
        while(readingThread>0 || writingThead==1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writingThead++;
    }

    public synchronized void writeUnLock(){
        writingThead--;
        notifyAll();
    }
}
