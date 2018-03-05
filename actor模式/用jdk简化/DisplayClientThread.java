package concurrent.actor模式.用jdk简化;

import concurrent.actor模式.用jdk简化.activeObject.ActiveObject;

/**
 * Created by zhangcy on 2018/2/8
 */
public class DisplayClientThread extends Thread{
    private final ActiveObject activeObject;
    public DisplayClientThread(String name,ActiveObject activeObject){
        super(name);
        this.activeObject = activeObject;
    }
    public void run(){
        try{
            for(int i=0;true;i++){
                String string = Thread.currentThread().getName() + " " +i;
                activeObject.displayString(string);
                Thread.sleep(200);
            }
        }catch(InterruptedException e){

        }
    }
}
