package concurrent.actor模式.自己的实现.activeObject;

/**
 * Created by zhangcy on 2018/2/7
 */
public class DisplayStringRequest extends MethodRequest<Object>{
    private final String string;

    public DisplayStringRequest(Servant servant,  String string) {
        super(servant, null);
        this.string = string;
    }

    @Override
    public void execute() {
        servant.displayString(string);
    }
}
