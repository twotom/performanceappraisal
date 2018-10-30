package cn.js.ccit.controller;

import cn.js.ccit.service.SystemTimeService;
import cn.js.ccit.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

@Controller
public class SystemTimeController {
    @Autowired
    private SystemTimeService systemTimeService;

    @RequestMapping("/setTime")
    @ResponseBody
    private void setTime(long time, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Timestamp timestamp = new Timestamp(time);
        systemTimeService.update(timestamp);
        ResponseUtil.write(response, "Y");
    }

}
