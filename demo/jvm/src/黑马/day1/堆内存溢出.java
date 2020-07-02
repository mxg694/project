package 黑马.day1;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 * -Xmx8m
 */
public class 堆内存溢出 {
    public static void main(String[] args) {
        int  i=0;

        try {
            List<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(a);
                a= a+a;
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }


    }
}
