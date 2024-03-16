package com.frankzhou.intelligence.bi.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 用户实体类
 * @date 2024-03-01
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户编号
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 电话号码
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 用户头像地址(oss返回的id)
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 性别(1男/0女)
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 邮箱地址
     */
    @TableField(value = "email")
    private String email;

    /**
     * 创建人
     */
    @TableField(value = "create_user")
    private String createUser;

    /**
     * 更新人
     */
    @TableField(value = "update_user")
    private String updateUser;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 数据状态
     */
    @TableField(value = "status")
    private String status;
}