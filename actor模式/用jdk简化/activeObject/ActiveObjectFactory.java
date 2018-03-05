package concurrent.actor模式.用jdk简化.activeObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangcy on 2018/2/8
 */
public class ActiveObjectFactory {
    public static ActiveObject createActiveObject(){
        return new ActiveObjectImpl();
    }
}
