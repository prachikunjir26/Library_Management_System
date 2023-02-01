package com.webtools.springproject.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.webtools.springproject.dao.BookDAO;
import com.webtools.springproject.dao.UserDAO;
import com.webtools.springproject.pojo.Book;

import com.webtools.springproject.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;


@Controller
public class Customer {


//	
	@Autowired
	BookDAO bookdao;
	@Autowired
	Book book;
//	
	
	
	
	
	 @GetMapping("/viewcust.htm")
	 public String viewproducts(HttpServletRequest request,HttpSession session,BookDAO bookdao)

	    {     
		 List<Book> book = (List<Book>) bookdao.getall();	
			session.setAttribute("books",book);
			System.out.println(request.getSession().getAttribute("books"));
	        return "customerview";

	    }
	 
	 @GetMapping("/lend.htm/{id}")
	 public String lend(@PathVariable String id,Model model,HttpServletRequest request,HttpSession session,BookDAO bookdao)

	    {    
		
		
		boolean isUpdate = bookdao.updatestatus(id);
		if(isUpdate) {
			Book book = bookdao.getdatabyid(id);
			request.setAttribute("book",book);
			model.addAttribute("book",book);
			 return "lendview";
		}  
		else {
			 return "lendview";
			}
	    }
	 
	 @GetMapping("/return.htm/{id}")
	 public String ret(@PathVariable String id,Model model,HttpServletRequest request,HttpSession session,BookDAO bookdao)

	    {    
		
		
		boolean isUpdate = bookdao.updatereturnstatus(id);
		if(isUpdate) {
			Book book = bookdao.getdatabyid(id);
			request.setAttribute("book",book);
			model.addAttribute("book",book);
			 return "returnview";
		}  
		else {
		 return "returnview";
		}
	    }
	 
	 
	
}
