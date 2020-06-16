package test;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * author: mxg
 *
 *  栈：运行
 *  堆：存储
 */

public class TestDemo {

    @Test
    public void d01() {
        int age = 20;
        changeValue(age);
        System.out.println("age-------"+age);

        Ps ps = new Ps();
        ps.name = "abc";
        changeValue3(ps);
        System.out.println("ps------"+ps.name);

        String str = "abc";
        changeValue2(str);
        System.out.println("str-----"+str);


        String newStr = new String("abc");
        changeValue2(str);
        System.out.println("newStr-----"+newStr);
    }

    public void changeValue(int age) {
        age = 30;
    }

    public void changeValue2( String str ) {
        str ="xxx";
    }

    public void changeValue3( Ps ps ) {
       ps.name = "xxx";
    }
}



class Ps {
    int  age;
    String name;
}
