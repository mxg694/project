package 行为型模式.观察者模式;

/**
 * author: mxg
 */
public class ObserverA implements Observer{
    /**
     * 需要和目标对象的值保持一致
     */
    private  String mystate;

    @Override
    public void update(Subject subject) {
        mystate = ((ConcreteSubject)subject).getState();
    }

    public String getMystate() {
        return mystate;
    }

    public void setMystate(String mystate) {
        this.mystate = mystate;
    }
}
