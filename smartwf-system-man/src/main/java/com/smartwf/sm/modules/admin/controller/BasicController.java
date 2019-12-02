package com.smartwf.sm.modules.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartwf.common.pojo.Result;
import com.smartwf.common.service.RedisService;
import com.smartwf.common.utils.JsonUtil;
import com.smartwf.sm.modules.admin.pojo.Organization;
import com.smartwf.sm.modules.admin.pojo.Post;
import com.smartwf.sm.modules.admin.pojo.Tenant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @Date: 2019-10-25 15:04:26
 * @Description: 基础数据控制器
 */
@RestController
@RequestMapping("base")
@Slf4j
@Api(description = "基础数据控制器")
public class BasicController {
	
	@Autowired
    private RedisService redisService;

	 /**
     * @Description 租户列表
     * @return
     */
    @GetMapping("tenant")
    @ApiOperation(value = "查询租户列表接口", notes = "查询租户列表信息")
    public ResponseEntity<Result<?>> tenantAll() {
        try {
        	List<Tenant> list=JsonUtil.jsonToList(redisService.get("tenantAll"), Tenant.class);
           return ResponseEntity.ok(Result.data(list));
        } catch (Exception e) {
            log.error("查询租户列表信息错误！{}", e.getMessage(), e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.msg("查询租户列表信息错误！"));
    }
    
    /**
     * @Description 组织架构列表
     * @param tenantId
     *          为空： 返回所有组织架构
     *          非空： 过滤租户
     * @return
     */
    @GetMapping("organization")
    @ApiOperation(value = "查询组织架构机构列表接口", notes = "查询组织架构列表信息")
    @ApiImplicitParams({
	    @ApiImplicitParam(paramType = "query", name = "tenantId", value = "租户（主键）为空返回租户下所有的组织架构", dataType = "Integer")
    })
    public ResponseEntity<Result<?>> organizationAll(Organization bean) {
        try {
        	List<Organization> list=JsonUtil.jsonToList(redisService.get("organizationAll"), Organization.class);
        	if(null !=bean.getId()) {
        		List<Organization> orglist=new ArrayList<Organization>();
            	for(Organization org:list) {
            		if(org.getTenantId()==bean.getTenantId()) {
            			orglist.add(org);
            		}
            	}
            	//过滤租户返回
            	return ResponseEntity.ok(Result.data(orglist));
        	}
        	//无需过滤租户返回
            return ResponseEntity.ok(Result.data(list));
        } catch (Exception e) {
            log.error("查询租户列表信息错误！{}", e.getMessage(), e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.msg("查询租户列表信息错误！"));
    }
    
    /**
     * @Description 职务列表
     * @param 
     * @return
     */
    @GetMapping("post")
    @ApiOperation(value = "查询职务列表接口", notes = "查询职务列表信息")
    @ApiImplicitParams({
    	@ApiImplicitParam(paramType = "query", name = "tenantId", value = "租户（主键）为空返回租户下所有的组织架构", dataType = "Integer"),
    	@ApiImplicitParam(paramType = "query", name = "organizationId", value = "组织架构（主键）", dataType = "Integer")
    })
    public ResponseEntity<Result<?>> PostAll(Post bean) {
        try {
        	List<Post> list=JsonUtil.jsonToList(redisService.get("postAll"), Post.class);
        	if(null !=bean.getId()) {
        		List<Post> orglist=new ArrayList<Post>();
            	for(Post org:list) {
            		if(org.getTenantId()==bean.getTenantId() && org.getOrganizationId()==bean.getOrganizationId()) {
            			orglist.add(org);
            		}
            	}
            	//过滤租户&组织架构返回
            	return ResponseEntity.ok(Result.data(orglist));
        	}
        	//无需过滤租户&组织架构返回
            return ResponseEntity.ok(Result.data(list));
        } catch (Exception e) {
            log.error("查询租户列表信息错误！{}", e.getMessage(), e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Result.msg("查询租户列表信息错误！"));
    }

}
