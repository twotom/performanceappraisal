package cn.js.ccit.serviceImp;

import cn.js.ccit.DAO.SystemTimeDAO;
import cn.js.ccit.model.SystemTime;
import cn.js.ccit.service.SystemTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
@Service
public class SystemTimeServiceImp implements SystemTimeService {
    @Autowired
    private SystemTimeDAO systemTimeDAO;
    @Override
    public boolean update(Timestamp time) {

        return systemTimeDAO.update(time)>0;
    }


    @Override
    public SystemTime search() {

        return systemTimeDAO.select();
    }

    /**
     * 检查时间是否到期 true:未到期 ，false :到期
     * @return
     */
    @Override
    public boolean check() {
        SystemTime st = systemTimeDAO.select();
        return st.getStime().after(new Timestamp(System.currentTimeMillis()));
    }
}
