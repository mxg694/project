package 链表;

import java.util.Stack;

/**
 * author: mxg
 */
public class 单链表 {

    public static void main(String[] args) {

//        -------第一种 start----------------------
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        插入时 按照大小排序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        System.out.println("原始节点列表");
        singleLinkedList.list();
//        reversetList(singleLinkedList.getHead());
//        System.out.println("反转后的节点列表");
//        singleLinkedList.list();

        reverseStackList(singleLinkedList.getHead());



//        singleLinkedList.list();
//        System.out.println("修改节点");
//        HeroNode newhero2 = new HeroNode(2, "卢俊义1", "玉麒麟~~");
//        singleLinkedList.update(newhero2);
//        singleLinkedList.list();
//
//        System.out.println("删除节点");
////        singleLinkedList.del(1);
//
//        singleLinkedList.list();
////        ------- end  ----------------------
//
//        System.out.println("链表的长度为：" + getLength(singleLinkedList.getHead()));
//
//        System.out.println("链表的倒数第" + 4 + "个位置：" + findLastIndexNode(singleLinkedList.getHead(), 4));


    }


    public static void reverseStackList(HeroNode head) {
        if (head.next == null) {
            return;
        }
        HeroNode cur= head.next;
        Stack<HeroNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        System.out.println("利用栈反转后的节点列表");
        while (stack.size()>0) {
            System.out.println(stack.pop());
        }

    }

    /**
     * 使用 单链表  反转链表  改变结构
     * @param head
     */
    public static void reversetList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        //当前节点
        HeroNode cur = head.next;
        //当前节点的下一个节点
        HeroNode next = null;
        HeroNode reverse = new HeroNode(0,"","");
        while (cur != null) {
            next = cur.next;
            // 当前节点的下一个节点 指向 反转后的节点  类似在反转节点的 addFirst
            cur.next = reverse.next;
            // 反转节点的下一个节点 指向 当前节点
            reverse.next = cur;
            cur =next;
        }
        head.next = reverse.next;

    }


    /**
     * 查找单链表中的倒数第k个结点
     *
     * @param heroNode
     * @param index
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode heroNode, int index) {
        if (heroNode.next == null) {
            return null;
        }
        int size = getLength(heroNode);
        if (index <= 0 && index > size) {
            return null;
        }
        HeroNode temp = heroNode.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    /**
     * 获取链表的长度， (如果是带头结点的链表，需求不统计头节点)
     *
     * @param heroNode
     * @return
     */
    public static int getLength(HeroNode heroNode) {
        if (heroNode.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = heroNode.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

}




