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
	
	@RequestMapping(value={"prolist"})
	public String prolist(Model model,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		
		model.addAttribute("mark",targetService.findUser((String)request.getSession().getAttribute("account")));
		
		return "admin/prolist";
	}

	@RequestMapping(value={"alluser"})
	public String alluser(Model model,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
	
		String project=request.getParameter("project");
		//System.out.println(project);
		project=new String(project.getBytes("ISO-8859-1"),"utf-8");
		request.getSession().setAttribute("project2", project);
		model.addAttribute("users",userService.findAllUser());
	
		
		return "admin/chose2";
	}
	@RequestMapping(value = "chose2",method=RequestMethod.POST)
	public String chose(Model model,HttpServletRequest request,HttpServletResponse response) {
		//System.out.println("chose2");
	//	String project =request.getParameter("project");
	//	System.out.println(project);
		String []a=request.getParameterValues("account");
		for(int i=0;i<a.length;i++)
		{
			if(pointService.isExist(a[i],(String)request.getSession().getAttribute("project2"))){continue;}
			else{
            Point p=new Point();
            p.setAccount(a[i]);
            p.setProject((String)request.getSession().getAttribute("project2"));
           pointService.save(p);}
	}
		return "admin/prolist";
	}
	@RequestMapping(value={"reset_pass"})
	public String resetPass(Model model,HttpServletRequest request,HttpServletResponse response,Integer id) throws Exception {
		model.addAttribute("users",userService.findAllUser());
		if (request.getMethod().equals("POST")) {
			
			
		}
		return "user/resetpass";
	}
	@RequestMapping(value={"test"})
	public String test(Model model,HttpServletRequest request,HttpServletResponse response) {
		return "user/test";
	}
	@RequestMapping(value={"test/test2"})
	public void test2(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();  
		List<Row> userList = userService.findAllUser();
		JSONObject jo = new JSONObject();
		jo.put("all_user", userList);

		out.write(jo.toString());
		//return ajaxReturn(response, jo,"",1);
	}
}
