package com.test.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import com.test.common.exception.CommonException;
import com.test.service.interf.IAnalysisService;
import net.sf.json.JSONArray;

/*
 * 统计分析
 */
@Controller
@RequestMapping("/analysis")
public class AnalysisController {

    @Autowired
    private IAnalysisService analysisService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    //驾校收支情况
    @RequestMapping(value = "/showSchoolInOut")
    public String showScholInOut(HttpSession session) {
        try {
            //查询驾校收入
            long allTraineeIn = analysisService.findAllTraineeIn();
            long allElseIn = analysisService.findAllElseIn();
            long allIn = allTraineeIn + allElseIn;
            //查询驾校支出
            long allEmployeeFeeOut = analysisService.findAllEmployeeFeeOut();
            long allCarPrice = analysisService.findAllCarPrice();
            long allCarRepairOut = analysisService.findAllCarRepairOut();
            long allCarOilOut = analysisService.findAllCarOilOut();
            long allCarOut = allCarPrice + allCarRepairOut + allCarOilOut;
            long allElseOut = analysisService.findAllElseOut();
            long allOut = allEmployeeFeeOut + allCarOut + allElseOut;
            //设置条形图X轴Y轴
            String[] barName = {"总收入", "学员收入", "其它收入", "总支出", "员工工资", "车辆费用", "其它支出"};
            Long[] barValue = {allIn, allTraineeIn, allElseIn, allOut, allEmployeeFeeOut, allCarOut, allElseOut};
            JSONArray schoolInOutNameBar = JSONArray.fromObject(barName);
            JSONArray schoolInOutValueBar = JSONArray.fromObject(barValue);
            session.setAttribute("schoolInOutNameBar", schoolInOutNameBar);
            session.setAttribute("schoolInOutValueBar", schoolInOutValueBar);
            //设置折线图X轴Y轴
            String[] months = analysisService.findAllMonths(null, null);
            long[] monthOut = analysisService.findAllMonthSchoolOut();
            long[] monthIn = analysisService.findAllMonthSchoolIn();
            JSONArray schoolInOutNameLine = JSONArray.fromObject(months);
            JSONArray schoolOutValueLine = JSONArray.fromObject(monthOut);
            JSONArray schoolInValueLine = JSONArray.fromObject(monthIn);
            session.setAttribute("schoolInOutNameLine", schoolInOutNameLine);
            session.setAttribute("schoolOutValueLine", schoolOutValueLine);
            session.setAttribute("schoolInValueLine", schoolInValueLine);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "analysises/school_InOut";
    }

    //按条件查询驾校收支情况
    @RequestMapping(value = "/findSchoolInOutByCon")
    public String findSchoolInOutByCon(@RequestParam Date startDate, @RequestParam Date endDate, HttpSession session) {
        try {
            //按条件查询驾校收入
            long allTraineeIn = analysisService.findAllTraineeInByCon(startDate, endDate);
            long allElseIn = analysisService.findAllElseInByCon(startDate, endDate);
            long allIn = allTraineeIn + allElseIn;
            //按条件查询驾校支出
            long allEmployeeFeeOut = analysisService.findAllEmployeeFeeOutByCon(startDate, endDate);
            long allCarPrice = analysisService.findAllCarPriceByCon(startDate, endDate);
            long allCarRepairOut = analysisService.findAllCarRepairOutByCon(startDate, endDate);
            long allCarOilOut = analysisService.findAllCarOilOutByCon(startDate, endDate);
            long allCarOut = allCarPrice + allCarRepairOut + allCarOilOut;
            long allElseOut = analysisService.findAllElseOutByCon(startDate, endDate);
            long allOut = allEmployeeFeeOut + allCarOut + allElseOut;
            //设置条形图X轴Y轴
            String[] barName = {"总收入", "学员收入", "其它收入", "总支出", "员工工资", "车辆费用", "其它支出"};
            Long[] barValue = {allIn, allTraineeIn, allElseIn, allOut, allEmployeeFeeOut, allCarOut, allElseOut};
            JSONArray schoolInOutNameBar = JSONArray.fromObject(barName);
            JSONArray schoolInOutValueBar = JSONArray.fromObject(barValue);
            session.setAttribute("schoolInOutNameBar", schoolInOutNameBar);
            session.setAttribute("schoolInOutValueBar", schoolInOutValueBar);
            //设置折线图X轴Y轴
            String[] months = analysisService.findAllMonths(startDate, endDate);
            long[] monthOut = analysisService.findAllMonthSchoolOutByCon(startDate, endDate);
            long[] monthIn = analysisService.findAllMonthSchoolInByCon(startDate, endDate);
            JSONArray schoolInOutNameLine = JSONArray.fromObject(months);
            JSONArray schoolOutValueLine = JSONArray.fromObject(monthOut);
            JSONArray schoolInValueLine = JSONArray.fromObject(monthIn);
            session.setAttribute("schoolInOutNameLine", schoolInOutNameLine);
            session.setAttribute("schoolOutValueLine", schoolOutValueLine);
            session.setAttribute("schoolInValueLine", schoolInValueLine);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
        return "analysises/school_InOut";
    }

    //人员数量分析
    @RequestMapping(value = "/showPeopleNum")
    public String showPeopleNum(HttpSession session) {
        try {
            //查询驾校人员数量
            long allFinishTraineesNum = analysisService.findAllFinishTraineesNum();
            long allTraineesNum = analysisService.findAllTraineesNum();
            long allTrainersNum = analysisService.findAllTrainersNum();
            long allPeopleNum = allTraineesNum + allTrainersNum;
            //设置条形图X轴Y轴
            String[] barName = {"总人数", "总教练人数", "总学员人数", "已毕业学员"};
            Long[] barValue = {allPeopleNum, allTrainersNum, allTraineesNum, allFinishTraineesNum};
            JSONArray peopleNumNameBar = JSONArray.fromObject(barName);
            JSONArray peopleNumValueBar = JSONArray.fromObject(barValue);
            session.setAttribute("peopleNumNameBar", peopleNumNameBar);
            session.setAttribute("peopleNumValueBar", peopleNumValueBar);
            //设置折线图X轴Y轴
            String[] months = analysisService.findAllMonths(null, null);
            long[] trainerNum = analysisService.findAllMonthTrainersNum();
            long[] traineeNum = analysisService.findAllMonthTraineesNum();
            JSONArray peopleNumNameLine = JSONArray.fromObject(months);
            JSONArray trainerNumValueLine = JSONArray.fromObject(trainerNum);
            JSONArray traineeNumValueLine = JSONArray.fromObject(traineeNum);
            session.setAttribute("peopleNumNameLine", peopleNumNameLine);
            session.setAttribute("trainerNumValueLine", trainerNumValueLine);
            session.setAttribute("traineeNumValueLine", traineeNumValueLine);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
        return "analysises/people_Num";
    }

    //按条件查询人员数量
    @RequestMapping(value = "/findPeopleNumByCon")
    public String findPeopleNumByCon(@RequestParam Date startDate, @RequestParam Date endDate, HttpSession session) {
        try {
            long allFinishTraineesNum = analysisService.findAllFinishTraineesNumByCon(startDate, endDate);
            long allTraineesNum = analysisService.findAllTraineesNumByCon(startDate, endDate);
            long allTrainersNum = analysisService.findAllTrainersNumByCon(startDate, endDate);
            long allPeopleNum = allTraineesNum + allTrainersNum;
            //设置条形图X轴Y轴
            String[] barName = {"总人数", "总教练人数", "总学员人数", "已毕业学员"};
            Long[] barValue = {allPeopleNum, allTrainersNum, allTraineesNum, allFinishTraineesNum};
            JSONArray peopleNumNameBar = JSONArray.fromObject(barName);
            JSONArray peopleNumValueBar = JSONArray.fromObject(barValue);
            session.setAttribute("peopleNumNameBar", peopleNumNameBar);
            session.setAttribute("peopleNumValueBar", peopleNumValueBar);
            //设置折线图X轴Y轴
            String[] months = analysisService.findAllMonths(startDate, endDate);
            long[] trainerNum = analysisService.findAllMonthTrainersNumByCon(startDate, endDate);
            long[] traineeNum = analysisService.findAllMonthTraineesNumByCon(startDate, endDate);
            JSONArray peopleNumNameLine = JSONArray.fromObject(months);
            JSONArray trainerNumValueLine = JSONArray.fromObject(trainerNum);
            JSONArray traineeNumValueLine = JSONArray.fromObject(traineeNum);
            session.setAttribute("peopleNumNameLine", peopleNumNameLine);
            session.setAttribute("trainerNumValueLine", trainerNumValueLine);
            session.setAttribute("traineeNumValueLine", traineeNumValueLine);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
        return "analysises/people_Num";
    }

    //车辆数量分析
    @RequestMapping(value = "/showCarNum")
    public String showCarNum(HttpSession session) {
        try {
            long allB1CarNum = analysisService.findAllB1CarsNum();
            long allB2CarNum = analysisService.findAllB2CarsNum();
            long allC1CarNum = analysisService.findAllC1CarsNum();
            long allC2CarNum = analysisService.findAllC2CarsNum();
            long allCarNum = allB1CarNum + allB2CarNum + allC1CarNum + allC2CarNum;
            //设置条形图X轴Y轴
            String[] barName = {"总车辆数量", "B1数量", "B2数量", "C1数量", "C2数量"};
            Long[] barValue = {allCarNum, allB1CarNum, allB2CarNum, allC1CarNum, allC2CarNum};
            JSONArray carNumNameBar = JSONArray.fromObject(barName);
            JSONArray carNumValueBar = JSONArray.fromObject(barValue);
            session.setAttribute("carNumNameBar", carNumNameBar);
            session.setAttribute("carNumValueBar", carNumValueBar);
            //设置折线图X轴Y轴
            String[] months = analysisService.findAllMonths(null, null);
            long[] B1CarsNum = analysisService.findAllMonthB1CarsNum();
            long[] B2CarsNum = analysisService.findAllMonthB2CarsNum();
            long[] C1CarsNum = analysisService.findAllMonthC1CarsNum();
            long[] C2CarsNum = analysisService.findAllMonthC2CarsNum();
            JSONArray carNumNameLine = JSONArray.fromObject(months);
            JSONArray B1CarsNumValueLine = JSONArray.fromObject(B1CarsNum);
            JSONArray B2CarsNumValueLine = JSONArray.fromObject(B2CarsNum);
            JSONArray C1CarsNumValueLine = JSONArray.fromObject(C1CarsNum);
            JSONArray C2CarsNumValueLine = JSONArray.fromObject(C2CarsNum);
            session.setAttribute("carNumNameLine", carNumNameLine);
            session.setAttribute("B1CarsNumValueLine", B1CarsNumValueLine);
            session.setAttribute("B2CarsNumValueLine", B2CarsNumValueLine);
            session.setAttribute("C1CarsNumValueLine", C1CarsNumValueLine);
            session.setAttribute("C2CarsNumValueLine", C2CarsNumValueLine);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
        return "analysises/car_Num";
    }

    //按条件查询车辆数量
    @RequestMapping(value = "/findCarNumByCon")
    public String findCarNumByCon(@RequestParam Date startDate, @RequestParam Date endDate, HttpSession session) {
        try {
            long allB1CarNum = analysisService.findAllB1CarsNumByCon(startDate, endDate);
            long allB2CarNum = analysisService.findAllB2CarsNumByCon(startDate, endDate);
            long allC1CarNum = analysisService.findAllC1CarsNumByCon(startDate, endDate);
            long allC2CarNum = analysisService.findAllC2CarsNumByCon(startDate, endDate);
            long allCarNum = allB1CarNum + allB2CarNum + allC1CarNum + allC2CarNum;
            //设置条形图X轴Y轴
            String[] barName = {"总车辆数量", "B1数量", "B2数量", "C1数量", "B2数量"};
            Long[] barValue = {allCarNum, allB1CarNum, allB2CarNum, allC1CarNum, allC2CarNum};
            JSONArray carNumNameBar = JSONArray.fromObject(barName);
            JSONArray carNumValueBar = JSONArray.fromObject(barValue);
            session.setAttribute("carNumNameBar", carNumNameBar);
            session.setAttribute("carNumValueBar", carNumValueBar);
            //设置折线图X轴Y轴
            String[] months = analysisService.findAllMonths(startDate, endDate);
            long[] B1CarsNum = analysisService.findAllMonthB1CarsNumByCon(startDate, endDate);
            long[] B2CarsNum = analysisService.findAllMonthB2CarsNumByCon(startDate, endDate);
            long[] C1CarsNum = analysisService.findAllMonthC1CarsNumByCon(startDate, endDate);
            long[] C2CarsNum = analysisService.findAllMonthC2CarsNumByCon(startDate, endDate);
            JSONArray carNumNameLine = JSONArray.fromObject(months);
            JSONArray B1CarsNumValueLine = JSONArray.fromObject(B1CarsNum);
            JSONArray B2CarsNumValueLine = JSONArray.fromObject(B2CarsNum);
            JSONArray C1CarsNumValueLine = JSONArray.fromObject(C1CarsNum);
            JSONArray C2CarsNumValueLine = JSONArray.fromObject(C2CarsNum);
            session.setAttribute("carNumNameLine", carNumNameLine);
            session.setAttribute("B1CarNumValueLine", B1CarsNumValueLine);
            session.setAttribute("B2CarsNumValueLine", B2CarsNumValueLine);
            session.setAttribute("C1CarsNumValueLine", C1CarsNumValueLine);
            session.setAttribute("C2CarsNumValueLine", C2CarsNumValueLine);
        } catch (CommonException e) {
            // TODO Auto-generated catch block
            System.err.println(e.getMessage());
        }
        return "analysises/car_Num";
    }
}