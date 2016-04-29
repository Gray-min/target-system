package com.zlzkj.app.controller;

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

import com.zlzkj.app.model.Pic;
import com.zlzkj.app.model.Point;
import com.zlzkj.app.model.Target;
import com.zlzkj.app.model.User;
import com.zlzkj.app.service.PicService;
import com.zlzkj.app.service.UserService;
import com.zlzkj.app.service.TargetService;
import com.zlzkj.app.service.PointService;
import com.zlzkj.app.util.MD5String;
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
		System.out.println(project);
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
}
