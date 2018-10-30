package cn.js.ccit.service;


import cn.js.ccit.model.ScoreSummary;

import java.util.List;

public interface ScoreSummaryService {
    List<ScoreSummary> regularSummary();
    ScoreSummary regularSummary(Integer department);
    List<ScoreSummary> keyWorkSummary();
    ScoreSummary keyWorkSummary(Integer department);
    List<ScoreSummary> satisfactionSameSummary(boolean percent);
    ScoreSummary satisfactionSameSummary(Integer department, boolean percent);
    List<ScoreSummary> satisfactionServiceSummary(boolean percent);
    ScoreSummary satisfactionServiceSummary(Integer department, boolean percent);
    List<ScoreSummary> satisfactionSuperiorSummary(boolean percent);
    ScoreSummary satisfactionSuperiorSummary(Integer department, boolean percent);
    List<ScoreSummary> routineConstructionSummary();
    ScoreSummary routineConstructionSummary(Integer department);
    List<ScoreSummary> routineWorkSummary();
    ScoreSummary routineWorkSummary(Integer department);
    List<ScoreSummary> contributionSummary();
    ScoreSummary contributionSummary(Integer department);
    List<ScoreSummary> mistakeSummary();
    ScoreSummary mistakeSummary(Integer department);





}
