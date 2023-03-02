package org.comstudy.myweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy.myweb.saram.model.SaramDAO;
import org.comstudy.myweb.saram.model.SaramDTO;

public class SaramController implements Controller {
	SaramDAO dao = new SaramDAO();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// String으로 다운 캐스팅
		String path = (String)req.getAttribute("path");
		
		String viewName = "/WEB-INF/views/home.jsp";
		if(path.indexOf("/input.do") != -1) {
			viewName = "/WEB-INF/views/saram/input.jsp";
		} else if(path.indexOf("/detail.do") != -1) {
			viewName = "/WEB-INF/views/saram/detail.jsp";
		} else if(path.indexOf("/modify.do") != -1) {
			SaramDTO dto = new SaramDTO();
			// 링크에서 쿼리스트링으로 전달 된 seq 값을 받아서 검색한다.
			dto.setSeq(Integer.parseInt(req.getParameter("seq") ) );
			SaramDTO saram = dao.findOne(dto);
			req.setAttribute("saram", saram);
			viewName = "/WEB-INF/views/saram/modify.jsp";
		} else {
			List<SaramDTO> list = dao.findAll();
			req.setAttribute("list", list);
			viewName = "/WEB-INF/views/saram/list.jsp";
		}
		return viewName;
	}
}
