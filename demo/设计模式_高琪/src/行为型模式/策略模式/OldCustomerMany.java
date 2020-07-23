package 行为型模式.策略模式;

/**
 * author: mxg
 */
public class OldCustomerMany implements Strategy{
    @Override
    public double getPrice(double price) {
        System.out.println("八折");
        return price * 0.8;
    }
}
