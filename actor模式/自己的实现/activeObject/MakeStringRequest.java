package concurrent.actor模式.自己的实现.activeObject;

/**
 * Created by zhangcy on 2018/2/7
 */
public class MakeStringRequest extends MethodRequest<String>{
    private final int count;
    private final char fillchar;
    public MakeStringRequest(Servant servant,FutureResult<String> future,int count,char fillchar){
        super(servant,future);
        this.count = count;
        this.fillchar = fillchar;
    }

    @Override
    public void execute() {
        RealResult<String> result = servant.makeString(count,fillchar);
        future.setResult(result);
    }
}
