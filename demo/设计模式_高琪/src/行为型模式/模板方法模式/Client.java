package 行为型模式.模板方法模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        BankTemplateMethod templateMethod = new DrawMoney();
       // templateMethod.process();

        //采用匿名内部类

        BankTemplateMethod method =new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("存款");
            }
        };
        method.process();
    }
}
