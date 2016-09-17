package com.zlzkj.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.zlzkj.app.model.Pic;
import com.zlzkj.app.model.Point;
import com.zlzkj.app.model.Target;
import com.zlzkj.app.model.User;
import com.zlzkj.app.service.PicService;
import com.zlzkj.app.service.UserService;
import com.zlzkj.app.service.TargetService;
import com.zlzkj.app.service.PointService;
import com.zlzkj.app.util.MD5String;
import com.zlzkj.app.util.Param2Bean;
import com.zlzkj.app.util.StringUtil;
import com.zlzkj.app.util.UIUtils;
import com.zlzkj.app.util.UploadUtils;
import com.zlzkj.core.base.BaseController;
import com.zlzkj.core.sql.Row;
@Controller
public class AdminController extends BaseController {
	
	@Autowired
	private TargetService targetService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private PointService pointService;
	
	
	
	@RequestMapping(value={"reset_pass"})
	public String deleteUser(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		String password=MD5String.getMD5Str("123456");
		int count = userService.reset_pass(userId,password);
		//System.out.println(123456);
		return ajaxReturn(response, count,"",1);
	}
}

//编写者：张佳旻