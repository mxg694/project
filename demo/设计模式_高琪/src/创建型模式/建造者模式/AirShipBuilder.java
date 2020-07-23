package 创建型模式.建造者模式;

/**
 * author: mxg
 *
  构建 公共 抽象类
 */
public interface AirShipBuilder {

    OrbitalModule buildOrbitalModule();
    Engine buildEngine();
    EscapeTower buildEscapeTower();

}
