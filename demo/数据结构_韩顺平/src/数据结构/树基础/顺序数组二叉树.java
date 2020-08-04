package 数据结构.树基础;

/**
 * author: mxg
 */
public class 顺序数组二叉树 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6,7 };
        //创建一个 ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        System.out.println("前序遍历---------------");
        arrBinaryTree.preOrder(0); // 1,2,4,5,3,6,7
        System.out.println("中序遍历---------------");
        arrBinaryTree.infixOrder(0);
        System.out.println("后序遍历---------------");
        arrBinaryTree.postOrder(0);

    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 顺序存储二叉树
     */
    public void preOrder(int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        System.out.println(arr[index]);
        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    /**
     * 中序遍歷
     * @param index
     */
    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            infixOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            infixOrder(2 * index + 2);
        }

    }

    /**
     * 中序遍歷
     * @param index
     */
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }
        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            postOrder(2 * index + 2);
        }
        System.out.println(arr[index]);
    }
}
