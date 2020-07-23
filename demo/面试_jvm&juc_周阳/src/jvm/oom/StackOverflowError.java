package jvm.oom;

/**
 * author: mxg

 Exception in thread "main" java.lang.StackOverflowError
 */
public class StackOverflowError {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}
