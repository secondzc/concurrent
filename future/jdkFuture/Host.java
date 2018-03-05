package concurrent.future.jdkFuture;

import java.util.concurrent.Callable;

/**
 * Created by zhangcy on 2018/2/6
 */
public class Host {
    public FutureData request(int count,char c){
        FutureData futureData = new FutureData(
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        char[] ch = new char[count];
                        for(int i=0;i<count;i++){
                            ch[i] = c;
                        }
                        Thread.sleep(2000);
                        return new String(ch);
                    }
                }
        );
        new Thread(futureData).start();
        return futureData;
    }
}
