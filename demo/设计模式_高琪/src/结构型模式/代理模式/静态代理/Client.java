package 结构型模式.代理模式.静态代理;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        Star proxyStar = new ProxyStar(realStar);
        proxyStar.pre();
        proxyStar.dosomething();
        proxyStar.post();
    }
}
