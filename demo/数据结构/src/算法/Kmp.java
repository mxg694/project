package 算法;

import java.util.Arrays;

/**
 * author: mxg
 */
public class Kmp {

    public static void main(String[] args) {
        String str1 = "ABCDABCDABDE";
        String str2 = "ABCDABD";
        //String str2 = "BBC";
        //[0,0,0,0,1, 2, 0]   1，2 表示在本串中 前缀某几个字符再次出现的情况
        int[] next = kmpNext("ABCDABD");
        System.out.println("next=" + Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println("index=" + index);
    }


    public static int kmpSearch( String str1, String str2, int[] next ){
        for (int i=0, j =0; i < str1.length(); i++) {
            //需要处理 str1.charAt(i) ！= str2.charAt(j), 去调整j的大小
            //KMP算法核心点, 当前值和 子串
            while (j> 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j-1];
            }
            if (str1.charAt(i) == str2.charAt(j)) {
                System.out.println(i+"-"+j);
                j++;
            }
            if (j ==  str2.length()) {
                return i-j+1;
            }
        }
        return -1;
    }


    /**
     * 获取到一个字符串(子串) 的部分匹配值表
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i=1, j=0; i<dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j
            //直到我们发现 有  dest.charAt(i) == dest.charAt(j)成立才退出
            //这时kmp算法的核心点
            while (j>0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }
            //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j ;
        }
        return next;
    }
}
