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
		//model.addAttribute("mark",targetService.findUser((String)request.getSession().getAttribute("account")));
		
		return ajaxReturn(response, null, "选择成功", 0);
	}
	
	@RequestMapping(value={"reset_pass"})
	public String deleteUser(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		String password=MD5String.getMD5Str("123456");
		int count = userService.reset_pass(userId,password);
		//System.out.println(123456);
		return ajaxReturn(response, count,"",1);
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
	@RequestMapping(value={"finish"})
	public String finish(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		String project=request.getParameter("project");
		project=new String(project.getBytes("ISO-8859-1"),"utf-8");
		
		model.addAttribute("project", pointService.detail(project));
		
		List<Row> detail=pointService.detail(project);
		List<Row> doit=pointService.findtarget(project);
		int zf=0;
		String[] t=doit.get(0).getString("target").split("\\@");
		ArrayList<String> target=new ArrayList<String>();
		for(int i=0;i<t.length;i++)
		{
			target.add(t[i]);
		}
		request.getSession().setAttribute("target",target);
		ArrayList<String> score=new ArrayList<String>();
		for(int i=0;i<detail.size();i++)
		{
		
		String[] s=detail.get(i).getString("point").split("\\@");
	//	System.out.println(s.toString());
		//request.getSession().setAttribute("length", s.length);
		int sum=0;
		for(int j=0;j<s.length;j++)
		{
			//System.out.println("这是第"+j+"个数据："+s[j]);
			score.add(s[j]);
		sum=Integer.valueOf(s[j])+sum;
		}
		zf+=sum;
		score.add(String.valueOf(sum));
		score.add("f");
		}
		//System.out.println(score.toString());
		request.getSession().setAttribute("score", score);
		request.getSession().setAttribute("zf", zf);
	return "admin/finish";
	}
	
}
