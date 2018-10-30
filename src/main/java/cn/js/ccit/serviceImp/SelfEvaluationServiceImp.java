package cn.js.ccit.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.js.ccit.DAO.SelfEvaluationDAO;
import cn.js.ccit.model.SelfEvaluation;
import cn.js.ccit.service.SelfEvaluationService;
import cn.js.ccit.util.CheckUtil;
import org.springframework.transaction.annotation.Transactional;

/**
 * 自评服务层 
 *
 */

@Service
@Transactional
public class SelfEvaluationServiceImp implements SelfEvaluationService {

	@Autowired
	private SelfEvaluationDAO selfEvaluationDAO;

	public boolean doEvaluation(SelfEvaluation se) {
		if(CheckUtil.isNullOrZero(se.getId())){
			selfEvaluationDAO.insert(se);
		}else{
			selfEvaluationDAO.updateByPrimaryKey(se);
		}
		return true;
	}
	@Transactional
	public boolean doEvaluation(List<SelfEvaluation> ses) {
		for (SelfEvaluation selfEvaluation : ses) {
			doEvaluation(selfEvaluation);
		}
		return true;
	}

	public List<SelfEvaluation> searchEvaluation(Map map) {
		return selfEvaluationDAO.select(map);
	}
	
	
}
