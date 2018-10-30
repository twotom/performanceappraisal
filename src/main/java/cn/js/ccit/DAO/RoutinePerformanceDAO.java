package cn.js.ccit.DAO;

import cn.js.ccit.model.RoutinePerformance;
import cn.js.ccit.model.RoutinePerformance;

import java.util.List;
import java.util.Map;


public interface RoutinePerformanceDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(RoutinePerformance record);


    RoutinePerformance selectByPrimaryKey(Integer id);


    int updateByPrimaryKey(RoutinePerformance record);
    
    
    List<RoutinePerformance> select(Map map);
}