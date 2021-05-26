package com.test.service.interf;

import com.test.bean.DsmsAdmins;
import com.test.common.exception.CommonException;

/**
 * Created by LuoFeng on 2018/12/8.
 */
public interface IAdminService {

	public DsmsAdmins login(String username, String password) throws CommonException;
	
	public void changePwd(String username, String password, String againPwd) throws CommonException;
	
    public DsmsAdmins findAdminsByAdminId(long admin_id) throws CommonException;
   
    public void UpdateAdmin(DsmsAdmins admin) throws CommonException;

}
