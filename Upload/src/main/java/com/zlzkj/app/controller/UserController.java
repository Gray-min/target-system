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

/**
 * 用户控制器
 */
@Controller
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	
	@Autowired
	private PicService picService;
	
	@Autowired
	private PointService PointService;
	
	@Autowired
	private TargetService TargetService;
	
	@RequestMapping(value={"savepic"},method=RequestMethod.POST)
	public String info(Model model,HttpServletRequest request,HttpServletResponse response
			,@RequestParam("ImportFile") MultipartFile uploadFile) {
		
		String workPath = UploadUtils.getConfig("FILE_REPOSITORY");
		
		Map<String,Object> info = UploadUtils.saveMultipartFile(uploadFile);
			
		int status = Integer.valueOf(info.get("status").toString());
		if(status>0){
			String FileName = UploadUtils.parseFileUrl(info.get("saveName").toString());
			System.out.println(FileName);
			
			
			String FilePath =workPath+ FileName.substring(workPath.length()-1, FileName.length());
			
			
			userService.savepic(FileName,(String)request.getSession().getAttribute("account"));
			model.addAttribute("userinfo",userService.findUser((String)request.getSession().getAttribute("account")));
			System.out.println("图片绝对路径："+FilePath);
		}
		return "user/info";
	}
	
