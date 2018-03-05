package concurrent.actor模式.自己的实现.activeObject;

/**
 * Created by zhangcy on 2018/2/8
 */
public class RealResult<T> implements Result<T>{
    private final T resultValue;

    public RealResult(T resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public T getResultValue() {
        return resultValue;
    }
}
