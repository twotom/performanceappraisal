package cn.js.ccit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import cn.js.ccit.service.RegularWorkService;
import cn.js.ccit.util.ResponseUtil;
import cn.js.ccit.model.RegularWork;
import cn.js.ccit.service.RegularWorkService;
import cn.js.ccit.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;


@Controller
public class RegularWorkController {
	@Autowired
	private RegularWorkService regularWorkService;
	
	
	/*
	 * 打分
	 */
	@RequestMapping(value ="/doEvaluate", method = {RequestMethod.POST })
	@ResponseBody
	public void doEvaluate(@RequestBody List<RegularWork> regularWorks, HttpServletResponse response ){
		regularWorkService.doEvaluate(regularWorks);
	}
	@RequestMapping(value ="/searchEvaluation", method = {RequestMethod.POST })
	@ResponseBody
	public void searchEvaluation(Map map,HttpServletResponse response){
		ResponseUtil.write(response, JSON.toJSONString( regularWorkService.searchEvaluation(map)));
	}
	
}
