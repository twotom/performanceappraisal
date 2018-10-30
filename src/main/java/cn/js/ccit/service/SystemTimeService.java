package cn.js.ccit.service;

import cn.js.ccit.model.SystemTime;

import java.sql.Timestamp;

public interface SystemTimeService {
    boolean update(Timestamp time);
    SystemTime search();
    boolean check();
}
