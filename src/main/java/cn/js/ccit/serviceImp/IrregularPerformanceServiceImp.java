package cn.js.ccit.serviceImp;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.js.ccit.DAO.IrregularPerformanceDAO;
import cn.js.ccit.model.IrregularPerformance;
import cn.js.ccit.service.IrregularPerformanceService;
import cn.js.ccit.util.CheckUtil;
import org.springframework.transaction.annotation.Transactional;

/**
 * 例外绩效服务层
 *
 */
@Service
public class IrregularPerformanceServiceImp  implements IrregularPerformanceService{

	@Autowired
	private IrregularPerformanceDAO irregularPerformanceDAO;
	public boolean doEvaluate(List<IrregularPerformance> ipis) {
		for (IrregularPerformance irregularPerformance : ipis) {
			doEvaluate(irregularPerformance);
		}
		return true;
	}
	@Transactional
	public boolean doEvaluate(IrregularPerformance ipi) {
		if(CheckUtil.isNullOrZero(ipi.getId())){
			irregularPerformanceDAO.insert(ipi);
		}else{
			irregularPerformanceDAO.updateByPrimaryKey(ipi);
		}
			
		return true;
	}

	public List<IrregularPerformance> searchEvaluation(Map map) {
		return irregularPerformanceDAO.select(map);
	}

	@Override
	public List<IrregularPerformance> searchDptSummary(Integer second) {
		Map map = new HashMap();
		map.put("second",second);
		return irregularPerformanceDAO.selectSummary(map) ;
	}

	@Override
	public List<IrregularPerformance> searchDptSummary(Map map) {
		return irregularPerformanceDAO.selectSummary(map) ;
	}

	@Override
	public IrregularPerformance searchDptSummary(Integer second, Integer department) {
		Map map = new HashMap();
		map.put("second",second);
		map.put("department",department);
		return irregularPerformanceDAO.selectSummary(map).get(0) ;
	}

}
