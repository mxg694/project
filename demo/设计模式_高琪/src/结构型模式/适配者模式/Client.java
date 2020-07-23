package 结构型模式.适配者模式;

/**
 * author: mxg
 * 客户类，相当于 笔记本
 */
public class Client {
    public void test(Target target) {
        target.handleReq();
    }

    public static void main(String[] args) {
        Client client = new Client();
        Target target = new Adapter();

        client.test(target);
    }

}
