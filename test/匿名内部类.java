package concurrent.test;

/**
 * Created by zhangcy on 2018/2/7
 */
public class 匿名内部类 {
    public static void main(String[] args) {
        A a = new A(){
            public void foo(){
                System.out.println("zhang");
            }
        };
        a.foo();
    }
}
