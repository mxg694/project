package jvm.oom;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 * <p>
 * -XX:MetaspaceSize=8M -XX:MaxMetaspaceSize=8m
 */
public class MetaSpaceError extends ClassLoader {


    public static void main(String[] args) {
        int j = 0;
        MetaSpaceError test = new MetaSpaceError();

        try {
            for (int i = 1; i < 5000; i++) {
                // classWriter  ，用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                //指明 版本号 修饰符  类名 包名  父类  接口
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "class" + i,
                        null, "java/lang/Object", null);
                // 返回byte 数组
                byte[] code = classWriter.toByteArray();
                //类的加载
                test.defineClass("class" + i, code, 0, code.length);
                j++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
