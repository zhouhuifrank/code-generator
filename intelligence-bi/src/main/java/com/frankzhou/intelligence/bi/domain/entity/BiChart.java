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
 * @TableName bi_chart
 */
@TableName(value ="bi_chart")
@Data
public class BiChart implements Serializable {
    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 图表编号
     */
    @TableField(value = "chart_no")
    private String chart_no;

    /**
     * 图表名称
     */
    @TableField(value = "chart_name")
    private String chart_name;

    /**
     * 分析目标
     */
    @TableField(value = "analysis_goal")
    private String analysis_goal;

    /**
     * 输入数据
     */
    @TableField(value = "input_data")
    private String input_data;

    /**
     * 图表类型
     */
    @TableField(value = "chart_type")
    private String chart_type;

    /**
     * 分析结论
     */
    @TableField(value = "analysis_result")
    private String analysis_result;

    /**
     * 结果数据
     */
    @TableField(value = "result_data")
    private String result_data;

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