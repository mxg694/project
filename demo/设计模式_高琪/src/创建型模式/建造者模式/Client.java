package 创建型模式.建造者模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        AirShipBuilder builder = new MxgAirShipBuilder();
        AirShipDirector director = new MxgAirShipDirector(builder);
        director.builderAirShip();
    }
}
