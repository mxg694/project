package 尚硅谷.类加载.类加载;

/**
 * author: mxg
 */
public class 类加载初始化 {

    private static int num = 0;

    static {
        num = 2;
        number = 20;
    }

    /**
     *  linking之 prepare : number = 0;
     *   initial : 20 -> 10
     */
    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(num); //2
        System.out.println(number); //10
    }
}
