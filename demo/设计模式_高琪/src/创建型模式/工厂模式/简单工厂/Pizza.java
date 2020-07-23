package 创建型模式.工厂模式.简单工厂;

/**
 * author: mxg
 */
public abstract class Pizza {

    private String name;

    public abstract void product();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
