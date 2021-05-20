package com.test.service.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.bean.DsmsCars;
import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTraineesExample;
import com.test.bean.DsmsTrainers;
import com.test.bean.DsmsTrainersExample;
import com.test.bean.DsmsTrainersExample.Criteria;
import com.test.common.exception.CommonException;
import com.test.mapper.DsmsCarsMapper;
import com.test.mapper.DsmsTraineesMapper;
import com.test.mapper.DsmsTrainersMapper;
import com.test.service.interf.ITrainerService;

@Service
public class TrainerServiceImpl implements ITrainerService{

	@Autowired
	private DsmsTrainersMapper trainerMapper;

	@Autowired
	private DsmsTraineesMapper traineeMapper;

	@Autowired
	private DsmsCarsMapper carMapper;

	public DsmsTrainers login(String username, String password) throws CommonException {
		DsmsTrainersExample example = new DsmsTrainersExample();
		example.createCriteria().andTrainerNoEqualTo(username).andPasswordEqualTo(password);
		List<DsmsTrainers> list = trainerMapper.selectByExample(example);
		if(list==null||list.size()<=0) {
			throw CommonException.getException(402);
		}
		return list.get(0);
	}

	public void changePwd(String username, String password, String againPwd) throws CommonException{
		if (password.equals(againPwd)) {
			DsmsTrainersExample example = new DsmsTrainersExample();
			example.createCriteria().andTrainerNoEqualTo(username);
			List<DsmsTrainers> list = trainerMapper.selectByExample(example);
			list.get(0).setPassword(password);
			trainerMapper.updateByPrimaryKeySelective(list.get(0));
		}else {
			throw CommonException.getException(406);
		}
	}

	public Map<DsmsTrainers,DsmsCars> findAllTrainers() throws CommonException {
		// TODO Auto-generated method stub
		TreeMap<DsmsTrainers,DsmsCars> map=new TreeMap<DsmsTrainers,DsmsCars>(new Comparator<DsmsTrainers>() {
			public int compare(DsmsTrainers o1, DsmsTrainers o2) {
				// TODO Auto-generated method stub
				int i = o1.getId().compareTo(o2.getId());
				return -i;
			}			
		});
		DsmsTrainersExample trainerExample = new DsmsTrainersExample();
		List<DsmsTrainers> list = trainerMapper.selectByExample(trainerExample);
		for (int i = 0; i < list.size(); i++) {		
			DsmsCars car = carMapper.selectByPrimaryKey(list.get(i).getCarId());
			map.put(list.get(i), car);
		}
		return map;
	}

