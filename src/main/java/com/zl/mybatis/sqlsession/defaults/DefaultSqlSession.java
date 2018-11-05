package com.zl.mybatis.sqlsession.defaults;

import com.zl.mybatis.cfg.Configuration;
import com.zl.mybatis.sqlsession.proxy.MapperProxy;
import com.zl.mybatis.sqlsession.SqlSession;
import com.zl.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession的默认实现
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSession(Configuration configuration) {
        this.cfg = configuration;
        this.conn = DataSourceUtil.getConnection(configuration);
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(),conn));
    }

    public void close() {
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
