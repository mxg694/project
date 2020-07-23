package 数据结构.排序算法;

import java.util.Arrays;

/**
 * author: mxg
 *
    选择排序：
        每次选出数组中最小的值，和数组中最开始的位置交换位置

 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {41,20,91,5};
        selectSort(arr);

    }

    public static void selectSort(int[] arr)  {


        for (int i=0; i< arr.length-1; i++) {
            int minval = arr[i];
            int minIndex = i;
            for (int j=i+ 1; j< arr.length; j++) {
                if (arr[j] < minval) {
                    minIndex= j;
                    minval = arr[j];
                }
            }
            System.out.println("最小值："+minval);
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minval;
            }
            System.out.println("第"+(i+1)+"次排序：" + Arrays.toString(arr));
        }

    }

}
