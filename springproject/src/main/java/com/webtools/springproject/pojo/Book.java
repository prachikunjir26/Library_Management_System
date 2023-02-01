package com.webtools.springproject.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.webtools.springproject.dao.BookDAO;
import com.webtools.springproject.pojo.User;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookID;
	private String bookName;
	private String bookDescription;
	private int bookPrice;
	private String imageP;
	
	@Transient
	private MultipartFile imageF;
	
	
	
	
	public MultipartFile getImageF() {
		return imageF;
	}

	public void setImageF(MultipartFile imageF) {
		this.imageF = imageF;
	}

	public String getImageP() {
		return imageP;
	}

	public void setImageP(String imageP) {
		this.imageP = imageP;
	}

	public int getBookID() {
		return bookID;
	}
	
	public Book() {
//		super();
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	@OneToOne
	@JoinColumn(name = "userID")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", bookName=" + bookName + ", bookDescription=" + bookDescription
				+ ", bookPrice=" + bookPrice + ", user=" + user + "]";
	}
	
}
