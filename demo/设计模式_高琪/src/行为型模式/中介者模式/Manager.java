package 行为型模式.中介者模式;

import java.util.HashMap;
import java.util.Map;

/**
 * author: mxg
 */
public class Manager implements Mediator {
   Map<String, Department> map = new HashMap<>();

    @Override
    public void register(String dnamem, Department d) {
       map.put(dnamem,d);
    }

    @Override
    public void command(String dnamem) {
        Department department = map.get(dnamem);
        department.doself();
    }
}
