package 创建型模式.工厂模式.抽象工厂;

import 创建型模式.工厂模式.工厂方法模式.Food;

/**
 * author: mxg
 */
public interface AbsFactory {
    public Food create(String type);
}
