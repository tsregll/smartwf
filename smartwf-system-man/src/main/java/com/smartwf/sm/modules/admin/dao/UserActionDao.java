package com.smartwf.sm.modules.admin.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smartwf.sm.modules.admin.pojo.UserAction;

import tk.mybatis.mapper.common.Mapper;

/**
 * @Date: 2019-11-27 11:29:02
 * @Description: 用户操作持久层接口
 */
@Repository
public interface UserActionDao extends Mapper<UserAction> {

	/**
	 * @Description: 批量删除用户操作
	 * @result:
	 */
	void deleteUserActionByIds(@Param("list") List<String> list);
	/**
	 * @Description: 初始化用户操作
	 * @result:
	 */
	List<UserAction> queryUserActionAll();

}
