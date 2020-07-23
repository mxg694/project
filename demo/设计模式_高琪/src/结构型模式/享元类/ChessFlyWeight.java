package 结构型模式.享元类;

/**
 * author: mxg
 *
 * 结构型模式.享元类
 */
public interface ChessFlyWeight {

    void setColor(String  color);
    String getColor();
    void display( Coordinate d);

}

/**
 * 为内部状态提供成员变量 进行存储
 * 具体享元类
 */
class ConcreteChess implements  ChessFlyWeight {

    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate d) {
        System.out.println("棋子颜色:"+color);
        System.out.println("棋子位置:"+d.getX() + "------"+d.getY());
    }
}