package 行为型模式.观察者模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ObserverA observer = new ObserverA();
        ObserverA observer2 = new ObserverA();
        ObserverA observer3 = new ObserverA();

        subject.list.add(observer);
        subject.list.add(observer2);
        subject.list.add(observer3);
        subject.setState("aaa");

        System.out.println("############################");

        System.out.println(observer.getMystate());
        System.out.println(observer3.getMystate());
        System.out.println(observer2.getMystate());
    }
}
