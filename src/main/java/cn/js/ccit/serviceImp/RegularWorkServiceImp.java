package cn.js.ccit.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.js.ccit.DAO.RegularWorkDAO;
import cn.js.ccit.model.RegularWork;
import cn.js.ccit.service.RegularWorkService;
import cn.js.ccit.util.CalcScoreUtil;
import cn.js.ccit.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegularWorkServiceImp implements RegularWorkService {
	
	@Autowired
	private RegularWorkDAO regularWorkDAO;
	@Transactional
	public boolean doEvaluate(List<RegularWork> regularWorks) {
		for (RegularWork regularWork : regularWorks) {
			regularWork.setScore(CalcScoreUtil.getRegularWorkScore(regularWork.getChoose()));
			if(CheckUtil.isNullOrZero(regularWork.getId())){
				regularWorkDAO.insert(regularWork);
			}else
				regularWorkDAO.update(regularWork);
			
		}
		return true;
	}
	public List<RegularWork> searchEvaluation(Map map) {
		List<RegularWork> evaluations = regularWorkDAO.select(map);
			
		return evaluations;
	}

	@Override
	public List<RegularWork> searchScore(Map map) {
		return regularWorkDAO.selectScore(map);
	}

}
