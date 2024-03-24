package com.frankzhou.data.sync.domain.entity;

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
 * @description topic信息实体类
 * @date 2024-03-09
 */
@Data
@TableName(value ="data_topic_info")
public class DataTopicInfo implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * topic名称
     */
    @TableField(value = "topic_name")
    private String topicName;

    /**
     * topic描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 分区数
     */
    @TableField(value = "partition_num")
    private Integer partitionNum;

    /**
     * 副本数
     */
    @TableField(value = "replication_num")
    private Integer replicationNum;

    /**
     * 生命周期
     */
    @TableField(value = "lifecycle")
    private Integer lifecycle;

    /**
     * 是否允许分区扩展(1允许/0不允许)
     */
    @TableField(value = "allow_expand")
    private Integer allowExpand;

    /**
     * 日志清理策略(delete/compact)
     */
    @TableField(value = "cleanup_policy")
    private String cleanupPolicy;

    /**
     * 消息数据类型(AVRO/JSON/STRING)
     */
    @TableField(value = "msg_data_type")
    private String msgDataType;

    /**
     * 来源数据库类型(FLINK_CDC_MYSQL/FLINK_CDC_MYSQL/DTS_MYSQL)
     */
    @TableField(value = "source_database_type")
    private String sourceDatabaseType;

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