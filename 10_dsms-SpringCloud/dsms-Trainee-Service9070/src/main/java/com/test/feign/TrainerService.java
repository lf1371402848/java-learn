package com.test.feign;

import com.test.bean.DsmsCars;
import com.test.bean.DsmsTrainers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Component
@FeignClient(contextId = "dsms-Trainer-Service9060-9070",value = "dsms-Trainer-Service9060")
public interface TrainerService {

    @RequestMapping(value = "/findAllTrainers")
    public Map<DsmsTrainers, DsmsCars> findAllTrainers();

    @RequestMapping(value = "/findTrainerById/{id}")
    public DsmsTrainers findTrainerById(@PathVariable long id);

    @RequestMapping(value = "/updateByPrimaryKey")
    public void updateByPrimaryKey(@RequestBody DsmsTrainers trainer);

    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public void updateByPrimaryKeySelective(@RequestBody DsmsTrainers trainer);
}
