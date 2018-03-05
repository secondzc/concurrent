package concurrent.actor模式.自己的实现.activeObject;

/**
 * Created by zhangcy on 2018/2/7
 */
abstract class MethodRequest<T> {
    protected final Servant servant;
    protected  final FutureResult<T> future;
    protected MethodRequest(Servant servant,FutureResult<T> future){
        this.servant = servant;
        this.future = future;
    }
    public abstract void execute();
}
