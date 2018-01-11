package controller;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import model.login.dao.LoginDao;

@Controller
public class LoginController extends MultiActionController{
	
	@Autowired
	public LoginDao loginDao;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView moveLogin() throws Exception {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/login",params="command=checkPW")
	public ModelAndView checkPW() throws Exception {
		return new ModelAndView("views/logview");
	}
	
	@RequestMapping(value="/login.do", params="command=checkRem", method=RequestMethod.POST)
	public ModelAndView checkRem(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String rid = "";
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("rid")) rid = cookie.getValue();
		}
		return new ModelAndView("JsonView", "rid", rid);
	}
	
	@RequestMapping(value="/login", params="command=login", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, String> usermap = new HashMap<String, String>();
		usermap.put("userid", request.getParameter("txtUserId"));
		usermap.put("userpw", request.getParameter("txtUserPwd"));
		usermap.put("remCheck", request.getParameter("remCheck"));
		HashMap<String, Object> check = loginDao.checkLogin(usermap);
		if ((Boolean) check.get("login")) {
			request.getSession().setAttribute("userInfo", check);
			if (usermap.get("remCheck").equals("true")) {
				Cookie cookie = new Cookie("rid", usermap.get("userid"));
			    cookie.setMaxAge(720*60*60);
			    response.addCookie(cookie);
			} else {
				Cookie[] cookies = request.getCookies();
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("rid")) {
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
			return new ModelAndView("home");
		} else {
			return new ModelAndView("login", "check", check);	
		}
	}

	@RequestMapping(value="/login", params="command=newMember", method=RequestMethod.POST)
	public ModelAndView newMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("newMember");
	}
	
	@RequestMapping(value="/login", params="command=newMemberUpload", method=RequestMethod.POST)
	public ModelAndView newMemberUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("userid", request.getParameter("userId"));
		param.put("username", request.getParameter("userName"));
		param.put("password", request.getParameter("password"));
		param.put("email", request.getParameter("email"));
//		param.put("company", request.getParameter("company"));
		param.put("phone", request.getParameter("phone"));
		param.put("mobile", request.getParameter("mobile"));
		param.put("address", request.getParameter("address"));
		param.put("IP", "");
		param.put("mac", "");
		int result = loginDao.newMemberUpload(param);
		if(result > 0){
			return new ModelAndView("JsonView", "result","success" );
		}else{
			return new ModelAndView("JsonView", "result","fail" );			
		}
		
	}
	

}
