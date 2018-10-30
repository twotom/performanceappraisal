package cn.js.ccit.DAO;

import java.util.List;
import java.util.Map;

import cn.js.ccit.model.IrregularPerformance;

public interface IrregularPerformanceDAO {
    int deleteByPrimaryKey(Integer id);
    int insert(IrregularPerformance record);
    IrregularPerformance selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(IrregularPerformance record);
    List<IrregularPerformance> select(Map map);
    List<IrregularPerformance> selectSummary(Map map) ;
}