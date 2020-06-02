package 排序算法;

import java.util.Arrays;

/**
 * author: mxg
 * <p>
 * 快速排序   冒泡排序的改进
 * <p>
 * 把数组 根据某个值 分成两部分，小于值的在左边  大于值的在右边  ，依次类推
 */
public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = {-9, -567, 0, 78, 23, 70};

        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = arr[(left + right) / 2];

        //目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
        System.out.println(Arrays.toString(arr));

    }

}
