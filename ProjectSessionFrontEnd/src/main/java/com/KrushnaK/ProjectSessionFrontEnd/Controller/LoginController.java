package com.KrushnaK.ProjectSessionFrontEnd.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.KrushnaK.ProjectSessionFrontEnd.Model.Contact;
import com.KrushnaK.ProjectSessionFrontEnd.Model.Login;

@Controller
public class LoginController {

	@Autowired // globaly creted object sf;
	SessionFactory sf;

	@RequestMapping("/") // localhost:8080.
	public String Login() {
		return "krushna"; // login
	}

	@RequestMapping("/krushnapage") // localhost:8080.
	public String Loginpage() {
		return "krushna"; // login
	}

	@RequestMapping("krushna")
	public String LoginDB(Login login) {

		Session ss = sf.openSession();
		Login dblogin = ss.get(Login.class, login.getPassword());// getpasswrd is PrimaryKey //dblogin ref variable Is
																	// Login class

		// work InDatabaseLoginCheck<-- //getM()<--Single
		// RecordPostGeUpdateDelete
		if (login.getUsername().equals(dblogin.getUsername())) {
			return "home";
		} else {
			return "krushna";
		}

	}

	@RequestMapping("createaccount")
	public String CreateAccount() {
		return "krushnakadam";// Create account
	}

	@RequestMapping("/krushnakadam")
	public Login CreateAccountDB_SAVE(Login login) {
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(login);
		tx.commit();
		return login;
	}

	@RequestMapping("homepage")
	public String HomePage() {
		return "home";
	}

	@RequestMapping("aboutpage")
	public String About() {
		return "about";
	}

	@RequestMapping("coursepage")
	public String Courses() {
		return "course";
	}

	@RequestMapping("contactpage")
	public String Contact() {
		return "contact";
	}

	@RequestMapping("contact")
	public Contact ContactDB(Contact contact) {
		System.out.println(contact);
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(contact);
		tx.commit();

		return contact;
	}

}
