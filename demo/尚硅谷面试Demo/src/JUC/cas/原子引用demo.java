package JUC.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * author: mxg
 */
public class 原子引用demo {

    public static void main(String[] args) {
        Us z3 = new Us("z3",22);
        Us l4 = new Us("l4",25);

        AtomicReference<Us> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3,l4)+ "\t "+ atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3,l4)+ "\t "+ atomicReference.get().toString());

    }

}



class Us {
    String username;
    int age;

    public Us(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Us{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}