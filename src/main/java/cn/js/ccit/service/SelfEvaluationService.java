package cn.js.ccit.service;

import java.util.List;
import java.util.Map;

import cn.js.ccit.model.SelfEvaluation;

public interface SelfEvaluationService {

	boolean doEvaluation(SelfEvaluation se);
	boolean doEvaluation(List<SelfEvaluation> ses);
	List<SelfEvaluation> searchEvaluation(Map map);
}
