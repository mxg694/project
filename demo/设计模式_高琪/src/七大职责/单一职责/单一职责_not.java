package 七大职责.单一职责;

/**
 * author: mxg
 * 没有按照单一职责原则
 *
 */
public class 单一职责_not {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("飞机");
        vehicle.run("轮船");

    }

}

class Vehicle {
    public void run(String vehicle) {
        System.out.println( vehicle+"在公路上运行");
    }
}