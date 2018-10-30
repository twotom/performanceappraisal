package cn.js.ccit.service;

import cn.js.ccit.model.RegularWork;

import java.util.List;
import java.util.Map;


public interface RegularWorkService {

	boolean doEvaluate(List<RegularWork> regularWorks);

	List<RegularWork> searchEvaluation(Map map);

	List<RegularWork> searchScore(Map map);
}
