package com.test.service.impl;

import com.test.bean.*;
import com.test.common.exception.CommonException;
import com.test.feign.CarService;
import com.test.feign.TraineeService;
import com.test.feign.TrainerService;
import com.test.mapper.DsmsFinancesMapper;
import com.test.service.interf.IAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AnalysisImpl implements IAnalysisService{

	@Autowired
	private DsmsFinancesMapper financesMapper;

	@Autowired
	private TrainerService trainersMapper;

	@Autowired
	private TraineeService traineesMapper;

	@Autowired
	private CarService carsMapper;


	public long findAllElseOut() throws CommonException {
		// TODO Auto-generated method stub
		DsmsFinancesExample example=new DsmsFinancesExample();
		int sum = 0;
		example.createCriteria().andFlagEqualTo("out");
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemFee() != null) {
				sum+=list.get(i).getItemFee();
			}
		}
		return sum;
	}

	public long findAllElseOutByCon(Date startDate,Date endDate) throws CommonException{
		// TODO Auto-generated method stub
		if (startDate==null&&endDate==null) {
			return findAllElseOut();
		}
		DsmsFinancesExample example=new DsmsFinancesExample();
		int sum = 0;
		example.createCriteria().andFlagEqualTo("out").andFeeDateBetween(startDate, endDate);
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemFee() != null) {
				sum+=list.get(i).getItemFee();
			}
		}
		return sum;
	}

	public long findAllEmployeeFeeOut() throws CommonException {
		// TODO Auto-generated method stub
		DsmsTrainersExample example=new DsmsTrainersExample();
		int sum = 0;
		List<DsmsTrainers> list = trainersMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSalary() != null) {
				sum+=list.get(i).getSalary();
			}
		}
		return sum;
	}

	public long findAllEmployeeFeeOutByCon(Date startDate,Date endDate) throws CommonException{
		// TODO Auto-generated method stub
		if (startDate==null&&endDate==null) {
			return findAllEmployeeFeeOut();
		}
		DsmsTrainersExample example=new DsmsTrainersExample();
		int sum = 0;
		List<DsmsTrainers> list = trainersMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getJoinDate().before(endDate) && list.get(i).getSalary() != null) {
				sum += list.get(i).getSalary();
			}
		}
		return sum;
	}

	public String[] findAllMonths(Date startDate,Date endDate) throws CommonException{
		Calendar cale = Calendar.getInstance(); 
		String[] months = null;
		//筛选条件为空时显示本年1月至本月
		if (startDate == null || endDate == null) {
			months=new String[cale.get(Calendar.MONTH)+1];
			for (int i = 0; i < months.length; i++) {
				months[i] = cale.get(Calendar.YEAR)+"-"+(i+1);
			}			
		}else {	        
			ArrayList<String> result = new ArrayList<String>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.setTime(startDate);
			end.setTime(endDate);
			int mNum = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
			int num = mNum*12+end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
			//时间相差12个月以上只显示年份,且只显示近10年的情况
			if (Math.abs(num) > 12) {
				if (mNum <= 10) {					
					int j = 1;
					months = new String[mNum+1];
					for (int i = 0; i < months.length; i++) {
						if (i == 0) {
							months[i] = sdf.format(startDate);
						}else if (i == months.length-1) {
							months[i] = sdf.format(endDate);
						}else {
							months[i] = start.get(Calendar.YEAR)+j+"";
							j++;
						}
					}
				}else {
					int j = 1;
					months=new String[10];
					for (int i = months.length-1; i >= 0; i--) {
						if (i == 0) {
							months[i] = cale.get(Calendar.YEAR)-10+"-01";
						}else if (i == months.length-1) {
							months[i] = sdf.format(cale.getTime());
						}else {
							months[i] = cale.get(Calendar.YEAR)-j+"";
							j++;
						}
					}
				}
			}else {
				//相差12个月以下显示年份月份
				start.set(start.get(Calendar.YEAR), start.get(Calendar.MONTH), 1);
				end.set(end.get(Calendar.YEAR), end.get(Calendar.MONTH), 2);
				Calendar curr = start;
				while (curr.before(end)) {
					result.add(sdf.format(curr.getTime()));
					curr.add(Calendar.MONTH, 1);
				}
				months=new String[result.size()];
				for (int i = 0; i < result.size(); i++) {
					if (i == 0) {
						months[i] = sdf.format(startDate);
					}else if (i == result.size()-1) {
						months[i] = sdf.format(endDate);
					}else {
						months[i] = result.get(i);
					}
				}
			}
		}
		return months;		
	}

	public long[] findAllMonthSchoolOut() throws CommonException{
		String[] months = findAllMonths(null,null);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar sys = Calendar.getInstance(); 
		Calendar cale = Calendar.getInstance(); 
		long[] out=new long[months.length];
		for (int i = 0; i < months.length; i++) {
			cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
			cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
			try {
				Date startDate = sdf.parse(sys.get(Calendar.YEAR)+"-1-1");
				Date endDate = null;
				if (i == months.length-1) {
					endDate = Calendar.getInstance().getTime();
				}else {
					endDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
				}
				out[i]=findAllEmployeeFeeOutByCon(startDate,endDate)
						+findAllCarPriceByCon(startDate,endDate)
						+findAllCarRepairOutByCon(startDate,endDate)
						+findAllCarOilOutByCon(startDate,endDate)
						+findAllElseOutByCon(startDate, endDate);
				System.err.println(findAllEmployeeFeeOutByCon(startDate,endDate)
						+" "+findAllCarPriceByCon(startDate,endDate)
						+" "+findAllCarRepairOutByCon(startDate,endDate)
						+" "+findAllCarOilOutByCon(startDate,endDate)
						+" "+findAllElseOutByCon(startDate, endDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return out;
	}

	public long[] findAllMonthSchoolOutByCon(Date startDate,Date endDate) throws CommonException{
		if (startDate == null || endDate == null) {
			return findAllMonthSchoolOut();
		}
		String[] months = findAllMonths(startDate,endDate);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long[] out= new long[months.length];
		Calendar cale = Calendar.getInstance(); 
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		int mNum = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int num = mNum*12+end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
		Date sDate = null;
		Date eDate = null;
		for (int i = 0; i < out.length; i++) {	
			try {
				if (i == 0) {
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH,12);
						sDate = startDate;
						eDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}else if (i == out.length-1) {
					if (Math.abs(num) > 12) {
						sDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-1-1");
						eDate = endDate;
					}else {
						sDate = sdf.parse(months[i]+"-1");
						eDate = endDate;
					}
				}else {					
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i]));
						cale.set(Calendar.MONTH,12);
						sDate = sdf.parse(months[i]+"-1-1");
						eDate = sdf.parse(months[i]+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}
				out[i] = findAllEmployeeFeeOutByCon(sDate,eDate)
						+findAllCarPriceByCon(sDate,eDate)
						+findAllCarRepairOutByCon(sDate,eDate)
						+findAllCarOilOutByCon(sDate,eDate)
						+findAllElseOutByCon(sDate,eDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return out;
	}

	public long findAllCarPrice() throws CommonException{
		DsmsCarsExample example=new DsmsCarsExample();
		int sum = 0;
		List<DsmsCars> list = carsMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPrice() != null) {
				sum+=list.get(i).getPrice();
			}
		}
		return sum;
	}

	public long findAllCarPriceByCon(Date startDate,Date endDate) throws CommonException{
		if (startDate==null&&endDate==null) {
			return findAllCarPrice();
		}
		DsmsCarsExample example=new DsmsCarsExample();
		int sum = 0;
		example.createCriteria().andBuyDateBetween(startDate, endDate);
		List<DsmsCars> list = carsMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPrice() != null) {
				sum+=list.get(i).getPrice();
			}
		}
		return sum;
	}

	public long findAllCarRepairOut() throws CommonException {
		// TODO Auto-generated method stub
		DsmsFinancesExample example=new DsmsFinancesExample();
		int sum = 0;
		example.createCriteria().andFlagEqualTo("car").andItemTypeEqualTo("repairFee");
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemFee() != null) {
				sum+=list.get(i).getItemFee();
			}
		}
		return sum;
	}

	public long findAllCarRepairOutByCon(Date startDate,Date endDate) throws CommonException{
		// TODO Auto-generated method stub
		if (startDate==null&&endDate==null) {
			return findAllCarRepairOut();
		}
		DsmsFinancesExample example=new DsmsFinancesExample();
		int sum = 0;
		example.createCriteria().andFlagEqualTo("car").andItemTypeEqualTo("repairFee").andFeeDateBetween(startDate, endDate);
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemFee() != null) {
				sum+=list.get(i).getItemFee();
			}
		}
		return sum;
	}

	public long findAllCarOilOut() throws CommonException {
		// TODO Auto-generated method stub
		DsmsFinancesExample example=new DsmsFinancesExample();
		int sum = 0;
		example.createCriteria().andFlagEqualTo("car").andItemTypeEqualTo("oilFee");
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemFee() != null) {
				sum+=list.get(i).getItemFee();
			}
		}
		return sum;
	}

	public long findAllCarOilOutByCon(Date startDate,Date endDate) throws CommonException{
		// TODO Auto-generated method stub
		if (startDate==null&&endDate==null) {
			return findAllCarOilOut();
		}
		DsmsFinancesExample example=new DsmsFinancesExample();
		int sum = 0;
		example.createCriteria().andFlagEqualTo("car").andItemTypeEqualTo("oilFee").andFeeDateBetween(startDate, endDate);
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemFee() != null) {
				sum+=list.get(i).getItemFee();
			}
		}
		return sum;
	}

	public long findAllElseIn() throws CommonException {
		// TODO Auto-generated method stub
		DsmsFinancesExample example=new DsmsFinancesExample();
		int sum = 0;
		example.createCriteria().andFlagEqualTo("in");
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemFee() != null) {
				sum+=list.get(i).getItemFee();
			}
		}
		return sum;
	}

	public long findAllElseInByCon(Date startDate,Date endDate) throws CommonException{
		// TODO Auto-generated method stub
		if (startDate==null&&endDate==null) {
			return findAllElseIn();
		}
		DsmsFinancesExample example=new DsmsFinancesExample();
		int sum = 0;
		example.createCriteria().andFlagEqualTo("in").andFeeDateBetween(startDate, endDate);
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemFee() != null) {
				sum+=list.get(i).getItemFee();
			}
		}
		return sum;
	}

	public long findAllTraineeIn() throws CommonException {
		// TODO Auto-generated method stub
		DsmsFinancesExample example=new DsmsFinancesExample();
		int sum = 0;
		example.createCriteria().andFlagEqualTo("trainee");
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemFee() != null) {
				sum+=list.get(i).getItemFee();
			}
		}
		return sum;
	}

	public long findAllTraineeInByCon(Date startDate,Date endDate) throws CommonException{
		// TODO Auto-generated method stub
		if (startDate==null&&endDate==null) {
			return findAllTraineeIn();
		}
		DsmsFinancesExample example=new DsmsFinancesExample();
		int sum = 0;
		example.createCriteria().andFlagEqualTo("trainee").andFeeDateBetween(startDate, endDate);
		List<DsmsFinances> list = financesMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getItemFee() != null) {
				sum+=list.get(i).getItemFee();
			}
		}
		return sum;
	}

	public long[] findAllMonthSchoolIn() throws CommonException{
		String[] months = findAllMonths(null,null);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar sys = Calendar.getInstance(); 
		Calendar cale = Calendar.getInstance(); 
		long[] in=new long[ months.length];
		for (int i = 0; i < months.length; i++) {
			cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
			cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
			try {
				Date startDate = sdf.parse(sys.get(Calendar.YEAR)+"-1-1");
				Date endDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
				in[i]=findAllTraineeInByCon(startDate,endDate)
						+findAllElseInByCon(startDate,endDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return in;
	}

	public long[] findAllMonthSchoolInByCon(Date startDate,Date endDate) throws CommonException{
		if (startDate == null || endDate == null) {
			return findAllMonthSchoolIn();
		}
		String[] months = findAllMonths(startDate,endDate);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long[] in=new long[months.length];
		Calendar cale = Calendar.getInstance(); 
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		int mNum = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int num = mNum*12+end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
		Date sDate = null;
		Date eDate = null;
		for (int i = 0; i < in.length; i++) {	
			try {
				if (i == 0) {
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH,12);
						sDate = startDate;
						eDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}else if (i == in.length-1) {
					if (Math.abs(num) > 12) {
						sDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-1-1");
						eDate = endDate;
					}else {
						sDate = sdf.parse(months[i]+"-1");
						eDate = endDate;
					}
				}else {							
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i]));
						cale.set(Calendar.MONTH,12);
						sDate = sdf.parse(months[i]+"-1-1");
						eDate = sdf.parse(months[i]+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}
				in[i] = findAllTraineeInByCon(sDate,eDate)
						+findAllElseInByCon(sDate,eDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return in;
	}

	public long findAllFinishTraineesNum() throws CommonException{
		// TODO Auto-generated method stub
		DsmsTraineesExample example=new DsmsTraineesExample();
		example.createCriteria().andStatusEqualTo("finish");
		long i = traineesMapper.countByExample(example);
		return i;
	}

	public long findAllFinishTraineesNumByCon(Date startDate,Date endDate) throws CommonException{
		// TODO Auto-generated method stub
		if (startDate==null&&endDate==null) {
			return findAllFinishTraineesNum();
		}
		DsmsTraineesExample example=new DsmsTraineesExample();
		example.createCriteria().andStatusEqualTo("finish").andEnterDateBetween(startDate, endDate);
		long i = traineesMapper.countByExample(example);
		return i;
	}
	
	public long findAllTraineesNum() throws CommonException{
		// TODO Auto-generated method stub
		DsmsTraineesExample example=new DsmsTraineesExample();
		long i = traineesMapper.countByExample(example);
		return i;
	}

	public long findAllTraineesNumByCon(Date startDate,Date endDate) throws CommonException{
		// TODO Auto-generated method stub
		if (startDate==null&&endDate==null) {
			return findAllTraineesNum();
		}
		DsmsTraineesExample example=new DsmsTraineesExample();
		example.createCriteria().andEnterDateBetween(startDate, endDate);
		long i = traineesMapper.countByExample(example);
		return i;
	}

	public long[] findAllMonthTraineesNum() throws CommonException{
		String[] months = findAllMonths(null,null);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar sys = Calendar.getInstance(); 
		Calendar cale = Calendar.getInstance(); 
		long[] traineeNum=new long[ months.length];
		for (int i = 0; i < months.length; i++) {
			cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
			cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
			try {
				Date startDate = sdf.parse(sys.get(Calendar.YEAR)+"-1-1");
				Date endDate = null;
				if (i == months.length-1) {
					endDate = Calendar.getInstance().getTime();
				}else {
					endDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
				}
				traineeNum[i]=findAllTraineesNumByCon(startDate,endDate);
				System.err.println("traineeNum"+findAllTraineesNumByCon(startDate,endDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return traineeNum;		
	}

	public long[] findAllMonthTraineesNumByCon(Date startDate,Date endDate) throws CommonException{
		if (startDate == null || endDate == null) {
			return findAllMonthSchoolIn();
		}
		String[] months = findAllMonths(startDate,endDate);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long[] traineeNum=new long[months.length];
		Calendar cale = Calendar.getInstance(); 
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		int mNum = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int num = mNum*12+end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
		Date sDate = null;
		Date eDate = null;
		for (int i = 0; i < traineeNum.length; i++) {	
			try {
				if (i == 0) {
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH,12);
						sDate = startDate;
						eDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}else if (i == traineeNum.length-1) {
					if (Math.abs(num) > 12) {
						sDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-1-1");
						eDate = endDate;
					}else {
						sDate = sdf.parse(months[i]+"-1");
						eDate = endDate;
					}
				}else {							
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i]));
						cale.set(Calendar.MONTH,12);
						sDate = sdf.parse(months[i]+"-1-1");
						eDate = sdf.parse(months[i]+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}
				traineeNum[i]=findAllTraineesNumByCon(sDate,eDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return traineeNum;
	}

	public long[] findAllMonthTrainersNum() throws CommonException{
		String[] months = findAllMonths(null,null);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar sys = Calendar.getInstance();
		Calendar cale = Calendar.getInstance(); 
		long[] trainerNum=new long[ months.length];
		for (int i = 0; i < months.length; i++) {
			cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
			cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
			try {
				Date startDate = sdf.parse(sys.get(Calendar.YEAR)+"-1-1");
				Date endDate = null;
				if (i == months.length-1) {
					endDate = Calendar.getInstance().getTime();
				}else {
					endDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
				}
				trainerNum[i]=findAllTrainersNumByCon(startDate,endDate);
				System.err.println("trainerNum"+findAllTrainersNumByCon(startDate,endDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return trainerNum;		
	}

	public long[] findAllMonthTrainersNumByCon(Date startDate,Date endDate) throws CommonException{
		if (startDate == null || endDate == null) {
			return findAllMonthSchoolIn();
		}
		String[] months = findAllMonths(startDate,endDate);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long[] trainerNum=new long[months.length];
		Calendar cale = Calendar.getInstance(); 
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		int mNum = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int num = mNum*12+end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
		Date sDate = null;
		Date eDate = null;
		for (int i = 0; i < trainerNum.length; i++) {	
			try {
				if (i == 0) {
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH,12);
						sDate = startDate;
						eDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}else if (i == trainerNum.length-1) {
					if (Math.abs(num) > 12) {
						sDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-1-1");
						eDate = endDate;
					}else {
						sDate = sdf.parse(months[i]+"-1");
						eDate = endDate;
					}
				}else {							
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i]));
						cale.set(Calendar.MONTH,12);
						sDate = sdf.parse(months[i]+"-1-1");
						eDate = sdf.parse(months[i]+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}
				trainerNum[i]=findAllTrainersNumByCon(sDate,eDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return trainerNum;
	}
	
	public long findAllTrainersNum() throws CommonException {
		// TODO Auto-generated method stub
		DsmsTrainersExample example=new DsmsTrainersExample();
		long i = trainersMapper.countByExample(example);
		return i;
	}

	public long findAllTrainersNumByCon(Date startDate,Date endDate) throws CommonException{
		// TODO Auto-generated method stub
		if (startDate==null&&endDate==null) {
			return findAllTrainersNum();
		}
		DsmsTrainersExample example=new DsmsTrainersExample();
		example.createCriteria().andJoinDateBetween(startDate, endDate);
		long i = trainersMapper.countByExample(example);
		return i;
	}

	public long findAllB1CarsNum() throws CommonException {
		// TODO Auto-generated method stub
		DsmsCarsExample example=new DsmsCarsExample();
		example.createCriteria().andCarTypeEqualTo("B1");
		long i = carsMapper.countByExample(example);
		return i;
	}

	public long findAllB1CarsNumByCon(Date startDate,Date endDate) throws CommonException {
		// TODO Auto-generated method stub
		if (startDate==null&&endDate==null) {
			return findAllB1CarsNum();
		}
		DsmsCarsExample example=new DsmsCarsExample();
		example.createCriteria().andCarTypeEqualTo("B1").andBuyDateBetween(startDate, endDate);
		long i = carsMapper.countByExample(example);
		return i;
	}

	public long[] findAllMonthB1CarsNum() throws CommonException{
		String[] months = findAllMonths(null,null);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = Calendar.getInstance(); 
		long[] B1CarsNum=new long[ months.length];
		for (int i = 0; i < months.length; i++) {
			cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
			cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
			try {
				Date startDate = sdf.parse(months[i]+"-1");
				Date endDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
				B1CarsNum[i]=findAllB1CarsNumByCon(startDate,endDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return B1CarsNum;		
	}

	public long[] findAllMonthB1CarsNumByCon(Date startDate,Date endDate) throws CommonException{
		if (startDate == null || endDate == null) {
			return findAllMonthSchoolIn();
		}
		String[] months = findAllMonths(startDate,endDate);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long[] B1CarsNum=new long[months.length];
		Calendar cale = Calendar.getInstance(); 
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		int mNum = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int num = mNum*12+end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
		Date sDate = null;
		Date eDate = null;
		for (int i = 0; i < B1CarsNum.length; i++) {	
			try {
				if (i == 0) {
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH,12);
						sDate = startDate;
						eDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}else if (i == B1CarsNum.length-1) {
					if (Math.abs(num) > 12) {
						sDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-1-1");
						eDate = endDate;
					}else {
						sDate = sdf.parse(months[i]+"-1");
						eDate = endDate;
					}
				}else {							
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i]));
						cale.set(Calendar.MONTH,12);
						sDate = sdf.parse(months[i]+"-1-1");
						eDate = sdf.parse(months[i]+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}
				B1CarsNum[i]=findAllC1CarsNumByCon(sDate, eDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return B1CarsNum;
	}
	
	public long findAllB2CarsNum() throws CommonException {
		// TODO Auto-generated method stub
		DsmsCarsExample example=new DsmsCarsExample();
		example.createCriteria().andCarTypeEqualTo("B2");
		long i = carsMapper.countByExample(example);
		return i;
	}

	public long findAllB2CarsNumByCon(Date startDate,Date endDate) throws CommonException {
		// TODO Auto-generated method stub
		if (startDate==null&&endDate==null) {
			return findAllB2CarsNum();
		}
		DsmsCarsExample example=new DsmsCarsExample();
		example.createCriteria().andCarTypeEqualTo("B2").andBuyDateBetween(startDate, endDate);
		long i = carsMapper.countByExample(example);
		return i;
	}

	public long[] findAllMonthB2CarsNum() throws CommonException{
		String[] months = findAllMonths(null,null);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = Calendar.getInstance(); 
		long[] B2CarsNum=new long[ months.length];
		for (int i = 0; i < months.length; i++) {
			cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
			cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
			try {
				Date startDate = sdf.parse(months[i]+"-1");
				Date endDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
				B2CarsNum[i]=findAllB2CarsNumByCon(startDate,endDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return B2CarsNum;		
	}

	public long[] findAllMonthB2CarsNumByCon(Date startDate,Date endDate) throws CommonException{
		if (startDate == null || endDate == null) {
			return findAllMonthSchoolIn();
		}
		String[] months = findAllMonths(startDate,endDate);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long[] B2CarsNum=new long[months.length];
		Calendar cale = Calendar.getInstance(); 
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		int mNum = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int num = mNum*12+end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
		Date sDate = null;
		Date eDate = null;
		for (int i = 0; i < B2CarsNum.length; i++) {	
			try {
				if (i == 0) {
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH,12);
						sDate = startDate;
						eDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}else if (i == B2CarsNum.length-1) {
					if (Math.abs(num) > 12) {
						sDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-1-1");
						eDate = endDate;
					}else {
						sDate = sdf.parse(months[i]+"-1");
						eDate = endDate;
					}
				}else {							
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i]));
						cale.set(Calendar.MONTH,12);
						sDate = sdf.parse(months[i]+"-1-1");
						eDate = sdf.parse(months[i]+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}
				B2CarsNum[i]=findAllC1CarsNumByCon(sDate, eDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return B2CarsNum;
	}
	
	public long findAllC1CarsNum() throws CommonException {
		// TODO Auto-generated method stub
		DsmsCarsExample example=new DsmsCarsExample();
		example.createCriteria().andCarTypeEqualTo("C1");
		long i = carsMapper.countByExample(example);
		return i;
	}

	public long findAllC1CarsNumByCon(Date startDate,Date endDate) throws CommonException {
		// TODO Auto-generated method stub
		if (startDate==null&&endDate==null) {
			return findAllC1CarsNum();
		}
		DsmsCarsExample example=new DsmsCarsExample();
		example.createCriteria().andCarTypeEqualTo("C1").andBuyDateBetween(startDate, endDate);
		long i = carsMapper.countByExample(example);
		return i;
	}
	
	public long[] findAllMonthC1CarsNum() throws CommonException{
		String[] months = findAllMonths(null,null);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = Calendar.getInstance(); 
		long[] C1CarsNum=new long[ months.length];
		for (int i = 0; i < months.length; i++) {
			cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
			cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
			try {
				Date startDate = sdf.parse(months[i]+"-1");
				Date endDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
				C1CarsNum[i]=findAllC1CarsNumByCon(startDate,endDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return C1CarsNum;		
	}

	public long[] findAllMonthC1CarsNumByCon(Date startDate,Date endDate) throws CommonException{
		if (startDate == null || endDate == null) {
			return findAllMonthSchoolIn();
		}
		String[] months = findAllMonths(startDate,endDate);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long[] C1CarsNum=new long[months.length];
		Calendar cale = Calendar.getInstance(); 
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		int mNum = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int num = mNum*12+end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
		Date sDate = null;
		Date eDate = null;
		for (int i = 0; i < C1CarsNum.length; i++) {	
			try {
				if (i == 0) {
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH,12);
						sDate = startDate;
						eDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}else if (i == C1CarsNum.length-1) {
					if (Math.abs(num) > 12) {
						sDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-1-1");
						eDate = endDate;
					}else {
						sDate = sdf.parse(months[i]+"-1");
						eDate = endDate;
					}
				}else {							
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i]));
						cale.set(Calendar.MONTH,12);
						sDate = sdf.parse(months[i]+"-1-1");
						eDate = sdf.parse(months[i]+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}
				C1CarsNum[i]=findAllC1CarsNumByCon(sDate, eDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return C1CarsNum;
	}

	public long findAllC2CarsNum() throws CommonException {
		// TODO Auto-generated method stub
		DsmsCarsExample example=new DsmsCarsExample();
		example.createCriteria().andCarTypeEqualTo("C2");
		long i = carsMapper.countByExample(example);
		return i;
	}

	public long findAllC2CarsNumByCon(Date startDate,Date endDate) throws CommonException {
		// TODO Auto-generated method stub
		if (startDate == null && endDate == null) {
			return findAllC2CarsNum();
		}
		DsmsCarsExample example=new DsmsCarsExample();
		example.createCriteria().andCarTypeEqualTo("C2").andBuyDateBetween(startDate, endDate);
		long i = carsMapper.countByExample(example);
		return i;
	}
	
	public long[] findAllMonthC2CarsNum() throws CommonException{
		String[] months = findAllMonths(null,null);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = Calendar.getInstance(); 
		long[] C2CarsNum=new long[ months.length];
		for (int i = 0; i < months.length; i++) {
			cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
			cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
			try {
				Date startDate = sdf.parse(months[i]+"-1");
				Date endDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
				C2CarsNum[i]=findAllC2CarsNumByCon(startDate,endDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return C2CarsNum;		
	}

	public long[] findAllMonthC2CarsNumByCon(Date startDate,Date endDate) throws CommonException{
		if (startDate == null || endDate == null) {
			return findAllMonthSchoolIn();
		}
		String[] months = findAllMonths(startDate,endDate);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long[] C2CarsNum=new long[months.length];
		Calendar cale = Calendar.getInstance(); 
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		int mNum = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
		int num = mNum*12+end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
		Date sDate = null;
		Date eDate = null;
		for (int i = 0; i < C2CarsNum.length; i++) {	
			try {
				if (i == 0) {
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH,12);
						sDate = startDate;
						eDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}else if (i == C2CarsNum.length-1) {
					if (Math.abs(num) > 12) {
						sDate = sdf.parse(Integer.parseInt(months[i].split("-")[0])+"-1-1");
						eDate = endDate;
					}else {
						sDate = sdf.parse(months[i]+"-1");
						eDate = endDate;
					}
				}else {							
					if (Math.abs(num) > 12) {
						cale.set(Calendar.YEAR,Integer.parseInt(months[i]));
						cale.set(Calendar.MONTH,12);
						sDate = sdf.parse(months[i]+"-1-1");
						eDate = sdf.parse(months[i]+"-12-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}else {						
						cale.set(Calendar.YEAR,Integer.parseInt(months[i].split("-")[0]));
						cale.set(Calendar.MONTH, Integer.parseInt(months[i].split("-")[1])-1);
						sDate = sdf.parse(months[i]+"-1");
						eDate = sdf.parse(months[i]+"-"+cale.getActualMaximum(Calendar.DAY_OF_MONTH));
					}
				}
				C2CarsNum[i]=findAllC2CarsNumByCon(sDate, eDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return C2CarsNum;
	}
}
