package 创建型模式.工厂模式.工厂方法模式;

/**
 * author: mxg
 */
public  class BjSonFactory extends FatherFactory {
    @Override
    Food create(String orderType) {
        Food food = null;
        if(orderType.equals("meet")) {
            food = new BjMeetFood();
        }
        return food;
    }
}
