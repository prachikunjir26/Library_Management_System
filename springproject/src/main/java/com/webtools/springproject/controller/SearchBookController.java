package com.webtools.springproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.webtools.springproject.dao.SearchUserDAO;
import com.webtools.springproject.pojo.Book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchBookController {

	@RequestMapping(value = "/searchbook.htm", method = RequestMethod.POST)
	 public String login(HttpServletRequest request, SearchUserDAO searchuserdao, ModelMap model,HttpSession httpsession) throws Exception {
		
		HttpSession session = request.getSession();
		String bookName = request.getParameter("bookName");
		
		try {
			Book book  = searchuserdao.searchPost(bookName);
		
			if (book != null) {	
				httpsession.setAttribute("books",book);
				model.addAttribute("books", book);
				System.out.println(httpsession.getId());
			return "viewbook";

			}	

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "Welcome";
	}
//	
}
