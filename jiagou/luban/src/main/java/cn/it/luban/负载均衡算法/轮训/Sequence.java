package cn.it.luban.负载均衡算法.轮训;

/**
 * author: mxg
 */
public class Sequence {
    public static Integer seqenceNum = 0;

    public static Integer getAndAdd() {
        return  ++seqenceNum;
    }
}
