package concurrent.服务器模式;

import java.util.concurrent.Executor;

/**
 * Created by zhangcy on 2018/2/3
 */
public class Host {
    private final Executor executor;
    public Host(Executor executor){
        this.executor = executor;
    }
    public void request(int count,char c){
        executor.execute(
                new HelperThread(count,c)
        );
    }
}
