package concurrent.actor模式.自己的实现.activeObject;

/**
 * Created by zhangcy on 2018/2/7
 * 调用与执行分离。Proxy类相当于方法的调用，它不会执行方法，所以makeString方法会立即返回。
 */
public class Proxy implements ActiveObject{
    private final SchedulerThread scheduler;
    private final Servant servant;

    public Proxy(SchedulerThread scheduler, Servant servant) {
        this.scheduler = scheduler;
        this.servant = servant;
    }

    @Override
    public Result<String> makeString(int count, char fillchar) {
        FutureResult<String> future = new FutureResult<>();
        scheduler.invoke(new MakeStringRequest(servant,future,count,fillchar));
        return future;
    }

    @Override
    public void displayString(String string) {
        scheduler.invoke(new DisplayStringRequest(servant,string));
    }
}
