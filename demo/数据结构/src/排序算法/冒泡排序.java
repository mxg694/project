package 排序算法;

import java.util.Arrays;

/**
 * author: mxg
 * 思想： 相邻两个位置的数据进行比较和位置交换
 */
public class 冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {1,-1,2,-3,5};
        bubbleSort(arr);

    }


    public static void bubbleSort(int[] arr) {

        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //进行了交换数据
            if (flag) {
                flag =false;
            }else  {
                break;
            }

            System.out.print("第"+(i+1)+"次排序：" + Arrays.toString(arr));
            System.out.println();
        }
    }

}
