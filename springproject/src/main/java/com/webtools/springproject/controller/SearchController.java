package com.webtools.springproject.controller;

import java.util.ArrayList;
import java.util.List;

import com.webtools.springproject.dao.SearchUserDAO;
import com.webtools.springproject.pojo.Book;
import com.webtools.springproject.pojo.InputValues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {


@Autowired
SearchUserDAO searchuserdao;

  private List<Book> allBooks;
  

  
   @RequestMapping(value="/autosearch")
   @ResponseBody
	public List<InputValues> Autosearch(@RequestParam(value="term", required = false, defaultValue="") String term)  {    
  
	   
	   List<InputValues> suggestions = new ArrayList<InputValues>();
		try {
			if (term.length() >= 3) {
				System.out.print("testttttttttttttttttttttttttttttttttttt");
				List<Book> name = (List<Book>) searchuserdao.fetch(term);
				
				for (Book book : name) {
					if (book.getBookName().contains(term)) {
						InputValues lblv = new InputValues();
						lblv.setLabel(book.getBookName());
						lblv.setValue(Long.toString(book.getBookID()));
						suggestions.add(lblv);
					}
				}
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Exception in autosearch");
		}	
		return suggestions;
		
		
}
}
