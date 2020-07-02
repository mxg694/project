package 黑马.day1;

/**
 * author: mxg
 */
public class A {
    public static void main(String[] args) {
        int a = 10;
        int b = a++ + ++a +a--;  //10 + 12 + 12
        System.out.println(a);
        System.out.println(b);
    }

}
