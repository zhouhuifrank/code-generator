package com.frankzhou.common.base;

/**
 * @author: this.FrankZhou
 * @date: 2012/12/27
 * @description: 系统错误码
 */
public class ApiResultCodeConstant {
    
    public static final ApiResultCodeDTO SUCCESS = new ApiResultCodeDTO(200,"success","请求成功");

    // 请求相关错误码

    public static final ApiResultCodeDTO REQUEST_PARAM_ERROR = new ApiResultCodeDTO(301,"request param is wrong","请求参数错误");

    public static final ApiResultCodeDTO SYSTEM_ERROR = new ApiResultCodeDTO(302,"system error","系统异常");

    // 业务相关错误码

    public static final ApiResultCodeDTO PHONE_IS_INVALID = new ApiResultCodeDTO(401,"phone is invalid","手机号不合法");

    public static final ApiResultCodeDTO CODE_IS_ERROR = new ApiResultCodeDTO(402,"verify code is error","验证码错误");

    public static final ApiResultCodeDTO USER_NOT_REGISTER = new ApiResultCodeDTO(403,"user is not register","用户没有注册");

    public static final ApiResultCodeDTO PASSWORD_ERROR = new ApiResultCodeDTO(404,"password error","密码错误");

    public static final ApiResultCodeDTO USER_HAS_EXISTED = new ApiResultCodeDTO(405,"user has existed","用户已经注册");

    public static final ApiResultCodeDTO TOKEN_NOT_EXISTED = new ApiResultCodeDTO(406,"token is not existed","token不存在");

    public static final ApiResultCodeDTO USER_NOT_LOGIN = new ApiResultCodeDTO(407,"user is not login","用户未登录");

    public static final ApiResultCodeDTO POST_THUMB_ERROR = new ApiResultCodeDTO(408,"post thumb failed","帖子点赞失败，请重试");

    public static final ApiResultCodeDTO POST_FAVOUR_ERROR = new ApiResultCodeDTO(409,"post favour failed","帖子收藏失败，请重试");

    public static final ApiResultCodeDTO DISTRIBUTED_LOCK_FAIL = new ApiResultCodeDTO(410,"distributed lock acquire fail","分布式锁获取失败");

    public static final ApiResultCodeDTO TOKEN_GEN_FAIL = new ApiResultCodeDTO(411,"jwt token generate faile","token生成失败");

    public static final ApiResultCodeDTO TOKEN_IS_EXPIRED = new ApiResultCodeDTO(412,"jwt token has expired","token过期失效");

    // 数据库相关错误码

    public static final ApiResultCodeDTO DB_QUERY_NO_DATA = new ApiResultCodeDTO(601,"database query no data","数据库查询无此数据");

    public static final ApiResultCodeDTO DB_INSERT_COUNT_ERROR = new ApiResultCodeDTO(602,"database insert count error","数据库插入条数错误");

    public static final ApiResultCodeDTO DB_UPDATE_COUNT_ERROR = new ApiResultCodeDTO(603,"database update count error","数据库更新条数错误");

    public static final ApiResultCodeDTO DB_DELETE_COUNT_ERROR = new ApiResultCodeDTO(604,"database delete count error","数据库删除条数错误");

    // Excel读取错误

    public static final ApiResultCodeDTO EXCEL_READ_ERROR = new ApiResultCodeDTO(701,"excel read error","excel解析错误");

    public static final ApiResultCodeDTO EXCEL_WRITE_ERROR = new ApiResultCodeDTO(702,"excel write error","excel表格写出错误");

    // 权限错误

    public static final ApiResultCodeDTO NO_AUTH_ERROR = new ApiResultCodeDTO(801,"no auth error","用户没有权限");

    ApiResultCodeConstant() {
    }
}
