package cn.js.ccit.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.js.ccit.DAO.*;
import cn.js.ccit.model.*;
import cn.js.ccit.service.*;
import cn.js.ccit.serviceImp.KWStateServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.js.ccit.serviceImp.SatisfactionServiceImp;

public class TestEvaluation {
	
	static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context*.xml") ;
	
	static SatisfactionService satisfactionService = (SatisfactionService) ctx.getBean("satisfactionServiceImp");
	static ScoreSummaryService scoreSummaryService = (ScoreSummaryService)ctx.getBean("scoreSummaryServiceImp");
	static RoutinePerformanceDAO  routinePerformanceDAO =(RoutinePerformanceDAO) ctx.getBean (RoutinePerformanceDAO.class);
	static RegularWorkService  regularWorkService = (RegularWorkService) ctx.getBean("regularWorkServiceImp");
	static KeyWorkService keyWorkService = (KeyWorkService) ctx.getBean("keyWorkServiceImp");
	static IrregularPerformanceService irregularPerformanceService = (IrregularPerformanceService) ctx.getBean("irregularPerformanceServiceImp");
	static KWStateService kwStateService = (KWStateService) ctx.getBean(KWStateServiceImp.class);
	static KeyWorkDAO kd = (KeyWorkDAO) ctx.getBean("keyWorkDAO");
	static SatisfactionDAO sd = (SatisfactionDAO) ctx.getBean("satisfactionDAO");
	static RoutinePerformanceDAO rd = (RoutinePerformanceDAO) ctx.getBean("routinePerformanceDAO");
	static IrregularPerformanceDAO id = (IrregularPerformanceDAO) ctx.getBean("irregularPerformanceDAO");
	static EmployeeDAO empDAO = (EmployeeDAO) ctx.getBean("employeeDAO");
	static DepartmentDAO dd = (DepartmentDAO) ctx.getBean("departmentDAO");
	static RegularWorkDAO regularWorkDAO = (RegularWorkDAO) ctx.getBean("regularWorkDAO");
	static ScoreSummaryDAO scoreSummaryDAO = (ScoreSummaryDAO) ctx.getBean("scoreSummaryDAO");

	public static void main(String[] args) {
//		testSatisfaction();
//		testSatisPrint();
//		testScoreSummary();
//		testRoutine();
		testRegularWork();
		testKeyWork();
//		testSummary();
//		testIrregular();
		testKWState();


	}
	static void  testKWState(){
		List<KWState> kwss = kwStateService.searchKWState("J00377");
		for (KWState kws:
		kwss) {
			System.out.println(kws);
		}
	}
	static  void testIrregular(){
		List<IrregularPerformance> irregularPerformances = irregularPerformanceService.searchDptSummary(1);
		for (IrregularPerformance i:
		irregularPerformances ) {
			System.out.println(i);
		}
		List<IrregularPerformance> irregularPerformances2 = irregularPerformanceService.searchDptSummary(2);
		for (IrregularPerformance i:
				irregularPerformances2 ) {
			System.out.println(i);
		}
		System.out.println(irregularPerformanceService.searchDptSummary(1,206));
		System.out.println(irregularPerformanceService.searchDptSummary(2,206));
	}
	static  void testSummary(){
		List<ScoreSummary> satisfactionSuperior = scoreSummaryService.satisfactionSuperiorSummary(true);
		List<ScoreSummary> satisfactionService = scoreSummaryService.satisfactionServiceSummary(true);
		List<ScoreSummary> satisfactionSame = scoreSummaryService.satisfactionSameSummary(true);
		System.out.println(satisfactionSuperior);
		System.out.println(satisfactionService);
		System.out.println(satisfactionSame);

	}
	static void  testKeyWork(){
		Map map = new HashMap();
//		map.put("department",201);
//		for (KeyWork k:keyWorkService.searchEvaluation(map)
//				) {
//			System.out.println(k);
//		}
//		System.out.println(scoreSummaryService.keyWorkSummary(201));
//		List<ScoreSummary> keyWork = scoreSummaryService.keyWorkSummary();
//		for (ScoreSummary s:keyWork)
//		{
//			System.out.println(s.getDepartment().getShortName()+"\t"+s.getScore());
//
//		}
		map.put("evaluator","J00377");
		List<KeyWork> ls = keyWorkService.searchScore(map);
		for (KeyWork r:ls
				) {
			System.out.println(r);
		}
	}

