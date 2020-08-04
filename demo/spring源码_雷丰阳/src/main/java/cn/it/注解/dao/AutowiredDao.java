package cn.it.注解.dao;

import org.springframework.stereotype.Repository;

/**
 * author: mxg
 */
//名字默认是类名首字母小写
@Repository
public class AutowiredDao {
    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
