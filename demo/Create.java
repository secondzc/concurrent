package concurrent.demo;

/**
 * Created by zhangcy on 2018/1/31
 * 1.通过继承Thread类
 * 2.通过实现Runnable接口,并将Runnable实现类的实例传入Thread类的构造方法
 * 第2种方式可以多个线程共享同一个目标对象，非常适合多线程处理同一份资源的情况。且第二种方式只是实现了Runnable接口，还可以继承其他的类，第一种方式
 * 就不行
 * 第2中方式因为不知道是哪个线程运行了它，所以要访问当前线程要用Thread.currentThread(),而方式一可以直接用this
 */
public class Create {
    static class MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"  created by Runnable");
        }
    }
    public static void main(String[] args) {
        new Thread(new MyThread()).start();
        new Thread(){
            @Override
            public void run(){
                //和this是相同的
                System.out.println(Thread.currentThread().getName()+"  created by Thread");
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                //若不是start启动而是run（），则实际上是Main线程在调用run（）方法
                System.out.println(Thread.currentThread().getName()+"  created by Thread");
            }
        }.run();
    }
}
