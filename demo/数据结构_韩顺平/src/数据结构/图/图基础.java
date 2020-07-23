package 数据结构.图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * author: mxg
 */
public class 图基础 {

    /**
     * 存储顶点集合
     */
    private ArrayList<String> vertexList;
    /**
     * 存储图对应的邻接矩阵
     */
    private int[][] edges;
    /**
     * 表示边的数量
     */
    private int numOfEdges;
    /**
     * 记录某个节点是否被访问
     */
    private boolean[] isVisited;

    public static void main(String[] args) {
//        int n = 5;
        int n = 8;
//        String Vertexs[] = {"A", "B", "C", "D", "E"};
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        //创建图对象
        图基础 graph = new 图基础(n);
        //循环的添加顶点
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }


        //添加边
        //A-B A-C B-C B-D B-E
//        graph.insertEdge(0, 1, 1); // A-B
//        graph.insertEdge(0, 2, 1); //
//        graph.insertEdge(1, 2, 1); //
//        graph.insertEdge(1, 3, 1); //
//        graph.insertEdge(1, 4, 1); //

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);


        //显示一把邻结矩阵
        graph.showGraph();
        System.out.println("深度遍历");
        graph.dfs();
        System.out.println("广度优先!");
        graph.bfs(); // A->B->C->D-E [1->2->3->4->5->6->7->8]

    }

    public 图基础(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        isVisited = new boolean[vertexList.size()];
        numOfEdges = 0;
    }


    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }



    /**
     * 获取第一邻接节点的下标 w
     *
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接结点的下标来获取下一个邻接结点
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }
    //对dfs 进行一个重载, 遍历我们所有的结点，并进行 dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //遍历所有的结点，进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 深度优先遍历算法
     *
     * @param i
     */
    public void dfs(boolean[] isVisited, int i) {
        //首先我们访问该结点,输出
       // System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
     //   System.out.printf(w+"");
        while (w != -1) {//说明有
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    /**
     *  广度优先算法
     * @param isVisited
     * @param i
     */
    public void  bfs(boolean[] isVisited, int i) {
        //队列的头结点对应的下标
        int u;
        //邻接节点w
        int w;
        //记录节点访问顺序
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "=>");
        isVisited[i] =  true;
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = (int)queue.removeFirst();
            //得到第一个邻接结点的下标 w
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }
    //遍历所有的结点，都进行广度优先搜索
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }


    /**
     * 获取图中顶点的个数
     *
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 得到边的数量
     *
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
     *
     * @param i
     * @return
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 返回v1和v2的权值
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 插入顶点 节点
     *
     * @param value
     */
    public void insertVertex(String value) {
        vertexList.add(value);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
