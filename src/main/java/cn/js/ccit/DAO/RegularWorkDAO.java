package cn.js.ccit.DAO;

import cn.js.ccit.model.RegularWork;

import java.util.List;
import java.util.Map;


public interface RegularWorkDAO {
	int insert(RegularWork regularWork);
	int update(RegularWork regularWork);
	List<RegularWork> select(Map map);
	List<RegularWork> selectScore(Map map);
}
