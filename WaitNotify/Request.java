package concurrent.WaitNotify;

/**
 * Created by zhangcy on 2018/1/31
 */
public class Request {
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Request(String msg) {
        this.msg = msg;
    }
}
