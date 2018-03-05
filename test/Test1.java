package concurrent.test;

import java.util.concurrent.FutureTask;

/**
 * Created by zhangcy on 2018/1/31
 */
public class Test1 {
    static class A{
        private B b;

        public B getB() {
            return new B(b);
        }

        public void setB(B b) {
            this.b = new B(b.getS());
        }
    }
    static class B{
        public String s;

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }
        public B(String s){
            this.s = s;
        }
        public B(B b){
            s = b.getS();
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B("zhang");

        a.setB(b);
        B b1 = a.getB();
        System.out.println(b1.getS());
        b1.setS("zhang11");
        B b2 = a.getB();
        System.out.println(b2.getS());
    }
}
