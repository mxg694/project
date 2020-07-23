package 行为型模式.责任链模式;

/**
 * author: mxg
 */
public class Director extends Leader {

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeavedays() < 3) {
            System.out.println("员工：" + leaveRequest.getEmpName() + ",天数：" + leaveRequest.getLeavedays());
            System.out.printf("审批人：" + this.name);
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(leaveRequest);
            }
        }
    }
}
