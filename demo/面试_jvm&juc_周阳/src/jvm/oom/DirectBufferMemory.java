package jvm.oom;

import java.nio.ByteBuffer;

/**
 * author: mxg
 * Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
  NIO
 堆内存充足，本地内存用光了
 */
public class DirectBufferMemory {
    public static void main(String[] args) {

        System.out.println("配置的maxDirectMemory："+
        sun.misc.VM.maxDirectMemory()/(double)1024/1024+"MB");

        ByteBuffer.allocateDirect(6*1024*1024);
    }
}
