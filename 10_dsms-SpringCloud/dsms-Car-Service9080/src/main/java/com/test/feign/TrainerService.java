package com.test.feign;

import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(contextId = "sms-Trainer-Service9060-9080", value = "dsms-Trainer-Service9060")
public interface TrainerService {
	//根据id查询教练
	@RequestMapping(value="/findTrainerById/{id}")
	public DsmsTrainers findTrainerById(long id) throws CommonException;
}
