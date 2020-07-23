package 数据结构.排序算法;

import java.util.Arrays;

/**
 * author: mxg
 * <p>
 * 核心思想：将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 具体做法是：将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
 * 这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 */
public class 基数排序 {

    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};

        radixSort(arr);
    }

    //基数排序方法
    public static void radixSort(int[] arr) {
        //得到数组中最大的值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        //定义一个二维数组，表示10个桶，每个桶代表一个一维数组
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCount = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位置的值
                int digitOfElement = arr[j] / n % 10;
                //哪个桶的那个位置上放的是什么值
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
                // 桶对应的存放值的下标
                bucketElementCount[digitOfElement]++;
            }
            int index = 0;
            //遍历每个桶，把值放到元素组
            for (int k = 0; k < bucketElementCount.length; k++) {
                if (bucketElementCount[k] !=0) {
                    for (int l=0; l<bucketElementCount[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCount[k] = 0;
            }
            System.out.println("第"+(i+1)+"轮，对个位的排序处理 arr =" + Arrays.toString(arr));
        }

    }

}
