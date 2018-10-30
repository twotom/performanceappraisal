package cn.js.ccit.service;


import cn.js.ccit.model.KeyWork;

import java.util.List;
import java.util.Map;

public interface KeyWorkService {

    boolean doEvaluate(List<KeyWork> kws,boolean commit);

    boolean doEvaluate(KeyWork kw);
    List<KeyWork> searchEvaluation(Map map);
    List<KeyWork> searchByDpt(Map map);
    List<KeyWork> searchScore(Map map);
}
