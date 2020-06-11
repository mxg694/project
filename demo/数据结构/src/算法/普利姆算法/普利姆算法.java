package 算法.普利姆算法;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * author: mxg
 */
public class 普利姆算法 {
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        //创建MGraph对象
        MGraph graph = new MGraph(verxs);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        //输出
        minTree.showGraph(graph);
        //测试普利姆算法
        minTree.prim(graph, 0);
    }
}


/**
 * 最小生成树  村庄的图
 */
class MinTree {

    /**
     *
     * @param graph 图对象
     * @param verxs  图对应的顶点
     * @param data   图各个顶点的值
     * @param weight  图的邻接矩阵
     */

    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight){
        int i,j;
        //顶点
        for (i =0; i< verxs;i++) {
            graph.data[i] = data[i];
            for (j=0; j<verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }
    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * prime  prime算法,得到最小生成树
     * @param graph 图
     * @param v  表示从图的第几个顶点开始生成'A'->0 'B'->1...
     */
    public void prim(MGraph graph, int v) {
        //表示节点 是否被访问过
        int[] visited = new int[graph.verxs];
        //当前顶点被访问过
        visited[v] = 1;
        //记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        //因为有 graph.verxs顶点，有 graph.verxs-1边
        for (int k=1; k< graph.verxs; k++) {
            // i结点表示被访问过的结点
            for (int i=0;i<graph.verxs; i++) {
                //j结点表示还没有访问过的结点
                for (int j=0;j<graph.verxs; j++) {
                    if (visited[i] ==1 && visited[j] ==0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 10000
            minWeight = 10000;
        }


    }
}


class MGraph {
    /**
     * 图的节点个数
     */
    int verxs;
    /**
     * 存放节点的数据
     */
    char[] data;
    /**
     * 存放边
     */
    int[][] weight;

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}