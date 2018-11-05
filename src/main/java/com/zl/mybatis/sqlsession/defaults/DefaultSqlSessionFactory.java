package com.zl.mybatis.sqlsession.defaults;

import com.zl.mybatis.cfg.Configuration;
import com.zl.mybatis.sqlsession.SqlSession;
import com.zl.mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory的默认实现
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory{

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.configuration = cfg;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}

