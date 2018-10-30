package cn.js.ccit.DAO;


import cn.js.ccit.model.Department;

import java.util.List;

public interface DepartmentDAO {

    Department selectByPrimaryKey(Integer id);
    List<Department> getAll();


}