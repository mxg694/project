package 负载均衡算法.最小活跃次数;

import cn.it.luban.负载均衡算法.ServiceIps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * author: mxg
 *
 * 最小活跃次数
 */
public class LeastActive {

    public static String getServer() {

        //最小活跃次数的服务
        Integer minActive = null;
        for (Integer num : ServiceIps.active_list.values()) {
            if (minActive == null || num < minActive ) {
                minActive = num;
            }
        }

        List<String> minIps = new ArrayList<>();
        for (Map.Entry<String,Integer> entry : ServiceIps.active_list.entrySet()) {
            if (entry.getValue().equals(minIps)) {
                minIps.add(entry.getKey());
            }
        }
        if (minIps.size() >1) {

        }else  {
            return minIps.get(0);
        }
        return null;
    }
}
