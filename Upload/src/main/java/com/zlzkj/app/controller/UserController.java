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
	
	@RequestMapping(value={"info"})
	public String info(Model model,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		//model.addAttribute("users", userService.findAllUser());
		//System.out.println(request.getSession().getAttribute("account"));
		model.addAttribute("userinfo",userService.findUser((String)request.getSession().getAttribute("account")));
		
		//model.addAttribute("info", "下面是所有用户");
		return "user/info";
	}

	@RequestMapping(value = "modify_password")
	public String modify_password(Model model,HttpServletRequest request,HttpServletResponse response,User user) {
		String password=request.getParameter("password");
	  userService.modify_password(user.getAccount(),password);
		return "user/modify_password";
	}
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
//编写者：张佳旻