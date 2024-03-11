package com.frankzhou.intelligence.bi.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 自增id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 用户编号
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String user_name;

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
    private String create_user;

    /**
     * 更新人
     */
    @TableField(value = "update_user")
    private String update_user;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date create_time;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date update_time;

    /**
     * 数据状态
     */
    @TableField(value = "status")
    private String status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}