package com.gaoice.oplog;

import com.gaoice.common.map.SimpleMap;

/**
 * @author gaoice
 */
public class OplogDetail {
    private static final ThreadLocal<SimpleMap<String, Object>> LOG_DETAIL_MAP = new ThreadLocal<>();

    public static SimpleMap<String, Object> append(String key, Object value) {
        SimpleMap<String, Object> detailMap = LOG_DETAIL_MAP.get();
        if (detailMap == null) {
            detailMap = new SimpleMap<>();
            LOG_DETAIL_MAP.set(detailMap);
        }
        detailMap.append(key, value);
        return detailMap;
    }

    public static SimpleMap<String, Object> get() {
        return LOG_DETAIL_MAP.get();
    }

    public static void clear() {
        LOG_DETAIL_MAP.remove();
    }
}
