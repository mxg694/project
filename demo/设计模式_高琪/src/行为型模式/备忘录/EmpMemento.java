package 行为型模式.备忘录;

/**
 * author: mxg
 *  备忘录类
 *
 */
public class EmpMemento {
    private String name;
    private int age;

    public EmpMemento(Emp emp)  {
        this.age = emp.getAge();
        this.name = emp.getName();
    }

    public String getName() {
        return name;
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
}
