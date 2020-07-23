package 七大职责.接口隔离原则;

/**
 * author: mxg
 B 和 D 其实现是通过把一个接口 拆分为了多个， 客户端代码不需要修改
    一个公共接口
    B单独需要的接口
    D单独需要的接口

 实现了接口隔离原则
 */
public class 接口隔离原则_improve {

    public static void main(String[] args) {
        A1 a = new A1();
        C1 c = new C1();
        B1 b = new B1();
        D1 d = new D1();
        //  a 依赖 b   or  a 使用 b
        a.depend1(b);
        a.depend2(b);

        c.depend1(d);
        c.depend3(d);
    }
}

interface interface_BD {
    void opertion1();
}

/**
 * B 类独有的方法
 */
interface interface_B{
    void opertion2();
}

/**
 * D 类独有的方法
 */
interface interface_D {
    void opertion3();
}


/**
 * B只需要  interface1 的 1,2 方法
 *  不需要 3 方法
 */
class B1 implements interface_BD, interface_B{

    @Override
    public void opertion1() {
        System.out.println("B 实现了 opertion1");
    }

    @Override
    public void opertion2() {
        System.out.println("B 实现了 opertion2");
    }


}

/**
 * D只需要  interface1 的 3,2 方法
 *  不需要 1 方法
 */
class D1 implements interface_BD ,interface_D{
    @Override
    public void opertion1() {
        System.out.println("D 实现了 opertion1");
    }


    @Override
    public void opertion3() {
        System.out.println("D 实现了 opertion3");
    }
}

/**
 * A1 依赖（使用） interface_BD, interface_B子类B 中的 1,2的方法
 */
class A1 {
    public void depend1(interface_BD interface1) {
        interface1.opertion1();
    }
    public void depend2(interface_B interface1) {
        interface1.opertion2();
    }
}

/**
 * C1 依赖（使用） interface_BD, interface_D 子类D 中的 1,3的方法
 */
class C1 {
    public void depend1(interface_BD interface1) {
        interface1.opertion1();
    }
    public void depend3(interface_D interface1) {
        interface1.opertion3();
    }
}