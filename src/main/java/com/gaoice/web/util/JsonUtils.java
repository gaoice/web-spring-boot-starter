package com.gaoice.web.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;

/**
 * Gson 的简单封装
 * Simple wrapper for Gson
 *
 * @author gaoice
 */
public class JsonUtils {

    public static final Gson GSON = new Gson();

    public static String toJson(Object o) {
        return GSON.toJson(o);
    }

    public static <T> T fromJson(String s, Class<T> c) {
        return GSON.fromJson(s, c);
    }

    public static <T> T fromJson(String s, Type t) {
        return GSON.fromJson(s, t);
    }

    public static <T> T fromJson(String s, TypeToken<T> t) {
        return GSON.fromJson(s, t.getType());
    }

    public static JsonObject fromJson(String s) {
        return GSON.fromJson(s, JsonObject.class);
    }

}
