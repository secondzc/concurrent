package concurrent.actor模式.自己的实现.activeObject;

/**
 * Created by zhangcy on 2018/2/7
 */
public class FutureResult<T> implements Result<T>{
    private  RealResult<T> result;
    private boolean ready = false;
    public synchronized void setResult(RealResult<T> result){
        this.result = result;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized T getResultValue() {
        while(!ready){
            try{
                wait();
            }catch(InterruptedException e){

            }
        }
        return result.getResultValue();
    }
}
