package 七大职责.单一职责;

/**
 * author: mxg
 * 完全按照单一职责原则
 *
 */
public class 单一职责_yes {
    public static void main(String[] args) {
        RoadVehicle RoadVehicle = new RoadVehicle();
        RoadVehicle.run("汽车");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");

        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("轮船");

    }

}
/**
 *  遵守了单一职责原则
    改动很大，将类分离，需要修改客户端代码

 */
class RoadVehicle {
    public void run(String vehicle) {
        System.out.println( vehicle+"在公路上运行");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println( vehicle+"在空中运行");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println( vehicle+"在水上运行");
    }
}