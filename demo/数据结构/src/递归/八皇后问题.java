package 递归;

/**
 * author: mxg
 * <p>
 * <p>
 * 1) 第一个皇后先放第一行第一列
 * 2) 第二个皇后放在第二行第一列、然后判断是否OK[即判断是冲突]， 如果不OK，继续放在第二列、第三列、依次把所有列都放完，找到一个合适
 * 3) 继续第三个皇后，还是第一列、第二列……直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确解
 * 4) 当得到一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解，全部得到.
 * 5) 然后回头继续第一个皇后放第二列，后面继续循环执行 1,2,3,4的步骤
 */
public class 八皇后问题 {
    int max = 8;
    /**
     * 保存皇后放置的位置 es：arr = {0 , 4, 7, 5, 2, 6, 1, 3}
     */
    int[] array = new int[max];
    public static int count = 0;

    public static void main(String[] args) {
        八皇后问题 queue8 = new 八皇后问题();
        queue8.check(0);

        System.out.println("一共有"+count+"种解法");

    }

    /**
     * 判断是否冲突
     * @param n
     */
    public void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i= 0; i< max; i++ ) {
            array[n] = i;
            //不冲突
            if (judge(n)) {
                check(n+1);
            }
            //如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行得 后移的一个位置
        }
    }

    /**
     * 查看第n个皇后，摆放的位置是否和前面皇后摆放的位置冲突
     *
     * @param n 表示第几个皇后
     * @return
     */
    public boolean judge(int n) {

        for (int i = 0; i < n; i++) {
            /**
             *  1. array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
             *  2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
             *   Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
             * 	3. 判断是否在同一行, 没有必要，n 每次都在递增
             */
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i]) ) {
                return false;
            }
        }
        return true;
    }


    /**
     * 输出皇后摆放的位置
     */
    public void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
