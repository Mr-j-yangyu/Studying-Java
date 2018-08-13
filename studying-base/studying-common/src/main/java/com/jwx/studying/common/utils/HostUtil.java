package com.jwx.studying.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Description: ip信息读取工具类
 *
 * <p>
 * PackageName:com.jwx.studying.common.utils
 * FileName: HostUtil.java
 * Copyright: Copyright (c)2018. songxiaocai
 *
 * @author jiwenxiang@songxiaocai.com
 * @version 1.0, 2018/7/24
 */
public class HostUtil {
    private static InetAddress localHost = getHost();

    private static InetAddress getHost() {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            return null;
        }
    }

    public static InetAddress getLocalHost() {
        return localHost;
    }

    public static String getHostInfo() {
        return "ip=" + getHostAddress() + ",name=" + getHostName();
    }

    public static String getHostName() {
        if (localHost != null) {
            return localHost.getHostName();
        }
        return "";
    }

    public static String getHostAddress() {
        if (localHost != null) {
            return localHost.getHostAddress();
        }
        return "";
    }
}