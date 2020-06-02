package 排序算法;

import java.util.Arrays;

/**
 * author: mxg
 * <p>
 * <p>
 * 插入排序的升级版  缩小增量排序
 * <p>
 * 把 数组 分割成若干个小组，然后对每个小组进入插入排序
 *
 * 数组中的数据 每隔多少个 是有序的
 */
public class 希尔排序 {

    public static void main(String[] args) {
        int[] arr = {20, 87, 6, 8, 9,10,1};
        shellSort2(arr);
    }

    /**
     * 希尔排序时， 对有序序列在插入时采用交换法
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        //需要进行几次 排序
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历数组中的所有元素
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
    }

    /**
     * 对交换式的希尔排序进行优化->移位法
     *
     * @param arr
     */
    public static void shellSort2(int[] arr) {
        int count = 0;
        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            System.out.println("gap:" +gap);
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                System.out.printf("i:" + i + "   ");
                int  j= i;
                int temp = arr[i];
                if (arr[j] < arr[j-gap] ){

                    while (j-gap >=0 && temp<=arr[j-gap] ) {
                        //将后面的较大的数 赋值给 当前位置
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
            System.out.println();
            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
    }
}
