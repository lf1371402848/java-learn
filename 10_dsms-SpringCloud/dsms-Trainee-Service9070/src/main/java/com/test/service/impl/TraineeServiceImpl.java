package com.test.service.impl;

import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTraineesExample;
import com.test.bean.DsmsTraineesExample.Criteria;
import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;
import com.test.feign.TrainerService;
import com.test.mapper.DsmsTraineesMapper;
import com.test.service.interf.ITraineeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TraineeServiceImpl implements ITraineeService{

	@Autowired
	private DsmsTraineesMapper traineeMapper;
	
	@Autowired
	private TrainerService trainerService;

	public DsmsTrainees login(String username, String password) throws CommonException {
		DsmsTraineesExample traineeExample = new DsmsTraineesExample();
		traineeExample.createCriteria().andTraineeNoEqualTo(username).andPasswordEqualTo(password);
		List<DsmsTrainees> list = traineeMapper.selectByExample(traineeExample);
		if(list==null||list.size()<=0) {
			throw CommonException.getException(402);
		}
		return list.get(0);
	}

	public void changePwd(String username, String password, String againPwd) throws CommonException{
		if (password.equals(againPwd)) {
			DsmsTraineesExample example = new DsmsTraineesExample();
			example.createCriteria().andTraineeNoEqualTo(username);
			List<DsmsTrainees> list = traineeMapper.selectByExample(example);
			list.get(0).setPassword(password);
			traineeMapper.updateByPrimaryKeySelective(list.get(0));
		}else {
			throw CommonException.getException(406);
		}
	}

	public Map<DsmsTrainees,DsmsTrainers> findAllTrainees() throws CommonException {
		// TODO Auto-generated method stub
		TreeMap<DsmsTrainees,DsmsTrainers> map=new TreeMap<DsmsTrainees,DsmsTrainers>(new Comparator<DsmsTrainees>() {
			public int compare(DsmsTrainees o1, DsmsTrainees o2) {
				// TODO Auto-generated method stub
				int i = o1.getId().compareTo(o2.getId());
				return -i;
			}			
		});
		DsmsTraineesExample traineeExample = new DsmsTraineesExample();
		List<DsmsTrainees> list = traineeMapper.selectByExample(traineeExample);
		for (int i = 0; i < list.size(); i++) {		
			DsmsTrainers trainer = trainerService.findTrainerById(list.get(i).getTrainerId());
			map.put(list.get(i), trainer);
		}
		return map;
	}

	public Map<DsmsTrainees,DsmsTrainers> findAllTraineesByCon(DsmsTrainees trainee)
			throws CommonException {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(trainee.getTraineeNo())&&StringUtils.isBlank(trainee.getStatus())&&StringUtils.isBlank(trainee.getApplicationType())) {
			return findAllTrainees();
		}
		HashMap<DsmsTrainees,DsmsTrainers> map=new HashMap<DsmsTrainees,DsmsTrainers>();
		DsmsTraineesExample example = new DsmsTraineesExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(trainee.getTraineeNo())) {
			criteria.andTraineeNoEqualTo(trainee.getTraineeNo());
		}
		if (StringUtils.isNotBlank(trainee.getApplicationType())) {
			criteria.andApplicationTypeEqualTo(trainee.getApplicationType());
		}
		if (StringUtils.isNotBlank(trainee.getStatus())) {
			criteria.andStatusLike("%"+trainee.getStatus()+"%");
		}
		List<DsmsTrainees> list = traineeMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {		
			DsmsTrainers trainer = trainerService.findTrainerById(list.get(i).getTrainerId());
			map.put(list.get(i), trainer);
		}
		return map;
	}		

	public Map<DsmsTrainees,DsmsTrainers> findTraineeAndDsmsTrainerById(long id) throws CommonException {
		// TODO Auto-generated method stub
		HashMap<DsmsTrainees,DsmsTrainers> map=new HashMap<DsmsTrainees,DsmsTrainers>();
		DsmsTrainees trainee = traineeMapper.selectByPrimaryKey(id);
		DsmsTrainers trainer = trainerService.findTrainerById(trainee.getTrainerId());
		map.put(trainee, trainer);
		return map;
	}

	@Override
	public DsmsTrainees findTraineeById(long id) throws CommonException {
		return traineeMapper.selectByPrimaryKey(id);
	}

	public Map<DsmsTrainees,DsmsTrainers> findTraineeByName(String name) throws CommonException {
		// TODO Auto-generated method stub
		HashMap<DsmsTrainees,DsmsTrainers> map=new HashMap<DsmsTrainees,DsmsTrainers>();
		DsmsTraineesExample traineeExample = new DsmsTraineesExample();
		traineeExample.createCriteria().andNameEqualTo(name);
		DsmsTrainees trainee = traineeMapper.selectByExample(traineeExample).get(0);
		DsmsTrainers trainer = trainerService.findTrainerById(trainee.getTrainerId());
		map.put(trainee, trainer);
		return map;
	}

	public Map<DsmsTrainees,DsmsTrainers> findTraineeByIdNumber(String idNumber) throws CommonException {
		// TODO Auto-generated method stub
		HashMap<DsmsTrainees,DsmsTrainers> map=new HashMap<DsmsTrainees,DsmsTrainers>();
		DsmsTraineesExample traineeExample = new DsmsTraineesExample();
		traineeExample.createCriteria().andIdNumberEqualTo(idNumber);
		DsmsTrainees trainee = traineeMapper.selectByExample(traineeExample).get(0);
		DsmsTrainers trainer = trainerService.findTrainerById(trainee.getTrainerId());
		map.put(trainee, trainer);
		return map;
	}
	public void updateTrainee(DsmsTrainees trainee) throws CommonException {
		// TODO Auto-generated method stubd
		traineeMapper.updateByPrimaryKeySelective(trainee);
	}

	public void deleteTraineeById(long id) throws CommonException {
		// TODO Auto-generated method stub
		traineeMapper.deleteByPrimaryKey(id);
	}

	public void insertTrainee(DsmsTrainees trainee) throws CommonException {
		// TODO Auto-generated method stub
		DsmsTraineesExample traineeExample = new DsmsTraineesExample();
		traineeExample.createCriteria().andTraineeNoEqualTo(trainee.getTraineeNo());
		List<DsmsTrainees> list = traineeMapper.selectByExample(traineeExample);	
		if (list==null||list.size()<=0) {
			traineeMapper.insertSelective(trainee);				
		}else {
			throw CommonException.getException(405);
		}	
	}
}
