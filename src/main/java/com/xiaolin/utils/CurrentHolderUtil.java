package com.xiaolin.utils;

/**
 * @author lzh
 * @description: 获取操作人util
 * @date 2025/11/11 17:21
 */
public class CurrentHolderUtil {
    private static final ThreadLocal<String> CURRENT_LOCAL = new ThreadLocal<>();

    public static void setCurrentUser(String username) {
        CURRENT_LOCAL.set(username);
    }

    public static String getCurrentUser() {
        return CURRENT_LOCAL.get();
    }

    public static void remove() {
        CURRENT_LOCAL.remove();
    }
}
