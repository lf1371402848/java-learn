package com.test.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import com.test.bean.DsmsCars;
import com.test.bean.DsmsFinances;
import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;
import com.test.service.interf.ICarService;
import com.test.service.interf.IFinanceService;
import com.test.service.interf.ITraineeService;
import com.test.service.interf.ITrainerService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/finance")
public class FinanceController {

	@Autowired
	private IFinanceService financeService;
	
	@Autowired
	private ITrainerService traineerService;
	
	@Autowired
	private ITraineeService traineeService;

	@Autowired
	private ICarService carService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	/*
	 * 显示学员费用信息
	 */
	
	//如果管理员登录显示所有学员费用信息
	//如果学员显示自己费用信息
	@RequestMapping(value="/showTraineeFee/{flag}")
	public String showTraineeFee(@PathVariable String flag,HttpSession session) {	
		if (flag.equals("admin")) {
			try {
				Map<DsmsTrainees, DsmsFinances> allTraineeFee = financeService.findAllTraineeFee();
				session.setAttribute("allTraineeFee",allTraineeFee);
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}else {
			DsmsTrainees trainee = (DsmsTrainees) session.getAttribute("trainee");
			try {
				Map<DsmsTrainees, DsmsFinances> traineeFee = financeService.findTraineeFeeByTraineeNo(trainee.getTraineeNo());
				session.setAttribute("traineeFee", traineeFee);
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}
		return "finances/trainee_fee_list";				
	}

	//根据条件查询学员费用信息
	@RequestMapping(value = "/findTraineeFeeByCon")
	public String findTraineeFeeByCon(HttpSession session, @RequestParam String traineeNo,@RequestParam String name) {
		try {
			Map<DsmsTrainees, DsmsFinances> allTraineeFee = financeService.findAllTraineeFeeByCon(traineeNo,name);
			session.setAttribute("allTraineeFee", allTraineeFee);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return "finances/trainee_fee_list";
	}

	//显示学员费用信息更新界面
	@RequestMapping(value="/showTraineeFeeEdit/{traineeFeeId}")
	public String showTraineeFeeEdit(@PathVariable Long traineeFeeId,HttpSession session) {
		try {
			Map<DsmsTrainees, DsmsFinances> traineeFee = financeService.findTraineeFeeById(traineeFeeId);
			session.setAttribute("traineeFee",traineeFee);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "finances/trainee_fee_edit";	
	}

	//更新学员费用信息
	@RequestMapping(value="/updateTraineeFee")
	public String updateCar(DsmsFinances finance,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			financeService.updateTraineeFee(finance);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}		
		return "redirect:/finance/showTraineeFee/"+flag;
	}

	//删除学员费用信息
	@RequestMapping(value="/deleteTraineeFee/{traineeFeeId}")
	public String deleteTraineeFee(@PathVariable int traineeFeeId,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			financeService.deleteTraineeFeeById(traineeFeeId);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "redirect:/finance/showTraineeFee/"+flag;
	}

	//显示学员费用信息新增界面
	@RequestMapping(value="/showTraineeFeeAdd")
	public String showTraineeFeeAdd(HttpSession session) {			
		try {
			Map<DsmsTrainees, DsmsTrainers> allTrainees = traineeService.findAllTrainees();
			session.setAttribute("allTrainees", allTrainees);
			JSONArray allTraineesJson = JSONArray.fromObject(allTrainees.keySet());
			session.setAttribute("allTraineesJson", allTraineesJson);
		} catch (CommonException e1) {
			// TODO Auto-generated catch block
			System.err.println(e1.getMessage());
		}
		return "finances/trainee_fee_add";	
	}

	//新增学员费用信息
	@RequestMapping(value="/addTraineeFee")
	public String addTraineeFee(DsmsFinances finance,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			financeService.insertTraineeFee(finance);
			return "redirect:/finance/showTraineeFee/"+flag;
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			session.setAttribute("addTraineeFee_msg", e.getMessage());
			return "finances/trainee_fee_add";	
		}		
	}
	
	/*
	 * 显示员工费用信息
	 */
	
	//如果管理员登录显示所有员工工资信息
	//如果员工显示自己工资信息
	@RequestMapping(value="/showEmployeeFee/{flag}")
	public String showEmployeeFee(@PathVariable String flag,HttpSession session) {	
		if (flag.equals("admin")) {
			try {
				List<DsmsTrainers> allTrainerFee = financeService.findAllEmployeeFee();
				session.setAttribute("allTrainerFee",allTrainerFee);
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}else {
			DsmsTrainers trainee = (DsmsTrainers) session.getAttribute("trainer");
			try {
				DsmsTrainers trainerFee = financeService.findEmployeeFeeById(trainee.getId());
				session.setAttribute("trainerFee", trainerFee);
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}
		return "finances/employee_fee_list";				
	}

	//根据条件查询员工工资信息
	@RequestMapping(value = "/findEmployeeFeeByCon")
	public String findEmployeeFeeByCon(HttpSession session, DsmsTrainers trainer) {
		try {
			List<DsmsTrainers> allTrainerFee = financeService.findAllEmployeeFeeByCon(trainer);
			session.setAttribute("allTrainerFee", allTrainerFee);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return "finances/employee_fee_list";
	}

	//显示员工工资信息更新界面
	@RequestMapping(value="/showEmployeeFeeEdit/{trainerId}")
	public String showEmployeeFeeEdit(@PathVariable Long trainerId,HttpSession session) {
		try {
			DsmsTrainers trainerFee = financeService.findEmployeeFeeById(trainerId);
			session.setAttribute("trainerFee",trainerFee);
			Map<DsmsTrainers, DsmsCars> allTrainers = traineerService.findAllTrainers();
			session.setAttribute("allTrainers", allTrainers);
			JSONArray allTrainersJson = JSONArray.fromObject(allTrainers.keySet());
			session.setAttribute("allTrainersJson", allTrainersJson);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "finances/employee_fee_edit";	
	}

	//更新员工工资信息
	@RequestMapping(value="/updateEmployeeFee")
	public String updateEmployeeFee(DsmsTrainers trainer,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			financeService.updateEmployeeFee(trainer);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}		
		return "redirect:/finance/showEmployeeFee/"+flag;
	}

	//删除员工工资信息
	@RequestMapping(value="/deleteEmployeeFee/{trainerId}")
	public String deleteEmployeeFee(@PathVariable long trainerId,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			financeService.deleteEmployeeFeeById(trainerId);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "redirect:/finance/showEmployeeFee/"+flag;
	}

	//显示员工工资信息新增界面
	@RequestMapping(value="/showEmployeeFeeAdd")
	public String showEmployeeFeeAdd(HttpSession session) {	
		try {
			Map<DsmsTrainers, DsmsCars> allTrainers = traineerService.findAllTrainers();
			session.setAttribute("allTrainers", allTrainers);
			JSONArray allTrainersJson = JSONArray.fromObject(allTrainers.keySet());
			session.setAttribute("allTrainersJson", allTrainersJson);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "finances/employee_fee_add";	
	}

	//新增员工工资信息
	@RequestMapping(value="/addEmployeeFee")
	public String addEmployeeFee(DsmsTrainers trainer,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			financeService.insertEmployeeFee(trainer);
			return "redirect:/finance/showEmployeeFee/"+flag;
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			session.setAttribute("addEmployeeFee_msg", e.getMessage());
			return "financess/employee_fee_add";		
		}		
	}
	
	/*
	 * 显示车辆费用信息
	 */
	
	//如果管理员登录显示所有车辆费用信息
	//如果教练登录显示自己负责车辆费用信息
	@RequestMapping(value="/showCarFee/{flag}")
	public String showCarFee(@PathVariable String flag,HttpSession session) {	
		if (flag.equals("admin")) {
			try {
				Map<DsmsCars, DsmsFinances> allCarFee = financeService.findAllCarFee();
				session.setAttribute("allCarFee",allCarFee);
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}else if (flag.equals("trainer")) {
			DsmsTrainers trainer = (DsmsTrainers) session.getAttribute("trainer");
			try {
				Map<DsmsCars, DsmsFinances> allCarFee = financeService.findCarFeeById(trainer.getCarId());
				session.setAttribute("allCarFee", allCarFee);
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}
		return "finances/car_fee_list";				
	}

	//根据条件查询车辆费用信息
	@RequestMapping(value = "/findCarFeeByCon")
	public String findCarFeeByCon(@RequestParam String carNo,@RequestParam Date startDate,@RequestParam Date endDate,HttpSession session) {
		try {
			Map<DsmsCars, DsmsFinances> allCarFee = financeService.findAllCarFeeByCon(carNo, startDate, endDate);
			session.setAttribute("allCarFee", allCarFee);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return "finances/car_fee_list";
	}

	//显示车辆费用信息更新界面
	@RequestMapping(value="/showCarFeeEdit/{financeId}")
	public String showCarFeeEdit(@PathVariable Long financeId,HttpSession session) {
		try {
			Map<DsmsCars, DsmsFinances> carFee = financeService.findCarFeeById(financeId);
			session.setAttribute("carFee",carFee);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "finances/car_fee_edit";	
	}

	//更新车辆费用信息
	@RequestMapping(value="/updateCarFee")
	public String updateCarFee(@RequestParam Long price,DsmsFinances finance,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			financeService.updateCarFee(price,finance);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}		
		return "redirect:/finance/showCarFee/"+flag;
	}

	//删除车辆费用信息
	@RequestMapping(value="/deleteCarFee/{carId}")
	public String deleteCarFee(@PathVariable long carId,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			financeService.deleteCarFeeById(carId);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "redirect:/finance/showCarFee/"+flag;
	}

	//显示车辆费用信息新增界面
	@RequestMapping(value="/showCarFeeAdd")
	public String showCarFeeAdd(HttpSession session) {		
		try {
			List<DsmsCars> allCars = carService.findAllCars();
			session.setAttribute("allCars", allCars);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "finances/car_fee_add";	
	}

	//新增车辆费用信息
	@RequestMapping(value="/addCarFee")
	public String addCarFee(DsmsFinances finance,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			financeService.insertCarFee(finance);
			return "redirect:/finance/showCarFee/"+flag;
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			session.setAttribute("addCarFee_msg", e.getMessage());
			return "finances/car_fee_add";		
		}		
	}
	
	/*
	 * 显示其它费用信息
	 */
	
	//如果管理员登录显示所有其它费用信息
	@RequestMapping(value="/showOtherFee/{flag}")
	public String showAllOtherFee(@PathVariable String flag,HttpSession session) {	
		if (flag.equals("admin")) {
			try {
				List<DsmsFinances> allOtherFee = financeService.findAllOtherFee();
				session.setAttribute("allOtherFee",allOtherFee);
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
		}
		return "finances/other_fee_list";				
	}

	//根据条件查询其它费用信息
	@RequestMapping(value = "/findOtherFeeByCon")
	public String findAllOtherFeeByCon(String feeType,@RequestParam Date startDate,@RequestParam Date endDate,HttpSession session) {
		try {
			List<DsmsFinances> allOtherFee = financeService.findAllOtherFeeByCon(feeType, startDate, endDate);
			session.setAttribute("allOtherFee", allOtherFee);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return "finances/other_fee_list";
	}

	//显示其它费用信息更新界面
	@RequestMapping(value="/showOtherFeeEdit/{financeId}")
	public String showOtherFeeEdit(@PathVariable Long financeId,HttpSession session) {
		try {
			DsmsFinances otherFee = financeService.findOtherFeeById(financeId);
			session.setAttribute("otherFee",otherFee);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "finances/other_fee_edit";	
	}

	//更新其它费用信息
	@RequestMapping(value="/updateOtherFee")
	public String updateOtherFee(DsmsFinances finance,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			financeService.updateOtherFee(finance);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}		
		return "redirect:/finance/showOtherFee/"+flag;
	}

	//删除其它费用信息
	@RequestMapping(value="/deleteOtherFee/{financeId}")
	public String deleteOtherFee(@PathVariable Long financeId,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			financeService.deleteOtherFeeById(financeId);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "redirect:/finance/showOtherFee/"+flag;
	}

	//显示其它费用信息新增界面
	@RequestMapping(value="/showOtherFeeAdd")
	public String showOtherFeeAdd() {			
		return "finances/other_fee_add";	
	}

	//新增其它费用信息
	@RequestMapping(value="/addOtherFee")
	public String addOtherFee(DsmsFinances finance,HttpSession session) {
		String flag = (String) session.getAttribute("flag");
		try {
			financeService.insertOtherFee(finance);
			return "redirect:/finance/showOtherFee/"+flag;
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			session.setAttribute("addOtherFee_msg", e.getMessage());
			return "finances/other_fee_add";		
		}		
	}
}