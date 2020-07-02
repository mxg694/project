package 尚硅谷.运行时区域.堆;

/**
 * author: mxg
 * 判断是否发生了逃逸分析: new的对象实体是否可能在方法为被调用
 */
public class 逃逸分析 {

    public 逃逸分析 obj;

    /**
     *  发生了逃逸
     * @return
     */
    public 逃逸分析 getInstance() {
        return obj==null?new 逃逸分析():obj;
    }

    /**
     * 发生了逃逸
     */
    public void setObj(){
        this.obj  = new 逃逸分析();
    }

    /**
     * 没有逃逸
     */
    public void m1() {
        逃逸分析 m = new 逃逸分析();
    }

    /**
     * 发生了逃逸
     */
    public void m2() {
        逃逸分析 m2 = getInstance();
    }

}
