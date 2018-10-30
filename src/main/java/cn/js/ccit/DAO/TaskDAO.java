package cn.js.ccit.DAO;


import cn.js.ccit.model.Task;
import cn.js.ccit.model.Task;

public interface TaskDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}