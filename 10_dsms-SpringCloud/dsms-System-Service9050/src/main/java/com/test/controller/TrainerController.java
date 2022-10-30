package com.test.controller;

import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;
import com.test.feign.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/system")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @RequestMapping(value = "/trainer/showTrainer/{flag}")
    public String showTrainer(@PathVariable String flag, HttpSession session) throws CommonException {
        List<DsmsTrainers> alltrainers = trainerService.showTrainer(flag);
        session.setAttribute("allTrainers",alltrainers);
        alltrainers.stream().forEach(System.err::println);
        return "trainers/trainer_list";
    }
}