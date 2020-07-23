package 创建型模式.工厂模式.抽象工厂;

import 创建型模式.工厂模式.工厂方法模式.Food;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * author: mxg
 */
public class Client {


    AbsFactory factory;

    // 构造器
    public Client(AbsFactory factory) {
        setFactory(factory);
        Food food = null;
        String orderType = ""; // 用户输入
        do {
            orderType = getType();
            // factory 可能是北京的工厂子类，也可能是伦敦的工厂子类
            food = factory.create(orderType);
            if (food != null) { // 订购ok
                food.product();
            } else {
                System.out.println("订购失败");
                break;
            }
        } while (true);
    }

    private void setFactory(AbsFactory factory) {

        this.factory = factory;

    }

    // 写一个方法，可以获取客户希望订购的披萨种类
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
