package cn.js.ccit.serviceImp;

import java.util.List;

import cn.js.ccit.DAO.EmployeeDAO;
import cn.js.ccit.model.Employee;
import cn.js.ccit.service.EmployeeService;
import cn.js.ccit.DAO.EmployeeDAO;
import cn.js.ccit.model.Employee;
import cn.js.ccit.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public Employee login(Employee employee) {
        List<Employee> list = employeeDAO.select(employee);
        return list.size() >= 1 ? list.get(0) : null;
    }

    /**
     * 随机账号登录
     * @param e   ranId,ranPwd
     * @return
     */
    public Employee ranLogin(Employee e) {
        e.setState(1);
        return employeeDAO.ranLogin(e);
    }


}
