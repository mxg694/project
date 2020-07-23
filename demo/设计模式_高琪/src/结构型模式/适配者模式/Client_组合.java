package 结构型模式.适配者模式;

/**
 * author: mxg
 * 客户类，相当于 笔记本
 */
public class Client_组合 {
    public void test(Target target) {
        target.handleReq();
    }

    public static void main(String[] args) {
        Client_组合 client = new Client_组合();
        Adaptee a = new Adaptee();
        Target target = new Adapter_组合(a);

        client.test(target);
    }

}
