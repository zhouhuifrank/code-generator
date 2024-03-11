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
 * @TableName bi_data
 */
@TableName(value ="bi_data")
@Data
public class BiData implements Serializable {
    /**
     * 自增id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 表编号
     */
    @TableField(value = "table_no")
    private String table_no;

    /**
     * 表英文名
     */
    @TableField(value = "table_name_en")
    private String table_name_en;

    /**
     * 表中文名
     */
    @TableField(value = "table_name_cn")
    private String table_name_cn;

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

    /**
     * 数据文件编号(oss返回的编号)
     */
    @TableField(value = "data_file_no")
    private byte[] data_file_no;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}