package concurrent.actor模式.用jdk简化;

import concurrent.actor模式.用jdk简化.activeObject.ActiveObject;
import concurrent.actor模式.用jdk简化.activeObject.ActiveObjectFactory;
import concurrent.actor模式.用jdk简化.MakerClientThread;

/**
 * Created by zhangcy on 2018/2/8
 */
public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        try{
            new MakerClientThread("alice",activeObject).start();
            new MakerClientThread("bobby",activeObject).start();
            new DisplayClientThread("chris",activeObject).start();
            Thread.sleep(5000);
        }catch(InterruptedException e){
        }finally{
            activeObject.shutdown();
        }
    }
}
