package cn.it.注解.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * author: mxg
 */
public class BeanCondition implements Condition {
    /**
     *
     * @param conditionContext   判断条件能使用的上下文（环境）
     * @param annotatedTypeMetadata  注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //1、能获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //2、获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //3、获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        //4、获取到bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        /**
         *  这边的逻辑 需要根据实际情况
         */
        String property = environment.getProperty("os.name");

        if(property.contains("Windows")){
            return true;
        }
        return false;
    }
}