/*	@RequestMapping(value={"/findpic"})
	public String findPic(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		model.addAttribute("Pic",picService.findALL());
		return "index/show_pic";
	}*/
	@RequestMapping(value = "add")
	public String add(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		return "user/add";
	}
	@RequestMapping(value = "add2")
	public String add2(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		return "user/add2";
	}
	@RequestMapping(value = "doit")
	public String doit(Model model,HttpServletRequest request,HttpServletResponse response) {
		String project=request.getParameter("project");
		try {
			project=new String(project.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//System.out.println(project);
		List<Row> doit=PointService.findtarget(project);
		String[] t=doit.get(0).getString("target").split("\\@");
		String[] s=doit.get(0).getString("score").split("\\@");
		
		ArrayList<String> target=new ArrayList<String>();
		for(int i=0;i<t.length;i++)
		{
			target.add(t[i]);
		
		}
		
		ArrayList<String> score=new ArrayList<String>();
		for(int i=0;i<s.length;i++)
		{
			score.add("总分：");
			score.add(s[i]);
			score.add("<select id='point' style='width:100px;'>");
			for(int j=Integer.valueOf(s[i]);j>=0;j--)
			{
				score.add("<option>"+String.valueOf(j)+"</option>");
				//score.add(String.valueOf(j));
				//score.add("</option>");
			}
			score.add("</select>");
			score.add("f");
		}
		request.getSession().setAttribute("target",target);
		request.getSession().setAttribute("score", score);
		model.addAttribute("doit",PointService.findtarget(project));
		return "user/doit";
	}
/*	@RequestMapping(value = "info")
	public String info(Model model,HttpServletRequest request,HttpServletResponse response) {
		List<Row> userinfo = userService.findUser((String)request.getSession().getAttribute("account"));
		//request.getSession().setAttribute("userinfo", userinfo);
		//User userinfo = userService.select_userinfo(user);
		request.getSession().setAttribute("name",userinfo.get(0).getString("name"));
		return "user/info";
	}*/
	@RequestMapping(value={"info"})
	public String info(Model model,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		//model.addAttribute("users", userService.findAllUser());
		//System.out.println(request.getSession().getAttribute("account"));
		model.addAttribute("userinfo",userService.findUser((String)request.getSession().getAttribute("account")));
		
		//model.addAttribute("info", "下面是所有用户");
		return "user/info";
	}
	@RequestMapping(value = "add",method=RequestMethod.POST)
	public String addtarget(Model model,HttpServletRequest request,HttpServletResponse response) {
		String[] ta = request.getParameterValues("target");
		String[] s =request.getParameterValues("score");
		String project =request.getParameter("project");
		request.getSession().setAttribute("project", project);
		 String target="";
         for(int i=0;i<ta.length;i++)
         {
         if(i==ta.length-1){target=target+ta[i];}
         else{
         target=target+ta[i]+"@";}
         //System.out.println(target[i]);
         }
         String score="";
         for(int i=0;i<s.length;i++)
         {
         if(i==s.length-1){score=score+s[i];}
         else{
         score=score+s[i]+"@";}
         }
		Target t = new Target();
		t.setTarget(target);
		t.setScore(score);
		t.setProject(project);
		t.setAccount((String)request.getSession().getAttribute("account"));
		TargetService.save(t);
		model.addAttribute("users",userService.findAllUser());
		
		return "user/chose";
	}
	@RequestMapping(value = "point",method=RequestMethod.POST)
	public String point(Model model,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String[] p = request.getParameterValues("point");
	    //p=new String(p.getBytes("ISO-8859-1"),"utf-8");
		String project =request.getParameter("project");
		 String point="";
         for(int i=0;i<p.length;i++)
         {
        	// p[i]=new String(p[i].getBytes("ISO-8859-1"),"utf-8");
        	//p[i].replaceAll(" ", "");
        	//p[i].trim();
        System.out.println(p[i]);
         if(i==p.length-1){point=point+p[i];}
         else{
        point=point+p[i]+"@";}
         //System.out.println(target[i]);
         }
		//Point po=new Point();
      List<Row> l=PointService.isFinish(project);
      if(l.size()<=1){
    	  PointService.savepoint((String)request.getSession().getAttribute("account"), project,point);
    	  TargetService.finishtarget(project);
      }
      else{ 
    	  PointService.savepoint((String)request.getSession().getAttribute("account"), project,point);
      }
		
      return ajaxReturn(response, null, "打分成功", 0);
	}
	@RequestMapping(value = "chose",method=RequestMethod.POST)
	public String chose(Model model,HttpServletRequest request,HttpServletResponse response) {
		String []a=request.getParameterValues("account");
		for(int i=0;i<a.length;i++)
		{
            Point p=new Point();
            p.setAccount(a[i]);
            p.setProject((String)request.getSession().getAttribute("project"));
           PointService.save(p);
	}
		return "user/add";
	}
	@RequestMapping(value={"join"})
	public String join(Model model,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		
	/*	System.out.println(23333);
		System.out.println(request.getSession().getAttribute("account"));*/
		model.addAttribute("mark",PointService.findUser((String)request.getSession().getAttribute("account")));
		
		return "user/join";
	}
	@RequestMapping(value = "prove")
	public String prove(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		return "user/prove";
	}
	@RequestMapping(value = "modify_password")
	public String modify_password(Model model,HttpServletRequest request,HttpServletResponse response,User user) {
		String password=request.getParameter("password");
	  userService.modify_password(user.getAccount(),password);
		return "user/modify_password";
	}
	/*@RequestMapping(value = "check",method=RequestMethod.POST)
	public String check(Model model,HttpServletRequest request,HttpServletResponse response,User user) {
		String answer1= request.getParameter("answer1");
		String answer2= request.getParameter("answer2");
		String answer3= request.getParameter("answer3");
		System.out.println(answer1);
		List<Row> list = userService.findUser((String)request.getSession().getAttribute("account"));
		//System.out.println(request.getSession().getAttribute("account"));
		//System.out.println(list.get(0).getString("answer1"));
		if(list.get(0).getString("answer1").equals(answer1)&&list.get(0).getString("answer2").equals(answer2)&&list.get(0).getString("answer3").equals(answer3)){
			return "user/modify_password";
		}
		return "user/prove";
	}*/
/*	@RequestMapping(value = "change_pass")
	public String changePass(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		return "user/change_pass";
	}*/
	@RequestMapping(value={"change_pass"})
	public String changePass(Model model,HttpServletRequest request,HttpServletResponse response,String name,
			String OPass, String NPass) throws Exception {
		if (request.getMethod().equals("POST")) {
			HashMap<String, Object> where = new HashMap<String, Object>();
			where.put("account", request.getSession().getAttribute("account"));
			where.put("password",MD5String.getMD5Str(request.getParameter("OPass")));
			User user = userService.getObjByProperties(where);
			if (StringUtil.isEmpty(user))
				return ajaxReturn(response, null, "原密码错误", 0);
			else {
				user.setPassword(MD5String.getMD5Str(request.getParameter("NPass")));
				int temp = userService.update(user);
				if (temp == 1)
					return ajaxReturn(response, null, "修改成功", 1);
				else
					return ajaxReturn(response, null, "修改失败", 0);
			}
		}
		return "user/change_pass";
	}
	@RequestMapping(value = "modify_info")
	public String modifyinfo(Model model,HttpServletRequest request,HttpServletResponse response) {
		model.addAttribute("userinfo",userService.findUser((String)request.getSession().getAttribute("account")));
		return "user/modify_info";
	}
	
	@RequestMapping(value="revise_info")
	public String reviseinfo(Model model,HttpServletRequest request,HttpServletResponse response,User user){
		user.setId(Integer.valueOf(request.getParameter("id")));
		//user.setAccount(request.getParameter("account"));
		user.setName(request.getParameter("name"));
		user.setAge(Integer.valueOf(request.getParameter("age")));
		user.setGender(request.getParameter("gender"));
		//System.out.println(request.getParameter("gender"));
		user.setBirth(request.getParameter("birth"));
		user.setPhone(request.getParameter("phone"));
		userService.updateSelective(user);
		return ajaxReturn(response, null, "修改成功", 1);
		
	}
}
