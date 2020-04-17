package cn.it.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Mp 自动填充 的实现
 * author: mxg
 */
@Component
public class MyMeateObjectHandler implements MetaObjectHandler {
    /**
     * 使用Mp 进行一个添加操作，这个方法会执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject );
        this.setFieldValByName("updateTime",new Date(),metaObject );
        this.setFieldValByName("version",1,metaObject );
    }

    /**
     * 使用Mpz执行一个更新操作，这个方法会执行
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject );
    }
}
