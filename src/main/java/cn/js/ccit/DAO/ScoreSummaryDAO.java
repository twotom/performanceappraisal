package cn.js.ccit.DAO;

import cn.js.ccit.model.ScoreSummary;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 11/19/2017.
 */
public interface ScoreSummaryDAO {
    List<ScoreSummary> regularSummary(Map map);
    List<ScoreSummary> satisfactionSummary(Map map);
    List<ScoreSummary> keyWorkSummary(Map map);
    List<ScoreSummary> satisfactionServiceOrSameSummary(Map map);
    List<ScoreSummary> satisfactionSuperiorSummary(Map map);
    List<ScoreSummary> routineSummary(Map map);
    List<ScoreSummary> irregularSummary(Map map);
}
