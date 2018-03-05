package concurrent.actor模式.自己的实现.activeObject;

/**
 * Created by zhangcy on 2018/2/7
 */
public class Servant implements ActiveObject{

    @Override
    public RealResult<String> makeString(int count, char fillchar) {
        char[] buffer = new char[count];
        for(int i=0;i<count;i++){
            buffer[i] = fillchar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        return new RealResult<String>(new String(buffer));
    }

    @Override
    public void displayString(String string) {
        try{
            System.out.println("displayString: "+ string);
            Thread.sleep(10);
        }catch (InterruptedException e){

        }
    }
}
