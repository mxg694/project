package 七大职责.里式替换;

/**
 * author: mxg
 */
public class 里式替换_not {
    public static void main(String[] args) {
        Father a = new Father();
        System.out.println("11-3=" + a.minus(11, 3));
        System.out.println("1-8=" + a.minus(1, 8));

        System.out.println("-----------------------");
        Son b = new Son();
        System.out.println("11-3=" + b.minus(11, 3));//这里本意是求出11-3
        System.out.println("1-8=" + b.minus(1, 8));// 1-8
        System.out.println("11+3+9=" + b.add(11, 3));
    }
}


class Father {
    public int minus(int n1, int n2) {
        return n1 - n1;
    }
}

/**
 * 子类 重写 父类的方法
 */
class Son extends Father {

    //这里，重写了Father的方法, 可能是无意识
    public int minus(int a, int b) {
        return a + b;
    }

    public int add(int a, int b) {
        return minus(a, b) + 9;
    }

}