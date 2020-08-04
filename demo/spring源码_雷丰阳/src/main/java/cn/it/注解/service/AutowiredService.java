package cn.it.注解.service;

import cn.it.注解.dao.AutowiredDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author: mxg
 */
@Service
public class AutowiredService {
    //@Qualifier("bookDao")
    //@Resource(name="bookDao2")
//    @Inject
    @Autowired
    private AutowiredDao autowiredDao;

    public void print(){
        System.out.println(autowiredDao);
    }

    @Override
    public String toString() {
        return "AutowiredService{" +
                "autowiredDao=" + autowiredDao +
                '}';
    }
}
