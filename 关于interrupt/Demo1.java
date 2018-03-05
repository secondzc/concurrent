package concurrent.关于interrupt;

/**
 * Created by zhangcy on 2018/2/6
 */
public class Demo1 {
    public static class AThread extends Thread{
        public void shutdownRequest(){
            //说明调用下面的方法改变的是t1线程的标志位
            //以下相当于this.interupt(),无论哪个线程调用shutdownRequest方法，AThread的线程都会被中断，如果以下写
            // 成Thread.currentThread.interrupt()则变成了main线程被中断
            interrupt();
        }
        public void run(){
            System.out.println("this t1 thread");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("t1 interrupt");
                //catch之后中断标志位就被重置了
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("main");
        AThread t1  = new AThread();
        t1.setName("t1");
        t1.start();
        Thread.sleep(300);
        t1.shutdownRequest();
    }
}
