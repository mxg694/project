package cn.it.mybatisplus.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import jdk.nashorn.internal.ir.Optimistic;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * author: mxg
 */
@Configuration
@MapperScan("cn.it.mybatisplus.mapper")
public class Appconfig {

    /**
     * Mybatis-plus乐观锁插件
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * mybatis-plus 逻辑删除 插件
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * sql 执行性能分析插件
     * 开发环境用，线上不推荐
     */
    @Bean
    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor p = new PerformanceInterceptor();
        //ms, 最大执行时间
        p.setMaxTime(100);
        p.setFormat(true);
        return p;
    }
}
