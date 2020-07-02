package 黑马.day1.常量池;

/**
 * author: mxg
 */
public class 常量 {
    public static void main(String[] args) {
        /**
         * 常量池中的信息，都会被加载到运行时常量池中，这时 "a","b","ab"都是常量池中的符号
         *  还没有变为java字符串对象
         */
        //StringTable ["a"]
        String s1 = "a";  //懒加载
        //StringTable ["a", "b"]
        String s2 = "b";
        //StringTable ["a","b","ab"]
        String s3 = "ab";
        // new StringBuilder().append("a").append("b").toString()   => new String("ab");
        String s4 = s1 + s2;
        //StringTable ["a","b","ab"]
        //javac 在编译期间的优化
        String s5 = "a" + "b";

//        System.out.println(s3 == s4);   //false
//        System.out.println(s3 == s5);   //true

        //----------------------------------------------


        //StringTable= ["ab"]
        String x = "ab";
        //StringTable= ["ab","a","b"]
        // 黑马.day1.堆： new String("a")  new String("b")  new String("ab")
       // String s = new String("a")+ new String("b");
        // 将这个字符串(s)尝试放入串池，如果有则不会放入，没有则放入串池，会把串池的对象返回
//        String st = s.intern();
//
//        System.out.println(st == x); //true
//        System.out.println(s == x); //false

//---------------------------
        //StringTable= ["a","b"]
        // 黑马.day1.堆： new String("a")  new String("b")  new String("ab")
        String t = new String("a")+ new String("b");
        //StringTable= ["a","b",ab]
        // 将这个字符串(s)尝试放入串池，如果有则不会放入，没有则放入串池，会把串池的对象返回
        String tr = t.intern();

        System.out.println(tr == "ab"); //true
        System.out.println(  t == "ab"); //false  , 需把前面代码注掉

    }

}
