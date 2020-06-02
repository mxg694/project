package 数组;

import java.util.Scanner;

/**
 * author: mxg
 */
public class 数组实现队列 {

    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            System.out.println("t(rear): 查看队列队尾所在位置");
            //接收一个字符
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
                //取出数据
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                //查看队列头的数据
                case 'h':
                    try {
                        int res = queue.showFront();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 't':

                    int res = queue.showRear();
                    System.out.printf("队列尾所在位置%d\n", res);

                    break;
                //退出
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

class  ArrayQueue{
    /**
     *  队列最大容量
     */
    private int maxSize;
    /**
     * 队列 存放数据
     */
    private int[] arr;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        // 指向队列头部，分析出front是指向队列头的前一个位置.
        this.front = -1;
        // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
        this.rear = -1;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean isFull() {
        return rear == maxSize-1;
    }

    /**
     * 判断队列是否为 null
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 往队列中加数据
     * @param num
     */
    public void  addQueue(int num) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        rear++;
        arr[rear] = num;
    }

    /**
     * 获取队列的数据, 出队列
     * @return
     */
    public int  getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空， 无法取数据");
        }
        front++;
        return arr[front];
    }

    /**
     * 显示队列的所有数据
     */
    public void  showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空， 无法取数据");
        }
        for (int i =0; i< arr.length; i++) {
            System.out.printf(" 队列中的元素： arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列的头数据， 注意不是取出数据
     * @return
     */
    public int showFront() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }

    public int showRear() {
        return rear;
    }


}
