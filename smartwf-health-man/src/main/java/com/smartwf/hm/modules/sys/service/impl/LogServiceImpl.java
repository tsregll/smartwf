package com.smartwf.hm.modules.sys.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.smartwf.common.dto.LogDTO;
import com.smartwf.common.pojo.PageVO;
import com.smartwf.common.pojo.Result;
import com.smartwf.hm.modules.sys.dao.LogDao;
import com.smartwf.hm.modules.sys.pojo.Log;
import com.smartwf.hm.modules.sys.service.LogService;

import tk.mybatis.mapper.entity.Example;

/**
 * @Date: 2018/12/18 15:44
 * @Description: 日志业务层实现
 */
@Service
public class LogServiceImpl implements LogService {

	
    @Autowired
    private LogDao logDao;
 

    /**
     * 保存日志
     * @param logDTOList
     * @return
     */
    @Transactional
    @Override
    public Integer saveLog(List<LogDTO> logDTOList) {
        return this.logDao.saveLog(logDTOList);
    }


    /**
     * 分页查询日志
     * @param page
     * @param queryPojo
     * @return
     */
    @Override
    public Result selectLogByPage(PageVO page) {
    	com.github.pagehelper.Page<Object> objectPage = PageHelper.startPage(page.getPage(), page.getLimit());
        Example example = new Example(Log.class);
        Example.Criteria criteria = example.createCriteria();
       
        List<Log> logs = this.logDao.selectByExample(example);
       
        return Result.data(objectPage.getTotal(), logs);
    }
}