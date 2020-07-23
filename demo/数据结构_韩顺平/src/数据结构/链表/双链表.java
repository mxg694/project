package 数据结构.链表;

/**
 * author: mxg
 */
public class 双链表 {
    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();
    }
}

/**
 * 带头节点的双向链表
 */
class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 添加到最后
     *
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {

        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void update(HeroNode2 heroNode2) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;
        //是否找到该节点
        boolean flag = false;
        while (temp != null) {
            if (temp.no == heroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
//            temp.pre.next = heroNode2;
//            heroNode2.pre = temp.pre;
            temp.name = heroNode2.name;
            temp.nickname = heroNode2.nickname;

        } else {
            System.out.println("未找到下标是" + heroNode2.no + "的数据");
        }
    }

    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (temp != null) {
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //最后一个节点
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }

        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }

    }


}


class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    /**
     * 指向下一个节点, 默认为null
     */
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}