package 七大职责.里式替换;

import org.omg.CORBA.BAD_CONTEXT;

/**
 * author: mxg
 */
public class 里式替换_improve {
    public static void main(String[] args) {
        IFather a = new IFather();
        System.out.println("11-3=" + a.minus(11, 3));
        System.out.println("1-8=" + a.minus(1, 8));

        System.out.println("-----------------------");
        ISon b = new ISon();
        //因为ISon类不再继承IFather类，因此调用者，不会再func1是求减法
        //调用完成的功能就会很明确
        System.out.println("11+3=" + b.add(11, 3));//这里本意是求出11+3
        System.out.println("1+8=" + b.add(1, 8));// 1+8
        System.out.println("11+3+9=" + b.add9(11, 3));


        //使用组合仍然可以使用到IFather类相关方法
        System.out.println("11-3=" + b.minus(11, 3));// 这里本意是求出11-3


    }
}

//创建一个更加基础的基类
class Base {
//把更加基础的方法和成员写到Base类
}

class IFather extends Base {
    public int minus(int n1, int n2) {
        return n1 - n1;
    }
}

class ISon extends Base {
    //使用组合关系 ，把father 实例注入到ISon中
    private IFather father = new IFather();

    public int add(int a, int b) {
        return a + b;
    }

    public int add9(int a, int b) {
        return add(a, b) + 9;
    }

    //我们仍然想使用IFather的方法, 不是通过继承
    public int minus(int a, int b) {
        return this.father.minus(a, b);
    }

}