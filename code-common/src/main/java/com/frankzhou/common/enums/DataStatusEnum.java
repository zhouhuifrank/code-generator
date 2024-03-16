package com.frankzhou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 数据状态枚举类
 * @date 2024-03-16
 */
@Getter
@AllArgsConstructor
public enum DataStatusEnum {

    NORMAL("NORMAL","正常"),
    DELETED("DELETE","删除");

    private final String code;

    private final String desc;

    private static Map<String, DataStatusEnum> enumMap = new HashMap<>();

    static {
        DataStatusEnum[] values = DataStatusEnum.values();
        for (DataStatusEnum value : values) {
            enumMap.put(value.getCode(), value);
        }
    }

    public static DataStatusEnum getEnumByCode(String code) {
        return Objects.nonNull(enumMap.get(code)) ? enumMap.get(code) : null;
    }
}
