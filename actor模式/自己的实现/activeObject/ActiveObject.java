package concurrent.actor模式.自己的实现.activeObject;

/**
 * Created by zhangcy on 2018/2/7
 */
public interface ActiveObject {
    Result<String> makeString(int count,char fillchar);
    void displayString(String string);
}
