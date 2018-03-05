package concurrent.future.jdkFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zhangcy on 2018/2/6
 * 使用FutureData的要点：1.传进来一个Callable对象表示要执行的任务  2.定义获取的方法，常用的是get等
 */
public class FutureData extends FutureTask<String>{
    public FutureData(Callable<String> callable) {
        super(callable);
    }

    public String getContent() throws ExecutionException {
        String str = null;
        try {
            str = get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return str;
    }
}
