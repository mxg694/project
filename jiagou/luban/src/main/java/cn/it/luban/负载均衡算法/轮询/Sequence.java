package cn.it.luban.负载均衡算法.轮询;

/**
 * author: mxg
 *
 *  轮询  指针
 *
 */
public class Sequence {
    public static Integer seqenceNum = 0;

    public static Integer getAndAdd() {
        return  ++seqenceNum;
    }
}
