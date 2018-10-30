package cn.js.ccit.DAO;


import cn.js.ccit.model.ContributeSelfEvaluation;

import java.util.List;
import java.util.Map;

public interface ContributeSelfEvaluationDAO {
    int insert(ContributeSelfEvaluation contributeSelfEvaluation);

    List<ContributeSelfEvaluation> select(Map map);
    int delete(Integer id);
    int update(ContributeSelfEvaluation contributeSelfEvaluation);
}
