package cn.js.ccit.DAO;

import cn.js.ccit.model.Satisfaction;

import java.util.List;
import java.util.Map;


public interface SatisfactionDAO {
	int insert (Satisfaction s);
    int deleteByPrimaryKey(Integer id);
    Satisfaction selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(Satisfaction record);
    List<Satisfaction> select (Map map);
}
