package 数据结构.树基础;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author: mxg
 */
public class 赫夫曼树 {
    public static void main(String[] args) {
        int[] arr =  { 13, 7, 8, 3, 29, 6, 1 };
        Node root = createHuffmanTree(arr);
        preOrder(root);
     }

    //编写一个前序遍历的方法
    public static void preOrder(Node root) {
        if(root != null) {
            root.preOrder();
        }else{
            System.out.println("是空树，不能遍历~~");
        }
    }

     public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        for (int val : arr) {
            nodes.add(new Node(val));
        }
        while (nodes.size()>1) {
            //排序
            Collections.sort(nodes);
            System.out.println("nodes ="+ nodes);
            //取出根节点权值最小的两颗二叉树
            //(1) 取出权值最小的结点（二叉树）
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //构建新的二叉树
            Node parent = new Node(leftNode.value+ rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //(4)从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent加入到nodes
            nodes.add(parent);

        }
        return nodes.get(0);
     }
}




class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value - o.value;
    }
}
