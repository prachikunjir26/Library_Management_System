package com.webtools.springproject.controller;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.webtools.springproject.dao.BookDAO;
import com.webtools.springproject.pojo.Book;
import com.webtools.springproject.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class BookController {
	
	@Autowired
	BookDAO bookdao;
//	
	@Autowired
	Book book;
//	
	
	@GetMapping("/bookdata.htm")
	public String addBookGet(ModelMap model, Book book) {
		// command object	
		model.addAttribute("book", book);
		// return form view
		return "bookdata";
	}
	
	 @PostMapping("/addedbooks.htm")
	public String addBookPost(@ModelAttribute("book") Book book, BindingResult result, HttpSession session,SessionStatus status,  BookDAO bookdao) {
		 String fileName = "img_" + System.currentTimeMillis() + "" + new Random().nextInt(100000000) + "" + new Random().nextInt(100000000) + ".jpg";
			book.setImageP(fileName);
			try {
				
				book.getImageF().transferTo(new File(System.getProperty("user.dir")+"\\src\\main\\webapp\\images\\"+fileName));
			} catch (IllegalStateException e1) {
				System.out.println("IllegalStateException: " + e1.getMessage());
			} catch (IOException e1) {
				System.out.println("IOException: " + e1.getMessage());
			}
		
			try {
				User user =  (User) session.getAttribute("user");
				book.setUser(user);
				bookdao.save(book);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			
			 return "redirect:/view.htm";
		
	}
	 
	 	@GetMapping("/view.htm")
	    public String viewproducts(HttpServletRequest request,HttpSession session,BookDAO bookdao)

	    {     

		 List<Book> book = (List<Book>) bookdao.getall();	
			session.setAttribute("book",book);
		
	        return "addedBooks";

	    }
	
	 
// Delete Logic 
	 
	    @GetMapping("/delete.htm/{id}")
		public String deleteproduct(BookDAO bookdao, @PathVariable String id)
		{
//	    	System.out.print("id-------"+id);
			boolean isDelete = bookdao.delete(id);
//			System.out.print("idel-------"+isDelete);
			
				return "redirect:/view.htm";
		}
	    
	    
// Update Logic
	    
	    @GetMapping("/update.htm/{id}")
		public String updateproduct(HttpServletRequest request,HttpSession session,@PathVariable String id,ModelMap model)
		{ 	
	    	
	    	Book book = bookdao.getdatabyid(id);
	    	request.setAttribute("book",book);
			model.addAttribute("book",book);
			return "editbookdata";
		}
		
	    @PostMapping("/update.htm")
		public String updateImage(@ModelAttribute("books")Book book,HttpSession session,HttpServletRequest request )
		{	
			book.setBookID(Integer.parseInt(request.getParameter("id")));
			System.out.print("inside update");
			User user =  (User) session.getAttribute("user");
			book.setUser(user);
			bookdao.update(book);
			return "redirect:/view.htm";
		}

	    
	    
	    
	    
		
}

