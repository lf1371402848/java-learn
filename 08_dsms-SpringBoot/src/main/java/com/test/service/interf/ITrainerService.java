package com.test.service.interf;

import com.test.bean.DsmsCars;
import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;

import java.util.List;
import java.util.Map;

public interface ITrainerService {

	//教练登录
	public DsmsTrainers login(String username, String password) throws CommonException;
	
	//修改密码
	public void changePwd(String username, String password, String againPwd) throws CommonException;

	//查询所有教练
	public Map<DsmsTrainers,DsmsCars> findAllTrainers() throws CommonException;

	//根据条件查询所有教练
	public Map<DsmsTrainers,DsmsCars> findAllTrainersByCon(DsmsTrainers trainer) throws CommonException;

	//根据id查询教练
	public Map<DsmsTrainers,DsmsCars> findTrainerById(long id) throws CommonException;

	//根据名字查询教练
	public Map<DsmsTrainers,DsmsCars> findTrainerByName(String name) throws CommonException;

	//根据身份证号码查询教练
	public Map<DsmsTrainers,DsmsCars> findTrainerByIdNumber(String idNumber) throws CommonException;

	//更新教练信息
	public void updateTrainer(DsmsTrainers trainer) throws CommonException;

	//删除教练
	public void deleteTrainerById(long id) throws CommonException;

	//新增教练
	public void insertTrainer(DsmsTrainers trainer) throws CommonException;
	
	//查询教练所有负责学员
	public List<DsmsTrainees> findAllTrainersTrainees(long trainerId) throws CommonException;
	
	//根据条件查询教练所有负责学员
	public List<DsmsTrainees> findAllTrainersTraineesByCon(long trainerId,DsmsTrainees trainee) throws CommonException;
}
