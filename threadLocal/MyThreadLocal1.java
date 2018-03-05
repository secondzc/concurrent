package concurrent.threadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangcy on 2018/2/7
 */
public class MyThreadLocal1<E> {
    public final Map<Thread,E> map = new HashMap<>();
    public void set(E e){
        map.put(Thread.currentThread(),e);
    }
    public E get(){
        return map.get(Thread.currentThread());
    }
}
