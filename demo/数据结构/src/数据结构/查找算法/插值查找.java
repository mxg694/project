package 数据结构.查找算法;

/**
 * author: mxg
 */
public class 插值查找 {

    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };

        int index = insertValueSearch(arr, 0, arr.length - 1, 123);
        System.out.println("index = " + index);
    }

    private static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        // 求出mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if (mid <0 ) {
            return  -1;
        }
        int midVal = arr[mid];
        if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else if (findVal == midVal){
            return mid;
        }else {
            return -1;
        }
    }


}
