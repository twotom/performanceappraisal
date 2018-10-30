package cn.js.ccit.controller;

import cn.js.ccit.DAO.DepartmentDAO;
import cn.js.ccit.model.ContributeSelfEvaluation;
import cn.js.ccit.service.*;
import cn.js.ccit.util.MD5Util;
import cn.js.ccit.DAO.DepartmentDAO;
import cn.js.ccit.model.Department;
import cn.js.ccit.model.Employee;
import cn.js.ccit.service.EmployeeService;
import cn.js.ccit.util.MD5Util;
import cn.js.ccit.util.ServletContextManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ViewController {

    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ContributeSelfEvaluationService contributeSelfEvaluationService;
    @Autowired
    private SystemTimeService systemTimeService;

    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");

        Employee employee = (Employee) session.getAttribute("employee");
        if (employee != null) {
            mv.addObject("employee", employee);
        }

        return mv;
    }

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        session.removeAttribute("employee");
        return mv;
    }

    @RequestMapping("satisfaction")
    public ModelAndView satisfaction(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Employee employee = (Employee) session.getAttribute("s_employee");
        if (employee != null) {
            mv.setViewName("satisfaction/index");
            mv.addObject("employee", employee);

            List<Department> departments = departmentDAO.getAll();
            mv.addObject("departments", departments);
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            try {
                String time = sdf.format(systemTimeService.search().getStime());
                mv.addObject("time", time);
            } catch (Exception e) {
                e.printStackTrace();
            }

            boolean overtime = systemTimeService.check();
            mv.addObject("overtime", overtime);
        } else {
            mv.setViewName("satisfaction/login");
        }

        return mv;
    }

    @RequestMapping("profile")
    public ModelAndView profile(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        Employee employee = (Employee) session.getAttribute("employee");
        if (employee != null) {
            mv.setViewName("profile");
            mv.addObject("employee", employee);
            List<Department> departments = departmentDAO.getAll();
            mv.addObject("departments", departments);

            Map irregular = new HashMap();
            for (Department department: departments) {
                Map<String, Integer> map = new HashMap<>();
                map.put("department", department.getId());
                map.put("indicator", 1);
                List<ContributeSelfEvaluation> contributions = contributeSelfEvaluationService.searchEvaluation(map);
                map.put("indicator", 2);
                List<ContributeSelfEvaluation> commendations = contributeSelfEvaluationService.searchEvaluation(map);
                Map item = new HashMap();
                item.put("contributions", contributions);
                item.put("commendations", commendations);
                item.put("shortName", department.getShortName());
                irregular.put(department.getId() + "", item);
            }

            mv.addObject("irregular", irregular);


            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            try {
                String time = sdf.format(systemTimeService.search().getStime());
                mv.addObject("time", time);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean overtime = systemTimeService.check();
            mv.addObject("overtime", overtime);
        } else {
            mv.setViewName("redirect:login");
        }

        return mv;
    }

    @RequestMapping("/")
    public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        Employee employee = (Employee) session.getAttribute("employee");
        if (employee != null) {
            mv.setViewName("redirect:profile");
        } else {
            Cookie[] cookies = request.getCookies();
            String empId = null;
            String password = null;

            if (cookies != null)
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("empId"))
                        empId = cookie.getValue();
                    if (cookie.getName().equals("password"))
                        password = cookie.getValue();
                }

            if (empId != null && !empId.trim().equals("") && password != null && !password.trim().equals("")) {
                employee = new Employee();
                employee.setEmpId(empId);
                employee.setPwd(MD5Util.convertMD5(password));
                employee = employeeService.login(employee);

                if (employee != null) {
                    session.setAttribute("employee", employee);
                    mv.setViewName("redirect:profile");
                } else {
                    mv.setViewName("redirect:login");
                }
            } else {
                mv.setViewName("redirect:login");
            }
        }

        return mv;
    }

    @RequestMapping("/time")
    public ModelAndView time(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        Object employee = session.getAttribute("employee");
        if(employee!=null &&employee instanceof  Employee &&"J00377".equals(((Employee)employee).getEmpId().toUpperCase())){

            mv.setViewName("time");
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                String time = sdf.format(systemTimeService.search().getStime());
                mv.addObject("time", time);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else
            mv.setViewName("redirect:login");

        return mv;
    }
}
