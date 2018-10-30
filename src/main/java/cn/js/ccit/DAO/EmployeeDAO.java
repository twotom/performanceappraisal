package cn.js.ccit.DAO;

import cn.js.ccit.model.Employee;

import java.util.List;
import java.util.Map;


public interface EmployeeDAO {
	 List<Employee> selectByMap(Map map);
	 List<Employee> select(Employee employee);
	 Employee ranLogin(Employee employee);
	 int insert(Employee e);
	 int update(Employee e);
}
