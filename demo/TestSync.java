package concurrent.demo;

/**
 * Created by zhangcy on 2018/1/31
 * 在同一个对象上用synchronized的不同方法之间会阻塞
 * 在同一个类的不同对象上的synchronized方法之间不受影响
 */
public class TestSync {
    static class A{
        synchronized void foo1(){
            System.out.println("foo1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized void foo2(){
            System.out.println("foo2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Athread implements Runnable{
        private A a;
        Athread(A a){
            this.a = a;
        }
        @Override
        public void run() {
            a.foo1();
        }
    }
    static class Bthread implements Runnable{
        private A a;
        Bthread(A a){
            this.a = a;
        }
        @Override
        public void run() {
            a.foo2();
        }
    }
    public static void main(String[] args) {
        new Thread(new Athread(new A())).start();
        new Thread(new Bthread(new A())).start();
    }
}
