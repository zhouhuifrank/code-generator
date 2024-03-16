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
 * @description bi图表实体类
 * @date 2024-03-01
 */
@TableName(value ="bi_chart")
@Data
public class BiChart implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 图表编号
     */
    @TableField(value = "chart_no")
    private String chartNo;

    /**
     * 图表名称
     */
    @TableField(value = "chart_name")
    private String chartName;

    /**
     * 分析目标
     */
    @TableField(value = "analysis_goal")
    private String analysisGoal;

    /**
     * 关联数据表编号
     */
    @TableField(value = "table_no")
    private String tableNo;

    /**
     * 图表类型
     */
    @TableField(value = "chart_type")
    private String chartType;

    /**
     * 分析结论
     */
    @TableField(value = "analysis_result")
    private String analysisResult;

    /**
     * 结果数据
     */
    @TableField(value = "result_data")
    private String resultData;

    /**
     * 图表状态
     */
    @TableField(value = "chart_status")
    private Integer chartStatus;

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