package concurrent.线程池;

/**
 * Created by zhangcy on 2018/2/4
 */
public class Request implements Runnable{
    private final String name;
    private final int number;
    public Request(String name,int number){
        this.name = name;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("requst name= "+name+" number= "+number);
    }
}
