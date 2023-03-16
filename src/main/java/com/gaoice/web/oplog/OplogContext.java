package com.gaoice.web.oplog;

import com.gaoice.common.map.ExtendedHashMap;

/**
 * 用于业务中传递参数给 OplogService
 *
 * @author gaoice
 */
public class OplogContext {
    private static final ThreadLocal<ExtendedHashMap<String, Object>> EXTENDED_MAP = new ThreadLocal<>();

    public static ExtendedHashMap<String, Object> append(String key, Object value) {
        ExtendedHashMap<String, Object> extendedHashMap = EXTENDED_MAP.get();
        if (extendedHashMap == null) {
            extendedHashMap = new ExtendedHashMap<>();
            EXTENDED_MAP.set(extendedHashMap);
        }
        extendedHashMap.append(key, value);
        return extendedHashMap;
    }

    public static ExtendedHashMap<String, Object> get() {
        return EXTENDED_MAP.get();
    }

    public static void clear() {
        EXTENDED_MAP.remove();
    }
}
