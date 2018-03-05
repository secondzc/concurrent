package concurrent.双锁检查;

import java.util.Date;

/**
 * Created by zhangcy on 2018/2/8
 */
public class MySystem {
    private static MySystem mySystem= null;
    private Date date = new Date();
    private MySystem(){

    }
    public static MySystem getInstance(){
        if(mySystem==null){
            synchronized (MySystem.class){
                if(mySystem==null){
                    //若线程A锁住，还没有退出，因为重排序的存在，线程B可能会看到instance字段的值，而看不到date字段的值
                    //改进的方法是取消双锁，将synchronized放在getInstance方法上
                    mySystem = new MySystem();
                }
            }
        }
        return mySystem;
    }
    public Date getDate(){
        return date;
    }
}
