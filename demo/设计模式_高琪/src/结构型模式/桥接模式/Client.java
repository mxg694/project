package 结构型模式.桥接模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        Computer2 computer2 = new Laptop2(new Lx());
        computer2.sale();
    }
}
