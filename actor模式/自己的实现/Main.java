package concurrent.actor模式.自己的实现;

import concurrent.actor模式.自己的实现.activeObject.ActiveObject;
import concurrent.actor模式.自己的实现.activeObject.ActiveObjectFactory;

/**
 * Created by zhangcy on 2018/2/7
 */
public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("alice",activeObject).start();
        new MakerClientThread("bobby",activeObject).start();
        new DisplayClientThread("chris",activeObject).start();
    }
}
