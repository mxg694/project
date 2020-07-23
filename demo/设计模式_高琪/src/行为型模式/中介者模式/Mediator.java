package 行为型模式.中介者模式;

/**
 * author: mxg
 */
public interface Mediator {
    void register(String dnamem ,Department d);

    void command(String dnamem);

}
