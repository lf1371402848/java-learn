package com.test.service.impl;

import com.test.bean.*;
import com.test.common.exception.CommonException;
import com.test.feign.CarService;
import com.test.feign.TraineeService;
import com.test.feign.TrainerService;
import com.test.mapper.DsmsAdminsMapper;
import com.test.mapper.DsmsLogsMapper;
import com.test.service.interf.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@Transactional
public class SystemServiceImpl implements ISystemService{

	@Autowired
	private DsmsAdminsMapper adminsMapper;

	@Autowired
	private TrainerService trainersMapper;

	@Autowired
	private TraineeService traineesMapper;

	@Autowired
	private CarService carsMapper;
	
	@Autowired
	private DsmsLogsMapper logsMapper;
	
	public Map<DsmsLogs, Object> findAllLogs() throws CommonException {
		// TODO Auto-generated method stub
		TreeMap<DsmsLogs, Object> map=new TreeMap<DsmsLogs, Object>(new Comparator<DsmsLogs>() {
			public int compare(DsmsLogs o1, DsmsLogs o2) {
				// TODO Auto-generated method stub				
				int i = o1.getLogDate().compareTo(o2.getLogDate());  
				return -i;
			}
		});
		DsmsLogsExample example = new DsmsLogsExample();
		List<DsmsLogs> list = logsMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getFlag().equals("admin")) {
				DsmsAdmins admin = adminsMapper.selectByPrimaryKey(list.get(i).getItemId());
				map.put(list.get(i), admin);
			}else if (list.get(i).getFlag().equals("trainer")) {
				DsmsTrainers trainer = trainersMapper.findTrainerById(list.get(i).getItemId());
				map.put(list.get(i), trainer);
			}else if (list.get(i).getFlag().equals("trainee")) {
				DsmsTrainees trainee = traineesMapper.findTraineeById(list.get(i).getItemId());
				map.put(list.get(i), trainee);
			}
		}
		return map;
	}

	public void insertLog(DsmsLogs log) throws CommonException {
		// TODO Auto-generated method stub
		logsMapper.insertSelective(log);
	}
}
