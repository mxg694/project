package 行为型模式.命令模式;

/**
 * author: mxg
 *  命令对象
 */
public interface Command {
    /**
     *  根据需求不同设计不同的方法
     */
    void execute();
}

class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //命令执行前后，执行相关的处理
        receiver.action();
    }
}