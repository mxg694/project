package 递归;

/**
 * author: mxg
 * <p>
 * 迷宫问题
 * 1 墙
 * 2 通路
 * 3 死路
 * <p>
 * 利用递归实现迷宫找路问题
 */
public class 迷宫问题 {

    public static void main(String[] args) {
        //地图  1表示
        int[][] map = new int[8][7];
        //上下都是墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右都为墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        // 输出地图
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);
        // 输出地图
        System.out.println("走过迷宫的地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 1. map 表示地图
     * 2. i,j 表示从地图的哪个位置开始出发 (1,1)
     * 3. 如果小球能到 map[6][5] 位置，则说明通路找到.
     * 4. 约定： 当map[i][j] 为 0 表示该点没有走过 当为 1 表示墙  ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
     * 5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯
     * /**
     *
     * @param map 地图
     * @param i   从哪个位置开始找
     * @param j
     */
    private static boolean setWay(int[][] map, int i, int j) {
        //通路 找到
        if (map[6][1] == 2) {
            return true;
        }else {
            //路没走过
            if (map[i][j] ==0 ) {
                map[i][j] = 2;
                //向下走
                if (setWay(map,i+1,j)) {
                    return true;
                    //右
                }else  if (setWay(map, i, j+1) ) {
                    return true;
                    //上
                }else  if (setWay(map, i-1, j)) {
                    return true;
                    //左
                }else if (setWay(map,i,j-1)) {
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }

        }


    }

}
