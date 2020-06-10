package 数据结构.栈;

/**
 * author: mxg
 */
public class 栈实现数据运算 {
    public static void main(String[] args) {
        String expression = "11+1*6-4";

        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        //将每次扫描到的char 保存到ch
        char ch = ' ';
        String keepNum = "";
        while (true) {
            if (index >= expression.length()) {
                break;
            }
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch 是否为操作符
            if (operStack.isOper(ch)) {
                // 操作数栈 不为 空
                if (!operStack.isEmpty()) {
                    // 当前操作符的优先级 大于 前一个操作符的优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = operStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                //ch 是数字
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    //注意是看后一位，不是index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
        }

        //表达式扫描完成
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = operStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        //将数栈的最后数，pop出，就是结果
        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, res2);

    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
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
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据~");
        }
        int val = stack[top];
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
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据~");
        }
        return stack[top];
    }

    /**
     * 判断是否为操作符
     *
     * @return
     */
    public boolean isOper(int val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 判断 操作符优先级
     *
     * @param oper
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        }
        return -1;
    }

    /**
     * 计算方法
     *
     * @param num1
     * @param num2
     * @param ch
     * @return
     */
    public int cal(int num1, int num2, int ch) {
        int res = 0;
        switch (ch) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}