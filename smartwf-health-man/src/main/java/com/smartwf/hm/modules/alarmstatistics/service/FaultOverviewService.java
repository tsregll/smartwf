package com.smartwf.hm.modules.alarmstatistics.service;

import com.smartwf.common.pojo.Result;
import com.smartwf.hm.modules.alarmstatistics.vo.FaultInformationVO;

/**
 * @author WCH
 * @Date: 2018/12/18 15:43
 * @Description: 故障总览业务层接口,
 */
public interface FaultOverviewService {
	/**
	 *  故障类型统计
	 *   1:30天   2:90天   3：一年   4 自定义
	 * @param startTime
	 * @param endTime
	 * @param bean
	 * @return
	 */
	Result<?> selectFaultTypeByDate( FaultInformationVO bean);
	/**
	 * 故障等级分布统计
	 * @param startTime
	 * @param endTime
	 * @param bean
	 * @return
	 */
	Result<?> selectFaultLevelByDate(FaultInformationVO bean);
	/**
	 * 故障处理状态&部件故障分析
	 * @param startTime
	 * @param endTime
	 * @param bean
	 * @return
	 */
	Result<?> selectFaultStatusByDate(FaultInformationVO bean);


}
