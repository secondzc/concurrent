package concurrent.WaitNotify;

/**
 * Created by zhangcy on 2018/1/31
 * 模拟生产者比较快的过程
 */
public class Main {
    static class Consumer implements Runnable{
        private MyQueue queue;
        public Consumer(MyQueue q){
            queue = q;
        }
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.take();
                System.out.println("拿了一个，还剩余   "+queue.toString());
            }
        }
    }

    static class Productor implements Runnable{
        private MyQueue queue;
        public Productor(MyQueue q){
            queue = q;
        }
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Request r = new Request(""+i);
                queue.put(r);
                System.out.println("生产了   "+r.getMsg());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        new Thread(new Productor(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
