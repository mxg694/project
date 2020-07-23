package 数据结构.排序算法;

import java.util.Arrays;

/**
 * author: mxg
 */
public class 堆排序 {

    public static void main(String[] args) {
//        int[] arr = {4, 6, 8, 5, 9};
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println("堆排序："+ Arrays.toString(arr));


    }


    public static void heapSort(int[] arr) {
        int temp = 0;
        System.out.println("堆排序");
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println("顶堆之后的数组：" + Arrays.toString(arr));
        /*
		 * 2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
　　	    3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
		 */
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

    }


    /**
     * 将一个数组（二叉树）， 调整成一个大顶堆
     * [1,6,8,5,9]
     * i=1 => 4 9 8 5 6
     * i=0 =>9 6 8 5 4
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];
        // k = i * 2 + 1 k 是 i结点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //如果子结点大于父结点
            if (arr[k] > temp) {
                //把较大的值赋给当前结点
                arr[i] = arr[k];
                //i 指向 k,继续循环比较
                i = k;
            } else {
                break;
            }
        }
        //当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了 最顶(局部)
        arr[i] = temp;//将temp值放到调整后的位置

    }
}
