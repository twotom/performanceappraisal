package cn.js.ccit.DAO;

import cn.js.ccit.model.KeyWork;

import java.util.List;
import java.util.Map;


public interface KeyWorkDAO {
	int insert(KeyWork kw);
	int update(KeyWork kw);
	List<KeyWork> select(Map map);
	List<KeyWork> selectByDpt(Map map);
	List<KeyWork> selectScore(Map map);
}
