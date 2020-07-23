package 创建型模式.原型模式;

/**
 * author: mxg
 */
public class 浅克隆  implements Cloneable {

    private String name;

    浅克隆 friend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public 浅克隆 getFriend() {
        return friend;
    }

    public 浅克隆(String name) {
        this.name = name;
    }

    public void setFriend(浅克隆 friend) {
        this.friend = friend;
    }

    @Override
    public String toString() {
        return "浅克隆{" +
                "name='" + name + '\'' +
                ", friend=" + friend +
                '}';
    }

    //克隆该实例，使用默认的clone方法来完成
    @Override
    protected Object clone() throws CloneNotSupportedException {
        浅克隆 sheep = null;
        try {
            sheep = (浅克隆)super.clone();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return sheep;
    }
}
