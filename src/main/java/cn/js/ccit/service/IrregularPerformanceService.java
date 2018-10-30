package cn.js.ccit.service;

import java.util.List;
import java.util.Map;

import cn.js.ccit.model.IrregularPerformance;

public interface IrregularPerformanceService {

	boolean doEvaluate(List<IrregularPerformance> ipis);
	boolean doEvaluate(IrregularPerformance ipi);
	List<IrregularPerformance> searchEvaluation(Map map);
	List<IrregularPerformance> searchDptSummary(Integer second);
	List<IrregularPerformance> searchDptSummary(Map map);
	IrregularPerformance searchDptSummary(Integer second, Integer department);
}
