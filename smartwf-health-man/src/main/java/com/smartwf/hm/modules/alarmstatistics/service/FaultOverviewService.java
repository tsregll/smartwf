package com.smartwf.hm.modules.alarmstatistics.service;

import com.smartwf.common.pojo.Result;
import com.smartwf.hm.modules.alarmstatistics.vo.FaultInformationVO;

/**
 * @Date: 2018/12/18 15:43
 * @Description: 故障总览业务层接口
 */
public interface FaultOverviewService {
	/**
	 * @Description: 故障类型统计
	 *   1:30天   2:90天   3：一年   4 自定义
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Result<?> selectFaultTypeByDate( FaultInformationVO bean);
	/**
	 * @Description: 故障等级分布统计 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Result<?> selectFaultDistrByDate(FaultInformationVO bean);


}