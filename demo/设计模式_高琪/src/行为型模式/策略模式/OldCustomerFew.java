package 行为型模式.策略模式;

/**
 * author: mxg
 */
public class OldCustomerFew implements Strategy{
    @Override
    public double getPrice(double price) {
        System.out.println("八五折");
        return price * 0.85;
    }
}
