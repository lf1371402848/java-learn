package com.test.controller;

import com.test.bean.DsmsCars;
import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;
import com.test.feign.CarService;
import com.test.service.interf.ITrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private ITrainerService trainerService;

    @Autowired
    private CarService carService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/findCarByTrainerId/{id}")
    @ResponseBody
    public DsmsCars findCarByTrainerId(@PathVariable long id) throws CommonException {
        return carService.findCarByTrainerId(id);
    }

    @RequestMapping(value = "/findTrainerById/{id}")
    @ResponseBody
    public DsmsTrainers findTrainerById(@PathVariable long id) {
        DsmsTrainers dsmsTrainers = null;
        try {
            dsmsTrainers = trainerService.findTrainerById(id);
        } catch (CommonException e) {
            e.printStackTrace();
        }
        return dsmsTrainers;
    }

    //显示教练信息
    //如果管理员登录显示所有教练
    //如果是教练登录显示教练本人
    //如果是学员显示自己教练
	/*@RequestMapping(value="/showTrainer/{flag}")
	public String showTrainer(@PathVariable String flag,HttpSession session) {
		if (flag.equals("admin")) {
			try {
				Map<DsmsTrainers, DsmsCars> alltrainers = trainerService.findAllTrainers();
				session.setAttribute("allTrainers",alltrainers);
			} catch (CommonException e) {
				System.err.println(e.getMessage());
			}
		}
		return "trainers/trainer_list";
	}*/
    @RequestMapping(value = "/showTrainer/{flag}")
    @ResponseBody
    public List<DsmsTrainers> showTrainer(@PathVariable String flag) throws CommonException {
        List<DsmsTrainers> alltrainers = null;
        if (flag.equals("admin")) {
            alltrainers = trainerService.findAllTrainers();
        }
        return alltrainers;
    }

    //根据条件查询教练
    @RequestMapping(value = "/findAllTrainersByCon")
    public String findAllTrainersByCon(HttpSession session, DsmsTrainers trainer) {
        try {
//            Map<DsmsTrainers, DsmsCars> allTrainers = trainerService.findAllTrainersByCon(trainer);
            List<DsmsTrainers> allTrainers = trainerService.findAllTrainersByCon(trainer);
            session.setAttribute("allTrainers", allTrainers);
        } catch (CommonException e) {
            e.printStackTrace();
            session.setAttribute("selectTrainer_msg", e.getMessage());
        }
        return "trainers/trainer_list";
    }

    //显示教练信息更新界面
    @RequestMapping(value = "/showTrainerEdit/{trainerId}")
    public String showTrainerEdit(@PathVariable Long trainerId, HttpSession session) {
        try {
            Map<DsmsTrainers, DsmsCars> trainer = trainerService.findTrainerAndDsmsCarsById(trainerId);
            session.setAttribute("trainer", trainer);
            List<DsmsCars> allCars = carService.findAllCars();
            session.setAttribute("allCars", allCars);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
        return "trainers/trainer_edit";
    }

    //更新教练信息
    @RequestMapping(value = "/updateTrainer")
    public String updateTrainer(DsmsTrainers trainer, HttpSession session) {
        session.removeAttribute("updateTrainer_msg");
        String flag = (String) session.getAttribute("flag");
        try {
            trainerService.updateTrainer(trainer);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
            session.setAttribute("updateTrainer_msg", e.getMessage());
        }
        if (flag.equals("admin")) {
            return "redirect:/trainer/showTrainer/" + flag;
        } else {
            return "redirect:/trainer/showTrainerEdit/" + trainer.getId();
        }
    }

    //删除教练
    @RequestMapping(value = "/deleteTrainer/{trainerId}")
    public String deleteTrainer(@PathVariable int trainerId, HttpSession session) {
        String flag = (String) session.getAttribute("flag");
        try {
            trainerService.deleteTrainerById(trainerId);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
            session.setAttribute("deleteTrainer_msg", e.getMessage());
        }
        return "redirect:/trainer/showTrainer/" + flag;
    }

    //显示教练新增界面
    @RequestMapping(value = "/showTrainerAdd")
    public String showTrainerAdd(HttpSession session) {
        List<DsmsCars> allCars = carService.findAllCars();
        session.setAttribute("allCars", allCars);
        return "trainers/trainer_add";
    }

    //新增教练
    @RequestMapping(value = "/addTrainer")
    public String addTrainer(DsmsTrainers trainer, HttpSession session) {
        session.removeAttribute("addTrainer_msg");
        String flag = (String) session.getAttribute("flag");
        try {
            trainerService.insertTrainer(trainer);
            return "redirect:/trainer/showTrainer/" + flag;
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
            session.setAttribute("addTrainer_msg", e.getMessage());
            return "trainers/trainer_add";
        }
    }

    //显示所负责学员
    @RequestMapping(value = "/showTrainee")
    public String showTrainee(HttpSession session) {
        DsmsTrainers trainer = (DsmsTrainers) session.getAttribute("trainerLogin");
        try {
            List<DsmsTrainees> alltrainees = trainerService.findAllTrainersTrainees(trainer.getId());
            session.setAttribute("alltrainees", alltrainees);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "trainers/trainee_list";
    }

    //根据条件查询学员
    @RequestMapping(value = "/findAllTrainersTraineesByCon")
    public String findAllTrainersTraineesByCon(HttpSession session, DsmsTrainees trainee) {
        DsmsTrainers trainer = (DsmsTrainers) session.getAttribute("trainerLogin");
        try {
            List<DsmsTrainees> alltrainees = trainerService.findAllTrainersTraineesByCon(trainer.getId(), trainee);
            session.setAttribute("alltrainees", alltrainees);
        } catch (CommonException e) {
            e.printStackTrace();
            session.setAttribute("selectTrainee_msg", e.getMessage());
        }
        return "trainers/trainee_list";
    }
}