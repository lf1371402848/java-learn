package com.test.feign;

import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTraineesExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@FeignClient(contextId = "dsms-Trainee-Service9070-9060", value = "dsms-Trainee-Service9070")
public interface TraineeService {

    @RequestMapping(value = "/findTraineeById/{id}")
    @ResponseBody
    public DsmsTrainees findTraineeById(@PathVariable long id);

    @RequestMapping(value = "/selectByExample")
    @ResponseBody
    public List<DsmsTrainees> selectByExample(@RequestBody DsmsTraineesExample example);
}
