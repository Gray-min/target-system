package com.zlzkj.app.controller;


import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zlzkj.app.model.User;
import com.zlzkj.app.service.PicService;
import com.zlzkj.app.service.UserService;
import com.zlzkj.app.service.TargetService;
import com.zlzkj.app.util.MD5String;
import com.zlzkj.core.base.BaseController;
import com.zlzkj.core.sql.Row;

/**
 * 首页控制器
 */
@Controller
public class IndexController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PicService picService;
	
	@Autowired
	private TargetService PointService;
	
	@Autowired
	private TargetService TargetService;
	
	@RequestMapping(value={"/"})
	public String index(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		return "index/index";
	}
	@RequestMapping(value={"welcome"})
	public String welcome(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		return "welcome/welcome";
	}
	/*@RequestMapping(value = "regist")
	public String regist(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		return "index/regist";
	}
*/
	/*@RequestMapping(value = "regist",method=RequestMethod.POST)
	public String registUser(Model model,HttpServletRequest request,HttpServletResponse response,User user) {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String mail=request.getParameter("mail");
		User value = userService.select_password(user.getAccount());
		if(value==null){
		//User user = new User();
		user.setAccount(account);
		user.setPassword(MD5String.getMD5Str(password));
		user.setMail(mail);
		userService.save(user);
		}	
		return "index/login";
	}*/
	@RequestMapping(value={"register"})
	public String registerUser(Model model,HttpServletRequest request,HttpServletResponse response,User entity) throws Exception {
		if (request.getMethod().equals("POST")) {
			if (userService.userNameIsExist(entity.getAccount())) {
				return ajaxReturn(response, null, "用户名已存在", 0);
			} else {
				//System.out.println(entity.getPassword());
				entity.setPassword(MD5String.getMD5Str(entity.getPassword()));
				//entity.setAddTime(Fn.time());
				int flag = userService.save(entity);
				System.out.println(flag);
				if (flag == 1) {
					return ajaxReturn(response, null, "添加成功", 1);
				} else {
					return ajaxReturn(response, null, "添加失败", 0);
				}
			}
		} else {
			return "index/login";
		}
	}
	/*@RequestMapping(value = "login")
	public String login(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		return "index/login";
	}*/
	
	/*@RequestMapping(value = "login",method=RequestMethod.POST)
	public String loginUser(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session,User user) {
		String account = request.getParameter("account");
	String password = request.getParameter("password");
		//String account = user.getAccount();
	//	String password = user.getPassword();
		System.out.println(password);
		List<Row> list = userService.findUser(account);
		 //System.out.println( list.get(0).getString("password"));
		request.getSession().setAttribute("name", list.get(0).getString("name"));
		request.getSession().setAttribute("account", account);
		if(list.size()<1){
			return "index/index";}
		else if(list.get(0).getInt("role")==1){
			session.setAttribute("seesion_member", list.get(0).getString("role"));
			return "admin/admin";
		}
		else if(list.get(0).getInt("role")==2&&list.get(0).getString("password").equals(password)){
			
			session.setAttribute("seesion_member", list.get(0).getString("role"));
			
			return "index/index";
		}
			return "index/login";
	}*/
	@RequestMapping(value = { "login" })
	public String login(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		if (request.getMethod() == "POST") {
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			System.out.println(MD5String.getMD5Str(password));
			if (userService.checkLogin(account, MD5String.getMD5Str(password))) {
				/*User user = userService.findById(userService.loginId(
						account, MD5String.getMD5Str(password)));*/
				//int roleId = user.getRole();
				request.getSession().setAttribute("account", account);// 登录成功放入session的内容，供前端页面访问
				//request.getSession().setAttribute("roleId",roleId);
				List<Row> list = userService.findUser(account);
			request.getSession().setAttribute("name",list.get(0).getString("name"));
			   
				return "index/index";
			} else
				//return ajaxReturn(response, null, "账号或密码错误", 0);
				return "index/login";
		} else {
			return "index/login";
		}
	}
	@RequestMapping(value = { "logout" })
	public String logout(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		Enumeration<String> em = request.getSession().getAttributeNames();
		// System.out.println(request.getSession().getAttributeNames());
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement());
		}
		request.getSession().invalidate();
		return "index/login";
	}
	/*@RequestMapping(value={"/admin"})
	public String admin(Model model,HttpServletRequest request,HttpServletResponse response) {
		return "admin/admin";
	}*/
	
	@RequestMapping(value={"/user"})
	public String User(Model model,HttpServletRequest request,HttpServletResponse response) {
		

		
		return "user/login";
	}	
}