	static void  testRegularWork(){
		Map map = new HashMap();
////		map.put("department",201);
//		List<ScoreSummary> regular = scoreSummaryService.regularSummary();
//
//		for (RegularWork r:regularWorkService.searchEvaluation(map)
//			 ) {
//			System.out.println(r.getDepartment().getShortName()+"\t"+r.getScore());
//		}
//		System.out.println("------------");
//		for (ScoreSummary s:regular)
//				 {
//			System.out.println(s.getDepartment().getShortName()+"\t"+s.getScore());
//
//		}
		map.put("evaluator","J00377");
		List<RegularWork> regularWorks = regularWorkService.searchScore(map);
		for (RegularWork r:regularWorks
			 ) {
			System.out.println(r);
		}
	}

	private  static void testRoutine(){
		RoutinePerformance rp= routinePerformanceDAO.selectByPrimaryKey(201);
		rp.setScore(1.1);
		routinePerformanceDAO.updateByPrimaryKey(rp);
	}

	private static void testScoreSummary(){
//		System.out.println(scoreSummaryService.regularSummary());
//		System.out.println(scoreSummaryService.regularSummary(201));
//		System.out.println(scoreSummaryService.keyWorkSummary());
//		System.out.println(scoreSummaryService.keyWorkSummary(201));
		System.out.println(scoreSummaryService.routineConstructionSummary(201));
//		List<ScoreSummary> list =   scoreSummaryService.satisfactionSameSummary();
		List<ScoreSummary> regular = scoreSummaryService.regularSummary();
		List<ScoreSummary> keyWork = scoreSummaryService.keyWorkSummary();
		List<ScoreSummary> satisfactionSuperior = scoreSummaryService.satisfactionSuperiorSummary(false);
		List<ScoreSummary> satisfactionService = scoreSummaryService.satisfactionServiceSummary(false);
		List<ScoreSummary> satisfactionSame = scoreSummaryService.satisfactionSameSummary(false);
		List<ScoreSummary> routineConstruction = scoreSummaryService.routineConstructionSummary();
		List<ScoreSummary> routineWork = scoreSummaryService.routineWorkSummary();
		List<ScoreSummary> contribution = scoreSummaryService.contributionSummary();
		List<ScoreSummary> mistake = scoreSummaryService.mistakeSummary();
		for (int i = 0;i<20;i++){
			ScoreSummary t1 = regular.get(i);
			ScoreSummary t2 = satisfactionSuperior.get(i);
			ScoreSummary t3 = satisfactionService.get(i);
			ScoreSummary t4 = satisfactionSame.get(i);
			ScoreSummary t5 = routineConstruction.get(i);
			ScoreSummary t6 = routineWork.get(i);
			ScoreSummary t7 = contribution.get(i);
			ScoreSummary t8 = mistake.get(i);
			ScoreSummary t9 = keyWork.get(i);
			System.out.printf("%5s  %s\t  %.2f\t %.2f\t  %.2f\t  %.2f\t  %.2f\t  %.2f\t  %.2f\t  %.2f\t  %.2f\t %.2f \n",i+1,t1.getDepartment().getShortName(),t1.getScore()+t2.getScore()+t3.getScore()+t4.getScore()+t5.getScore()+t6.getScore()+t7.getScore()+t8.getScore()+t9.getScore(),
					t1.getScore(),t2.getScore(),t3.getScore(),t4.getScore(),t5.getScore(),t6.getScore(),t7.getScore(),t8.getScore(),t9.getScore());


		}


//		System.out.println(scoreSummaryService.satisfactionSameSummary(null));
	}

	private static void testSatisfaction() {
		
		Satisfaction satisfaction;
		Employee emp1 = new Employee();
		emp1.setEmpId("J00007");
		Employee emp2 = new Employee();
		emp2.setEmpId("J00016");
		for (int i = 0; i < 15; i++) {
			satisfaction = new Satisfaction();
			satisfaction.setIndicator(1);
			Department department = new Department();
			department.setId(201+i);
			satisfaction.setDepartment(department);
			satisfaction.setChoose(1);
			satisfaction.setElement(1);
			satisfaction.setEvaluator(emp1);
			satisfactionService.doEvaluate(satisfaction);
		}
		
	}
	
	static void testSatisPrint(){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("evaluator", "J00007");
		System.out.println(satisfactionService.searchEvaluation(map));
	}
}
