package 行为型模式.责任链模式;

/**
 * author: mxg
 * 抽象类
 */
public abstract class Leader {
    protected String name;
    protected Leader nextLeader;  //责任链的后继对象

    public Leader(String name) {
        this.name = name;
    }

    public Leader getNextLeader() {
        return nextLeader;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     * 处理请求的核心业务方法
     * @param leaveRequest
     */
    public abstract  void handleRequest(LeaveRequest leaveRequest);
}
