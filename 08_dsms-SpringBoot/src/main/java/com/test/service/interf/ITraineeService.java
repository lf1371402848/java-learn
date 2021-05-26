package com.test.service.interf;

import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;

import java.util.Map;

public interface ITraineeService {

	//学员登录
	public DsmsTrainees login(String username, String password) throws CommonException;

	//修改密码
	public void changePwd(String username, String password, String againPwd) throws CommonException;

	//查询所有学员
	public Map<DsmsTrainees,DsmsTrainers> findAllTrainees() throws CommonException;

	//根据条件查询所有学员
	public Map<DsmsTrainees,DsmsTrainers> findAllTraineesByCon(DsmsTrainees trainee) throws CommonException;

	//通过id查询学员
	public Map<DsmsTrainees,DsmsTrainers> findTraineeById(long id) throws CommonException;

	//根据名字查询学员
	public Map<DsmsTrainees,DsmsTrainers> findTraineeByName(String name) throws CommonException;

	//根据身份证号码查询学员
	public Map<DsmsTrainees,DsmsTrainers> findTraineeByIdNumber(String idNumber) throws CommonException;

	//更新学员信息
	public void updateTrainee(DsmsTrainees trainee) throws CommonException;

	//删除学员
	public void deleteTraineeById(long id) throws CommonException;

	//新增学员
	public void insertTrainee(DsmsTrainees trainee) throws CommonException;

}
