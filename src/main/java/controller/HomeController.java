package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import model.codeinfo.dao.CodeInfoDao;

@Controller
public class HomeController extends MultiActionController{

	@Autowired
	public CodeInfoDao codeInfoDao;
	

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView baseView() throws Exception {
		return new ModelAndView("home");
	}
	@RequestMapping(value="/home.do", params="command=logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().removeAttribute("userInfo");
		return new ModelAndView("home");
	}
	
	
	@RequestMapping(value="/home.do", params="command=getCodeAllInfo", method=RequestMethod.POST)
	public ModelAndView getCodeAllInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String,Object> result = codeInfoDao.getCodeAllInfo(null);
		return new ModelAndView("JsonView","result",result);
	}
	
	@RequestMapping(value="/home.do", params="command=getPDFFiles", method=RequestMethod.POST)
	public ModelAndView getPDFFiles(HttpServletRequest request, HttpServletResponse response) throws Exception {

	        response.setContentType("application/pdf");
	        FileInputStream in = new FileInputStream(new File("d:/1.pdf"));
	        OutputStream out = response.getOutputStream();
	        byte[] b = new byte[512];
	        while ((in.read(b)) != -1) {
	            out.write(b);
	        }
	        out.flush();
	        in.close();
	        out.close();
	        return new ModelAndView();
//		return new ModelAndView("JsonView","result",result);
	}
	
}	