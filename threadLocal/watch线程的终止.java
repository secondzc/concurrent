package concurrent.threadLocal;

/**
 * Created by zhangcy on 2018/2/7
 */
public class watch线程的终止 extends Thread{
    public void startWatcher(){
        final Thread target = Thread.currentThread();
        final Thread watcher = new Thread(){
            public void run(){
                try {
                    target.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                close();
            }
        };
        watcher.start();
    }
    public void close(){
        System.out.println("结束target被监视线程时应该做的操作");
    }
    public void run(){
        System.out.println("工作线程dowork");
        startWatcher();
    }

    public static void main(String[] args) {
        watch线程的终止 w = new watch线程的终止();
        w.start();
    }
}
