package 结构型模式.装饰器模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {

        ICar car = new Car();

        car.move();

        System.out.println("增加飞行");

        FlyCar flyCar = new FlyCar(car);
        flyCar.move();
        System.out.println("水里游");
        WaterCar waterCar = new WaterCar(flyCar);
        waterCar.move();
    }
}
