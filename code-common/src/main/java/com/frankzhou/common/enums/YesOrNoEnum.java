package com.frankzhou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 1/0二元枚举
 * @date 2024-03-16
 */
@Getter
@AllArgsConstructor
public enum YesOrNoEnum {

    YES(1,"是"),
    NO(0,"否");

    private final Integer code;

    private final String desc;

    private static Map<Integer, YesOrNoEnum> enumMap = new HashMap<>();

    static {
        YesOrNoEnum[] values = YesOrNoEnum.values();
        for (YesOrNoEnum value : values) {
            enumMap.put(value.getCode(), value);
        }
    }

    public static YesOrNoEnum getEnumByCode(Integer code) {
        return Objects.nonNull(enumMap.get(code)) ? enumMap.get(code) : null;
    }
}
