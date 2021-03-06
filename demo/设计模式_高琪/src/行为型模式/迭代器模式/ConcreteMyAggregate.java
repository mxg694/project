package 行为型模式.迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 */
public class ConcreteMyAggregate {

    private List<Object> list = new ArrayList<>();

    /**
     * 获得迭代器
     * @return
     */
    public MyIterator createMyIterator() {
        return new ConcreteIterator();
    }

    //使用内部类定义迭代器，可以直接使用外部类的属性
    private class ConcreteIterator implements MyIterator {
        /**
         * 定义游标用于记录遍历时的位置
         */
        private int cursor;

        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public void next() {
            if (cursor< list.size()) {
                cursor = cursor+1;
            }
        }

        @Override
        public boolean hasNext() {
            if (cursor< list.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
