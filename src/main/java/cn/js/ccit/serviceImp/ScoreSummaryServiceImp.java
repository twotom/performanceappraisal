package cn.js.ccit.serviceImp;

import cn.js.ccit.DAO.ScoreSummaryDAO;
import cn.js.ccit.model.ScoreSummary;
import cn.js.ccit.service.ScoreSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 得分汇总服务层
 */
@Service
public class ScoreSummaryServiceImp implements ScoreSummaryService{
    @Autowired
    private ScoreSummaryDAO scoreSummaryDAO;

    /**
     * 突出贡献
     * @return
     */
    @Override
    public List<ScoreSummary> contributionSummary() {
        Map map = new HashMap();
        map.put("indicator",1);
        return scoreSummaryDAO.irregularSummary(map);
    }

    @Override
    public ScoreSummary contributionSummary(Integer department) {
        Map map = new HashMap();
        map.put("department",department);
        map.put("indicator",1);
        List<ScoreSummary> result = scoreSummaryDAO.irregularSummary(map);
        return result.size()>0?result.get(0):null;
    }
    /**
     * 严重失误
     * @return
     */
    @Override
    public List<ScoreSummary> mistakeSummary() {
        Map map = new HashMap();
        map.put("indicator",2);
        return scoreSummaryDAO.irregularSummary(map);
    }

    @Override
    public ScoreSummary mistakeSummary(Integer department) {
        Map map = new HashMap();
        map.put("department",department);
        map.put("indicator",2);
        List<ScoreSummary> result = scoreSummaryDAO.irregularSummary(map);
        return result.size()>0?result.get(0):null;
    }

    /**
     * 自身建设
     * @return
     */
    @Override
    public List<ScoreSummary> routineConstructionSummary() {
        Map map = new HashMap();
        map.put("indicator",1);
        return scoreSummaryDAO.routineSummary(map);
    }

    @Override
    public ScoreSummary routineConstructionSummary(Integer department) {
        Map map = new HashMap();
        map.put("department",department);
        map.put("indicator",1);
        List<ScoreSummary> result = scoreSummaryDAO.routineSummary(map);
        return result.size()>0?result.get(0):null;
    }
    /**
     * 工作规范
     * @return
     */
    @Override
    public List<ScoreSummary> routineWorkSummary() {
        Map map = new HashMap();
        map.put("indicator",2);
        return scoreSummaryDAO.routineSummary(map);
    }

    @Override
    public ScoreSummary routineWorkSummary(Integer department) {
        Map map = new HashMap();
        map.put("department",department);
        map.put("indicator",2);
        List<ScoreSummary> result = scoreSummaryDAO.routineSummary(map);
        return result.size()>0?result.get(0):null;
    }

    /**
     * 满意度统计  上级
     * @return
     */
    @Override
    public List<ScoreSummary> satisfactionSuperiorSummary(boolean percent) {
        Map map = new HashMap();
        map.put("percent",percent);
        return scoreSummaryDAO.satisfactionSuperiorSummary(map);
    }

    @Override
    public ScoreSummary satisfactionSuperiorSummary(Integer department,boolean percent) {
        Map map = new HashMap();
        map.put("department",department);
        map.put("percent",percent);
        List<ScoreSummary> result = scoreSummaryDAO.satisfactionSuperiorSummary(map);
        return result.size()>0?result.get(0):null;
    }

    /**
     * 满意度 同级评价
      * @return
     */
    public List<ScoreSummary> satisfactionSameSummary(boolean percent) {
        Map map = new HashMap();
        map.put("percent",percent);
        map.put("indicator",3);
        return scoreSummaryDAO.satisfactionServiceOrSameSummary(map);
    }

    /**
     * 满意度 同级评价
     * @param department
     */
    public ScoreSummary satisfactionSameSummary(Integer department,boolean percent) {
        Map map = new HashMap();
        map.put("indicator",3);
        map.put("percent",percent);
        map.put("department",department);
        List<ScoreSummary> result = scoreSummaryDAO.satisfactionServiceOrSameSummary(map);
        return result.size()>0?result.get(0):null;
    }

    /**
     * 满意度 服务评价
     * @return
     */
    public List<ScoreSummary> satisfactionServiceSummary(boolean percent) {
        Map map = new HashMap();
        map.put("percent",percent);
        map.put("indicator",2);
        return scoreSummaryDAO.satisfactionServiceOrSameSummary(map);
    }

    /**
     * 满意度 服务评价
     * @return
     */
    public ScoreSummary satisfactionServiceSummary(Integer department,boolean percent) {
        Map map = new HashMap();
        map.put("indicator",2);
        map.put("percent",percent);
        map.put("department",department);
        List<ScoreSummary> result = scoreSummaryDAO.satisfactionServiceOrSameSummary(map);
        return result.size()>0?result.get(0):null;
    }

    @Override
    public List<ScoreSummary> keyWorkSummary() {
        return scoreSummaryDAO.keyWorkSummary(null);
    }

    @Override
    public ScoreSummary keyWorkSummary(Integer department) {
        Map map = new HashMap();
        map.put("department",department);
        List<ScoreSummary> result = scoreSummaryDAO.keyWorkSummary(map);
        return result.size()>0?result.get(0):null;
    }


    @Override
    public List<ScoreSummary> regularSummary() {
        return scoreSummaryDAO.regularSummary(null);
    }

    @Override
    public ScoreSummary regularSummary(Integer department) {
        Map map = new HashMap();
        map.put("department",department);
        List<ScoreSummary> result = scoreSummaryDAO.regularSummary(map);
        return result.size()>0?result.get(0):null;
    }


}
