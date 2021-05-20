package com.test.service.interf;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.test.bean.DsmsCars;
import com.test.bean.DsmsFinances;
import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;

/*
 * 财务信息
*/
public interface IFinanceService {

	/*
	 * 学员费用情况
	*/
	
	//查询所有学员费用情况
	public Map<DsmsTrainees,DsmsFinances> findAllTraineeFee() throws CommonException;

	//根据条件查询所有学员费用情况
	public Map<DsmsTrainees,DsmsFinances> findAllTraineeFeeByCon(String traineeNo,String name) throws CommonException;

	//通过财务id查询学员费用情况
	public Map<DsmsTrainees,DsmsFinances> findTraineeFeeById(long id) throws CommonException;
		
	//通过学员编号查询学员费用情况
	public Map<DsmsTrainees,DsmsFinances> findTraineeFeeByTraineeNo(String traineeNo) throws CommonException;
		
	//通过学员名字查询学员费用情况
	public Map<DsmsTrainees,DsmsFinances> findTraineeFeeByName(String name) throws CommonException;

	//更新学员费用情况
	public void updateTraineeFee(DsmsFinances finance) throws CommonException;

	//删除学员费用情况
	public void deleteTraineeFeeById(long id) throws CommonException;

	//新增学员费用情况
	public void insertTraineeFee(DsmsFinances finance) throws CommonException;

	/*
	 * 员工工资发放情况
	*/	
	
	//查询所有员工工资发放情况
	public List<DsmsTrainers> findAllEmployeeFee() throws CommonException;

	//根据条件查询所有员工工资发放情况
	public List<DsmsTrainers> findAllEmployeeFeeByCon(DsmsTrainers trainer) throws CommonException;

	//通过员工id查询员工工资发放情况
	public DsmsTrainers findEmployeeFeeById(long id) throws CommonException;

	//根据员工名字查询员工工资发放情况
	public DsmsTrainers findEmployeeFeeByName(String name) throws CommonException;

	//更新员工工资发放情况
	public void updateEmployeeFee (DsmsTrainers trainer) throws CommonException;

	//删除员工工资发放情况
	public void deleteEmployeeFeeById(long id) throws CommonException;

	//新增员工工资发放情况
	public void insertEmployeeFee(DsmsTrainers trainer) throws CommonException;

	/*
	 * 车辆费用情况
	*/	
	//查询所有车辆费用情况
	public Map<DsmsCars,DsmsFinances> findAllCarFee() throws CommonException;

	//根据条件查询车辆费用情况
	public Map<DsmsCars,DsmsFinances> findAllCarFeeByCon(String carNo,Date startDate,Date endDate) throws CommonException;

	//通过id查询车辆费用情况
	public Map<DsmsCars,DsmsFinances> findCarFeeById(long id) throws CommonException;

	//根据车辆编号查询车辆费用情况
	public Map<DsmsCars,DsmsFinances> findCarFeeByNo(String carNo) throws CommonException;

	//更新车辆费用情况
	public void updateCarFee (Long price,DsmsFinances finance) throws CommonException;

	//删除车辆费用情况
	public void deleteCarFeeById(long id) throws CommonException;

	//新增车辆费用情况
	public void insertCarFee(DsmsFinances finance) throws CommonException;
	
	/*
	 * 其它费用
	*/	
	
	//查询所有其它费用
	public List<DsmsFinances> findAllOtherFee() throws CommonException;

	//根据条件查询所有其它费用
	public List<DsmsFinances> findAllOtherFeeByCon(String feeType,Date startDate,Date endDate) throws CommonException;

	//通过id查询其它费用
	public DsmsFinances findOtherFeeById(long id) throws CommonException;

	//更新其它费用
	public void updateOtherFee(DsmsFinances finance) throws CommonException;

	//删除其它费用
	public void deleteOtherFeeById(long id) throws CommonException;

	//新增其它费用
	public void insertOtherFee(DsmsFinances finance) throws CommonException;
}
