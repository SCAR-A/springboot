package com.example.springboot.models.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * MyBatisPlusConfig
 */
@MapperScan(basePackages = {"com.example.**.mapper*"})
@Configuration
public class MyBatisPlusConfiguration {

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new FillFieldConfiguration();
    }

    /**
     * 持久化数据时，自动填充新增时间
     */
    public static class FillFieldConfiguration implements MetaObjectHandler {

        @Override
        public void insertFill(MetaObject metaObject) {
            metaObject.setValue("createTime", new Date());
        }

        @Override
        public void updateFill(MetaObject metaObject) {
            metaObject.setValue("updateTime", new Date());
        }
    }
    /**
     * 分页插件配置
     *
     * @return PaginationInnerInterceptor
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return mybatisPlusInterceptor;
    }
}
