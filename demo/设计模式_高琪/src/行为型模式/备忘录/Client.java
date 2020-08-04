package 行为型模式.备忘录;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Emp emp = new Emp("aa",12);
        System.out.println("第一次创建对象："+emp);
        //备忘一次
        careTaker.setMemento(emp.memento());

        emp.setAge(23);
        emp.setName("bb");
        System.out.println("第二次创建对象："+emp);

        //恢复到备忘录对象保存的状态
        emp.revcovery(careTaker.getMemento());
        System.out.println("数据恢复："+emp);
    }
}
