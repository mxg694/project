package cn.it;

import cn.it.bean.Person;
import cn.it.config.Appconfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author: mxg
 */
public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        Person person = ac.getBean(Person.class);
        System.out.println(person);
        System.out.println("aaaa");
    }
}
