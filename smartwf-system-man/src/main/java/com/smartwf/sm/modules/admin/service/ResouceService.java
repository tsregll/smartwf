package com.smartwf.sm.modules.admin.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.smartwf.common.pojo.Result;
import com.smartwf.sm.modules.admin.pojo.Resouce;
import com.smartwf.sm.modules.admin.vo.ResouceVO;

/**
 * @Description: 资源业务层接口
 * @author WCH
 * @Date: 2019-11-27 11:25:24
 */
public interface ResouceService {

	/**
	 * @Description: 查询资源分页
	 * @result: 
	 */
	Result<?> selectResouceByPage(Page<Object> page, ResouceVO bean);

	/**
     * @Description: 主键查询资源
     * @return
     */
	Result<?> selectResouceById(Resouce bean);

	/**
     * @Description： 添加资源
     * @return
     */
	void saveResouce(Resouce bean);
	
	/**
     * @Description： 修改资源
     * @return
     */
	void updateResouce(Resouce bean);

	/**
     * @Description： 删除资源
     * @return
     */
	void deleteResouce(ResouceVO bean);
	
	/**
     * @Description： 初始化资源
     * @return
     */
	List<Resouce> queryResouceAll();
	

}
