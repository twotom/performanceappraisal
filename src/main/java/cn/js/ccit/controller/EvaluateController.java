package cn.js.ccit.controller;

import cn.js.ccit.model.*;
import cn.js.ccit.service.*;
import cn.js.ccit.util.ResponseUtil;
import com.alibaba.fastjson.JSON;
import cn.js.ccit.service.RegularWorkService;
import cn.js.ccit.service.RoutinePerformanceService;
import cn.js.ccit.service.SatisfactionService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class EvaluateController {
    @Autowired
    private RegularWorkService regularWorkService;
    @Autowired
    private SatisfactionService satisfactionService;
    @Autowired
    private RoutinePerformanceService routinePerformanceService;
    @Autowired
    private KeyWorkService keyWorkService;
    @Autowired
    private SelfEvaluationService selfEvaluationService;
    @Autowired
    private IrregularPerformanceService irregularPerformanceService;
    @Autowired
    private ContributeSelfEvaluationService contributeSelfEvaluationService;
    @Autowired
    private ScoreSummaryService scoreSummaryService;

    @RequestMapping(value = "/regular_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void regularEvaluate(@RequestBody List<RegularWork> regularWorks, HttpServletResponse response) {
        Map map = new HashMap();
        if (regularWorkService.doEvaluate(regularWorks)) {
            map.put("result", "Y");
            ResponseUtil.write(response, JSON.toJSONString(map));
        } else {
            map.put("result", "N");
            ResponseUtil.write(response, JSON.toJSONString(map));
        }
    }

    @RequestMapping(value = "/show_regular_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void showRegularEvaluate(@RequestParam Map map, HttpServletResponse response) {
        ResponseUtil.write(response, JSON.toJSONString(regularWorkService.searchEvaluation(map)));
    }

    @RequestMapping(value = "/satisfaction_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void satisfactionEvaluate(@RequestBody List<Satisfaction> satisfactions, HttpServletResponse response) {
        Map map = new HashMap();

        if (satisfactionService.doEvaluate(satisfactions)) {
            map.put("result", "Y");
            ResponseUtil.write(response, JSON.toJSONString(map));
        } else {
            map.put("result", "N");
            ResponseUtil.write(response, JSON.toJSONString(map));
        }
    }

    @RequestMapping(value = "/show_satisfaction_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void showSatisfactionEvaluate(@RequestParam Map map, HttpServletResponse response) {
        ResponseUtil.write(response, JSON.toJSONString(satisfactionService.searchEvaluation(map)));
    }

    @RequestMapping(value = "/routine_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void routineEvaluate(@RequestBody List<RoutinePerformance> routinePerformances, HttpServletResponse response) {
        Map map = new HashMap();
        if (routinePerformanceService.doEvaluate(routinePerformances)) {
            map.put("result", "Y");
            ResponseUtil.write(response, JSON.toJSONString(map));
        } else {
            map.put("result", "N");
            ResponseUtil.write(response, JSON.toJSONString(map));
        }
    }

    @RequestMapping(value = "/show_routine_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void showRoutineEvaluate(@RequestParam Map map, HttpServletResponse response) {
        ResponseUtil.write(response, JSON.toJSONString(routinePerformanceService.searchEvaluation(map)));
    }

    @RequestMapping(value = "/self_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void selfEvaluate(@RequestBody List<SelfEvaluation> selfEvaluations, HttpServletResponse response) {
        Map map = new HashMap();

        if (selfEvaluationService.doEvaluation(selfEvaluations)) {
            map.put("result", "Y");
            ResponseUtil.write(response, JSON.toJSONString(map));
        } else {
            map.put("result", "N");
            ResponseUtil.write(response, JSON.toJSONString(map));
        }
    }

    @RequestMapping(value = "/show_self_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void showSelfEvaluate(@RequestParam Map map, HttpServletResponse response) {
        ResponseUtil.write(response, JSON.toJSONString(selfEvaluationService.searchEvaluation(map)));
    }

    @RequestMapping(value = "/keyWork_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void keyWorkSelfEvaluate(@RequestBody List<KeyWork> keyWorks, HttpServletResponse response) {
        Map map = new HashMap();
        boolean commit = true;
        if (keyWorkService.doEvaluate(keyWorks,commit)) {
            map.put("result", "Y");
            ResponseUtil.write(response, JSON.toJSONString(map));
        } else {
            map.put("result", "N");
            ResponseUtil.write(response, JSON.toJSONString(map));
        }

    }

    @RequestMapping(value = "/show_keyWork_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void showKeyWorkSelfEvaluate(@RequestParam Map map, HttpServletResponse response) {
        ResponseUtil.write(response, JSON.toJSONString(keyWorkService.searchEvaluation(map)));
    }

    @RequestMapping(value = "/irregularPerformances_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void irregularPerformancesEvaluate(@RequestBody List<IrregularPerformance> irregularPerformances, HttpServletResponse response) {
        Map map = new HashMap();

        if (irregularPerformanceService.doEvaluate(irregularPerformances)) {
            map.put("result", "Y");
            ResponseUtil.write(response, JSON.toJSONString(map));
        } else {
            map.put("result", "N");
            ResponseUtil.write(response, JSON.toJSONString(map));
        }
    }

    @RequestMapping(value = "/show_irregularPerformances_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void showIrregularPerformancesEvaluate(@RequestParam Map map, HttpServletResponse response) {
        ResponseUtil.write(response, JSON.toJSONString(irregularPerformanceService.searchEvaluation(map)));
    }

    @RequestMapping(value = "/contribution_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void contributeEvaluate(@RequestBody List<ContributeSelfEvaluation> contributeSelfEvaluations, HttpServletResponse response) {
        Map map = new HashMap();

        if (contributeSelfEvaluationService.doEvaluate(contributeSelfEvaluations)) {
            map.put("result", "Y");
            ResponseUtil.write(response, JSON.toJSONString(map));
        } else {
            map.put("result", "N");
            ResponseUtil.write(response, JSON.toJSONString(map));
        }
    }

    @RequestMapping(value = "/show_contribution_evaluate", method = {RequestMethod.POST})
    @ResponseBody
    public void showContributionEvaluate(@RequestParam Map map, HttpServletResponse response) {
        Map result = new HashMap();
        map.put("indicator", 1);
        List<ContributeSelfEvaluation> contributions = contributeSelfEvaluationService.searchEvaluation(map);
        result.put("contributions", contributions);
        map.put("indicator", 2);
        List<ContributeSelfEvaluation> commendations = contributeSelfEvaluationService.searchEvaluation(map);
        result.put("commendations", commendations);

        ResponseUtil.write(response, JSON.toJSONString(result));
    }

    @RequestMapping(value = "/contribution_remove", method = {RequestMethod.POST})
    @ResponseBody
    public void contributeRemove(int id, HttpServletResponse response) {
        contributeSelfEvaluationService.deleteItem(id);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public void upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) {

        String path = request.getSession().getServletContext().getRealPath("/upload");
        String originalFilename = file.getOriginalFilename();
        String type = originalFilename.substring(originalFilename.length() - 4, originalFilename.length());
        String finalName = originalFilename.substring(0, originalFilename.length() - 4) + new Date().getTime();
        File targetFile = new File(path, finalName + type);

        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        Map<String, String> map = new HashMap<>();

        //保存
        try {
            file.transferTo(targetFile);
            map.put("message", finalName + type);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", e.getMessage());
        } finally {
            ResponseUtil.write(response, JSON.toJSONString(map));
        }
    }

    @RequestMapping(value = "/download/{file:.+}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(@PathVariable("file") String file, HttpServletResponse response, HttpSession session) throws IOException {
        String path = session.getServletContext().getRealPath("/upload/" + file);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String fileName = new String(file.getBytes("UTF-8"), "iso-8859-1");
        headers.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(path)),
                headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/result_show", method = {RequestMethod.POST})
    @ResponseBody
    public void resultShow(HttpServletResponse response) {
        List<ScoreSummary> regular = scoreSummaryService.regularSummary();
        List<ScoreSummary> keyWork = scoreSummaryService.keyWorkSummary();
        List<ScoreSummary> satisfactionSuperior = scoreSummaryService.satisfactionSuperiorSummary(false);
        List<ScoreSummary> satisfactionService = scoreSummaryService.satisfactionServiceSummary(false);
        List<ScoreSummary> satisfactionSame = scoreSummaryService.satisfactionSameSummary(false);
        List<ScoreSummary> routineConstruction = scoreSummaryService.routineConstructionSummary();
        List<ScoreSummary> routineWork = scoreSummaryService.routineWorkSummary();
        List<ScoreSummary> contribution = scoreSummaryService.contributionSummary();
        List<ScoreSummary> mistake = scoreSummaryService.mistakeSummary();
        Map<String, List<Double>> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            List<Double> list = new ArrayList<>();
            list.add(regular.get(i).getScore());
            list.add(keyWork.get(i).getScore());
            list.add(satisfactionSuperior.get(i).getScore());
            list.add(satisfactionService.get(i).getScore());
            list.add(satisfactionSame.get(i).getScore());
            list.add(routineConstruction.get(i).getScore());
            list.add(routineWork.get(i).getScore());
            list.add(contribution.get(i).getScore());
            list.add(mistake.get(i).getScore());
            double sum = 0.0;
            for (int j = 0; j < list.size(); j++) {
                sum += list.get(j);
            }
            list.add(sum);

            map.put(regular.get(i).getDepartment().getShortName(), list);
        }

        ResponseUtil.write(response, JSON.toJSONString(map));
    }

    @RequestMapping(value = "/result_exception", method = {RequestMethod.POST})
    @ResponseBody
    public void resultException(HttpServletResponse response) {
        Map map = new HashMap();
        map.put("first", 2);
        List<IrregularPerformance> irregularPerformances = irregularPerformanceService.searchEvaluation(map);

        irregularPerformances.addAll(irregularPerformanceService.searchDptSummary(1));
        irregularPerformances.addAll(irregularPerformanceService.searchDptSummary(2));

        ResponseUtil.write(response, JSON.toJSONString(irregularPerformances));
    }

    @RequestMapping(value = "/result_key", method = {RequestMethod.POST})
    @ResponseBody
    public void resultKey(HttpServletResponse response) {
        List<ScoreSummary> regular = scoreSummaryService.regularSummary();
        List<ScoreSummary> keyWork = scoreSummaryService.keyWorkSummary();
        Map<String, List<Double>> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            List<Double> list = new ArrayList<>();
            list.add(regular.get(i).getScore());
            list.add(keyWork.get(i).getScore());

            map.put(regular.get(i).getDepartment().getShortName(), list);
        }

        ResponseUtil.write(response, JSON.toJSONString(map));
    }

    @RequestMapping(value = "/result_satisfaction", method = {RequestMethod.POST})
    @ResponseBody
    public void resultSatisfaction(HttpServletResponse response) {
        List<ScoreSummary> satisfactionSuperior = scoreSummaryService.satisfactionSuperiorSummary(true);
        List<ScoreSummary> satisfactionService = scoreSummaryService.satisfactionServiceSummary(true);
        List<ScoreSummary> satisfactionSame = scoreSummaryService.satisfactionSameSummary(true);
        Map<String, List<Double>> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            List<Double> list = new ArrayList<>();
            list.add(satisfactionSuperior.get(i).getScore());
            list.add(satisfactionService.get(i).getScore());
            list.add(satisfactionSame.get(i).getScore());

            map.put(satisfactionSame.get(i).getDepartment().getShortName(), list);
        }

        ResponseUtil.write(response, JSON.toJSONString(map));
    }

    @RequestMapping(value = "/result_daily", method = {RequestMethod.POST})
    @ResponseBody
    public void resultDaily(int type, HttpServletResponse response) {
        Map map = new HashMap();
        map.put("indicator", type);
        List<RoutinePerformance> routinePerformances = routinePerformanceService.searchEvaluation(map);

        ResponseUtil.write(response, JSON.toJSONString(routinePerformances));
    }

    @RequestMapping(value = "/result_department_show", method = {RequestMethod.POST})
    @ResponseBody
    public void resultDepartmentShow(int department, HttpServletResponse response) {
        ScoreSummary regular = scoreSummaryService.regularSummary(department);
        ScoreSummary keyWork = scoreSummaryService.keyWorkSummary(department);
        ScoreSummary satisfactionSuperior = scoreSummaryService.satisfactionSuperiorSummary(department,false);
        ScoreSummary satisfactionService = scoreSummaryService.satisfactionServiceSummary(department,false);
        ScoreSummary satisfactionSame = scoreSummaryService.satisfactionSameSummary(department,false);
        ScoreSummary routineConstruction = scoreSummaryService.routineConstructionSummary(department);
        ScoreSummary routineWork = scoreSummaryService.routineWorkSummary(department);
        ScoreSummary contribution = scoreSummaryService.contributionSummary(department);
        ScoreSummary mistake = scoreSummaryService.mistakeSummary(department);
        Map<String, Double> map = new HashMap<>();
        map.put("关键绩效-常规工作", regular.getScore());
        map.put("关键绩效-重点工作", keyWork.getScore());
        map.put("关键绩效-上级评价", satisfactionSuperior.getScore());
        map.put("关键绩效-服务对象", satisfactionService.getScore());
        map.put("关键绩效-同级部门", satisfactionSame.getScore());
        map.put("日常绩效-作风建设", routineConstruction.getScore());
        map.put("日常绩效-工作条理", routineWork.getScore());
        map.put("例外绩效-突出贡献", contribution.getScore());
        map.put("例外绩效-严重失误", mistake.getScore());

        ResponseUtil.write(response, JSON.toJSONString(map));
    }

    @RequestMapping(value = "/detail_regular", method = {RequestMethod.POST})
    @ResponseBody
    public void resultRegular(@RequestParam Map map, HttpServletResponse response) {
        List<RegularWork> regularWorks = regularWorkService.searchEvaluation(map);
        Map<String, Double> result = new HashMap<>();
        for (RegularWork regularWork : regularWorks) {
            result.put(regularWork.getEvaluator().getName(), regularWork.getScore());
        }

        ResponseUtil.write(response, JSON.toJSONString(result));
    }

    @RequestMapping(value = "/detail_keywork", method = {RequestMethod.POST})
    @ResponseBody
    public void detailKeywork(@RequestParam Map map, HttpServletResponse response) {
        List<KeyWork> keyWorks = keyWorkService.searchByDpt(map);
        Map<String, Double> result = new HashMap<>();
        for (KeyWork keyWork : keyWorks) {
            result.put(keyWork.getEvaluator().getName(), keyWork.getScore());
        }

        ResponseUtil.write(response, JSON.toJSONString(result));
    }

    @RequestMapping(value = "/detail_routine", method = {RequestMethod.POST})
    @ResponseBody
    public void detailRoutine(@RequestParam Map map, HttpServletResponse response) {
        String assessments[][] = new String[][]{{"宣传思想政治工作", "队伍建设", "廉政建设", "制度建设"}, {"工作计划和总结报送的及时性", "工作台账规范性资料上交或部门归档", "安全保卫", "资产设备保管环境卫生", "经费预决算及规范使用"}};
        List<RoutinePerformance> routinePerformances = routinePerformanceService.searchEvaluation(map);
        Map<String, Double> result = new HashMap<>();
        for (RoutinePerformance routinePerformance : routinePerformances) {
            result.put(assessments[routinePerformance.getIndicator() - 1][routinePerformance.getElement() - 1], routinePerformance.getScore());
        }

        ResponseUtil.write(response, JSON.toJSONString(result));
    }

    @RequestMapping(value = "/detail_irregular", method = {RequestMethod.POST})
    @ResponseBody
    public void detailIrregular(@RequestParam Map map, HttpServletResponse response) {
        String assessments[][] = new String[][]{{"重大贡献", "奖励表彰"}, {"工作失误", "工作作风", "师德师风", "党风廉政", "审计问题", "安全工作"}};
       List<IrregularPerformance> irregularPerformances = irregularPerformanceService.searchEvaluation(map);

        Map<String, Double> result = new HashMap<>();
        double contribution = 0.0;
        double commendation = 0.0;
        for (IrregularPerformance irregularPerformance : irregularPerformances) {
            if (irregularPerformance.getFirst() == 1) {
                if (irregularPerformance.getSecond() == 1)
                    contribution += irregularPerformance.getScore();
                else
                    commendation += irregularPerformance.getScore();
            } else {
                result.put(assessments[irregularPerformance.getFirst() - 1][irregularPerformance.getSecond() - 1], irregularPerformance.getScore());
            }
        }

        if(Integer.parseInt(map.get("first").toString()) == 1) {
            result.put("重大贡献", contribution > 10 ? 10 : contribution);
            result.put("奖励表彰", commendation < -10 ? -10 : commendation);
        }

        ResponseUtil.write(response, JSON.toJSONString(result));
    }

}
