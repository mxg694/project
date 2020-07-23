package 行为型模式.策略模式;

/**
 * author: mxg
 */
public class NewCustomerMany implements Strategy{
    @Override
    public double getPrice(double price) {
        System.out.println("打九折");
        return price  * 0.9;
    }
}
