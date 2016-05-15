package com.zlzkj.app.Interceptor;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;




/*import com.zlzkj.app.service.BaseUrlService;
import com.zlzkj.app.service.DictService;*/
import com.zlzkj.app.util.DynamicDataSource;
import com.zlzkj.core.sql.Row;


/**
 * 核心拦截器，配置request的一些初始值
 * @author Simon
 *
 */
public class CoreInterceptor implements HandlerInterceptor{
	/*
	@Autowired
	private DictService dictService;
	
	@Autowired
	private BaseUrlService baseUrlService;*/
	
	@Autowired 
	CookieLocaleResolver resolver;
	
	//@Autowired SessionLocaleResolver resolver;
	
	/*
	 * 拦截器白名单列表
	 */
	public String[] exclude; 
	
	public void setExclude(String[] exclude) {
		this.exclude = exclude;
	}
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//动态数据源切换
		if(request.getSession().getAttribute("language")==null){
			Locale locale = RequestContextUtils.getLocaleResolver(request) .resolveLocale(request);  
			DynamicDataSource.setCurrentLookupKey(locale.getLanguage());
			if(locale.getLanguage().contains("zh")){
				request.getSession().setAttribute("language", "zh_CN");
				resolver.setLocale(request, response, Locale.CHINA );
			}
			else{
				request.getSession().setAttribute("language", "en");
				resolver.setLocale(request, response, Locale.ENGLISH );
			}
			//System.out.println("locale1=="+locale.getLanguage());
		}else{
			String language = String.valueOf(request.getSession().getAttribute("language"));
			if(language.contains("zh")){
				DynamicDataSource.setCurrentLookupKey("zh");
				resolver.setLocale(request, response, Locale.CHINA );
			}
			else{
				DynamicDataSource.setCurrentLookupKey("en");
				resolver.setLocale(request, response, Locale.ENGLISH );
			}
			//System.out.println("locale2=="+request.getSession().getAttribute("language"));
		}
		
		String language = null;
		if(( language = request.getParameter("language"))!=null){
			if(language.contains("zh")){
				DynamicDataSource.setCurrentLookupKey("zh");
				resolver.setLocale(request, response, Locale.CHINA );
			}
			else{
				DynamicDataSource.setCurrentLookupKey("en");
				resolver.setLocale(request, response, Locale.ENGLISH );
			}
			request.getSession().setAttribute("language", language);
			//System.out.println("locale3=="+language);
		}
		//白名单放行
		if(exclude!=null && exclude.length!=0){
			String uri = request.getRequestURI().substring(request.getContextPath().length());
			for(String one:exclude){
				if(uri.startsWith(one)){
					return true;
				}
			}
		}
		/*
		//解析url验证是否显示左侧
		//String path = request.getServletPath();  
        //String[] str = path.split("/");
         //拦截地址清单, 如果请求中是以以下路径开头，则进行拦截
        String[] urls = {
       * 
        };
		if(request.getAttribute("url")==null){//如果没有获取友情链接数据，则重新获取
			//友情链接数据
//			List<Row> rowlst = dictService.getTypeList("url_type");
//					
//			for(Row row : rowlst){
//				String item_value = row.getString("id");
				List<Row> urlList = baseUrlService.getUrlListByType("Links");
				//row.put("list", urlList);
			//}
			request.setAttribute("url", urlList);
		}*/
		
      if(request.getSession().getAttribute("account") != null){
        	//System.out.println(1);
    	  return true;
        }else{
        	response.sendRedirect(request.getContextPath() + "/index/login");
        }
        
		return true;}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
