package 创建型模式.工厂模式.简单工厂;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * author: mxg
 */
public class Client_orl {

    public Client_orl() {
        Pizza pizza = null;
		String orderType; // 订购披萨的类型
		do {
			orderType = getType();
			if (orderType.equals("greek")) {
				pizza = new GreekPizza();
				pizza.setName(" 希腊披萨 ");
			} else if (orderType.equals("china")) {
				pizza = new ChinaPizza();
				pizza.setName(" 奶酪披萨 ");
			}else {
				break;
			}
			pizza.product();

		} while (true);
    }

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
