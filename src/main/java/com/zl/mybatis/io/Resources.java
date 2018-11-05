package com.zl.mybatis.io;

import java.io.InputStream;

/**
 * 用于加载资源
 */
public class Resources {
    /**
     * 根据路径获取资源输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
