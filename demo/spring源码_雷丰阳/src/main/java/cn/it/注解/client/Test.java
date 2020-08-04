package cn.it.注解.client;

import cn.it.注解.aop.Target;
import cn.it.注解.bean.*;
import cn.it.注解.config.*;
import cn.it.注解.ext.ExtConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * author: mxg
 */
public class Test {


    public static void main(String[] args) throws SQLException {
//        t_beanAndComponent();
//        t_import();
//        t_factoryBean();
//          t_生命周期();
//        t_profile();
//        t_aop();
//        t_tx();
        t_ext();
    }


    public static void t_beanAndComponent() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Bean注解_ComponentScan注解.class);
        Bean_1 bean = applicationContext.getBean(Bean_1.class);

        String[] namesForType = applicationContext.getBeanNamesForType(Bean_2.class);
        for (String name : namesForType) {
            System.out.println("name:" + name);
        }
    }

    public static void t_import() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Import注解_FactoryBean.class);
        String[] namesForType = applicationContext.getBeanNamesForType(ImportBean.class);
        for (String name : namesForType) {
            System.out.println("name:" + name);
        }
    }

    public static void t_factoryBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Import注解_FactoryBean.class);
        Object bean = applicationContext.getBean("myFactoryBean");
        System.out.println(bean);
        String[] namesForType = applicationContext.getBeanNamesForType(MyFactoryBean.class);

        for (String name : namesForType) {
            System.out.println("name:" + name);
        }
    }


    public static void t_生命周期() {
        //1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config_生命周期.class);
        System.out.println("容器创建完成...");

        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }

        //关闭容器
        applicationContext.close();
    }

    public static void t_profile() throws SQLException {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        //1、创建一个applicationContext
        //2、设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test");
        //3、注册主配置类
        applicationContext.register(Config_profile.class);
        //4、启动刷新容器
        applicationContext.refresh();


//        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
//        for (String string : namesForType) {
//            System.out.println(string);
//        }

        DataSource bean = applicationContext.getBean(DataSource.class);
        System.out.println(bean);
        applicationContext.close();
    }

    public static void t_aop() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config_Aop.class);

        //1、不要自己创建对象
//		Target target = new Target();
//		target.div(1, 1);
        Target target = applicationContext.getBean(Target.class);

//        target.div(1, 0);
        target.div(1, 1);

        applicationContext.close();
    }

    public static void t_tx() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config_Tx.class);
        applicationContext.close();
    }

    public static void t_ext() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);

        applicationContext.publishEvent(new ApplicationEvent(new String("自定义事件")) {
        });

        applicationContext.close();
    }

}
