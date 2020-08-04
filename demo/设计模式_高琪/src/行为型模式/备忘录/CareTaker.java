package 行为型模式.备忘录;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 * 负责人类
 */
public class CareTaker {
    private EmpMemento memento;

    /**
     * 多个备忘录
     */
    private List<EmpMemento> list = new ArrayList<>();


    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}
