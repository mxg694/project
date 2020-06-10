package 算法.动态规划算法;

/**
 * author: mxg
 */
public class 背包 {

    public static void main(String[] args) {
        //物品的重量
        int[] w = {1,4,3};
        //物品的价值
        int[]val = {1500,3000,2000};
        //背包的容量
        int m = 4;
        //物品的个数
        int n = val.length;
        //v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n+1][m+1];
        int[][] path = new int[n+1][m+1];

        //初始化第一行和第一列,
        for(int i = 0; i < v.length; i++) {
            v[i][0] = 0; //将第一列设置为0
        }
        for(int i=0; i < v[0].length; i++) {
            v[0][i] = 0; //将第一行设置0
        }

        //  前 i 个商品  j  商品价格
        for (int i =1; i< v.length; i++) {
            for (int j =1; j<v[0].length; j++) {
                if (w[i-1] > j) {   //商品重量 >  背包容量
                    v[i][j] = v[i-1][j];
                }else {
                    if(v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //把当前的情况记录到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出一下v 看看目前的情况
        for(int i =0; i < v.length;i++) {
            for(int j = 0; j < v[i].length;j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("============================");
        int i = path.length - 1; //行的最大下标
        int j = path[0].length - 1;  //列的最大下标
        while(i > 0 && j > 0 ) { //从path的最后开始找
            if(path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i-1]; //w[i-1]
            }
            i--;
        }
    }
}
