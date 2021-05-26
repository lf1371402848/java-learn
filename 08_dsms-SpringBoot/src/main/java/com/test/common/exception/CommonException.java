package com.test.common.exception;

import java.util.HashMap;
import java.util.Map;

public class CommonException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final Map<Integer, CommonException> exceptionMap = new HashMap<Integer, CommonException>();
	private static final Map<Integer, String> errmsgMap = new HashMap<Integer, String>();

	static {
		errmsgMap.put(401, "参数为空!");
		errmsgMap.put(402, "用户名密码错误!");
		errmsgMap.put(403, "参数错误！");
		errmsgMap.put(404, "查询结果为空！");
		errmsgMap.put(405, "已存在该用户!");
		errmsgMap.put(406, "两次输入密码不一致!");
		exceptionMap.put(501, new CommonException(501, getMessage(501)));
	}

	private int errcode;
	private String errmsg;

	public CommonException(int errcode, String msg) {
		super(msg);
		this.errcode = errcode;
		this.errmsg = msg;
	}

	public int getErrcode() {
		return errcode;
	}

	@Override
	public String getMessage() {
		return errmsg;
	}

	public static String getMessage(int errcode) {
		if (errmsgMap.containsKey(errcode)) {
			return errmsgMap.get(errcode);
		}
		else {
			return errmsgMap.get(501);
		}
	}

	public static CommonException getException(int errcode) {
		if (exceptionMap.containsKey(errcode)) {
			return exceptionMap.get(errcode);
		} else if (errmsgMap.containsKey(errcode)) {
			CommonException ex = new CommonException(errcode, getMessage(errcode));
			exceptionMap.put(errcode, ex);
			return ex;
		} else {
			return exceptionMap.get(501);
			
		}
	}
}
