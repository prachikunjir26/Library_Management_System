package com.webtools.springproject.dao;



import java.util.List;

import com.webtools.springproject.pojo.Book;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

@Component
public class SearchUserDAO extends DAO{

	
	public List<Book> fetch(String temp) {
		

		List<Book> book = null;
        try {
        	Query query = getSession().createQuery("From Book");
        	book = (List<Book>) query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } 
		
		return book;
		
	}
	
	
	public Book searchPost(String bookName) {
		

		
    	Query query = getSession().createQuery("From Book where bookName = '"+bookName+"'");
    	Book book = (Book) query.uniqueResult();
    	return book;
	
}
	
	
//	public List<Image> searchimgbyser(String fname) {
//	
//	List<Image> image = null;
//	try {
//	Query query1 = getSession().createQuery(
//			"FROM User where firstName= '"+fname+ "'");
//
//	User user =  (User) query1.uniqueResult();
//	
//	int uid= user.getUserID();
//    
//    Query query = getSession().createQuery("From Image where user_userID = '"+uid+ "'");
//    
//    image = (List<Image>) query.list();
//    
//    } catch (HibernateException e) {
//        e.printStackTrace();
//    } 
//   return image;
//}
	
	
	public List<Book> searchbookname(String bname){
		
		List<Book> book = null;
		try {
			Query query1 = getSession().createQuery(
					"FROM Book where bookName= '"+bname+ "'");
		
			Book book1 =  (Book) query1.uniqueResult();
		
			int uid= book1.getBookID();
	  
		    book = (List<Book>) query1.list();
	    } catch (HibernateException e) {
	        e.printStackTrace();
	    }

	   return book;
	}
		
		
}
