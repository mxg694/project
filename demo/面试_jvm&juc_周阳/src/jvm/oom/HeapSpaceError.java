package jvm.oom;

/**
 * author: mxg

 Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */
public class HeapSpaceError {

    public static void main(String[] args) {
        String string = "aaaaaaaa";
        while (true) {
            string += string;
        }
    }
}
