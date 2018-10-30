package cn.js.ccit.service;

import cn.js.ccit.model.RoutinePerformance;

import java.util.List;
import java.util.Map;


public interface RoutinePerformanceService {
	boolean doEvaluate(RoutinePerformance rp);
	boolean doEvaluate(List<RoutinePerformance> rps);
	List<RoutinePerformance> searchEvaluation(Map map);
}
