package com.test.controller;

import com.test.bean.DsmsCars;
import com.test.common.exception.CommonException;
import com.test.service.interf.ICarService;
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

@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	private ICarService carService;

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/findCarByTrainerId/{id}")
	@ResponseBody
	public DsmsCars findCarByTrainerId(@PathVariable long id) throws CommonException {
		return carService.findCarByTrainerId(id);
	}

	//显示车辆信息
	//如果管理员登录显示所有车辆
	//如果教练登录显示自己负责的车辆
	@RequestMapping(value="/showCar/{flag}")
	public String showCar(@PathVariable String flag,HttpSession session) {	
		if (flag.equals("admin")) {
			try {
				List<DsmsCars> allCars = carService.findAllCars();
				session.setAttribute("allCars",allCars);
			} catch (CommonException e) {
				System.err.println(e.getMessage());
			}
		}
		return "cars/car_list";				
	}

	//根据条件查询车辆
	@RequestMapping(value = "/findCarByCon")
	public String findCarByCon(HttpSession session, DsmsCars car) {
		try {
			List<DsmsCars> allCars = carService.findAllCarsByCon(car);
			session.setAttribute("allCars", allCars);
		} catch (CommonException e) {
			e.printStackTrace();
			session.setAttribute("selectCar_msg", e.getMessage());
		}
		return "cars/car_list";
	}

	//显示车辆信息更新界面
	@RequestMapping(value="/showCarEdit/{carId}")
	public String showCarEdit(@PathVariable Long carId,HttpSession session) {
		try {
				DsmsCars car = carService.findCarById(carId);
				session.setAttribute("car",car);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "cars/car_edit";	
	}

	//更新车辆信息
	@RequestMapping(value="/updateCar")
	public String updateCar(DsmsCars car,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			carService.updateCar(car);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}	
		if (flag.equals("admin")) {	
			return "redirect:/car/showCar/"+flag;
		}else {
			return "redirect:/car/showCarEdit/"+car.getId();	
		}
	}

	//删除车辆
	@RequestMapping(value="/deleteCar/{carId}")
	public String deleteCar(@PathVariable int carId,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			carService.deleteCarById(carId);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "redirect:/car/showCar/"+flag;
	}

	//显示车辆新增界面
	@RequestMapping(value="/showCarAdd")
	public String showCarAdd() {			
		return "cars/car_add";	
	}

	//新增车辆
	@RequestMapping(value="/addCar")
	public String addCar(DsmsCars car,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			carService.insertCar(car);
			return "redirect:/car/showCar/"+flag;
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			session.setAttribute("addCar_msg", e.getMessage());
			return "cars/car_add";	
		}		
	}
}