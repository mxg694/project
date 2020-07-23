package 创建型模式.工厂模式.工厂方法模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        String loc = "bj";
        if (loc.equals("bj")) {
            //创建北京口味的各种Pizza
            new BjSonFactory();
        } else {
            //创建伦敦口味的各种Pizza
            new OtherSonFactory();
        }
    }
}
