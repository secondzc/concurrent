package concurrent.future.myFuture;

/**
 * Created by zhangcy on 2018/2/5
 */
public class Host {
    public MyFuture request(int count, char c){
        final MyFuture myFuture = new MyFuture();
        new Thread(){
            public void run(){
                try{
                    myFuture.setContent(count,c);
                }catch(Exception e ){
                    myFuture.setException(e);
                }
            }
        }.start();
        return myFuture;
    }
}
