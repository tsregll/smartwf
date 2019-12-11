package com.smartwf.sm.modules.admin.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.smartwf.sm.modules.admin.pojo.Tenant;
import com.smartwf.sm.modules.admin.vo.TenantVO;

import tk.mybatis.mapper.common.Mapper;

/**
 * @Date: 2019-11-27 11:29:02
 * @Description: 租户持久层接口
 */
@Repository
public interface TenantDao extends Mapper<Tenant> {

	/**
	 * @Description: 批量删除租户
	 * @result:
	 */
	void deleteTenantByIds(@Param("list") List<String> list);

	/**
	 * @Description: 初始化租户
	 * @result:
	 */
	List<Tenant> queryTenantAll();

	/**
	 * @Description: 级联删除
	 * 
	 * */
	void deleteOrgByTenantId(@Param("bean") TenantVO bean);

	void deleteUserOrgByTenantId(@Param("bean") TenantVO bean);

	void deletePostByTenantId(@Param("bean") TenantVO bean);

	void deleteUserPostByTenantId(@Param("bean") TenantVO bean);

	void deleteRoleByTenantId(@Param("bean") TenantVO bean);

	void deleteUserRoleByTenantId(@Param("bean") TenantVO bean);

	void deletePermissionByTenantId(@Param("bean") TenantVO bean);
	
	void deleteUserByTenantId(@Param("bean") TenantVO bean);

	/**
	 * @Description: 批量级联删除
	 * 
	 * */
	void deleteOrgByTenantIds(@Param("list") List<String> list);

	void deleteUserOrgByTenantIds(@Param("list") List<String> list);

	void deletePostByTenantIds(@Param("list") List<String> list);

	void deleteUserPostByTenantIds(@Param("list") List<String> list);

	void deleteRoleByTenantIds(@Param("list") List<String> list);

	void deleteUserRoleByTenantIds(@Param("list") List<String> list);

	void deletePermissionByTenantIds(@Param("list") List<String> list);

	void deleteUserByTenantIds(@Param("list") List<String> list);

    
}