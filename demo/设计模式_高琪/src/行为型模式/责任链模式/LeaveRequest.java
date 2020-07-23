package 行为型模式.责任链模式;

/**
 * author: mxg
 *
 * 封装请假基本信息
 */
public class LeaveRequest {
    private String empName;
    private int leavedays;
    private String reason;

    public LeaveRequest(String empName, int leavedays, String reason) {
        this.empName = empName;
        this.leavedays = leavedays;
        this.reason = reason;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getLeavedays() {
        return leavedays;
    }

    public void setLeavedays(int leavedays) {
        this.leavedays = leavedays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
