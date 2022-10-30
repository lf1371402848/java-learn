package com.test.service.impl;

import com.test.bean.*;
import com.test.bean.DsmsTrainersExample.Criteria;
import com.test.common.exception.CommonException;
import com.test.feign.CarService;
import com.test.feign.TraineeService;
import com.test.mapper.DsmsTrainersMapper;
import com.test.service.interf.ITrainerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class TrainerServiceImpl implements ITrainerService{

	@Autowired
	private DsmsTrainersMapper trainerMapper;

	@Autowired
	private TraineeService traineeService;

	@Autowired
	private CarService carService;

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

	/*public Map<DsmsTrainers,DsmsCars> findAllTrainers() throws CommonException {
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
			DsmsCars car = carService.findCarByTrainerId(list.get(i).getId());
			map.put(list.get(i), car);
		}
		return map;
	}*/
	public List<DsmsTrainers> findAllTrainers() throws CommonException {
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
		return list;
	}

	/*public Map<DsmsTrainers,DsmsCars> findAllTrainersByCon(DsmsTrainers trainer)
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
			DsmsCars car = carService.findCarByTrainerId(list.get(i).getId());
			map.put(list.get(i), car);
		}
		return map;
	}*/
	public List<DsmsTrainers> findAllTrainersByCon(DsmsTrainers trainer)
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
		return list;
	}

	public DsmsTrainers findTrainerById(long id) throws CommonException {
		return trainerMapper.selectByPrimaryKey(id);
	}

	public Map<DsmsTrainers,DsmsCars> findTrainerAndDsmsCarsById(long id) throws CommonException {
		// TODO Auto-generated method stub
		HashMap<DsmsTrainers,DsmsCars> map=new HashMap<DsmsTrainers,DsmsCars>();
		DsmsTrainers trainer = trainerMapper.selectByPrimaryKey(id);
		DsmsCars car = carService.findCarByTrainerId(trainer.getCarId());
		map.put(trainer, car);
		return map;
	}

	public Map<DsmsTrainers,DsmsCars> findTrainerByName(String name) throws CommonException {
		// TODO Auto-generated method stub
		HashMap<DsmsTrainers,DsmsCars> map=new HashMap<DsmsTrainers,DsmsCars>();
		DsmsTrainersExample trainerExample = new DsmsTrainersExample();
		trainerExample.createCriteria().andNameEqualTo(name);
		DsmsTrainers trainer = trainerMapper.selectByExample(trainerExample).get(0);
		DsmsCars car = carService.findCarByTrainerId(trainer.getCarId());
		map.put(trainer, car);
		return map;
	}


	public Map<DsmsTrainers,DsmsCars> findTrainerByIdNumber(String idNumber) throws CommonException {
		// TODO Auto-generated method stub
		HashMap<DsmsTrainers,DsmsCars> map=new HashMap<DsmsTrainers,DsmsCars>();
		DsmsTrainersExample trainerExample = new DsmsTrainersExample();
		trainerExample.createCriteria().andIdNumberEqualTo(idNumber);
		DsmsTrainers trainer = trainerMapper.selectByExample(trainerExample).get(0);
		DsmsCars car = carService.findCarByTrainerId(trainer.getCarId());
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


	/*public void insertTrainer(DsmsTrainers trainer) throws CommonException {
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
	}*/
	public void insertTrainer(DsmsTrainers trainer) throws CommonException {
		// TODO Auto-generated method stub
		DsmsTrainersExample trainerExample = new DsmsTrainersExample();
		trainerExample.createCriteria().andTrainerNoEqualTo(trainer.getTrainerNo());
		List<DsmsTrainers> list = trainerMapper.selectByExample(trainerExample);
		if (list == null || list.size() <= 0) {
			trainerMapper.insertSelective(trainer);
		}else {
			throw CommonException.getException(405);
		}
	}

	public List<DsmsTrainees> findAllTrainersTrainees(long trainerId) throws CommonException{
		DsmsTraineesExample example = new DsmsTraineesExample();
		example.createCriteria().andTrainerIdEqualTo(trainerId);
		List<DsmsTrainees> list = traineeService.selectByExample(example);
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
		List<DsmsTrainees> list = traineeService.selectByExample(example);
		return list;
	}
}
