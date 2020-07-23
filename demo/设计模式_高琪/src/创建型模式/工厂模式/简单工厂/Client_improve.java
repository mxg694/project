package 创建型模式.工厂模式.简单工厂;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * author: mxg
 */
public class Client_improve {

    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    //构造器
    public Client_improve(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);

        String orderType = ""; //用户输入的
        do {
            orderType = getType();
            pizza = this.simpleFactory.create(orderType);

            //输出pizza
            if(pizza != null) { //订购成功
                pizza.product();
            } else {
                System.out.println(" 订购披萨失败 ");
                break;
            }
        }while(true);
    }

    public void setFactory(SimpleFactory simpleFactory) {

        this.simpleFactory = simpleFactory; //设置简单工厂对象
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
