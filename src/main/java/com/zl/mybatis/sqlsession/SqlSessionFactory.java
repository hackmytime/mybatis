package com.zl.mybatis.sqlsession;

/**
 * SqlSession工厂类
 */
public interface SqlSessionFactory {
    /**
     * 生产SqlSession
     * @return
     */
    SqlSession openSession();
}
