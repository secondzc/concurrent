package concurrent.服务器模式;

/**
 * Created by zhangcy on 2018/2/4
 */
public class HelperThread implements Runnable{
    private final int times;
    private  final char c;
    HelperThread(int times,char c){
        this.times = times;
        this.c = c;
    }
    @Override
    public void run() {
        for(int i=0;i<times;i++){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(c);
        }
    }
}
