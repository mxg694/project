package 尚硅谷.运行时区域.方法区;


import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * author: mxg


 -XX:MetaspaceSize=10m
 -XX:MaxMetaspaceSize=10m

 java.lang.OutOfMemoryError: Metaspace
 */
public class 方法区异常处理 extends ClassLoader {

    public static void main(String[] args) {
        int j = 0;
        方法区异常处理 test = new 方法区异常处理();

        try {
            for (int i = 1; i < 100000; i++) {
                // classWriter  ，用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                //指明 版本号 修饰符  类名 包名  父类  接口
                classWriter.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"C"+i,
                        null,"java/lang/Object", null);
               // 返回byte 数组
                byte[] code = classWriter.toByteArray();
                //类的加载
                test.defineClass("C" +i, code, 0,code.length);
                j++;
            }
        }catch (Throwable e) {
          e.printStackTrace();
        } finally {
            System.out.println(j);
        }
    }

}
