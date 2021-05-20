package com.test.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.test.bean.DsmsExamPlans;
import com.test.bean.DsmsExamOrders;
import com.test.bean.DsmsExamResults;
import com.test.bean.DsmsTrainees;
import com.test.bean.DsmsTrainers;
import com.test.common.exception.CommonException;
import com.test.service.interf.IExamService;
import com.test.service.interf.ITraineeService;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	private IExamService examService;

	@Autowired
	private ITraineeService traineeService;

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	//显示考试计划
	@RequestMapping(value="/showExamPlan")
	public String showExamPlan(HttpSession session) {	
		try {
			List<DsmsExamPlans> allexamplans = examService.findAllExamsPlans();
			session.setAttribute("allexamplans",allexamplans);
		} catch (CommonException e) {
			System.err.println(e.getMessage());
		}
		return "exams/exam_plan";				
	}

	//根据条件查询考试计划
	@RequestMapping(value = "/findExamPlanByCon")
	public String findExamPlanByCon(HttpSession session, DsmsExamPlans examsPlan) {
		try {
			List<DsmsExamPlans> allexamplans = examService.findAllExamsPlansByCon(examsPlan);
			session.setAttribute("allexamplans", allexamplans);
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return "exams/exam_plan";
	}

	//显示考试计划更新界面
	@RequestMapping(value="/showExamPlanEdit/{planId}")
	public String showExamPlanEdit(@PathVariable Long planId,HttpSession session) {
		try {
			DsmsExamPlans examPlan = examService.findExamsPlanById(planId);
			session.setAttribute("examPlan",examPlan);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "exams/exam_plan_edit";	
	}

	//更新考试计划
	@RequestMapping(value="/updateExamPlan")
	public String updateExamPlan(DsmsExamPlans examPlan) {
		try {
			examService.updateExamsPlan(examPlan);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}		
		return "redirect:/exam/showExamPlan";
	}

	//删除考试计划
	@RequestMapping(value="/deleteExamPlan/{planId}")
	public String deleteExamPlan(@PathVariable int planId,HttpSession session) {
		try {
			examService.deleteExamsPlanById(planId);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "redirect:/exam/showExamPlan";
	}

	//显示考试计划新增界面
	@RequestMapping(value="/showExamPlanAdd")
	public String showTrainerAdd() {			
		return "exams/exam_plan_add";	
	}

	//新增考试计划
	@RequestMapping(value="/addExamPlan")
	public String addExamPlan(DsmsExamPlans examPlan,HttpSession session) {
		try {
			examService.insertExamsPlan(examPlan);
			return "redirect:/exam/showExamPlan";
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			session.setAttribute("addExamPlan_msg", e.getMessage());
			return "exams/exam_plan_add";		
		}		
	}

	//显示已预约考试情况
	@RequestMapping(value="/showExamOrdered")
	public String showExamOrdered(HttpSession session) {	
		String flag = (String) session.getAttribute("flag");
		DsmsTrainers trainer = (DsmsTrainers) session.getAttribute("trainerLogin");
		try {
			Map<DsmsTrainees, DsmsExamPlans> map = examService.findAllExamsOrdered(flag,trainer);
			session.setAttribute("allexamorders",map);
		} catch (CommonException e) {
			System.err.println(e.getMessage());
		}
		return "exams/exam_ordered";				
	}

	//根据条件查询已预约考试情况
	@RequestMapping(value = "/findExamOrderedByCon")
	public String findExamOrderedByCon(HttpSession session,@RequestParam String traineeNo,@RequestParam String name,@RequestParam String examType) {
		String flag = (String) session.getAttribute("flag");
		DsmsTrainers trainer = (DsmsTrainers) session.getAttribute("trainerLogin");
		try {
			Map<DsmsTrainees, DsmsExamPlans> map = examService.findAllExamsOrderedByCon(flag,trainer,traineeNo,name,examType);
			session.setAttribute("allexamorders", map);
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return "exams/exam_ordered";
	}

	//删除已预约考试情况
	@RequestMapping(value="/deleteExamOrdered/{orderId}")
	public String deleteExamOrdered(@PathVariable int orderId,HttpSession session) {
		try {
			examService.deleteExamsOrderedById(orderId);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "redirect:/exam/showExamOrdered";
	}

	//显示可预约学员列表
	@RequestMapping(value="/showExamOrderList")
	public String showExamOrderList(HttpSession session) {	
		try {
			List<DsmsTrainees> allTrainees = examService.findAllExamsOrderList();
			session.setAttribute("allTrainees", allTrainees);
			List<DsmsExamPlans> allExamPlans = examService.findAllExamsPlans();
			session.setAttribute("allExamPlans", allExamPlans);
			JSONArray allExamPlansJson = JSONArray.fromObject(allExamPlans);
			session.setAttribute("allExamPlansJson", allExamPlansJson);
		} catch (CommonException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "exams/exam_order_list";				
	}

	//显示学员预约界面
	@RequestMapping(value="/showExamOrderList/{traineeId}")
	public String showExamOrderList(@PathVariable int traineeId,HttpSession session) {
		try {
			Map<DsmsTrainees, DsmsTrainers> trainee = traineeService.findTraineeById(traineeId);
			session.setAttribute("trainee", trainee);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "exams/exam_order_detail";				
	}

	//预约考试
	@RequestMapping(value="/orderExam")
	public String orderExam(DsmsExamOrders examsOrder,HttpSession session) {
		try {
			examService.insertExamsOrdered(examsOrder);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/exam/showExamOrderList";				
	}

	//显示考试成绩
	@RequestMapping(value="/showExamResult")
	public String showExamResult(HttpSession session) {	
		try {
			Map<DsmsTrainees, DsmsExamResults> map = examService.findAllExamsResults();
			session.setAttribute("allexamresults",map);
			List<DsmsExamPlans> list = examService.findAllExamsPlans();
			session.setAttribute("allExamPlan", list);
		} catch (CommonException e) {
			System.err.println(e.getMessage());
		}
		return "exams/exam_result";				
	}

	//根据条件查询考试成绩
	@RequestMapping(value = "/findExamResultByCon")
	public String findExamResultByCon(HttpSession session, @RequestParam String traineeNo,@RequestParam String name,@RequestParam String examType) {
		try {
			Map<DsmsTrainees, DsmsExamResults> map = examService.findAllExamsResultsByCon(traineeNo,name,examType);
			session.setAttribute("allexamresults", map);
		} catch (CommonException e) {
			e.printStackTrace();
		}
		return "exams/exam_result";
	}

	//显示考试成绩新增界面
	@RequestMapping(value="/showExamResultAdd")
	public String showExamResultAdd(HttpSession session) {		
		try {
			Set<DsmsTrainees> allTrainees = traineeService.findAllTrainees().keySet();
			session.setAttribute("allTrainees", allTrainees);
			JSONArray allTraineesJson = JSONArray.fromObject(allTrainees);
			session.setAttribute("allTraineesJson", allTraineesJson);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "exams/exam_result_add";	
	}
	
	//新增考试成绩
	@RequestMapping(value="/addExamResult")
	public String addExamResult(DsmsExamResults examResult,HttpSession session) {
		try {
			examService.insertExamsResult(examResult);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}		
		return "redirect:/exam/showExamResult";
	}

	//显示考试成绩更新界面
	@RequestMapping(value="/showExamResultEdit/{resultId}")
	public String showExamResultEdit(@PathVariable Long resultId,HttpSession session) {
		try {
			DsmsExamResults examResult = examService.findExamsResultById(resultId);
			session.setAttribute("examResult",examResult);
			Set<DsmsTrainees> allTrainees = traineeService.findAllTrainees().keySet();
			session.setAttribute("allTrainees", allTrainees);
			JSONArray allTraineesJson = JSONArray.fromObject(allTrainees);
			session.setAttribute("allTraineesJson", allTraineesJson);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "exams/exam_result_edit";	
	}

	//更新考试成绩
	@RequestMapping(value="/updateExamResult")
	public String updateExamResult(DsmsExamResults examResult) {
		try {
			examService.updateExamsResult(examResult);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}		
		return "redirect:/exam/showExamPlan";
	}

	//删除考试成绩
	@RequestMapping(value="/deleteExamResult/{resultId}")
	public String deleteExamResult(@PathVariable int resultId,HttpSession session) {
		try {
			examService.deleteExamsResultById(resultId);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}			
		return "redirect:/exam/showExamResult";
	}
}