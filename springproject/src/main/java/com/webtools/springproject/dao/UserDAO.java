package com.webtools.springproject.dao;

import com.webtools.springproject.pojo.User;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Component;


@Component
public class UserDAO extends DAO {

	 public UserDAO() {
		 
		 
	 }
	 
		public User findUser(String username) throws Exception {
			try {

				Query query = getSession().createQuery(
						"FROM User where UserName= '"+username+ "'");
				query.setMaxResults(1);
				User user =  (User) query.uniqueResult();
				return user;

			} catch (HibernateException e) {
				rollback();
				throw new Exception("Error while finidng User", e);
			} finally {
				close();
			}

		}
	
	 

	    
	    
	    public void delete(User user)
	    {
	        try {
	            begin();
	            getSession().delete(user);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            
	        }
	    }

//		public void save(User user) {
//		     try {
//		            begin();
//		            getSession().save(user);
//		            commit();
//		        } catch (HibernateException e) {
//		        rollback();
//		        }
//			
//		}

		public void save(User user) {
			
			try {
	            begin();
	            getSession().save(user);
	            commit();
	        } catch (HibernateException e) {
	        rollback();
	        }
			
		}

		
	
	    
}
