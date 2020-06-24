package 尚硅谷.类加载.类加载;

/**
 * author: mxg
 */
public class ClinitTest {

//    static int  a = 12;
//    static {
//        a = 1;
//    }

    static class  father {
        public static int A = 1;
        static  {
            A = 2;
        }
    }
    static class son extends father {
        public static int B = A;
    }

    public static void main(String[] args) {
        /**
         * 类的加载机制
         *
         *  先加载父类，然后才加载子类
         */
        System.out.println(son.B);
    }

}
