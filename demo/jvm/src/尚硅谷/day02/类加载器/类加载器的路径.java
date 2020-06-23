package 尚硅谷.day02.类加载器;

import sun.misc.Launcher;

import java.net.URL;

/**
 * author: mxg
 */
public class 类加载器的路径 {

    public static void main(String[] args) {
        System.out.println("启动类加载器");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL el: urLs) {
            System.out.println(el.toExternalForm());
        }


        System.out.println("********************扩展类加载器***********************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
    }

}
