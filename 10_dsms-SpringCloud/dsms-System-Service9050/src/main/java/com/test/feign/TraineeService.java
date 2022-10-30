package com.test.feign;

import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTraineesExample;
import com.test.bean.DsmsTrainers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
@FeignClient(contextId = "dsms-Trainee-Service9070-9090", value = "dsms-Trainee-Service9070")
public interface TraineeService {

    @RequestMapping(value = "/findAllTrainees/{flag}")
    public Map<DsmsTrainees, DsmsTrainers> findAllTrainees();

    @RequestMapping(value = "/findTraineeById/{id}")
    public DsmsTrainees findTraineeById(@PathVariable long id);

    @RequestMapping(value = "/countByExample")
    public long countByExample(@RequestBody DsmsTraineesExample example);

    @RequestMapping(value = "/updateByPrimaryKey")
    public void updateByPrimaryKey(@RequestBody DsmsTrainees trainee);

    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public void updateByPrimaryKeySelective(@RequestBody DsmsTrainees trainee);

    @RequestMapping(value="/userLogin")
    public DsmsTrainees login(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping(value="/changePwd")
    public void changePwd(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("againPwd") String againPwd);
}
