package 行为型模式.备忘录;

/**
 * author: mxg
 * 源发器类
 *
 */
public class Emp {
    private String name;
    private int age;

    public Emp(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //进行备忘操作，返回备忘录对象
    public String getName() {
        return name;
    }

    /**
     * 进行备忘操作，并返回备忘录对象
     * @return
     */
    public EmpMemento memento() {
        return new EmpMemento(this);
    }

    //进行数据恢复，恢复成指定备忘录的值
    public void revcovery(EmpMemento empMemento) {
        this.name = empMemento.getName();
        this.age = empMemento.getAge();
    }



    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
