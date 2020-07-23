package 数据结构.查找算法;

import java.util.Arrays;

/**
 * author: mxg
 *

 斐波那契查找与折半查找很相似，他是根据斐波那契序列的特点对有序表进行分割的。他要求开始表中记录的个数为某个斐波那契数小1，即n=F(k)-1;

 开始将k值与第F(k-1）位置的记录进行比较(及mid=low+F(k-1)-1),比较结果也分为三种

 1）相等，mid位置的元素即为所求
 2）>   ,low=mid+1,k-=2;说明:low=mid+1说明待查找的元素在[mid+1,hign]范围内，
    k-=2 说明范围[mid+1,high]内的元素个数为n-（F(k-1))= Fk-1-F(k-1)=Fk-F(k-1)-1=F(k-2)-1个，所以可以递归的应用斐波那契查找

 3) <  ,high=mid-1,k-=1;说明:low=mid+1说明待查找的元素在[low,mid-1]范围内，
    k-=1 说明范围[low,mid-1]内的元素个数为F(k-1)-1个，所以可以递归的应用斐波那契查找
 */
public class 斐波那契_黄金分割法 {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibSearch(arr, 89));
    }

    /**
     * 斐波那契数列
     *
     * @return
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    private static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        //存放斐波那契分割数组的下标
        int k = 0;
        //存放mid 值
        int mid = 0;
        int f[] = fib();
        //获取斐波那契分割数组的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为 f[k] 值 可能大于 a 的 长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
        int[] temp = Arrays.copyOf(arr, f[k]);
        //temp = {1,8, 10, 89, 1000, 1234, 0, 0}  => {1,8, 10, 89, 1000, 1234, 1234, 1234,}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        // 使用while来循环处理，找到我们的数 key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            //我们应该继续向数组的前面查找(左边)
            if (key < temp[mid]) {
                high = mid - 1;
                //为甚是 k--
                //说明
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //因为 前面有 f[k-1]个元素,所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                //即 在 f[k-1] 的前面继续查找 k--
                //即下次循环 mid = f[k-1-1]-1
                k--;
                // 我们应该继续向数组的后面查找(右边)
            } else if (key > temp[mid]) {
                low = mid + 1;
                //为什么是k -=2
                //说明
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //3. 因为后面我们有f[k-2] 所以可以继续拆分 f[k-1] = f[k-3] + f[k-4]
                //4. 即在f[k-2] 的前面进行查找 k -=2
                //5. 即下次循环 mid = f[k - 1 - 2] - 1
                k -= 2;
            } else { //找到
                //需要确定，返回的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;

    }


}
