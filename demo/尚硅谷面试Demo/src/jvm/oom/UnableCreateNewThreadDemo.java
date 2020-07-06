package jvm.oom;

/**
 * author: mxg
 */
public class UnableCreateNewThreadDemo {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            i++;
            System.out.println("i=" + i);
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
