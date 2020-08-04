package 行为型模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 * 主题对象
 */
public class Subject {

    protected List<Observer> list = new ArrayList<>();

    /**
     * 通知所有观察者
     */
    public void notityAllObserver() {
        for (Observer observer: list) {
            observer.update(this);
        }

    }
}
