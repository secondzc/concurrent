package concurrent.服务器模式;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/**
 * Created by zhangcy on 2018/2/4
 */
public class 匿名内部类的嵌套 {
    static class Log{
        public static void println(String s){
            System.out.println(Thread.currentThread().getName()+":"+s);
        }
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("MainThread");
        Log.println("main:begin");
        new Executor(){
            public void execute(Runnable r){
                Log.println("execute:begin");
                new ThreadFactory(){
                    public Thread newThread(Runnable r){
                        Log.println("newThread:begin");
                        Thread t = new Thread(r,"quizThread");
                        Log.println("newThread:end");
                        return t;
                    }
                }.newThread(r).start();
                Log.println("executor:end");
            }
        }.execute(
                new Runnable(){
                    public void run(){
                        Log.println("run:begin");
                        Log.println("run:end");
                    }
                }
        );
        Log.println("main:end");
    }
}
