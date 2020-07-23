package 行为型模式.责任链模式;

/**
 * author: mxg
 * 总经理
 */
public class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeavedays() >= 3 && leaveRequest.getLeavedays()<10) {
            System.out.println("员工：" + leaveRequest.getEmpName() + ",天数：" + leaveRequest.getLeavedays());
            System.out.printf("审批人：" + this.name);
        } else {
            if (this.nextLeader != null) {
                this.nextLeader.handleRequest(leaveRequest);
            }
        }
    }
}
