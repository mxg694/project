package 创建型模式.工厂模式.抽象工厂;

import 创建型模式.工厂模式.工厂方法模式.BjMeetFood;
import 创建型模式.工厂模式.工厂方法模式.Food;


public class BJFactory implements AbsFactory {

	@Override
	public Food create(String orderType) {
		System.out.println("~北京工厂~");
		Food food = null;
		if(orderType.equals("meet")) {
			food = new BjMeetFood();
		}
		return food;
	}

}
