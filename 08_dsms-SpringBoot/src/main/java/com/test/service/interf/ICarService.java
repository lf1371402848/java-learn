package com.test.service.interf;

import com.test.bean.DsmsCars;
import com.test.common.exception.CommonException;

import java.util.List;

public interface ICarService {

	//查询所有车辆
	public List<DsmsCars> findAllCars() throws CommonException;

	//根据条件查询所有车辆
	public List<DsmsCars> findAllCarsByCon(DsmsCars car) throws CommonException;

	//通过id查询车辆
	public DsmsCars findCarById(long id) throws CommonException;

	//通过教练id查询车辆
	public DsmsCars findCarByTrainerId(long trainerId) throws CommonException;

	//通过车类型查询车辆
	public DsmsCars findCarByCarType(String car_type) throws CommonException;

	//通过车状态查询车辆
	public DsmsCars findCarByStatus(String status) throws CommonException;

	//更新车辆信息 
	public void updateCar(DsmsCars car) throws CommonException;

	//删除车辆
	public void deleteCarById(long id) throws CommonException;

	//新增车辆
	public void insertCar(DsmsCars car) throws CommonException;
}
