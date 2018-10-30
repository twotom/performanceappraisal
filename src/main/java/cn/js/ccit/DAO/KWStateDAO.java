package cn.js.ccit.DAO;

import cn.js.ccit.model.KWState;

import java.util.List;
import java.util.Map;

public interface KWStateDAO {
    List<KWState> select(Map map);
    int insert (KWState k);
    List<KWState> selectDptState(Map map);

}
