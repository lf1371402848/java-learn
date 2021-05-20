package com.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.test.bean.DsmsAdmins;
import com.test.bean.DsmsAdminsExample;
import com.test.common.exception.CommonException;
import com.test.mapper.DsmsAdminsMapper;
import com.test.service.interf.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private DsmsAdminsMapper adminMapper;

	public DsmsAdmins login(String username, String password) throws CommonException {
		DsmsAdminsExample example=new DsmsAdminsExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<DsmsAdmins> list = adminMapper.selectByExample(example);
		if(list==null||list.size()<=0) {
			throw CommonException.getException(402);
		}
		return list.get(0);
	}

	public void changePwd(String username, String password, String againPwd) throws CommonException{
		if (password.equals(againPwd)) {
			DsmsAdminsExample example=new DsmsAdminsExample();
			example.createCriteria().andUsernameEqualTo(username);
			List<DsmsAdmins> list = adminMapper.selectByExample(example);
			list.get(0).setPassword(password);
			adminMapper.updateByPrimaryKeySelective(list.get(0));
		}else {
			throw CommonException.getException(406);
		}
	}

	public DsmsAdmins findAdminsByAdminId(long admin_id) throws CommonException {
		// TODO Auto-generated method stub
		return adminMapper.selectByPrimaryKey(admin_id);
	}

	public void UpdateAdmin(DsmsAdmins admin) throws CommonException {
		// TODO Auto-generated method stub
		if (admin==null) {
			throw CommonException.getException(403);
		}
		adminMapper.updateByPrimaryKey(admin);
	}
}