	public Map<DsmsTrainers,DsmsCars> findAllTrainersByCon(DsmsTrainers trainer)
			throws CommonException {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(trainer.getTrainerNo())&&StringUtils.isBlank(trainer.getName())&&StringUtils.isBlank(trainer.getLicenseType())) {
			return findAllTrainers();
		}
		HashMap<DsmsTrainers, DsmsCars> map=new HashMap<DsmsTrainers, DsmsCars>();
		DsmsTrainersExample example = new DsmsTrainersExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(trainer.getTrainerNo())) {
			criteria.andTrainerNoEqualTo(trainer.getTrainerNo());
		}
		if (StringUtils.isNotBlank(trainer.getName())) {
			criteria.andNameLike(trainer.getName());
		}
		if (StringUtils.isNotBlank(trainer.getLicenseType())) {
			criteria.andLicenseTypeEqualTo(trainer.getLicenseType());
		}
		List<DsmsTrainers> list = trainerMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			DsmsCars car = carMapper.selectByPrimaryKey(list.get(i).getCarId());
			map.put(list.get(i), car);
		}
		return map;
	}

	public Map<DsmsTrainers,DsmsCars> findTrainerById(long id) throws CommonException {
		// TODO Auto-generated method stub
		HashMap<DsmsTrainers,DsmsCars> map=new HashMap<DsmsTrainers,DsmsCars>();
		DsmsTrainers trainer = trainerMapper.selectByPrimaryKey(id);
		DsmsCars car = carMapper.selectByPrimaryKey(trainer.getCarId());
		map.put(trainer, car);
		return map;
	}

	public Map<DsmsTrainers,DsmsCars> findTrainerByName(String name) throws CommonException {
		// TODO Auto-generated method stub
		HashMap<DsmsTrainers,DsmsCars> map=new HashMap<DsmsTrainers,DsmsCars>();
		DsmsTrainersExample trainerExample = new DsmsTrainersExample();
		trainerExample.createCriteria().andNameEqualTo(name);
		DsmsTrainers trainer = trainerMapper.selectByExample(trainerExample).get(0);
		DsmsCars car = carMapper.selectByPrimaryKey(trainer.getCarId());
		map.put(trainer, car);
		return map;
	}


	public Map<DsmsTrainers,DsmsCars> findTrainerByIdNumber(String idNumber) throws CommonException {
		// TODO Auto-generated method stub
		HashMap<DsmsTrainers,DsmsCars> map=new HashMap<DsmsTrainers,DsmsCars>();
		DsmsTrainersExample trainerExample = new DsmsTrainersExample();
		trainerExample.createCriteria().andIdNumberEqualTo(idNumber);
		DsmsTrainers trainer = trainerMapper.selectByExample(trainerExample).get(0);
		DsmsCars car = carMapper.selectByPrimaryKey(trainer.getCarId());
		map.put(trainer, car);
		return map;
	}

	public void updateTrainer(DsmsTrainers trainer) throws CommonException {
		// TODO Auto-generated method stub
		DsmsTrainersExample example = new DsmsTrainersExample();
		List<DsmsTrainers> list = trainerMapper.selectByExample(example);
		for (int i=0;i<list.size();i++) {
			if (list.get(i).getCarId() != null && trainer.getCarId() != null && list.get(i).getCarId().equals(trainer.getCarId())) {
				throw new CommonException(502, "该车辆已有教练负责");
			}
		}
		trainerMapper.updateByPrimaryKeySelective(trainer);
	}


	public void deleteTrainerById(long id) throws CommonException {
		// TODO Auto-generated method stub
		trainerMapper.deleteByPrimaryKey(id);
	}


	public void insertTrainer(DsmsTrainers trainer) throws CommonException {
		// TODO Auto-generated method stub
		DsmsTrainersExample trainerExample = new DsmsTrainersExample();
		trainerExample.createCriteria().andTrainerNoEqualTo(trainer.getTrainerNo());
		List<DsmsTrainers> list = trainerMapper.selectByExample(trainerExample);	
		if (list == null || list.size() <= 0) {
			Map<DsmsTrainers, DsmsCars> map = findAllTrainers();
			for (DsmsTrainers trainers: map.keySet()) {
				if (trainers.getCarId() != null && trainer.getCarId() != null && trainers.getCarId().equals(trainer.getCarId())) {
					throw new CommonException(502, "该车辆已有教练负责");
				}
			}
			trainerMapper.insertSelective(trainer);				
		}else {
			throw CommonException.getException(405);
		}
	}

	public List<DsmsTrainees> findAllTrainersTrainees(long trainerId) throws CommonException{
		DsmsTraineesExample example = new DsmsTraineesExample();
		example.createCriteria().andTrainerIdEqualTo(trainerId);
		List<DsmsTrainees> list = traineeMapper.selectByExample(example);
		return list;
	}

	public List<DsmsTrainees> findAllTrainersTraineesByCon(long trainerId,DsmsTrainees trainee) throws CommonException{
		if (StringUtils.isBlank(trainee.getTraineeNo())&&StringUtils.isBlank(trainee.getStatus())&&StringUtils.isBlank(trainee.getApplicationType())) {
			return findAllTrainersTrainees(trainerId);
		}
		DsmsTraineesExample example = new DsmsTraineesExample();
		DsmsTraineesExample.Criteria criteria = example.createCriteria();
		criteria.andTrainerIdEqualTo(trainerId);
		if (StringUtils.isNotBlank(trainee.getTraineeNo())) {
			criteria.andTraineeNoEqualTo(trainee.getTraineeNo());
		}
		if (StringUtils.isNotBlank(trainee.getApplicationType())) {
			criteria.andApplicationTypeEqualTo(trainee.getApplicationType());
		}
		if (StringUtils.isNotBlank(trainee.getStatus())) {
			criteria.andStatusEqualTo(trainee.getStatus());
		}
		List<DsmsTrainees> list = traineeMapper.selectByExample(example);
		return list;
	}
}
