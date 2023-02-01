package com.webtools.springproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.webtools.springproject.dao.UserDAO;
import com.webtools.springproject.pojo.User;
import com.webtools.springproject.validator.UserFormValidator;
@Controller
public class UserFormController {
	@Autowired
	UserDAO userdao;
	@Autowired
	User user;
	
	  
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    
    UserFormValidator validator;

	
	
	
@PostMapping("/login.htm")	
public String loginuser(HttpServletRequest request, UserDAO userdao, ModelMap model, User user,HttpSession httpsession) throws Exception {
	
//	HttpSession session = request.getSession();
	String userName = request.getParameter("UserName");
	String userPassword = request.getParameter("UserPass");

	try {

		User userdata = userdao.findUser(userName);
		
		boolean istrue = passwordEncoder.matches(userPassword, userdata.getUserPass());	
			
			if (userdata != null && istrue && userdata.getUserType().equalsIgnoreCase("admin")) {
				System.out.println("Login is done successfuly");
				httpsession.setAttribute("user",userdata);
				model.addAttribute("user", user);
				System.out.println(httpsession.getId());
				return "bookdata";
				
			}	
			
			if (userdata != null && istrue && userdata.getUserType().equalsIgnoreCase("user")) {
				httpsession.setAttribute("user",userdata);
				model.addAttribute("user", user);
				System.out.println(httpsession.getId());
				return "customer";
				
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "Welcome";
	
		
	}
	
	
	
	
	
	@GetMapping("/")
	public String addUserGet(ModelMap model, User user) {
		// command object	
		model.addAttribute("user", user);
		// return form view
		return "signup";
	}
	
	@GetMapping("/signup.htm")
	public String addUser(ModelMap model, User user) {
		// command object	
		model.addAttribute("user", user);
		// return form view
		return "signup";
	}
	
	@GetMapping("/log.htm")
	public String add(ModelMap model, User user) {
		// command object	
		model.addAttribute("user", user);
		// return form view
		return "login";
	}
	
	@PostMapping("/adduser.htm")
	public String addUserPost(@ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDAO userdao) {
		
		validator.validate(user, result);

        if(result.hasErrors())

        {

            System.out.print("Please check firstname and lastname");

            return "redirect:signup.htm";

        }

        else {
		 user.setUserPass(passwordEncoder.encode( user.getUserPass()));
		userdao.save(user);
		
		status.setComplete(); //mark it complete
		return "login";
        }
		
	}
	
	
	
	@GetMapping("/orderbook.htm")
	public String addCustomerGet(ModelMap model, User user) {
		// command object	
		model.addAttribute("user", user);
		// return form view
		return "customer";
	}
	
	@GetMapping("/logout.htm")
	public String logout(HttpSession httpsession,HttpServletRequest request)
	{ 
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "redirect:signup.htm";
	}
	
	
	
}
