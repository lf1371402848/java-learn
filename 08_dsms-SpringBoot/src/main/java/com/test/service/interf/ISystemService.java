package com.test.service.interf;

import com.test.bean.DsmsLogs;
import com.test.common.exception.CommonException;

import java.util.Map;

/**
 * Created by LuoFeng on 2018/12/8.
 */
public interface ISystemService {
	
	//查询所有日志
	public Map<DsmsLogs,Object> findAllLogs() throws CommonException;

	//新增日志
	public void insertLog(DsmsLogs log) throws CommonException;
}
