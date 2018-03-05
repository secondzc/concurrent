package concurrent.actor模式.用jdk简化.activeObject;

import java.util.concurrent.Future;

/**
 * Created by zhangcy on 2018/2/8
 */
public interface ActiveObject {
    Future<String> makeString(int count, char fillchar);
    void displayString(String string);
    void shutdown();
}
