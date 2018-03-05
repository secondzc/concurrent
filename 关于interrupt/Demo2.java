package concurrent.关于interrupt;

/**
 * Created by zhangcy on 2018/2/6
 * 这个例子中，进入了catch块，但是中断标志位没有被清除
 * 说明线程被interrupt（） 之后， 会中断sleep wait join 这些方法，进入catch块，但中断标志位不是进入catch块被清除的，
 * 而是跳出这三个方法被清除的，
 */
public class Demo2 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run(){
                while(true){
                    try{
                        if(Thread.currentThread().isInterrupted()){
                            throw new InterruptedException();
                        }
                        System.out.print(".");
                    }catch(InterruptedException e){
                        System.out.print("*");
                    }
                }
            }
        };
        t.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.stop();
    }
}
