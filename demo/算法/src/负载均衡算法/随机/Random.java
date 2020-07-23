package 负载均衡算法.随机;

import cn.it.luban.负载均衡算法.ServiceIps;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 *
 * @author 17934
 */
public class Random {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            System.out.println(getServer());
        }
    }

    private static String getServer() {
        java.util.Random random = new java.util.Random();
        int pos = random.nextInt(ServiceIps.list.size());
        return ServiceIps.list.get(pos);
    }

    // 太耗时 权重随机算法
    private static String getWeightServer() {
        List<String> ips = new ArrayList<>();
        for (String key : ServiceIps.weight_list.keySet()) {
            Integer num = ServiceIps.weight_list.get(key);
            for (int i = 0; i < num; i++) {
                ips.add(key);
            }
        }

        java.util.Random random = new java.util.Random();
        int pos = random.nextInt(ips.size());
        return ips.get(pos);
    }

    /**
     * 更进一步： 判断权重是否一样，如果一样， 可以用简单的方法
     *
     * @return
     */
    private static String getWeightServer2() {
        Integer totalWeight = 0;
        for (Integer weight : ServiceIps.weight_list.values()) {
            totalWeight += weight;
        }
        java.util.Random random = new java.util.Random();
        int pos = random.nextInt(totalWeight);

        for (String ip : ServiceIps.weight_list.keySet()) {
            Integer weight = ServiceIps.weight_list.get(ip);
            if (pos <= weight) {
                return ip;
            }
            pos -= weight;
        }


        return null;
    }
}
