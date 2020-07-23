package 行为型模式.迭代器模式;

/**
 * author: mxg
 */
public interface MyIterator {

    void first();
    void next();
    boolean hasNext();

    /**
     * 获取当然游标执行的对象
     * @return
     */
    Object getCurrentObj();
}
