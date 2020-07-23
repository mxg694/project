package 行为型模式.模板方法模式;

/**
 * author: mxg
 */
public class DrawMoney extends BankTemplateMethod {
    @Override
    public void transact() {
        System.out.println("取款");
    }
}
