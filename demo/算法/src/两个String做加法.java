import com.sun.deploy.util.StringUtils;

/**
 * author: mxg
 */
public class 两个String做加法 {

    public static void main(String[] args) {
        String str1 = "555";
        String str2 = "666";
        char[] large = null;
        char[] small = null;
        int[] sum = null;


        if (str1.length() > str2.length()) {
            large = str1.toCharArray();
            small = str2.toCharArray();
        } else {
            large = str2.toCharArray();
            small = str1.toCharArray();
        }

        sum = new int[large.length + 1];

        for (int i = 0; i < large.length; i++) {
            sum[i] = Integer.valueOf(large[large.length - i - 1]) - Integer.valueOf('0');
        }
        for (int i = 0; i < small.length; i++) {
            sum[i] = sum[i] + Integer.valueOf(small[small.length - i - 1]) - Integer.valueOf('0');
        }

        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > 9) {
                sum[i] = sum[i] % 10;
                sum[i + 1] = sum[i + 1] + 1;
            }
        }
        String sumstr = "";
        for (int i = 0; i < sum.length; i++) {
            sumstr += sum[sum.length - 1 - i];
        }
        if (sum[sum.length - 1] == 0) {
            sumstr = sumstr.substring(1);
        }
        System.out.println(555 + 666);
        System.out.println(sumstr);
    }

}
