package day1;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * author: mxg
 * <p>
 * 演示元空间内存溢出
 *
 * -XX:MaxMetaspaceSize=8m  最大元空间大小
 */
public class 方法区内存溢出 extends ClassLoader{

    public static void main(String[] args) {
        int j = 0;
        方法区内存溢出 test = new 方法区内存溢出();
        for (int i = 0; i < 10000; i++) {
            j++;
            //ClassWriter 生成类的二进制字节码
            ClassWriter cw = new ClassWriter(0);
            //版本号  public 类名   包名  父类  接口
            cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "class" + i, null, "java/lang/Object", null);
            byte[] code = cw.toByteArray();
            //执行类的加载
            test.defineClass("class"+i,code,0,code.length);
        }
    }
}
