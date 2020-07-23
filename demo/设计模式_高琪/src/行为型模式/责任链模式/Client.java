package 行为型模式.责任链模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        Leader a =new Director("主任");
        Leader b =new Manager("经理");

        a.setNextLeader(b);
        a.handleRequest(new LeaveRequest("mxg",5,"回家探亲"));
    }
}
