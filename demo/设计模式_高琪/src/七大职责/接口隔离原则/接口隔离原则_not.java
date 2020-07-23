package 七大职责.接口隔离原则;

/**
 * author: mxg

 B 和 D 其实现 多实现了一个自己不需要的方法
 违反了接口隔离原则
 */
public class 接口隔离原则_not {
    public static void main(String[] args) {
        A a = new A();
        C c = new C();
        B b = new B();
        D d = new D();
        a.depend1(b);
        a.depend2(b);

        c.depend1(d);
        c.depend3(d);
    }
}

interface interface1 {
    void opertion1();
    void opertion2();
    void opertion3();
}


/**
 * B只需要  interface1 的 1,2 方法
 *  不需要 3 方法
 */
class B implements interface1{

    @Override
    public void opertion1() {
        System.out.println("B 实现了 opertion1");
    }

    @Override
    public void opertion2() {
        System.out.println("B 实现了 opertion2");
    }

    @Override
    public void opertion3() {
        System.out.println("B 实现了 opertion3");
    }
}

/**
 * D只需要  interface1 的 3,2 方法
 *  不需要 1 方法
 */
class D implements interface1 {
    @Override
    public void opertion1() {
        System.out.println("D 实现了 opertion1");
    }

    @Override
    public void opertion2() {
        System.out.println("D 实现了 opertion2");
    }

    @Override
    public void opertion3() {
        System.out.println("D 实现了 opertion3");
    }
}

/**
 * A 依赖（使用） interface1 子类B 中的 1,2的方法
 */
class A {
    public void depend1(interface1 interface1) {
        interface1.opertion1();
    }
    public void depend2(interface1 interface1) {
        interface1.opertion2();
    }
}

/**
 * C 依赖（使用） interface1 子类D 中的 1,3的方法
 */
class C {
    public void depend1(interface1 interface1) {
        interface1.opertion1();
    }
    public void depend3(interface1 interface1) {
        interface1.opertion3();
    }
}