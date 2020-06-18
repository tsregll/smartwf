package com.smartwf.common.constant;

/**
 * @Date: 2018/9/17 15:53
 * @Description: 常量
 */
public class Constants {

    public static final String SMARTWF_TOKEN = "smartwfToken";

    public static final String SUCCESS = "成功";

    public static final String FAIL = "失败";

    public static final String ERROR = "错误";

    public static final String PER_CENT = "%";

    public static final String EMPTY = "empty";

    public static final String BLANK = "";

    public static final int ONE = 1;

    public static final int ZERO = 0;
    
    public static final int ADMIN = 2;
    
    public static final int ALARMLEVEL = 4; //0故障 1严重  2一般  3普通
    
    /**
     * 默认租户状态========================================================
     */ 
    public static final Integer ISSEL = 1;//默认租户
    

    /**
     * 状态码========================================================
     */
    public static final int INTERNAL_SERVER_ERROR = 500;

    public static final int GONE = 410;

    public static final int CONFLICT = 409;

    public static final int FORBIDDEN = 403;

    public static final int UNAUTHORIZED = 401;

    public static final int BAD_REQUEST = 400;
    
    public static final int EQU_SUCCESS = 200;

    /**
     * 状态码========================================================
     */
    //wso2 soap请求响应时间
    public static final int SOCKET_TIME_OUT = 90000;
    public static final int CONNECT_TIME_OUT = 90000;
    //wso2 各租户默认密码
    public static final String WSO2_PASSWORD = "000000";

}
