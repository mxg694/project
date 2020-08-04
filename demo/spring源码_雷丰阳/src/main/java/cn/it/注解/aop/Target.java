package cn.it.注解.aop;

/**
 * author: mxg
 */
public class Target {
    public int div(int i,int j){
        System.out.println("Target...div...");
        return i/j;
    }
}
