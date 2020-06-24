package 尚硅谷.类加载.类加载器;

/**
 * author: mxg
 */
public class classLoaderTest {

    public static void main(String[] args) {
        //获取系统类加载器   sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader:" + systemClassLoader);

        //获取其上层： 扩展类加载器 sun.misc.Launcher$ExtClassLoader@4554617c
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println("extClassLoader:" + extClassLoader);

        //获取其上层：   null
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println("bootstrapClassLoader:" + bootstrapClassLoader);

        //自定义的类加载器
        ClassLoader classLoader = classLoaderTest.class.getClassLoader();
        System.out.println("自定义类加载器：" + classLoader);

        //String 类的类加载器: 引导类加载器
        //java的核心类库就是由 引导类加载器加载的
        ClassLoader strClassLoader = String.class.getClassLoader();
        System.out.println("String类加载器：" + strClassLoader);

    }


}
