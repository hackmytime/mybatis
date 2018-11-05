package com.zl.mybatis.sqlsession;

import com.zl.mybatis.cfg.Configuration;
import com.zl.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.zl.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * SqlSessionFactory的构建者类
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据配置文件构建SqlSessionFactory
     * @param is
     * @return
     */
    public SqlSessionFactory build(InputStream is) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(is);
        return new DefaultSqlSessionFactory(cfg);
    }
}
