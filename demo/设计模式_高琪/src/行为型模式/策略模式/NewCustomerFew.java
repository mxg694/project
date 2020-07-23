package 行为型模式.策略模式;

/**
 * author: mxg
 */
public class NewCustomerFew implements Strategy{
    @Override
    public double getPrice(double price) {
        System.out.println("不打折，原价");
        return price;
    }
}
