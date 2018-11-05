package com.zl.mybatis.sqlsession.proxy;

import com.zl.mybatis.cfg.Mapper;
import com.zl.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * dao代理类
 */
public class MapperProxy implements InvocationHandler{

    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className + "."+ name;
        System.out.println("key:"+ key);
        Mapper mapper = mappers.get(key);
        if (mapper == null){
            throw new IllegalArgumentException("输入参数有误");
        }
        return new Executor().selectList(mapper, conn);
    }
}
