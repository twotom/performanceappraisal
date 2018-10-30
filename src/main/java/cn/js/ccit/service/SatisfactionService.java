
package cn.js.ccit.service;

import cn.js.ccit.model.Satisfaction;

import java.util.List;
import java.util.Map;


public interface SatisfactionService {

	boolean  doEvaluate(Satisfaction satisfactions);
	boolean  doEvaluate(List<Satisfaction> s);
	List<Satisfaction> searchEvaluation(Map map);
}
