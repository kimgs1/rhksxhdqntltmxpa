

package controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.content.dao.ContentInfoDao;
import pasing.ContentInfoPagingBean;

@Controller
public class ContentInfoController {
	@Autowired
	ContentInfoDao contentInfoDao;
	@RequestMapping(value="/contentinfo", method=RequestMethod.GET)
	public ModelAndView baseView() throws Exception {
		return new ModelAndView("contentinfo_List");
	}
	@RequestMapping(value = "/contentinfo_content", method=RequestMethod.GET)
	public ModelAndView getContentInfoByUrl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", request.getParameter("id"));
		HashMap<String,Object> result = contentInfoDao.getContent(param);
		return new ModelAndView("contentinfo_view", "result", result);
	}
	@RequestMapping(value="/contentinfo_create", method=RequestMethod.GET)
	public ModelAndView ContentInfoCreateView() throws Exception {
		return new ModelAndView("contentinfo_create");
	}
	@RequestMapping(value = "/contentinfo_edit", method=RequestMethod.GET)
	public ModelAndView ContentInfoEditView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", request.getParameter("id"));
		HashMap<String,Object> result = contentInfoDao.getContent(param);
		return new ModelAndView("contentinfo_edit", "result", result);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/contentinfo.do", params="command=create")
	public ModelAndView createContentInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("subject", request.getParameter("subject"));
		param.put("Contents", request.getParameter("Contents"));
		param.put("FileName", request.getParameter("FileName"));
		String userid = (String)((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id");
		param.put("userid", userid);
		HashMap<String,Object> result = contentInfoDao.createContentInfo(param);
		return new ModelAndView("JsonView", "result", result);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/contentinfo.do", params="command=edit")
	public ModelAndView editContentInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();

		param.put("id", request.getParameter("id"));
		param.put("subject", request.getParameter("subject"));
		param.put("Contents", request.getParameter("Contents"));
		param.put("FileName", request.getParameter("FileName"));
		String userid = (String)((HashMap<String, Object>)request.getSession().getAttribute("userInfo")).get("id");
		param.put("userid", userid);
		HashMap<String,Object> result = contentInfoDao.editContentInfo(param);
		return new ModelAndView("JsonView", "result", result);
	}
	@RequestMapping(value="/contentinfo.do", params="command=getList")
	public ModelAndView getContentInfoList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("low",0);
		param.put("high",5);
		param.put("nowPage", "1");
		HashMap<String,Object> result = contentInfoDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	@RequestMapping(value="/contentinfo.do", params="command=getListPaging")
	public ModelAndView getContentInfoListPaging(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		String nowPageStr = request.getParameter("nowPage");
		if(nowPageStr== null || nowPageStr.toString().equals("")){
			nowPageStr = "1";
		}
		int nowPage = Integer.parseInt(nowPageStr);
		param.put("nowPage", nowPage);
		param.put("low",(ContentInfoPagingBean.numberOfContentPerPage * (nowPage - 1)));
		param.put("high",(ContentInfoPagingBean.numberOfContentPerPage * nowPage));
		HashMap<String,Object> result = contentInfoDao.getList(param);
		return new ModelAndView("JsonView", "result", result);
	}
	@RequestMapping(value="/contentinfo.do", params="command=getContent")
	public ModelAndView getContentInfoContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", request.getParameter("id"));
		HashMap<String,Object> result = contentInfoDao.getContent(param);
		return new ModelAndView("JsonView", "result", result);
	}
	@RequestMapping(value="/contentinfo.do", params="command=delete")
	public ModelAndView deleteContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("id", request.getParameter("id"));
		HashMap<String,Object> result = contentInfoDao.delete(param);
		return new ModelAndView("JsonView", "result", result);
	}
	@RequestMapping(value="/uploadContentFile",produces="application/text;charset=utf8")  
	@ResponseBody  
	public String uploadFile(@RequestParam("uploadFile") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {  
	    String path = "C:\\UploadFiles\\";
	    String FileName = request.getParameter("uploadFileName");
	    String resMsg = "";
	    try {
	        long  startTime=System.currentTimeMillis();
	        System.out.println("fileName："+file.getOriginalFilename());
	        path += startTime+"_"+FileName;
	        System.out.println("path:" + path);
	        File newFile=new File(path);
	        newFile.deleteOnExit();
	        file.transferTo(new File(path));
	        long  endTime=System.currentTimeMillis();
	        System.out.println("근무시간："+String.valueOf(endTime-startTime)+"ms");
	        resMsg = startTime+"_"+FileName;
	    } catch (IllegalStateException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        resMsg = "0";
	    }
	    return resMsg; 
	} 
}
