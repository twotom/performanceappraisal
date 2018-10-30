package cn.js.ccit.service;

import cn.js.ccit.model.ContributeSelfEvaluation;

import java.util.List;
import java.util.Map;

public interface ContributeSelfEvaluationService {
    boolean doEvaluate(ContributeSelfEvaluation contributeSelfEvaluation);
    boolean doEvaluate(List<ContributeSelfEvaluation> contributeSelfEvaluations);
    List<ContributeSelfEvaluation> searchEvaluation(Map map);
    void deleteItem(int id);
}
