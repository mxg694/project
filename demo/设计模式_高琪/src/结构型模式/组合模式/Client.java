package 结构型模式.组合模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        Folder f1 = new Folder("我的电脑");
        AbstractFile f2 = new Folder("收藏夹");
        AbstractFile f3 = new Folder("其他");
        f1.add(f2);
        f1.add(f3);
        f1.killVirus();
    }
}
