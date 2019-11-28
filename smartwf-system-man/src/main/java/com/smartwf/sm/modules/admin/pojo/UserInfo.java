package com.smartwf.sm.modules.admin.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @Description: 系统用户表
 */
@Data
@Table(name = "sys_user_info")
public class UserInfo implements Serializable{
	 private static final long serialVersionUID = 1L;
	/**
     * 主键id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Integer id;
   
	/**
	 * 用户编码
	 */
	private String userCode;
	/**
	 * 登录账号
	 */
	private String loginCode;
	/**
	 * 用户昵称
	 */
	private String userName;
	/**
	 * 登录密码
	 */
	private String pwd;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 办公电话
	 */
	private String phone;
	/**
	 * 性别
            0男 1女
	 */
	private Integer sex;
	/**
	 * 头像路径
	 */
	private String avatar;
	/**
	 * 个性签名
	 */
	private String sign;
	/**
	 * 微信号
	 */
	private String wxOpenid;
	/**
	 * qq号
	 */
	private String qqOpenid;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 租户id
	 */
	private Integer tenantId;
	/**
	 * 审批状态
            0-审批通过
            1-审批中
            2-待审批
	 */
	private String status;
	/**
	 * 管理员类型
            0非管理员
            1系统管理员
            
	 */
	private Integer mgrType;
	/**
	 * 保密问题
	 */
	private String pwdQuestion;
	/**
	 * 保密问题答案
	 */
	private String pwdQuestionAnswer;
	/**
	 * 保密问题2
	 */
	private String pwdQuestion2;
	/**
	 * 保密问题答案2
	 */
	private String pwdQuestionAnswer2;
	/**
	 * 保密问题3
	 */
	private String pwdQuestion3;
	/**
	 * 保密问题答案3
	 */
	private String pwdQuestionAnswer3;
	/**
	 * 是否有效
            0有效  
            1无效
            
	 */
	private Integer enable;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人id
	 */
	private Integer createUserId;
	/**
	 * 创建人姓名
	 */
	private String createUserName;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 修改人id
	 */
	private Integer updateUserId;
	/**
	 * 修改人姓名
	 */
	private String updateUserName;
	
}