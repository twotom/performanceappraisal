package cn.js.ccit.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.js.ccit.DAO.*;
import cn.js.ccit.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;

public class Test {
    static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context*.xml");

    //	static TestController testController = (TestController) ctx.getBean("testController");
    public static void main(String[] args) {
        KeyWorkDAO kd = (KeyWorkDAO) ctx.getBean("keyWorkDAO");
        SatisfactionDAO sd = (SatisfactionDAO) ctx.getBean("satisfactionDAO");
        RoutinePerformanceDAO rd = (RoutinePerformanceDAO) ctx.getBean("routinePerformanceDAO");
        IrregularPerformanceDAO id = (IrregularPerformanceDAO) ctx.getBean("irregularPerformanceDAO");
        EmployeeDAO empDAO = (EmployeeDAO) ctx.getBean("employeeDAO");
        DepartmentDAO dd = (DepartmentDAO) ctx.getBean("departmentDAO");
        RegularWorkDAO regularWorkDAO = (RegularWorkDAO) ctx.getBean("regularWorkDAO");
        ScoreSummaryDAO scoreSummaryDAO = (ScoreSummaryDAO) ctx.getBean("scoreSummaryDAO");

        Map map = new HashMap();
        map.put("department", 201);
//        List<KeyWork> list = kd.select(map);
//        System.out.println(list.size());
//        for(KeyWork keyWork : list) {
//            System.out.println(keyWork);
//        }

        List<RegularWork> regularWorks = regularWorkDAO.select(map);
        for(RegularWork regularWork : regularWorks) {
            System.out.println(regularWork);
        }

//		kd.update(null);
//		sd.updateByPrimaryKey(null);
//		sd.selectByPrimaryKey(1);
//		rd.updateByPrimaryKey( s);
//		id.selectByPrimaryKey(1);
//		Map<Object, Object> map = new HashMap();
//		map.put("empId", "J00377");
//		System.out.println(regularWorkDAO.select(map));
//		kd.select(null);
//		sd.selectByPrimaryKey(null);
//		id.select(null);
//		rd.select(null);
//		System.out.printf("%5f",6.0);
    }
}