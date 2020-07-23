package JUC.volatile关键字;

/**
 * author: mxg
 */
public class 指令重排 {

    public static void main(String[] args) {

        for (int i = 0; i< 10000; i++) {
           new Thread(()->{
               ResortSeq resortSeq = new ResortSeq();
               resortSeq.method1();
               resortSeq.method2();
           }, String.valueOf(i)) .start();
        }
    }

}

class ResortSeq {
    int a = 0;
    boolean flag = false;

    public void method1() {
        a = 1;
        flag = true;
    }

    public void method2() {
        if (flag) {
            a = a + 5;
            if (a == 5) {
                System.err.println("***指令重排：" +a);
            }else {
                System.out.println("*** retValue:" + a);
            }

        }
    }
}