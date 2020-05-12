package cn.it.luban.负载均衡算法.轮询;

import cn.it.luban.负载均衡算法.ServiceIps;

import java.util.HashMap;
import java.util.Map;

/**
 * 轮询
 * <p>
 * author: mxg
 */
public class RoundRobin {

    private static Integer pos = 0;
    private static Integer total = ServiceIps.list.size();


    public static String getServer() {
        String ip = "";
        synchronized (pos) {
            if (pos >= total) {
                pos = 0;
            }
            ip = ServiceIps.list.get(pos);
            pos++;
        }

        return ip;
    }

    public static String getWeightServer() {
        Integer totalWeight = 0;
        for (Integer weight : ServiceIps.weight_list.values()) {
            totalWeight += weight;
        }
        Integer sequenceNum = Sequence.getAndAdd();
        Integer pos = sequenceNum % totalWeight;

        for (String ip : ServiceIps.weight_list.keySet()) {
            Integer weight = ServiceIps.weight_list.get(ip);
            if (pos < weight) {
                return ip;
            }
            pos -= weight;
        }

        return null;
    }

    /**
     * 平滑加权重轮询
     */

    private static Map<String, Weight> weightMap = new HashMap<>();

    public static String getSmoothWeightServer() {
        int totalweight = ServiceIps.weight_list.values().stream()
                .reduce(0, (w1, w2) -> w1 + w2);
        //初始化所以weight
        if (weightMap.isEmpty()) {
            for (String ip : ServiceIps.weight_list.keySet()) {
                Integer wei = ServiceIps.weight_list.get(ip);
                weightMap.put(ip, new Weight(wei, wei, ip));
            }
        }
        //获取最大的weight
        Weight maxCurrentWeight = null;
        for (Weight weight : weightMap.values()) {
            if (maxCurrentWeight == null || weight.getCurrentWeight() > maxCurrentWeight.getCurrentWeight()) {
                maxCurrentWeight = weight;
            }
        }
        //当前最大值的weight的当前值 减去 总权重
        maxCurrentWeight.setCurrentWeight(maxCurrentWeight.getCurrentWeight() - totalweight);
        // 更新所有权重，  当前权重值 + 权重本身的值
        for (Weight weight : weightMap.values()) {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }

        return maxCurrentWeight.getIp();
    }

}
