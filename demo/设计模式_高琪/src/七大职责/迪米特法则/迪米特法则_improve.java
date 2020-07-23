package 七大职责.迪米特法则;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 */
public class 迪米特法则_improve {
    public static void main(String[] args) {
        System.out.println("~~~使用迪米特法则的改进~~~");
        ISchoolManager schoolManager = new ISchoolManager();
        schoolManager.printAllEmployee(new ICollegeManager());
    }
}

/**
 * 管理学院员工的管理类
 */
class ICollegeManager {
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) { //这里我们增加了10个员工到 list
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    public void  printAllEmployee() {
        //获取到学院员工
        List<CollegeEmployee> list1 = getAllEmployee();
        System.out.println("------------学院员工------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
    }
}

/**
 * 学校管理类
 *
 *  分析 SchoolManager 类的直接朋友类有哪些 Employee、CollegeManager
 */
class ISchoolManager {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();

        for (int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("学校总部员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    //该方法完成输出学校总部和学院员工信息(id)
    void printAllEmployee(ICollegeManager sub) {

        sub.printAllEmployee();
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }

}