package concurrent.读写锁;

/**
 * Created by zhangcy on 2018/1/31
 */
public class Data {
    private final char[] info;
    private final MyRWLock lock = new MyRWLock();

    public Data(int size){
        info = new char[size];
        for(int i=0;i<info.length;i++){
            info[i] = '*';
        }
    }

    public char[] read(){
        lock.readLock();
        try{
            return info;
        }finally{
            lock.readUnLock();
        }
    }

    public void write(char c){
        lock.writeLock();
        try{
            for(int i=0;i<info.length;i++){
                info[i] = c;
            }
        }finally{
            lock.writeUnLock();
        }
    }
}
