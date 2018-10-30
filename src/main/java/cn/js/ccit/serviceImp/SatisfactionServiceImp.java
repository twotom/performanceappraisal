package cn.js.ccit.serviceImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.js.ccit.DAO.EmployeeDAO;
import cn.js.ccit.DAO.SatisfactionDAO;
import cn.js.ccit.model.Employee;
import cn.js.ccit.model.Satisfaction;
import cn.js.ccit.service.SatisfactionService;
import cn.js.ccit.util.CalcScoreUtil;
import cn.js.ccit.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SatisfactionServiceImp implements SatisfactionService {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private SatisfactionDAO satiscfactionDAO;

    public boolean doEvaluate(Satisfaction s) {
        s.setScore(CalcScoreUtil.getSatisfactionScore(s.getChoose()));
        if (CheckUtil.isNullOrZero(s.getId())) {
            satiscfactionDAO.insert(s);
        } else {
            satiscfactionDAO.updateByPrimaryKey(s);
        }
        return true;
    }
    @Transactional
    public boolean doEvaluate(List<Satisfaction> s) {
        for (Satisfaction satisfaction : s) {
            doEvaluate(satisfaction);
        }

        Employee e = employeeDAO.select(s.get(0).getEvaluator()).get(0);
        e.setState(2);
        employeeDAO.update(e);
        return true;
    }

    /**
     * 初始化 页面时   参数： evaluator
     */
    public List<Satisfaction> searchEvaluation(Map map) {
        return satiscfactionDAO.select(map);
    }


}
