package 结构型模式.享元类;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        ChessFlyWeight chess1 = ChessFlyweightFactory.getChess("黑色");
        ChessFlyWeight chess2 = ChessFlyweightFactory.getChess("黑色");

        System.out.println(chess1);
        System.out.println(chess2);

        System.out.println("增加外部处理状态===============");
        chess1.display(new Coordinate(10,10));
        chess2.display(new Coordinate(20,20));

        System.out.println(chess1.equals(chess2));
    }
}
