package com.test.service.impl;

import com.test.bean.*;
import com.test.bean.DsmsFinancesExample.Criteria;
import com.test.common.exception.CommonException;
import com.test.feign.CarService;
import com.test.feign.TraineeService;
import com.test.feign.TrainerService;
import com.test.mapper.DsmsFinancesMapper;
import com.test.service.interf.IFinanceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Transactional
public class FinanceServiceImpl implements IFinanceService{

	@Autowired
	private DsmsFinancesMapper financesMapper;

	@Autowired
	private TrainerService trainersMapper;

	@Autowired
	private TraineeService traineesMapper;

	@Autowired
	private CarService carsMapper;

	public Map<DsmsTrainees,DsmsFinances> findAllTraineeFee() throws CommonException {
		// TODO Auto-generated method stub
		TreeMap<DsmsTrainees,DsmsFinances> map=new TreeMap<DsmsTrainees,DsmsFinances>(new Comparator<DsmsTrainees>() {
			public int compare(DsmsTrainees o1, DsmsTrainees o2) {
				// TODO Auto-generated method stub
				int i = o1.getId().compareTo(o2.getId());
				return -i;
			}			
		});
		DsmsFinancesExample example=new DsmsFinancesExample();
		example.setOrderByClause("id");
		example.createCriteria().andFlagEqualTo("trainee");
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			DsmsTrainees trainee = traineesMapper.findTraineeById(list.get(i).getItemId());
			if (trainee != null) {				
				map.put(trainee, list.get(i));
			}
		}
		return map;
	}

	public Map<DsmsTrainees,DsmsFinances> findAllTraineeFeeByCon(String traineeNo,String traineeName) throws CommonException {
		// TODO Auto-generated method stub
		Map<DsmsTrainees, DsmsFinances> allmap = findAllTraineeFee();
		ConcurrentHashMap<DsmsTrainees,DsmsFinances> map=new ConcurrentHashMap<DsmsTrainees,DsmsFinances>();
		if (StringUtils.isBlank(traineeNo)&&StringUtils.isBlank(traineeName)) {
			return allmap;
		}
		if (StringUtils.isNotBlank(traineeNo)) {
			for (Entry<DsmsTrainees,DsmsFinances> entry : allmap.entrySet()) {
				if (StringUtils.isNotBlank(entry.getKey().getTraineeNo())&&entry.getKey().getTraineeNo().equals(traineeNo)) {
					map.put(entry.getKey(),entry.getValue());
				}
			}
		}
		if (StringUtils.isNotBlank(traineeName)) {
			if (map.isEmpty()&&StringUtils.isBlank(traineeNo)) {	
				for (Entry<DsmsTrainees,DsmsFinances> entry : allmap.entrySet()) {
					if (entry.getKey().getName().equals(traineeName)) {
						map.put(entry.getKey(),entry.getValue());
					}
				}
			}else {
				for (Entry<DsmsTrainees, DsmsFinances> entry : map.entrySet()) {
					if (!entry.getKey().getName().equals(traineeName)) {
						map.remove(entry.getKey());
					}
				}
			}
		}
		return map;
	}

	public Map<DsmsTrainees,DsmsFinances> findTraineeFeeById(long id) throws CommonException {
		// TODO Auto-generated method stub
		Map<DsmsTrainees, DsmsFinances> allmap = findAllTraineeFee();
		ConcurrentHashMap<DsmsTrainees,DsmsFinances> map = new ConcurrentHashMap<DsmsTrainees,DsmsFinances>();
		for (Entry<DsmsTrainees,DsmsFinances> entry : allmap.entrySet()) {
			if (entry.getValue().getId() == id) {
				map.put(entry.getKey(),entry.getValue());
			}
		}
		return map;
	}

	public Map<DsmsTrainees,DsmsFinances> findTraineeFeeByTraineeNo(String traineeNo) throws CommonException{
		// TODO Auto-generated method stub
		Map<DsmsTrainees, DsmsFinances> allmap = findAllTraineeFee();
		ConcurrentHashMap<DsmsTrainees,DsmsFinances> map = new ConcurrentHashMap<DsmsTrainees,DsmsFinances>();
		for (Entry<DsmsTrainees,DsmsFinances> entry : allmap.entrySet()) {
			if (entry.getKey().getTraineeNo().equals(traineeNo)) {
				map.put(entry.getKey(),entry.getValue());
			}
		}
		return map;
	}

	public Map<DsmsTrainees,DsmsFinances> findTraineeFeeByName(String name) throws CommonException {
		// TODO Auto-generated method stub
		Map<DsmsTrainees, DsmsFinances> allmap = findAllTraineeFee();
		ConcurrentHashMap<DsmsTrainees,DsmsFinances> map = new ConcurrentHashMap<DsmsTrainees,DsmsFinances>();
		for (Entry<DsmsTrainees,DsmsFinances> entry : allmap.entrySet()) {
			if (entry.getKey().getName().equals(name)) {
				map.put(entry.getKey(),entry.getValue());
			}
		}
		return map;
	}

	public void updateTraineeFee(DsmsFinances finance) throws CommonException {
		// TODO Auto-generated method stub
		financesMapper.updateByPrimaryKeySelective(finance);
	}

	public void deleteTraineeFeeById(long id) throws CommonException {
		// TODO Auto-generated method stub
		financesMapper.deleteByPrimaryKey(id);
	}

	public void insertTraineeFee(DsmsFinances finance) throws CommonException {
		// TODO Auto-generated method stub
		finance.setFlag("trainee");
		financesMapper.insertSelective(finance);
	}

	public List<DsmsTrainers> findAllEmployeeFee() throws CommonException {
		// TODO Auto-generated method stub
		DsmsTrainersExample example=new DsmsTrainersExample();
		List<DsmsTrainers> list = trainersMapper.selectByExample(example);
		return list;
	}

	public List<DsmsTrainers> findAllEmployeeFeeByCon(DsmsTrainers trainer) throws CommonException {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(trainer.getTrainerNo())&&StringUtils.isBlank(trainer.getName())) {
			findAllEmployeeFee();
		}
		DsmsTrainersExample example=new DsmsTrainersExample();
		if (StringUtils.isNotBlank(trainer.getTrainerNo())) {
			example.createCriteria().andTrainerNoEqualTo(trainer.getTrainerNo());			
		}
		if (StringUtils.isNotBlank(trainer.getName())) {
			example.createCriteria().andNameEqualTo(trainer.getName());			
		}
		List<DsmsTrainers> list = trainersMapper.selectByExample(example);
		return list;
	}

	public DsmsTrainers findEmployeeFeeById(long id) throws CommonException {
		// TODO Auto-generated method stub
		return trainersMapper.findTrainerById(id);
	}

	public DsmsTrainers findEmployeeFeeByName(String name) throws CommonException {
		// TODO Auto-generated method stub
		DsmsTrainersExample example=new DsmsTrainersExample();
		example.createCriteria().andNameEqualTo(name);
		List<DsmsTrainers> list = trainersMapper.selectByExample(example);
		return list.get(0);
	}

	public void updateEmployeeFee(DsmsTrainers trainer) throws CommonException {
		// TODO Auto-generated method stub
		DsmsTrainers trainerFee = trainersMapper.findTrainerById(trainer.getId());
		trainerFee.setSalary(trainer.getSalary());
		trainerFee.setComments(trainer.getComments());
		trainersMapper.updateByPrimaryKey(trainerFee);
	}

	public void deleteEmployeeFeeById(long id) throws CommonException {
		// TODO Auto-generated method stub
		DsmsTrainers trainer = trainersMapper.findTrainerById(id);
		trainer.setSalary(null);
		trainersMapper.updateByPrimaryKey(trainer);
	}

	public void insertEmployeeFee(DsmsTrainers trainer) throws CommonException {
		// TODO Auto-generated method stub
		DsmsTrainers trainers = trainersMapper.findTrainerById(trainer.getId());
		trainers.setSalary(trainer.getSalary());
		trainersMapper.updateByPrimaryKeySelective(trainers);
	}

	public Map<DsmsCars,DsmsFinances> findAllCarFee() throws CommonException {
		// TODO Auto-generated method stub
		TreeMap<DsmsCars,DsmsFinances> map=new TreeMap<DsmsCars,DsmsFinances>(new Comparator<DsmsCars>() {
			public int compare(DsmsCars o1, DsmsCars o2) {
				// TODO Auto-generated method stub
				int i = o1.getId().compareTo(o2.getId());
				return i;
			}
		});
		DsmsFinancesExample example=new DsmsFinancesExample();
		example.createCriteria().andFlagEqualTo("car");
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			DsmsCars car = carsMapper.findCarById(list.get(i).getItemId());
			map.put(car, list.get(i));
		}
		return map;
	}

	public Map<DsmsCars,DsmsFinances> findAllCarFeeByCon(String carNo,Date startDate,Date endDate) throws CommonException {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(carNo)&&startDate==null&&endDate==null) {
			return findAllCarFee();
		}
		ConcurrentHashMap<DsmsCars,DsmsFinances> map=new ConcurrentHashMap<DsmsCars,DsmsFinances>();
		DsmsFinancesExample financesExample=new DsmsFinancesExample();
		Criteria criteria = financesExample.createCriteria();
		if (StringUtils.isNotBlank(carNo)) {
			DsmsCarsExample example=new DsmsCarsExample();
			example.createCriteria().andCarNoEqualTo(carNo);
			List<DsmsCars> list = carsMapper.selectByExample(example);
			criteria.andItemIdEqualTo(list.get(0).getId());
		}
		if (startDate!=null&&endDate!=null) {
			criteria.andFlagEqualTo("car").andFeeDateBetween(startDate, endDate);
		}
		List<DsmsFinances> list = financesMapper.selectByExample(financesExample);
		for (int i = 0; i < list.size(); i++) {
			DsmsCars car = carsMapper.findCarById(list.get(i).getItemId());
			map.put(car, list.get(i));
		}
		return map;
	}

	public Map<DsmsCars,DsmsFinances> findCarFeeById(long id) throws CommonException {
		// TODO Auto-generated method stub
		Map<DsmsCars, DsmsFinances> allmap = findAllCarFee();
		ConcurrentHashMap<DsmsCars,DsmsFinances> map=new ConcurrentHashMap<DsmsCars,DsmsFinances>();
		for (Entry<DsmsCars,DsmsFinances> entry : allmap.entrySet()) {
			if (entry.getValue().getId()==id) {
				map.put(entry.getKey(),entry.getValue());
			}
		}
		return map;
	}

	public Map<DsmsCars,DsmsFinances> findCarFeeByNo(String carNo) throws CommonException {
		// TODO Auto-generated method stub
		Map<DsmsCars, DsmsFinances> allmap = findAllCarFee();
		ConcurrentHashMap<DsmsCars,DsmsFinances> map=new ConcurrentHashMap<DsmsCars,DsmsFinances>();
		for (Entry<DsmsCars,DsmsFinances> entry : allmap.entrySet()) {
			if (entry.getKey().getCarNo().equals(carNo)) {
				map.put(entry.getKey(),entry.getValue());
			}
		}
		return map;
	}

	public void updateCarFee(Long price,DsmsFinances finance) throws CommonException {
		// TODO Auto-generated method stub
		DsmsCars carFee = carsMapper.findCarById(finance.getItemId());
		carFee.setPrice(price);
		carsMapper.updateByPrimaryKeySelective(carFee);
		financesMapper.updateByPrimaryKeySelective(finance);
	}

	public void deleteCarFeeById(long id) throws CommonException {
		// TODO Auto-generated method stub
		DsmsFinances finance = financesMapper.selectByPrimaryKey(id);
		DsmsCars car = carsMapper.findCarById(finance.getItemId());
		car.setPrice(null);
		carsMapper.updateByPrimaryKeySelective(car);
		financesMapper.deleteByPrimaryKey(id);
	}

	public void insertCarFee(DsmsFinances finance) throws CommonException {
		// TODO Auto-generated method stub
		finance.setFlag("car");
		financesMapper.insertSelective(finance);
	}

	public List<DsmsFinances> findAllOtherFee() throws CommonException {
		// TODO Auto-generated method stub
		DsmsFinancesExample example=new DsmsFinancesExample();
		example.createCriteria().andFlagNotEqualTo("trainee").andFlagNotEqualTo("car");
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		return list;
	}

	public List<DsmsFinances> findAllOtherFeeByCon(String itemType,Date startDate,Date endDate) throws CommonException {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(itemType)&&startDate==null&&endDate==null) {
			return findAllOtherFee();
		}
		DsmsFinancesExample financesExample=new DsmsFinancesExample();
		Criteria criteria = financesExample.createCriteria();
		criteria.andFlagEqualTo("other");
		if (StringUtils.isNotBlank(itemType)) {
			criteria.andItemTypeEqualTo(itemType);
		}
		if (startDate!=null&&endDate!=null) {
			criteria.andFeeDateBetween(startDate, endDate);
		}
		List<DsmsFinances> list = financesMapper.selectByExample(financesExample);
		return list;
	}

	public DsmsFinances findOtherFeeById(long id) throws CommonException {
		// TODO Auto-generated method stub
		return financesMapper.selectByPrimaryKey(id);
	}

	public void updateOtherFee(DsmsFinances finance) throws CommonException {
		// TODO Auto-generated method stub
		financesMapper.updateByPrimaryKeySelective(finance);
	}

	public void deleteOtherFeeById(long id) throws CommonException {
		// TODO Auto-generated method stub
		financesMapper.deleteByPrimaryKey(id);
	}

	public void insertOtherFee(DsmsFinances finance) throws CommonException {
		// TODO Auto-generated method stub
		financesMapper.insertSelective(finance);
	}
}
