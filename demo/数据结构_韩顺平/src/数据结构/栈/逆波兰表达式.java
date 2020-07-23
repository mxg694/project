package 数据结构.栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * author: mxg
 * <p>
 * 将一个中缀表达式转换为后缀表达式
 */
public class 逆波兰表达式 {


    public static void main(String[] args) {

//        String expression = "10 1 + 5 * 6 -";
//        List<String> stringList = getStringList(expression);
//        Integer cal = cal(stringList);
//        System.out.println("后缀表达式计算的结果：" +cal);
//        -------------------------------------------------------------
        //中缀表达式
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List=" + infixExpressionList);
        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);

    }

    /**
     * 方法：将得到的中缀表达式对应的List => 后缀表达式对应的List
     *
     * @param ls
     * @return
     */
    private static List<String> parseSuffixExpreesionList(List<String> ls) {
        Stack<String> s1 = new Stack<>();
        //说明：因为s2 这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出 所以使用 List 代替
        List<String> s2 = new ArrayList<>();

        for (String item : ls) {
            //是一个数字
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
//注意因为是存放到List, 因此按顺序输出就是对应的后缀表达式对应的List
        return s2;
    }

    /**
     * 将 中缀表达式转成对应的List
     *
     * @param s
     * @return
     */
    private static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<>();
        // 辅助指针
        int i = 0;
        String str;
        char c;
        do {
            c = s.charAt(i);
            if (c < 48 || c > 57) {
                ls.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && c >= 48 && c <= 57) {
                    str += c;
                    i++;
                    if (i < s.length()) {
                        c = s.charAt(i);
                    }
                }
                ls.add(str);
            }

        } while (i < s.length());
        return ls;
    }


    public static List<String> getStringList(String str) {
        String[] split = str.split(" ");
        return Arrays.asList(split);
    }

    //完成对逆波兰表达式的运算

    /**
     * 1)从左至右扫描，将3和4压入堆栈；
     * 2)遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
     * 3)将5入栈；
     * 4)接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
     * 5)将6入栈；
     * 6)最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static Integer cal(List<String> ls) {
        Stack<String> stack = new Stack<String>();
        for (String item : ls) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                // pop出两个数，并运算， 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res 入栈
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }

}

