package cn.js.ccit.DAO;

import java.util.List;
import java.util.Map;

import cn.js.ccit.model.SelfEvaluation;

public interface SelfEvaluationDAO {

	int insert(SelfEvaluation record);
	int updateByPrimaryKey(SelfEvaluation record);
	List<SelfEvaluation> select(Map map);
	SelfEvaluation selectByPrimaryKey(Integer key);
}
