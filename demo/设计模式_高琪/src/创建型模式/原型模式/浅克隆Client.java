package 创建型模式.原型模式;

/**
 * author: mxg
 */
public class 浅克隆Client {
    public static void main(String[] args) throws Exception{
        System.out.println("原型模式完成对象的创建");
        浅克隆 sheep = new 浅克隆("tom");

        sheep.friend = new 浅克隆("jack");

        浅克隆 sheep2 = (浅克隆) sheep.clone(); //克隆
        浅克隆 sheep3 = (浅克隆) sheep.clone(); //克隆


        System.out.println("sheep ="+ sheep.hashCode());
        System.out.println("sheep2 ="+sheep2.hashCode());
        System.out.println("sheep3 ="+sheep3.hashCode());
        System.out.println( sheep3.equals(sheep2));
        System.out.println("sheep2 =" + sheep2 + "sheep2.friend=" + sheep2.friend.hashCode());
        System.out.println("sheep3 =" + sheep3 + "sheep3.friend=" + sheep3.friend.hashCode());
    }
}
