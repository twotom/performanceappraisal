package cn.js.ccit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.js.ccit.util.ImageUtil;
import cn.js.ccit.util.ResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.js.ccit.util.GenerateVerifyCodeUtil;



public class ValidateImageController {
	@RequestMapping(value = "validateImage", method = RequestMethod.GET)
	@ResponseBody
	public void validateImage(HttpServletResponse response, HttpSession session) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("image/jpeg");
		String code = GenerateVerifyCodeUtil.generateVerifyCode(4);

		session.setAttribute("code", code.toLowerCase());
		try {
			ImageUtil.outputImage(104, 34, response.getOutputStream(), code);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("validateCode")
	@ResponseBody
	public void validateCode(String code, HttpServletResponse response,
			HttpSession session) {
		if (!code.toLowerCase().equals(session.getAttribute("phoneCode")))
			ResponseUtil.write(response, "验证码错误！");
		else {
			session.removeAttribute("tempEmployee");
			ResponseUtil.write(response, "true");
		}
	}

}
