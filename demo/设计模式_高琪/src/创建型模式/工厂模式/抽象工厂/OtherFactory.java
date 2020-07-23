package 创建型模式.工厂模式.抽象工厂;


import 创建型模式.工厂模式.工厂方法模式.Food;
import 创建型模式.工厂模式.工厂方法模式.OtherMeetFood;


public class OtherFactory implements AbsFactory {

	@Override
	public Food create(String orderType) {
		System.out.println("~其他工厂~");
		Food pizza = null;
		if (orderType.equals("meet")) {
			pizza = new OtherMeetFood();
		}
		return pizza;
	}

}
