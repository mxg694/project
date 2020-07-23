package 七大职责.依赖倒置;

/**
 * author: mxg
 * 依赖倒置三种传递方式
 * <p>
 * 接口传递
 * <p>
 * 构造方法传递
 * <p>
 * setter方法传递
 *
 此类为了简单，或者说为了重用部分代码 违反了 接口隔离原则
 */
public class 依赖倒置传递的三种方式 {

    public static void main(String[] args) {
        //通过接口 传递实现依赖倒置
        IClient client = new MethodClient();
        Father ref = new Son();
        client.method(ref);

        //  方式2: 通过构造方法依赖传递
        ConstructorClinet constructorClinet =new ConstructorClinet(ref);
        constructorClinet.method();

        //方式3 setter方法传递
        SetterClinet setterClinet = new SetterClinet();
        setterClinet.setRef(ref);
        setterClinet.method();
    }

}

// 方法中传递接口引用 -- 通过接口 传递实现依赖倒置
class MethodClient implements IClient {

    @Override
    public void method(Father reference) {
        reference.method();
    }

    @Override
    public void method() {
    }
}

// 方式2: 通过构造方法依赖传递
class ConstructorClinet implements IClient {
    public Father ref;

    public ConstructorClinet(Father ref) {
        this.ref = ref;
    }

    @Override
    public void method(Father reference) {
    }

    @Override
    public void method() {
        ref.method();
    }
}

// 方式3: 通过Setter依赖传递
class SetterClinet implements IClient {
    public Father ref;

    @Override
    public void method(Father reference) {

    }

    @Override
    public void method() {
        ref.method();
    }


    public void setRef(Father ref) {
        this.ref = ref;
    }
}

//---------------------------------------------------------------------------
/**
 * 公共部分代码
 */
interface IClient {
    /*方法中传递接口引用 -- 通过接口 传递实现依赖倒置*/
    void method(Father reference);
    void method();
}

/**
 * 父类，也就是传递的接口
 */
interface Father {
    void method();
}

class Son implements Father {

    @Override
    public void method() {
        System.out.printf("子类的方法");
    }
}