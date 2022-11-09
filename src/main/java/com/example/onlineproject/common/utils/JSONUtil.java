package com.example.onlineproject.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JSONUtil {

    public static String toJSONString(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static <T> T parseObject(String json, TypeReference<T> typeReference) {
        return JSON.parseObject(json, typeReference);
    }

    public static <T> T parseObject(Object obj, Class<T> clazz) {
        String json = toJSONString(obj);
        return parseObject(json, clazz);
    }

    private static Gson gson = new GsonBuilder().serializeNulls().create();

    public static <T> T parseGObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> T parseGObject(String json, TypeToken<T> typeToken) {
        return gson.fromJson(json, typeToken.getType());
    }

    public static String toGSONString(Object obj) {
        return gson.toJson(obj);
    }
}
