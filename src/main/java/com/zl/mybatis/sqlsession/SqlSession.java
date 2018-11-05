package com.zl.mybatis.sqlsession;

/**
 * sql执行类
 */
public interface SqlSession {
    /**
     * 根据接口返回代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
