package 数据结构.排序算法;

import java.util.Arrays;

/**
 * author: mxg
 * <p>
 * 把一个数组 分成两部分，
 * 第一部分是有序数组， 只有首元素     arr1
 * 第二部分是无序列表， 是数组其余元素 arr2
 * <p>
 * 每次从无序列表中拿出一个元素，然后插入到  有序列表 arr1 中 依次类推
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] arr = {10,2, -1, 91, 50};
        insertSort2(arr);
        teseFor();
    }


    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;

            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //插入位置的值 =  次最小值
                arr[insertIndex+1]  = arr[insertIndex];
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arr));

        }


    }

    public static void insertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                   int temp = arr[j];
                   arr[j] = arr[j-1];
                   arr[j-1] = temp;
                }
            }
            System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arr));
        }
    }


    public static  void  teseFor() {
        for (int i=0; i<0; i++) {
            System.out.println("testfor");
        }
    }


}
