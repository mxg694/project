package 数据结构.栈;

import 数据结构.链表.HeroNode;
import 数据结构.链表.SingleLinkedList;

import java.util.Scanner;

/**
 * author: mxg
 */
public class 单向链表实现栈 {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 单向链表--表示显示栈");
            System.out.println("exit: 单向链表--退出程序");
            System.out.println("push: 单向链表--表示添加数据到栈(入栈)");
            System.out.println("pop: 单向链表--表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }
}


class SingleLinkedListStack {
    private int maxSize;
    private SingleLinkedList stack ;
    private int top = -1;

    public SingleLinkedListStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new SingleLinkedList();
    }

    public boolean isFull() {
        return this.maxSize - 1 == top;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack.add(new HeroNode(value,"",""));
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据~");
        }

        int val = stack.get(top);
        top--;
        return val;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i,stack.get(i));
        }
    }


}