package 行为型模式.命令模式;

/**
 * author: mxg
 */
public class Invoke {
    /**
     * 也可以通过容器，容纳很多命令，进行批处理
     *
     *  List<Command>
     */
    private Command command;


    public Invoke(Command command) {
        this.command = command;
    }

    //业务方法，用于调用命令的方法
    public void call() {
        command.execute();
    }
}
