package 数据结构.链表;

/**
 * author: mxg
 */
public class SingleLinkedList {
    /**
     * 头结点， 不动，不存放数据
     */
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单向链表
     * 思路，当不考虑编号顺序时
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next 指向 新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        //辅助结点
        HeroNode temp = head;

        while (true) {
            // 链表最后一个结点
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    /**
     * 根据 no 插入数据
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        //用于 判断要插入节点的 no是否存在
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //位置找到，就在temp的后面插入
            if (temp.next.no > heroNode.no) {
                break;
                //说明希望添加的heroNode的编号已然存在
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            //后移，遍历当前链表
            temp = temp.next;
        }
        if (flag) {
            System.out.println("当前节点的数据已存在，无法插入");
        } else {
            //链表的插入数据
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode newHeroNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }

        //定义一个辅助变量
        HeroNode temp = head.next;
        //表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**
     * ；链表的删除
     *
     * @param n
     */
    public void del(int n) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == n) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没找到节点是" + n + "的数据");
        }

    }

    public int get(int n) {
        HeroNode temp = head;
        boolean flag =true;
        int i =0;
        while (i<n) {
            if (temp.next == null) {
                flag = false;
                break;
            }
            temp = temp.next;
            i++;
        }
        if (flag) {
            return temp.no;
        }else {
            throw  new RuntimeException("获取数据失败");
        }
    }

    /**
     * 遍历链表
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //后移
            temp = temp.next;
        }
    }

}