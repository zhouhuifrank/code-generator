package com.frankzhou.intelligence.bi.domain.enums;

import com.frankzhou.common.enums.DataStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 消息状态枚举类
 * @date 2024-03-16
 */
@Getter
@AllArgsConstructor
public enum MessageStatusEnum {

    SEND_BEFORE(1,"待发送"),
    SENDING(2,"发送中"),
    EXCEPTION(3,"发送异常"),
    SUCCESS(4,"发送成功"),
    FAIL(5,"发送失败");

    private final Integer code;

    private final String desc;

    private static Map<Integer, MessageStatusEnum> enumMap = new HashMap<>();

    static {
        MessageStatusEnum[] values = MessageStatusEnum.values();
        for (MessageStatusEnum value : values) {
            enumMap.put(value.getCode(), value);
        }
    }

    public static MessageStatusEnum getEnumByCode(Integer code) {
        return Objects.nonNull(enumMap.get(code)) ? enumMap.get(code) : null;
    }
}
