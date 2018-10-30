package cn.js.ccit.serviceImp;


import cn.js.ccit.DAO.KWStateDAO;
import cn.js.ccit.DAO.KeyWorkDAO;
import cn.js.ccit.DAO.TaskDAO;
import cn.js.ccit.model.Department;
import cn.js.ccit.model.KWState;
import cn.js.ccit.model.KeyWork;
import cn.js.ccit.service.KeyWorkService;
import cn.js.ccit.util.CalcScoreUtil;
import cn.js.ccit.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KeyWorkServiceImp implements KeyWorkService {
	@Autowired
	private KeyWorkDAO keyWorkDAO;
	@Autowired
	private KWStateDAO kwStateDAO;
	@Autowired
	private TaskDAO taskDAO;
	public boolean doEvaluate(KeyWork kw) {
		kw.setScore(CalcScoreUtil.getKeyWorkScore(kw.getGrade(),kw.getLevel(),kw.getCharge()));
		if(CheckUtil.isNullOrZero(kw.getId())){//空Id insert
			keyWorkDAO.insert(kw);
		}else{//update
			keyWorkDAO.update(kw);
		}
		return true;
	}
	@Transactional
	public boolean doEvaluate(List<KeyWork> kws,boolean commit) {
		for (KeyWork keyWork : kws) {
			doEvaluate(keyWork);
		}
		if(commit)//提交状态
		{
			checkStateAndInsert(kws.get(0));
		}
		return true;
	}

	private void checkStateAndInsert(KeyWork kw){
		Map map = new HashMap();
		Integer department = taskDAO.selectByPrimaryKey(kw.getTask().getId()).getDepartment().getId();
		map.put("department",department);
		map.put("evaluator",kw.getEvaluator().getEmpId());
		if(kwStateDAO.select(map).size()==0){
			kwStateDAO.insert(new KWState(new Department(department),kw.getEvaluator().getEmpId()));
		}

	}
	public List<KeyWork> searchEvaluation(Map map) {
		return keyWorkDAO.select(map);
	}

	@Override
	public List<KeyWork> searchByDpt(Map map) {
		return keyWorkDAO.selectByDpt(map);
	}

	@Override
	public List<KeyWork> searchScore(Map map) {
		return keyWorkDAO.selectScore(map);
	}
}
