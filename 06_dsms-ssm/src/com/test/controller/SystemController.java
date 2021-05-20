package com.test.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.bean.DsmsLogs;
import com.test.common.exception.CommonException;
import com.test.service.interf.ISystemService;

@Controller
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	private ISystemService systemService;

	@RequestMapping(value="/showSystemLog")
	public String showSystemLog(HttpSession session) {
		try {
			Map<DsmsLogs, Object> allLogs = systemService.findAllLogs();
			session.setAttribute("allLogs", allLogs);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "system/log";
	}
}
