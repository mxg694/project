package 结构型模式.享元类;

import java.util.HashMap;
import java.util.Map;

/**
 * author: mxg
 * 享元工厂
 *
 */
public class ChessFlyweightFactory {
    //享元池
    private  static Map<String,ChessFlyWeight> map = new HashMap<>();

    public static ChessFlyWeight getChess(String color) {
        if (map.get(color) != null) {
            return map.get(color);
        }else {
            ChessFlyWeight c = new ConcreteChess(color);
            map.put(color,c);
            return c;
        }
    }
}
