package cn.js.ccit.DAO;


import cn.js.ccit.model.SystemTime;

import java.sql.Time;
import java.sql.Timestamp;

public interface SystemTimeDAO {
    int update(Timestamp time);
    SystemTime select();
}
