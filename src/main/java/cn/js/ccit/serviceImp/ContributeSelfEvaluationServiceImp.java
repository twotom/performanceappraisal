package cn.js.ccit.serviceImp;

import cn.js.ccit.DAO.ContributeSelfEvaluationDAO;
import cn.js.ccit.model.ContributeSelfEvaluation;
import cn.js.ccit.service.ContributeSelfEvaluationService;
import cn.js.ccit.util.CheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 突出贡献自评服务层
 */
@Service
public class ContributeSelfEvaluationServiceImp implements ContributeSelfEvaluationService {
    @Autowired
    private ContributeSelfEvaluationDAO contributeSelfEvaluationDAO;
    @Override
    public boolean doEvaluate(ContributeSelfEvaluation contributeSelfEvaluation) {
        if(CheckUtil.isNullOrZero(contributeSelfEvaluation.getId())){
            contributeSelfEvaluationDAO.insert(contributeSelfEvaluation);
        }else{
            contributeSelfEvaluationDAO.update(contributeSelfEvaluation);
        }
        return true;
    }

    @Transactional
    public boolean doEvaluate(List<ContributeSelfEvaluation> contributeSelfEvaluations) {
        for (ContributeSelfEvaluation ontributeSelfEvaluation: contributeSelfEvaluations){
            doEvaluate(ontributeSelfEvaluation);
        }
        return true;
    }

    @Override
    public List<ContributeSelfEvaluation> searchEvaluation(Map map) {
        return contributeSelfEvaluationDAO.select(map);
    }

    @Override
    public void deleteItem(int id) {
        contributeSelfEvaluationDAO.delete(id);
    }
}
