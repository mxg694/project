package 行为型模式.模板方法模式;

/**
 * author: mxg
 */
public abstract class BankTemplateMethod {

    public void takeNum() {
        System.out.println("取号");
    }

    /**
     * 办理具体业务
     */
    public abstract void transact();


    public void evaluate() {
        System.out.println("反馈评分");
    }

    public final void process() {
        this.takeNum();
        this.transact();
        this.evaluate();
    }
}
