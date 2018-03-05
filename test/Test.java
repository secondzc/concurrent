package concurrent.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangcy on 2018/1/31
 * StringBuffer与String不同，是mutable的，包含着修改内部状态的方法，如果返回值是StringBuffer的话，如果修改了返回值，则实例内容也会发生变化。
 * 如final StringBuffer  info，info字段的值本身（指向的实例）并不会发生变化， 但info字段指向的实例的状态可能会发生变化。
 */
public class Test {
    static class A{
        private final StringBuffer sb;
        public void print(){
            System.out.println(sb.toString());
        }
        public A(String s){
            sb = new StringBuffer(s);
        }
        public StringBuffer getSb(){
            return sb;
        }
    }

    public static void main(String[] args) {
        A a = new A("zhang");
        a.print();
        StringBuffer sb = a.getSb();

        sb.append(11);
        a.print();
    }
}
