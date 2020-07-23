package 创建型模式.工厂模式.简单工厂;

/**
 * author: mxg
 */
public class SimpleFactory {

    //更加orderType 返回对应的Pizza 对象
    public Pizza create(String orderType) {

        Pizza pizza = null;

        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" 希腊披萨 ");
        } else if (orderType.equals("china")) {
            pizza = new ChinaPizza();
            pizza.setName(" 中国披萨 ");
        }
        return pizza;
    }

}
