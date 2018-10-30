package cn.js.ccit.controller;

import cn.js.ccit.service.EmployeeService;
import cn.js.ccit.util.MD5Util;
import com.alibaba.fastjson.JSON;
import cn.js.ccit.model.Employee;
import cn.js.ccit.service.EmployeeService;
import cn.js.ccit.util.MD5Util;
import cn.js.ccit.util.ResponseUtil;
import cn.js.ccit.util.ServletContextManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/login_validate")
    @ResponseBody
    public void login_validate(Employee employee, boolean remember, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        employee.setEmpId(employee.getEmpId().toUpperCase());
        employee = employeeService.login(employee);
        if (employee != null) {
            session.setAttribute("employee", employee);
            if (remember) {
                Cookie empId = new Cookie("empId", employee.getEmpId());
                empId.setPath("/");
                empId.setMaxAge(24 * 60 * 60 * 7);
                Cookie ps = new Cookie("password", MD5Util.convertMD5(employee.getPwd()));
                ps.setPath("/");
                ps.setMaxAge(24 * 60 * 60 * 7);
                response.addCookie(empId);
                response.addCookie(ps);
            } else {
                Cookie ps = new Cookie("password", employee.getPwd());
                ps.setPath("/");
                ps.setMaxAge(0);
                response.addCookie(ps);
            }
            ResponseUtil.write(response, "Y");
        } else {
            ResponseUtil.write(response, "N");
        }
    }

    @RequestMapping("/satisfaction_login")
    @ResponseBody
    public void satisfactionLogin(Employee employee, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        employee.setRanId(employee.getRanId().toUpperCase());
        employee = employeeService.ranLogin(employee);
        if (employee != null) {
            session.setAttribute("s_employee", employee);
            ResponseUtil.write(response, "Y");
        } else {
            ResponseUtil.write(response, "N");
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("employee");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");

        return mv;
    }

    @RequestMapping("/s_logout")
    @ResponseBody
    public ModelAndView sLogout(HttpSession session) {
        session.removeAttribute("s_employee");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("satisfaction/login");

        return mv;
    }
}
