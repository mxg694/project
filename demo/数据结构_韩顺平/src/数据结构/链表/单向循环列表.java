package 数据结构.链表;

import static java.lang.System.out;

/**
 * author: mxg
 */
public class 单向循环列表 {
    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.show();

        //测试一把小孩出圈是否正确
        circleSingleLinkedList.Josepfu(1, 2, 5); // 2->4->1->5->3
        //String str = "7*2*2-5+1-5+3-3";
    }
}

/**
 * 不带头结点的单向循环链表
 */
class CircleSingleLinkedList {
    private Boy first = null;

    /**
     * 添加节点，形成一个环形列表
     *
     * @param nums
     */
    public void add(int nums) {
        if (nums < 1) {
            out.println("nums的值不正确");
            return;
        }
        Boy cur = null;
        for (int i = 1; i <= nums; i++) {
            Boy b = new Boy(i);

            if (i == 1) {
                first = b;
                first.setNext(first);
                cur = first;
            } else {
                cur.setNext(b);
                b.setNext(first);
                cur = b;
            }
        }
    }

    public void show() {
        if (first == null) {
            out.println("链表为空");
            return;
        }
        Boy cur = first;
        while (true) {
            out.println("编号为：" + cur.getNo());
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }

    /**
     *
     * @param startNo 从第几个位置开始
     * @param countNum  数多少次
     * @param nums   最初又多少数据
     */
    public  void Josepfu(int startNo, int countNum, int nums  ) {
        if (first == null || startNo <1 || startNo > nums ) {
            out.println("参数输入有误，请重新输入");
            return;
        }
        //辅助遍历
        Boy helper = first;
        // helper 指向尾节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 先让链表移动  移动的位置-1
        for (int j =0;j<startNo-1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true) {
            if (helper == first) {
                break;
            }
            for (int i=0; i< countNum -1;i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("数据结构/链表" +first.getNo()+"出圈\n");
            first = first.getNext();
            helper.setNext(first);
        }
        out.println("留在链表中的数据:"+first.getNo());
    }
}


class Boy {
    private Integer no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}