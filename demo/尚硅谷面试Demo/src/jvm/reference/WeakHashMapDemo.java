package jvm.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * author: mxg
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
//        myHashMap();
        myWeakHashMap();
    }


    private static void myHashMap() {
        HashMap<String,String> hashMap = new HashMap<>();
        String k1 = "1";
        String v1 = "1";
        hashMap.put(k1,v1);
        System.out.println(hashMap);
        k1 = null;

        System.out.println("=============");
        System.out.println(hashMap);

        System.gc();
        System.out.println("=======After GC======");
        System.out.println(hashMap);
    }


    private static void myWeakHashMap() {
        WeakHashMap<String,String> hashMap = new WeakHashMap<>();
        String k1 = "2";
        String v1 = "2";
        hashMap.put(k1,v1);
        System.out.println(hashMap);
        k1 = null;

        System.out.println("=============");
        System.out.println(hashMap);

        System.gc();
        System.out.println("=======After GC======");
        System.out.println(hashMap);
    }
}
