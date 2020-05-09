package demo;

import org.apache.commons.lang3.StringUtils;

/**
 * author: mxg
 */
public class Test {
    public static void main(String[] args) {
        String[] arr = {"aa","ab","ac"};
        String join = StringUtils.join(arr, "','");
        System.out.println(join);

    }
}
