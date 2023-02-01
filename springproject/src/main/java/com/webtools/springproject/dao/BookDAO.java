package com.webtools.springproject.dao;

import java.util.List;


import com.webtools.springproject.pojo.Book;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Component;

@Component
public class BookDAO extends DAO {

	
	

	public BookDAO() {
		 
		 
	 }


	public boolean searchBook(int bookID, String bookName, String bookDescription, int bookPrice) throws Exception {
		try {

			SQLQuery query = getSession().createSQLQuery(
					"select * from user where bookID=:bookID and bookName=:bookName and bookDescription=:bookDescription and bookPrice=:bookPrice ");
			query.setInteger("bookID", bookID);
			query.setString("bookName", bookName);
			query.setString("bookDescription", bookDescription);
			query.setInteger("bookPrice", bookPrice);
			Object obj = query.uniqueResult();
			if (obj == null || obj.equals(null)) {
				return false;
			}

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Error while finidng User", e);
		} finally {
			close();
		}

		return true;

	}


public void save(Book book) {
	
	try {
       begin();
       getSession().save(book);
       commit();
   } catch (HibernateException e) {
   rollback();
   }
	
}

public List<Book> getall() {

    List<Book> book = null;
    try {
        Query query = getSession().createQuery("From Book");
        book = (List<Book>) query.list();
    } catch (HibernateException e) {
        e.printStackTrace();
    }

   return book;
}


public boolean delete(String id) {
	try
	{
	Book book = new Book();
	book.setBookID(Integer.parseInt(id));
	begin();
	getSession().delete(book);
	commit();
	return true;
	}
	catch(Exception e)
	{
		return false;
	}
}

public Book getdatabyid(String id) {
	
	Query query = getSession().createQuery("FROM Book where id = '"+id +"'");
	Book book = (Book) query.uniqueResult();
	return book;
}

public boolean update(Book book)
{
	try {
		begin();
	System.out.println("update Book set bookName= '"+book.getBookName() +"',"+"bookDescription= '"+book.getBookDescription()+"',"+"bookPrice= '"+book.getBookPrice()+"',userID= " +book.getUser().getUserID()+ " where id ="+book.getBookID());
        	   Query query = getSession().createQuery("update Book set bookName= '"+book.getBookName() +"',"+"bookDescription= '"+book.getBookDescription()+"',"+"bookPrice= '"+book.getBookPrice()+"',userID= " +book.getUser().getUserID()+ " where id ="+book.getBookID());
               int val = query.executeUpdate();
               commit();  
		
		return true;
	}
	catch(Exception e)
	{
		System.out.println(e);
	return false;
	}
}


public boolean updatestatus(String id) {
	
	try {
	begin();
	System.out.println("update Book set bookPrice= 1 where id ='"+id+"'");
        	   Query query = getSession().createQuery("update Book set bookPrice= 1 where id ='"+id+"'");
               int val = query.executeUpdate();
               commit();  
		
		return true;
	}
	catch(Exception e)
	{
		System.out.println(e);
	return false;
	}
}





public boolean updatereturnstatus(String id) {
	try {
		begin();
		System.out.println("update Book set bookPrice= 0 where id ='"+id+"'");
	        	   Query query = getSession().createQuery("update Book set bookPrice= 0 where id ='"+id+"'");
	               int val = query.executeUpdate();
	               commit();  
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		return false;
		}
}





}





