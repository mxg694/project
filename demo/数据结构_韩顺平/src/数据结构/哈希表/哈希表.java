package 数据结构.哈希表;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * author: mxg
 */
public class 哈希表 {

    public static void main(String[] args) {
//创建哈希表
        MyHashTab hashTab = new MyHashTab(7);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            System.out.println("del: 删除雇员");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "del":
                    System.out.println("输入id");
                     id = scanner.nextInt();
                    hashTab.del(id);
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.getById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }

        }
    }
}

class MyHashTab {
    int size;
    EmpLinkedList[] empLinkedListArray;

    public MyHashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        // 初始化每个链表
        for(int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        //根据员工的id ,得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp 添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);

    }
    public void list() {
        for(int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    public void  getById(int id) {
        int linkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[linkedListNo].findById(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (linkedListNo + 1), id);
        }else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    public void  del(int id) {
        int linkedListNo = hashFun(id);
        empLinkedListArray[linkedListNo].del(id);
    }

    public int hashFun(int id) {
        return id % size;
    }

}

/**
 * 表示链表
 */
class EmpLinkedList {
    /**
     * 头指针
     */
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        cur.next = emp;
    }

    public void  list(int no ) {
        if (head == null) {
            out.println("第 "+(no+1)+" 链表为空");
            return;
        }
        System.out.print("第 "+(no+1)+" 链表的信息为");
        Emp curEmp = head;
        while (true) {
            System.out.println(" => id="+ curEmp.id+"--name="+curEmp.name +"\t");
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }

    }

    public Emp findById(int id) {
        if (head ==null) {
            out.println("链表为空");
            return null;
        }

        Emp cur = head;
        while (true) {

            if (cur.id == id ) {
                break;
            }
            if (cur.next ==null) {
                cur = null;
                break;
            }
            cur = cur.next;
        }
        return cur;

    }

    public void del(int id) {
        if (head ==null) {
            out.println("链表为空");
            return;
        }
        Emp cur = head;
        int  i= 0;
        while (true) {
            if (cur.id == id) {
                break;
            }
            if (cur.next == null) {
                cur = null;
                break;
            }
            cur = cur.next;
            if (i> 0 ) {
                head = head.next;
            }
            i++;
        }
        if (cur == null) {
            out.println("未找到要删除的数据：" + id);
        }else {
            if(i ==0) {
                head = cur.next;
            }else {
                head.next = cur.next;
            }
        }

    }
}

/**
 * 表示 一个雇员  链表中的元素
 */
class Emp {
    public int id;
    public String  name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
