package cn.js.ccit.service;


import cn.js.ccit.model.KWState;

import java.util.List;

public interface KWStateService {
    List<KWState> searchKWState(String evaluator);
}
