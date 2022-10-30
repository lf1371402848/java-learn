package com.test.feign;

import com.test.bean.DsmsCars;
import com.test.bean.DsmsTrainers;
import com.test.bean.DsmsTrainersExample;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(contextId = "sms-Trainer-Service9060-9080", value = "dsms-Trainer-Service9060")
public interface TrainerService {

    @RequestMapping(value = "/trainer/findAllTrainers")
    public Map<DsmsTrainers, DsmsCars> findAllTrainers();

    @RequestMapping(value = "/trainer/findTrainerById/{id}")
    public DsmsTrainers findTrainerById(@PathVariable long id);

    @RequestMapping(value = "/trainer/showTrainer/{flag}")
    @ResponseBody
    public List<DsmsTrainers> showTrainer(@PathVariable String flag);

    @RequestMapping(value = "/trainer/selectByExample")
    public List<DsmsTrainers> selectByExample(@RequestBody DsmsTrainersExample example);

    @RequestMapping(value = "/trainer/countByExample")
    public long countByExample(@RequestBody DsmsTrainersExample example);

    @RequestMapping(value = "/trainer/updateByPrimaryKey")
    public void updateByPrimaryKey(@RequestBody DsmsTrainers trainer);

    @RequestMapping(value = "/trainer/updateByPrimaryKeySelective")
    public void updateByPrimaryKeySelective(@RequestBody DsmsTrainers trainer);

    @RequestMapping(value = "/userLogin")
    public DsmsTrainers login(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping(value = "/changePwd")
    public void changePwd(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("againPwd") String againPwd);
}
