package cn.it.luban.负载均衡算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: mxg
 */
public class ServiceIps  {
    public static List<String> list;
    public static Map<String, Integer> weight_list= new HashMap<>();
    public static Map<String, Integer> active_list= new HashMap<>();
    static {
        list = new ArrayList<>();

        list.add("192.168.0.1");
        list.add("192.168.0.2");
        list.add("192.168.0.3");
        list.add("192.168.0.4");
        list.add("192.168.0.5");

        weight_list.put("192.168.0.2",2);
        weight_list.put("192.168.0.3",3);
        weight_list.put("192.168.0.4",4);
        weight_list.put("192.168.0.5",5);

        active_list.put("192.168.0.2",2);
        active_list.put("192.168.0.3",3);
        active_list.put("192.168.0.4",4);
        active_list.put("192.168.0.5",5);


    }
}
