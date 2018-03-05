package concurrent.actor模式.自己的实现;

import concurrent.actor模式.自己的实现.activeObject.ActiveObject;
import concurrent.actor模式.自己的实现.activeObject.Result;

/**
 * Created by zhangcy on 2018/2/7
 */
public class MakerClientThread extends Thread{
    private final ActiveObject activeObject;
    private final char fillchar;
    public MakerClientThread(String name,ActiveObject activeObject){
        super(name);
        this.activeObject = activeObject;
        this.fillchar = name.charAt(0);
    }
    public void run(){
        try{
            for(int i=0;true;i++){
                Result<String> result = activeObject.makeString(i,fillchar);
                //表示线程进行了其他的操作，这里用sleep代替
                Thread.sleep(10);
                String value = result.getResultValue();
                System.out.println(Thread.currentThread().getName()+":value= " + value);
            }
        }catch(InterruptedException e){

        }

    }
}
