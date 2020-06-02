package 数组;

import java.util.Scanner;

/**
 * author: mxg
 */
public class 环形数组队列 {
    public static void main(String[] args) {
        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列 说明设置4, 其队列的有效数据最大是3
        CircleArrayQueue1 queue = new CircleArrayQueue1(4);
        // 接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            // 接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                // 取出数据
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                // 查看队列头的数据
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                // 退出
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

/**
 * 核心思想： 预留一个空间作为缓冲， 实现循环队列
 */
class CircleArrayQueue {

    /**
     * 数组最大容量
     */
    private int maxSize;
    /**
     * front 指向队列的第一个元素  即 front 初始值 = 0；
     */
    private int front;

    /**
     * rear 指向队列的最后一个元素的后一个位置， 留出一个空间作为约定
     * rear 的初始值 = 0；
     */
    private int rear;
    /**
     * 存放数据
     */
    int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        arr[rear] = n;
        // 将rear 后移  这里需要取模  为什么？
        rear = (rear + 1) % maxSize;
    }

    public Integer getQueue() {
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        int v = arr[front];
        //将 front 后移, 考虑取模
        front = (front + 1) % maxSize;
        return v;
    }

    /**
     * 队列的有效数据个数
     *
     * @return
     */
    public int size() {
        // rear =2, front = 1; maxsize = 3
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue() {
// 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        // 思路：从front开始遍历，遍历多少个元素
        // 动脑筋
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front];
    }
}

class CircleArrayQueue1 {

    /**
     * 数组最大容量
     */
    private int maxSize;
    /**
     * front 指向队列的第一个元素  即 front 初始值 = 0；
     */
    private int front;

    /**

     * rear 指向队列的最后一个元素，
     * rear 的初始值 = 0；
     */
    private int rear;
    /**
     * 存放数据
     */
    int[] arr;

    public CircleArrayQueue1(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return rear  % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        arr[rear] = n;
        // 将rear 后移  这里需要取模  为什么？
        rear = (rear + 1) % maxSize;
    }

    public Integer getQueue() {
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        int v = arr[front];
        //将 front 后移, 考虑取模
        front = (front + 1) % maxSize;
        return v;
    }

    /**
     * 队列的有效数据个数
     *
     * @return
     */
    public int size() {
        // rear =2, front = 1; maxsize = 3
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue() {
// 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        // 思路：从front开始遍历，遍历多少个元素
        // 动脑筋
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 显示队列的头数据， 注意不是取出数据
     */
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front];
    }

}