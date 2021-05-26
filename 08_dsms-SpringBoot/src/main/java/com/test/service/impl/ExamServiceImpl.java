package com.test.service.impl;

import com.test.bean.*;
import com.test.bean.DsmsExamPlansExample.Criteria;
import com.test.common.exception.CommonException;
import com.test.mapper.DsmsExamOrdersMapper;
import com.test.mapper.DsmsExamPlansMapper;
import com.test.mapper.DsmsExamResultsMapper;
import com.test.mapper.DsmsTraineesMapper;
import com.test.service.interf.IExamService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Transactional
public class ExamServiceImpl implements IExamService{

	@Autowired
	private DsmsExamPlansMapper examsPlanMapper;

	@Autowired
	private DsmsExamOrdersMapper examsOrderMapper;

	@Autowired
	private DsmsExamResultsMapper examsResultMapper;

	@Autowired
	private DsmsTraineesMapper traineesMapper;

	public List<DsmsExamPlans> findAllExamsPlans() throws CommonException {
		DsmsExamPlansExample example = new DsmsExamPlansExample();
		List<DsmsExamPlans> list = examsPlanMapper.selectByExample(example);	
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPlanNo() == null) {
				list.get(i).setPlanNo("P"+list.get(i).getId());
				updateExamsPlan(list.get(i));
			}
		}
		return list;
	}

	public List<DsmsExamPlans> findAllExamsPlansByCon(DsmsExamPlans examsPlan)
			throws CommonException {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(examsPlan.getExamType())&&StringUtils.isBlank(examsPlan.getCarType())&&StringUtils.isBlank(examsPlan.getStatus())) {
			return findAllExamsPlans();
		}
		DsmsExamPlansExample example = new DsmsExamPlansExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(examsPlan.getExamType())) {
			criteria.andExamTypeEqualTo(examsPlan.getExamType());
		}
		if (StringUtils.isNotBlank(examsPlan.getCarType())) {
			criteria.andCarTypeLike("%"+examsPlan.getCarType()+"%");
		}
		if (StringUtils.isNotBlank(examsPlan.getStatus())) {
			criteria.andStatusEqualTo(examsPlan.getStatus());
		}
		List<DsmsExamPlans> list = examsPlanMapper.selectByExample(example);
		return list;
	}

	public DsmsExamPlans findExamsPlanById(long id) throws CommonException {
		return examsPlanMapper.selectByPrimaryKey(id);
	}

	public DsmsExamPlans findExamsPlanByExamType(String examsType) throws CommonException {
		DsmsExamPlansExample examsPlanExample = new DsmsExamPlansExample();		
		examsPlanExample.createCriteria().andExamTypeEqualTo(examsType);
		return examsPlanMapper.selectByExample(examsPlanExample).get(0);
	}

	public DsmsExamPlans findExamsPlanByExamPlace(String place) throws CommonException {
		DsmsExamPlansExample examsPlanExample = new DsmsExamPlansExample();		
		examsPlanExample.createCriteria().andPlaceEqualTo(place);
		return examsPlanMapper.selectByExample(examsPlanExample).get(0);
	}

	public DsmsExamPlans findExamsPlanByCarType(String carsType) throws CommonException {
		DsmsExamPlansExample examsPlanExample = new DsmsExamPlansExample();		
		examsPlanExample.createCriteria().andCarTypeEqualTo(carsType);
		return examsPlanMapper.selectByExample(examsPlanExample).get(0);
	}

	public void updateExamsPlan(DsmsExamPlans examsPlan) throws CommonException {
		examsPlanMapper.updateByPrimaryKeySelective(examsPlan);
	}

	public void deleteExamsPlanById(long id) throws CommonException {
		examsPlanMapper.deleteByPrimaryKey(id);

	}

	public void insertExamsPlan(DsmsExamPlans examsPlan) throws CommonException {
		examsPlanMapper.insertSelective(examsPlan);
	}

	public Map<DsmsTrainees, DsmsExamPlans> findAllExamsOrdered(String flag,DsmsTrainers trainer) throws CommonException {
		TreeMap<DsmsTrainees, DsmsExamPlans> map=new TreeMap<DsmsTrainees, DsmsExamPlans>(new Comparator<DsmsTrainees>() {
			public int compare(DsmsTrainees o1, DsmsTrainees o2) {
				// TODO Auto-generated method stub				
				int i = o1.getId().compareTo(o2.getId());
				return -i;
			}
		});
		DsmsExamOrdersExample examsOrderExample = new DsmsExamOrdersExample();
		List<DsmsExamOrders> list = examsOrderMapper.selectByExample(examsOrderExample);
		for (int i = 0; i < list.size(); i++) {			
			DsmsTrainees trainee = traineesMapper.selectByPrimaryKey(list.get(i).getTraineeId());
			if (trainee != null) {	
				if (flag.equals("admin")) {						
					DsmsExamPlans examsPlan = examsPlanMapper.selectByPrimaryKey(list.get(i).getExamPlanId());
					map.put(trainee, examsPlan);
				}else if (flag.equals("trainer")) {
					if (trainee.getTrainerId() != null && trainee.getTrainerId().equals(trainer.getId())) {
						DsmsExamPlans examsPlan = examsPlanMapper.selectByPrimaryKey(list.get(i).getExamPlanId());
						map.put(trainee, examsPlan);
					}
				}
			}
		}
		return map;
	}

	public Map<DsmsTrainees, DsmsExamPlans> findAllExamsOrderedByCon(String flag,DsmsTrainers trainer,String traineeNo,String traineeName,String examType)
			throws CommonException {		
		Map<DsmsTrainees, DsmsExamPlans> allmap = findAllExamsOrdered(flag,trainer);
		ConcurrentHashMap<DsmsTrainees, DsmsExamPlans> map=new ConcurrentHashMap<DsmsTrainees, DsmsExamPlans>();
		if (StringUtils.isBlank(traineeNo)&&StringUtils.isBlank(traineeName)&&StringUtils.isBlank(examType)) {
			return allmap;
		}
		if (StringUtils.isNotBlank(traineeNo)) {			
			for (Entry<DsmsTrainees, DsmsExamPlans> entry : allmap.entrySet()) {
				if (StringUtils.isNotBlank(entry.getKey().getTraineeNo())&&entry.getKey().getTraineeNo().equals(traineeNo)) {
					map.put(entry.getKey(),entry.getValue());
				}
			}
		}
		if (StringUtils.isNotBlank(traineeName)) {
			if (map.isEmpty()&&StringUtils.isBlank(traineeNo)) {	
				for (Entry<DsmsTrainees, DsmsExamPlans> entry : allmap.entrySet()) {
					if (StringUtils.isNotBlank(entry.getKey().getName())&&entry.getKey().getName().equals(traineeName)) {
						map.put(entry.getKey(),entry.getValue());
					}
				}
			}else {
				for (Entry<DsmsTrainees, DsmsExamPlans> entry : map.entrySet()) {
					if (!entry.getKey().getName().equals(traineeName)) {
						map.remove(entry.getKey());
					}
				}
			}
		}
		if (StringUtils.isNotBlank(examType)) {
			if (map.isEmpty()&&StringUtils.isBlank(traineeNo)&&StringUtils.isBlank(traineeName)) {	
				for (Entry<DsmsTrainees, DsmsExamPlans> entry : allmap.entrySet()) {
					if (StringUtils.isNotBlank(entry.getValue().getExamType())&&entry.getValue().getExamType().equals(examType)) {
						map.put(entry.getKey(),entry.getValue());
					}
				}
			}else {
				for (Entry<DsmsTrainees, DsmsExamPlans> entry : map.entrySet()) {
					if (!entry.getValue().getExamType().equals(examType)) {
						map.remove(entry.getKey());
					}
				}
			}
		}
		return map;
	}

	public DsmsExamOrders findExamsOrderedById(long id) throws CommonException {
		return examsOrderMapper.selectByPrimaryKey(id);
	}

	public DsmsExamOrders findExamsOrderedByTraineeNo(String traineeNo) throws CommonException {
		return null;
	}

	public DsmsExamOrders findExamsOrderedByStatus(String status) throws CommonException {
		return null;
	}

	public void updateExamsOrdered(DsmsExamOrders examsOrder) throws CommonException {
		examsOrderMapper.updateByPrimaryKeySelective(examsOrder);
	}

	public void deleteExamsOrderedById(long id) throws CommonException {
		DsmsExamOrdersExample example = new DsmsExamOrdersExample();
		List<DsmsExamOrders> list = examsOrderMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTraineeId() == id) {				
				examsOrderMapper.deleteByPrimaryKey(id);
			}
		}
	}

	public void insertExamsOrdered(DsmsExamOrders examsOrder) throws CommonException {
		DsmsExamPlans examPlan = examsPlanMapper.selectByPrimaryKey(examsOrder.getExamPlanId());
		DsmsTrainees trainee = traineesMapper.selectByPrimaryKey(examsOrder.getTraineeId());
		trainee.setStatus(examPlan.getExamType()+"_ordered");
		traineesMapper.updateByPrimaryKey(trainee);
		examsOrderMapper.insertSelective(examsOrder);
	}

	public List<DsmsTrainees> findAllExamsOrderList() throws CommonException{
		DsmsTraineesExample example=new DsmsTraineesExample();
		example.createCriteria().andStatusNotEqualTo("finish").andStatusNotLike("%ordered");
		List<DsmsTrainees> list = traineesMapper.selectByExample(example);
		return list;
	}

	public Map<DsmsTrainees,DsmsExamResults> findAllExamsResults() throws CommonException {
		TreeMap<DsmsTrainees, DsmsExamResults> map=new TreeMap<DsmsTrainees, DsmsExamResults>(new Comparator<DsmsTrainees>() {
			public int compare(DsmsTrainees o1, DsmsTrainees o2) {
				// TODO Auto-generated method stub
				int i = o1.getId().compareTo(o2.getId());
				return -i;
			}			
		});
		DsmsExamResultsExample example = new DsmsExamResultsExample();
		example.setOrderByClause("trainee_id");
		List<DsmsExamResults> list = examsResultMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			DsmsTrainees trainee = traineesMapper.selectByPrimaryKey(list.get(i).getTraineeId());	
			if (trainee != null) {				
				map.put(trainee, list.get(i));
			}
		}
		return map;
	}

	public Map<DsmsTrainees, DsmsExamResults> findAllExamsResultsByCon(String traineeNo,String traineeName,String examType)
			throws CommonException {
		Map<DsmsTrainees, DsmsExamResults> allmap = findAllExamsResults();
		ConcurrentHashMap<DsmsTrainees, DsmsExamResults> map=new ConcurrentHashMap<DsmsTrainees, DsmsExamResults>();
		if (StringUtils.isBlank(traineeNo)&&StringUtils.isBlank(traineeName)&&StringUtils.isBlank(examType)) {
			return allmap;
		}		
		if (StringUtils.isNotBlank(traineeNo)) {			
			for (Entry<DsmsTrainees, DsmsExamResults> entry : allmap.entrySet()) {
				if (StringUtils.isNotBlank(entry.getKey().getTraineeNo())&&entry.getKey().getTraineeNo().equals(traineeNo)) {
					map.put(entry.getKey(),entry.getValue());
				}
			}
		}
		if (StringUtils.isNotBlank(traineeName)) {
			if (map.isEmpty()&&StringUtils.isBlank(traineeNo)) {	
				for (Entry<DsmsTrainees, DsmsExamResults> entry : allmap.entrySet()) {
					if (StringUtils.isNotBlank(entry.getKey().getName())&&entry.getKey().getName().equals(traineeName)) {
						map.put(entry.getKey(),entry.getValue());
					}
				}
			}else {
				for (Entry<DsmsTrainees, DsmsExamResults> entry : map.entrySet()) {
					if (!entry.getKey().getName().equals(traineeName)) {
						map.remove(entry.getKey());
					}
				}
			}
		}
		if (StringUtils.isNotBlank(examType)) {
			for (Entry<DsmsTrainees, DsmsExamResults> entry : allmap.entrySet()) {
				DsmsExamPlans examPlan = examsPlanMapper.selectByPrimaryKey(entry.getValue().getExamPlanId());
				if (map.isEmpty()&&StringUtils.isBlank(traineeNo)&&StringUtils.isBlank(traineeName)) {	
					if (examPlan.getExamType().equals(examType)) {
						map.put(entry.getKey(),entry.getValue());
					}
				}else {
					if (!examPlan.getExamType().equals(examType)) {
						map.remove(entry.getKey());
					}
				}
			}
		}
		return map;
	}

	public DsmsExamResults findExamsResultById(long id) throws CommonException {
		return examsResultMapper.selectByPrimaryKey(id);
	}

	public void updateExamsResult(DsmsExamResults examsResult) throws CommonException {
		examsResultMapper.updateByPrimaryKeySelective(examsResult);
		if (examsResult.getStatus().equals("pass")) {
			DsmsTrainees trainees = traineesMapper.selectByPrimaryKey(examsResult.getTraineeId());
			DsmsExamPlans examPlan = examsPlanMapper.selectByPrimaryKey(examsResult.getExamPlanId());
			if (examPlan.getExamType().equals("exam4")) {
				trainees.setStatus("finish");
			}else {
				trainees.setStatus(trainees.getStatus()+"_"+examPlan.getExamType()+"_pass");
			}
			traineesMapper.updateByPrimaryKeySelective(trainees);
		}
	}

	public void deleteExamsResultById(long id) throws CommonException {
		examsResultMapper.deleteByPrimaryKey(id);
	}

	public void insertExamsResult(DsmsExamResults examsResult) throws CommonException {
		examsResultMapper.insertSelective(examsResult);
		if (examsResult.getStatus().equals("pass")) {
			DsmsTrainees trainees = traineesMapper.selectByPrimaryKey(examsResult.getTraineeId());
			DsmsExamPlans examPlan = examsPlanMapper.selectByPrimaryKey(examsResult.getExamPlanId());
			if (examPlan.getExamType().equals("exam4")) {
				trainees.setStatus("finish");
			}else {
				trainees.setStatus(trainees.getStatus()+"_"+examPlan.getExamType()+"_pass");
			}
			traineesMapper.updateByPrimaryKeySelective(trainees);
		}
	}
}