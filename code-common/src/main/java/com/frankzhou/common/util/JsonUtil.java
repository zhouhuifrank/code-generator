package com.frankzhou.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description Json解析和转化工具类
 * @date 2024-03-16
 */
@Slf4j
public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T toObject (String jsonStr, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            log.warn("json解析错误 errorMsg:{}", e.getMessage());
        }

        return null;
    }

    public static <T> T toObject(String jsonStr, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(jsonStr, typeReference);
        } catch (JsonProcessingException e) {
            log.warn("json解析错误 errorMsg:{}", e.getMessage());
        }

        return null;
    }

    public static <T> List<T> toList(String jsonStr, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonStr, new TypeReference<List<T>>() {});
        } catch (JsonProcessingException e) {
            log.warn("json解析错误 errorMsg:{}", e.getMessage());
        }

        return null;
    }

    public static <T> String toJsonStr(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.warn("json解析错误 errorMsg:{}", e.getMessage());
        }

        return null;
    }
}
