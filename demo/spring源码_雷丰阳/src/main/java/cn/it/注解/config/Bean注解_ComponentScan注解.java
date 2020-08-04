package cn.it.注解.config;

import cn.it.注解.bean.Bean_1;
import cn.it.注解.bean.Bean_2;
import cn.it.注解.condition.BeanCondition;
import org.springframework.context.annotation.*;

/**
 * author: mxg
 */
//类中组件统一设置。满足当前条件，这个类中配置的所有bean注册才能生效；
@Conditional({BeanCondition.class})
@Configuration
@ComponentScans(
        value = {
                @ComponentScan(value = "cn.it", includeFilters = {
/*						@Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
						@Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class}),*/
//                        @ComponentScan.Filter(type= FilterType.CUSTOM,classes={MyTypeFilter.class})
                }, useDefaultFilters = false)
        }
)
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class Bean注解_ComponentScan注解 {

    /**
     * * @Scope:调整作用域
     *  prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
     *  					每次获取的时候才会调用方法创建对象；
     *  singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。
     *  			以后每次获取就是直接从容器（map.get()）中拿，
     *  request：同一次请求创建一个实例
     *  session：同一个session创建一个实例
     * @Lazy
     *  懒加载：
     * 		单实例bean：默认在容器启动的时候创建对象；
     * 		懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
     * @return
     */
    @Scope("prototype")
    @Bean
    public Bean_1 bean_1() {
        return new Bean_1();
    }


    @Bean("bean2")
    public Bean_2 Bean_2() {
        return new Bean_2();
    }

    @Conditional(BeanCondition.class)
    @Bean("linus")
    public Bean_2 person02(){
        return new Bean_2();
    }
}
