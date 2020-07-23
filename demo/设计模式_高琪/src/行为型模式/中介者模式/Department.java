package 行为型模式.中介者模式;

/**
 * author: mxg
 *
 * 各个部门接口
 */
public interface Department {
    void doself(); //做自己的事
    void askRequest(); //发送申请
}

