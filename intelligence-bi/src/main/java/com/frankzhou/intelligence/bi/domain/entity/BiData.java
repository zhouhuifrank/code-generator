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
 * @description BI用户上传数据实体类
 * @date 2024-03-01
 */
@TableName(value ="bi_data")
@Data
public class BiData implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 表编号
     */
    @TableField(value = "table_no")
    private String tableNo;

    /**
     * 表英文名
     */
    @TableField(value = "table_name_en")
    private String tableNameEn;

    /**
     * 表中文名
     */
    @TableField(value = "table_name_cn")
    private String tableNameCn;

    /**
     * 数据文件编号
     */
    @TableField(value = "data_file_no")
    private String dataFileNo;

    /**
     * 数据导入状态
     */
    private Integer importStatus;

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