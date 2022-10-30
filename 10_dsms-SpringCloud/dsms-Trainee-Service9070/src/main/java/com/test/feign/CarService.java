package com.test.feign;

import com.test.bean.DsmsCars;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(contextId = "dsms-Car-Service9080-9070", value = "dsms-Car-Service9080")
public interface CarService {
    //根据id查询教练
    @RequestMapping(value = "/findCarByTrainerId/{id}")
    public DsmsCars findCarByTrainerId(long id);
}
