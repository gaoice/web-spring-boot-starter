package com.gaoice.web.oplog;

import java.util.HashMap;

/**
 * 用于业务中传递参数给 OplogService
 *
 * @author gaoice
 */
public class OplogContext {
    private static final ThreadLocal<HashMap<String, Object>> MAP_THREAD_LOCAL = new ThreadLocal<>();

    public static void put(String key, Object value) {
        HashMap<String, Object> map = MAP_THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>();
            MAP_THREAD_LOCAL.set(map);
        }
        map.put(key, value);
    }

    public static HashMap<String, Object> getMap() {
        return MAP_THREAD_LOCAL.get();
    }

    public static void clear() {
        MAP_THREAD_LOCAL.remove();
    }
}
