package com.test.service.impl;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.bean.DsmsCars;
import com.test.bean.DsmsCarsExample;
import com.test.bean.DsmsCarsExample.Criteria;
import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;
import com.test.mapper.DsmsCarsMapper;
import com.test.mapper.DsmsTrainersMapper;
import com.test.service.interf.ICarService;

@Service
public class CarServiceImpl implements ICarService{

	@Autowired
	private DsmsCarsMapper carMapper;

	@Autowired
	private DsmsTrainersMapper trainerMapper;

	public List<DsmsCars> findAllCars() throws CommonException {
		// TODO Auto-generated method stub
		DsmsCarsExample example = new DsmsCarsExample();
		List<DsmsCars> list = carMapper.selectByExample(example);
		return list;
	}	
	public List<DsmsCars> findAllCarsByCon(DsmsCars car) throws CommonException {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(car.getCarNo())&&StringUtils.isBlank(car.getCarType())&&StringUtils.isBlank(car.getStatus())) {
			return findAllCars();
		}
		DsmsCarsExample example = new DsmsCarsExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(car.getCarNo())) {
			criteria.andCarNoLike("%"+car.getCarNo()+"%");
		}
		if (StringUtils.isNotBlank(car.getCarType())) {
			criteria.andCarTypeEqualTo(car.getCarType());
		}
		if (StringUtils.isNotBlank(car.getStatus())) {
			criteria.andStatusEqualTo(car.getStatus());
		}
		List<DsmsCars> list = carMapper.selectByExample(example);
		return list;
	}

	public DsmsCars findCarById(long id) throws CommonException {
		// TODO Auto-generated method stub
		return carMapper.selectByPrimaryKey(id);
	}

	public DsmsCars findCarByTrainerId(long trainerId) throws CommonException{
		DsmsTrainers trainer = trainerMapper.selectByPrimaryKey(trainerId);			
		return carMapper.selectByPrimaryKey(trainer.getCarId());
	}

	public DsmsCars findCarByCarType(String car_type) throws CommonException {
		// TODO Auto-generated method stub
		DsmsCarsExample carExample = new DsmsCarsExample();		
		carExample.createCriteria().andCarTypeEqualTo(car_type);
		return carMapper.selectByExample(carExample).get(0);
	}

	public DsmsCars findCarByStatus(String status) throws CommonException {
		// TODO Auto-generated method stub
		DsmsCarsExample carExample = new DsmsCarsExample();		
		carExample.createCriteria().andStatusEqualTo(status);
		return carMapper.selectByExample(carExample).get(0);
	}

	public void updateCar(DsmsCars car) throws CommonException {
		// TODO Auto-generated method stubd
		carMapper.updateByPrimaryKeySelective(car);
	}

	public void deleteCarById(long id) throws CommonException {
		// TODO Auto-generated method stub
		carMapper.deleteByPrimaryKey(id);
	}

	public void insertCar(DsmsCars car) throws CommonException {
		// TODO Auto-generated method stub
		DsmsCarsExample carExample = new DsmsCarsExample();
		carExample.createCriteria().andCarNoEqualTo(car.getCarNo());
		List<DsmsCars> list = carMapper.selectByExample(carExample);	
		if (list==null||list.size()<=0) {
			carMapper.insertSelective(car);				
		}else {
			throw CommonException.getException(405);
		}	
	}
}
