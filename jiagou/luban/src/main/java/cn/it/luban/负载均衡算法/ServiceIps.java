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

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        weight_list.put("A",2);
        weight_list.put("B",3);
        weight_list.put("C",4);
        weight_list.put("D",5);

        active_list.put("A",2);
        active_list.put("B",3);
        active_list.put("C",4);
        active_list.put("D",5);


    }
}
