package 七大职责.单一职责;

/**
 * author: mxg
 */
public class 单一职责_finially {
    public static void main(String[] args) {
        FinallyVehicle vehicle = new FinallyVehicle();
        vehicle.run("汽车");
        vehicle.airRun("飞机");
        vehicle.waterRun("轮船");

    }
}

/**
 *   没有对原来代码改动很大，只是增加了方法
 *   虽然没有在类上遵守单一职责，在方法上遵守了单一职责
 */
class FinallyVehicle {
    public void run(String vehicle) {
        System.out.printf(vehicle + "在路上跑");
    }

    public void airRun(String vehicle) {
        System.out.printf(vehicle + "在天空跑");
    }

    public void waterRun(String vehicle) {
        System.out.printf(vehicle + "在水上跑");
    }
}
