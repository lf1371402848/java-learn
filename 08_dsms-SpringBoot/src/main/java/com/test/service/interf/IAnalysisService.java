package com.test.service.interf;

import com.test.common.exception.CommonException;

import java.util.Date;

public interface IAnalysisService {

	//查询所有其它支出
	public long findAllElseOut() throws CommonException;

	//根据条件查询所有其它支出
	public long findAllElseOutByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有员工工资支出
	public long findAllEmployeeFeeOut() throws CommonException;

	//根据条件查询所有员工工资支出
	public long findAllEmployeeFeeOutByCon(Date startDate,Date endDate) throws CommonException;

	//查询年初到当前月每月的所有月份
	public String[] findAllMonths(Date startDate,Date endDate) throws CommonException;

	//查询年初到当前月每月的所有支出
	public long[] findAllMonthSchoolOut() throws CommonException;

	//根据条件查询年初到当前月每月的所有支出
	public long[] findAllMonthSchoolOutByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有车辆价格
	public long findAllCarPrice() throws CommonException;

	//根据条件查询所有车辆价格
	public long findAllCarPriceByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有车辆维修支出
	public long findAllCarRepairOut() throws CommonException;

	//根据条件查询所有车辆维修支出
	public long findAllCarRepairOutByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有车辆加油支出
	public long findAllCarOilOut() throws CommonException;

	//根据条件查询所有车辆加油支出
	public long findAllCarOilOutByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有其它收入
	public long findAllElseIn() throws CommonException;

	//根据条件查询所有其它收入
	public long findAllElseInByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有学员收入
	public long findAllTraineeIn() throws CommonException;

	//根据条件查询所有学员收入
	public long findAllTraineeInByCon(Date startDate,Date endDate) throws CommonException;

	//查询年初到当前月每月的所有收入
	public long[] findAllMonthSchoolIn() throws CommonException;

	//根据条件查询年初到当前月每月的所有收入
	public long[] findAllMonthSchoolInByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有已毕业学员数量
	public long findAllFinishTraineesNum() throws CommonException;

	//根据条件查询所有已毕业学员数量
	public long findAllFinishTraineesNumByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有学员数量
	public long findAllTraineesNum() throws CommonException;

	//根据条件查询所有学员数量
	public long findAllTraineesNumByCon(Date startDate,Date endDate) throws CommonException;

	//查询年初到当前月每月的学员数量
	public long[] findAllMonthTraineesNum() throws CommonException;

	//根据条件查询年初到当前月每月的学员数量
	public long[] findAllMonthTraineesNumByCon(Date startDate,Date endDate) throws CommonException;

	//查询年初到当前月每月的教练数量
	public long[] findAllMonthTrainersNum() throws CommonException;

	//根据条件查询年初到当前月每月的教练数量
	public long[] findAllMonthTrainersNumByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有教练数量
	public long findAllTrainersNum() throws CommonException;

	//根据条件查询所有教练数量
	public long findAllTrainersNumByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有B1车辆数量
	public long findAllB1CarsNum() throws CommonException;

	//根据条件查询所有B1车辆数量
	public long findAllB1CarsNumByCon(Date startDate,Date endDate) throws CommonException;

	//查询年初到当前月每月B1数量
	public long[] findAllMonthB1CarsNum() throws CommonException;

	//根据条件查询年初到当前月每月B1数量
	public long[] findAllMonthB1CarsNumByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有B2车辆数量
	public long findAllB2CarsNum() throws CommonException;

	//根据条件查询所有B2车辆数量
	public long findAllB2CarsNumByCon(Date startDate,Date endDate) throws CommonException;

	//查询年初到当前月每月B2数量
	public long[] findAllMonthB2CarsNum() throws CommonException;

	//根据条件查询年初到当前月每月B2数量
	public long[] findAllMonthB2CarsNumByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有C1车辆数量
	public long findAllC1CarsNum() throws CommonException;

	//根据条件查询所有C1车辆数量
	public long findAllC1CarsNumByCon(Date startDate,Date endDate) throws CommonException;

	//查询年初到当前月每月C1数量
	public long[] findAllMonthC1CarsNum() throws CommonException;

	//根据条件查询年初到当前月每月C1数量
	public long[] findAllMonthC1CarsNumByCon(Date startDate,Date endDate) throws CommonException;

	//查询所有C2车辆数量
	public long findAllC2CarsNum() throws CommonException;

	//根据条件查询所有C2车辆数量
	public long findAllC2CarsNumByCon(Date startDate,Date endDate) throws CommonException;	

	//查询年初到当前月每月C2数量
	public long[] findAllMonthC2CarsNum() throws CommonException;

	//根据条件查询年初到当前月每月C2数量
	public long[] findAllMonthC2CarsNumByCon(Date startDate,Date endDate) throws CommonException;


}