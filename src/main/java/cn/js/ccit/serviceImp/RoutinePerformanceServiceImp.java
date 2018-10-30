package cn.js.ccit.serviceImp;

import java.util.List;
import java.util.Map;

import cn.js.ccit.DAO.RoutinePerformanceDAO;
import cn.js.ccit.model.RoutinePerformance;
import cn.js.ccit.service.RoutinePerformanceService;
import cn.js.ccit.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *  日常绩效服务层 
 *
 */
@Service
@Transactional
public class RoutinePerformanceServiceImp implements RoutinePerformanceService {
	@Autowired
	private RoutinePerformanceDAO routinePerformanceDAO;

	public boolean doEvaluate(RoutinePerformance rp) {
		if(CheckUtil.isNullOrZero(rp.getId())){
			routinePerformanceDAO.insert(rp);
		}else{
			routinePerformanceDAO.updateByPrimaryKey(rp);
		}
			
		return true;
	}
	@Transactional
	public boolean doEvaluate(List<RoutinePerformance> rps) {
		for (RoutinePerformance routinePerformance : rps) {
			doEvaluate(routinePerformance);
		}
		return true;
	}

	public List<RoutinePerformance> searchEvaluation(Map map) {
		return routinePerformanceDAO.select(map);
	}

}
