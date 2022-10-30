package com.test.controller;

import com.test.bean.DsmsCars;
import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;
import com.test.feign.CarService;
import com.test.feign.TrainerService;
import com.test.service.interf.ITraineeService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/trainee")
public class TraineeController {

	@Autowired
	private ITraineeService traineeService;

	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private CarService carService;

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value="/findTraineeById/{id}")
	public DsmsTrainees findTraineeById(@PathVariable long id) throws CommonException {
		return traineeService.findTraineeById(id);
	}

	@RequestMapping(value="/findTraineeAndDsmsTrainerById/{id}")
	public Map<DsmsTrainees,DsmsTrainers> findTraineeAndDsmsTrainerById(long id) throws CommonException {
			return traineeService.findTraineeAndDsmsTrainerById(id);
	}
	//显示学员信息
	//如果管理员登录显示所有学员
	//如果教练登录显示所负责学员
	//如果是学员显示自己本人
	@RequestMapping(value="/findAllTrainees/{flag}")
	public String findAllTrainees(@PathVariable String flag,HttpSession session) {
		if (flag.equals("admin")) {
			try {
				Map<DsmsTrainees, DsmsTrainers> alltrainees = traineeService.findAllTrainees();
				session.setAttribute("alltrainees",alltrainees);
			} catch (CommonException e) {
				System.err.println(e.getMessage());
			}
		}
		return "trainees/trainee_list";				
	}

	//根据条件查询学员
	@RequestMapping(value = "/findAllTraineesByCon")
	public String findAllTraineesByCon(HttpSession session, DsmsTrainees trainer) {
		try {
			Map<DsmsTrainees, DsmsTrainers> alltrainees = traineeService.findAllTraineesByCon(trainer);
			session.setAttribute("alltrainees", alltrainees);
		} catch (CommonException e) {
			e.printStackTrace();
			session.setAttribute("selectTrainee_msg", e.getMessage());
		}
		return "trainees/trainee_list";
	}

	//显示学员信息更新界面
	@RequestMapping(value="/showTraineeEdit/{traineeId}")
	public String showTraineeEdit(@PathVariable Long traineeId,HttpSession session) {
		try {
			Map<DsmsTrainees, DsmsTrainers> trainee = traineeService.findTraineeAndDsmsTrainerById(traineeId);
			session.setAttribute("trainee",trainee);
			Map<DsmsTrainers, DsmsCars> map = trainerService.findAllTrainers();
			Set<DsmsTrainers> allTrainers = map.keySet();
			session.setAttribute("allTrainers",allTrainers);
			JSONArray allTrainersJson = JSONArray.fromObject(allTrainers);
			session.setAttribute("allTrainersJson", allTrainersJson);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "trainees/trainee_edit";	
	}

	//更新学员信息
	@RequestMapping(value="/updateTrainee")
	public String updateTrainee(DsmsTrainees trainee,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			traineeService.updateTrainee(trainee);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}	
		if (flag.equals("trainee")) {
			return "redirect:/trainee/showTraineeEdit/"+trainee.getId();
		}else {			
			return "redirect:/trainee/showTrainee/"+flag;
		}
	}

	//删除学员
	@RequestMapping(value="/deleteTrainee/{traineeId}")
	public String deleteTrainee(@PathVariable int traineeId,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			traineeService.deleteTraineeById(traineeId);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "redirect:/trainee/showTrainee/"+flag;
	}

	//显示学员新增界面
	@RequestMapping(value="/showTraineeAdd")
	public String showTrainerAdd(HttpSession session) {
		Map<DsmsTrainers, DsmsCars> map = trainerService.findAllTrainers();
		Set<DsmsTrainers> allTrainers = map.keySet();
		session.setAttribute("allTrainers",allTrainers);
		JSONArray allTrainersJson = JSONArray.fromObject(allTrainers);
		session.setAttribute("allTrainersJson", allTrainersJson);
		return "trainees/trainee_add";
	}

	//新增学员
	@RequestMapping(value="/addTrainee")
	public String addTrainee(DsmsTrainees trainee,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			traineeService.insertTrainee(trainee);
			return "redirect:/trainee/showTrainee/"+flag;
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			session.setAttribute("addTrainee_msg", e.getMessage());
			return "trainees/trainee_add";	
		}		
	}

	//显示车辆界面
	@RequestMapping(value="/showCar/{trainerId}")
	public String showCar(@PathVariable Long trainerId,HttpSession session) {
		DsmsCars car = carService.findCarByTrainerId(trainerId);
		session.setAttribute("car",car);
		return "cars/car_edit";
	}
}