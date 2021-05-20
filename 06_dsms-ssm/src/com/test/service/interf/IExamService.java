package com.test.service.interf;

import java.util.List;
import java.util.Map;
import com.test.bean.DsmsExamPlans;
import com.test.bean.DsmsExamOrders;
import com.test.bean.DsmsExamResults;
import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;

public interface IExamService {

	/*
	 * 考试计划
	*/
	//查询所有考试计划
	public List<DsmsExamPlans> findAllExamsPlans() throws CommonException;

	//根据条件查询所有考试计划
	public List<DsmsExamPlans> findAllExamsPlansByCon(DsmsExamPlans examsPlan) throws CommonException;

	//通过id查询考试计划
	public DsmsExamPlans findExamsPlanById(long id) throws CommonException;
		
	//通过考试科目查询考试计划
	public DsmsExamPlans findExamsPlanByExamType(String examsType) throws CommonException;

	//根据考试场地查询考试计划
	public DsmsExamPlans findExamsPlanByExamPlace(String place) throws CommonException;

	//根据考试车型查询考试计划
	public DsmsExamPlans findExamsPlanByCarType(String carsType) throws CommonException;

	//更新考试计划
	public void updateExamsPlan(DsmsExamPlans examsPlan) throws CommonException;

	//删除考试计划
	public void deleteExamsPlanById(long id) throws CommonException;

	//新增考试计划
	public void insertExamsPlan(DsmsExamPlans examsPlan) throws CommonException;

	/*
	 * 考试预约
	*/	
	//查询所有已预约考试情况
	public Map<DsmsTrainees, DsmsExamPlans> findAllExamsOrdered(String flag,DsmsTrainers trainer) throws CommonException;

	//根据条件查询所有已预约考试情况
	public Map<DsmsTrainees, DsmsExamPlans> findAllExamsOrderedByCon(String flag,DsmsTrainers trainer,String traineeNo,String traineeName,String examType) throws CommonException;

	//通过id查询已预约考试情况
	public DsmsExamOrders findExamsOrderedById(long id) throws CommonException;

	//根据学员编号查询已预约考试情况
	public DsmsExamOrders findExamsOrderedByTraineeNo(String traineeNo) throws CommonException;
	
	//通过预约状态查询已预约考试情况
	public DsmsExamOrders findExamsOrderedByStatus(String status) throws CommonException;

	//更新已预约考试情况
	public void updateExamsOrdered(DsmsExamOrders examsOrder) throws CommonException;

	//删除已预约情况
	public void deleteExamsOrderedById(long id) throws CommonException;

	//新增已预约情况
	public void insertExamsOrdered(DsmsExamOrders examsOrder) throws CommonException;
	
	//查询所有可预约考试学员
	public List<DsmsTrainees> findAllExamsOrderList() throws CommonException;

	/*
	 * 考试成绩
	*/	
	//查询所有考试成绩
	public Map<DsmsTrainees,DsmsExamResults> findAllExamsResults() throws CommonException;

	//根据条件查询所有成绩
	public Map<DsmsTrainees,DsmsExamResults> findAllExamsResultsByCon(String traineeNo,String traineeName,String examType) throws CommonException;

	//通过id查询成绩
	public DsmsExamResults findExamsResultById(long id) throws CommonException;

	//更新考试成绩
	public void updateExamsResult (DsmsExamResults examsResult) throws CommonException;

	//删除考试成绩
	public void deleteExamsResultById(long id) throws CommonException;

	//新增考试成绩
	public void insertExamsResult(DsmsExamResults examsResult) throws CommonException;
}
