package com.learn.servlet.custom_view_framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomHttpSessionOnServerRepository {
    private final static Map<String, CustomHttpSession> session = new ConcurrentHashMap<>();

    public static CustomHttpSession getSession(String sessionId){
        return getSession(sessionId, true);
    }

    private static CustomHttpSession getSession(String sessionId, boolean canCreate) {
        CustomHttpSession result = session.get(sessionId);
        if (result == null && canCreate){
            result = new CustomHttpSession();
            session.put(sessionId, result);
        }
        return result;
    }
}
