package cn.js.ccit.serviceImp;

import cn.js.ccit.DAO.KWStateDAO;
import cn.js.ccit.model.KWState;
import cn.js.ccit.service.KWStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KWStateServiceImp implements KWStateService  {
    @Autowired
    private KWStateDAO kwStateDAO;
    @Override
    public List<KWState> searchKWState(String evaluator) {
        Map map = new HashMap();
        map.put("evaluator",evaluator);
        return kwStateDAO.selectDptState(map);
    }
}
