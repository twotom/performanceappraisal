package cn.js.ccit.model;

import java.sql.Timestamp;

/**
 * 系统时间
 */
public class SystemTime {

    private Integer id;
    private Timestamp stime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getStime() {
        return stime;
    }

    public void setStime(Timestamp stime) {
        this.stime = stime;
    }

    @Override
    public String toString() {
        return "SystemTime{" +
                "id=" + id +
                ", stime=" + stime +
                '}';
    }
}
