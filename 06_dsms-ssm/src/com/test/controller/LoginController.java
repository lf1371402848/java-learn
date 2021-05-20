package com.test.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.test.bean.DsmsAdmins;
import com.test.bean.DsmsLogs;
import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;
import com.test.service.interf.IAdminService;
import com.test.service.interf.ISystemService;
import com.test.service.interf.ITraineeService;
import com.test.service.interf.ITrainerService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private ITrainerService trainerService;
	
	@Autowired
	private ITraineeService traineeService;
	
	@Autowired
	private ISystemService systemService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value="/userLogin")
	public String userLogin(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("flag") String flag,HttpSession session) {
		session.removeAttribute("login_msg");
		session.setAttribute("flag", flag);
		DsmsLogs log = null;
		try {
			if (flag.equals("admin")) {
				DsmsAdmins admin = adminService.login(username, password);
				session.setAttribute("adminLogin", admin);
				log = new DsmsLogs(null, admin.getId(), admin.getUsername()+"登录了系统", null, flag);
			}else if (flag.equals("trainer")) {
				DsmsTrainers trainer = trainerService.login(username, password);
				session.setAttribute("trainerLogin", trainer);
				log = new DsmsLogs(null, trainer.getId(), trainer.getName()+"登录了系统", null, flag);
			}else if (flag.equals("trainee")) {
				DsmsTrainees trainee = traineeService.login(username, password);
				session.setAttribute("traineeLogin", trainee);
				log = new DsmsLogs(null, trainee.getId(), trainee.getName()+"登录了系统", null, flag);
			}		
			systemService.insertLog(log);
			return "index";
		} catch (CommonException e) {
			session.setAttribute("login_msg", e.getMessage());
			System.err.println(e.getMessage());
			return "login";
		}
	}
	
	@RequestMapping(value="/userLogOut")
	public String userLogOut(HttpSession session) {
		DsmsLogs log = null;
		String flag = (String) session.getAttribute("flag");
		if (flag.equals("admin")) {
			DsmsAdmins admin = (DsmsAdmins) session.getAttribute("adminLogin");
			log = new DsmsLogs(null, admin.getId(), admin.getUsername()+"退出了系统", null, flag);
		}else if (flag.equals("trainer")) {
			DsmsTrainers trainer = (DsmsTrainers) session.getAttribute("trainerLogin");
			log = new DsmsLogs(null, trainer.getId(), trainer.getName()+"退出了系统", null, flag);
		}else if (flag.equals("trainee")) {
			DsmsTrainees trainee = (DsmsTrainees) session.getAttribute("traineeLogin");
			log = new DsmsLogs(null, trainee.getId(), trainee.getName()+"退出了系统", null, flag);
		}
		try {
			systemService.insertLog(log);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login";
	}
	
	@RequestMapping(value="/showChangePwd")
	public String showChangePwd(HttpSession session) {
		session.removeAttribute("changePwd_msg");
		return "change_pwd";
	}
	@RequestMapping(value="/changePwd")
	public String changePwd(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("againPwd") String againPwd,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			if (flag.equals("admin")) {
				adminService.changePwd(username, password, againPwd);
			}else if (flag.equals("trainer")) {
				trainerService.changePwd(username, password, againPwd);
			}else if (flag.equals("trainee")) {
				traineeService.changePwd(username, password, againPwd);
			}		
			return "index";
		} catch (CommonException e) {
			session.setAttribute("changePwd_msg", e.getMessage());
			System.err.println(e.getMessage());
			return "change_pwd";
		}
	}
}
