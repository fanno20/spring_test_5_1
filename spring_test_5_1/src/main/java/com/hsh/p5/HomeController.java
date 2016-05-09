package com.hsh.p5;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hsh.test.Test1;
import com.hsh.test.Test2;
import com.hsh.test.Test3;
import com.hsh.test.Test6;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Inject
	private DataSource dataSource;
	
	/*@Inject
	private Test1 t1;
	@Inject
	private Test6 test6;*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*System.out.println(t1.getT1());
		System.out.println(t1.getT2().getT2());
		System.out.println(t1.getT2().getT3().getT3());*/
		/*Test1 t1 = new Test1();
		t1.setT2(new Test2());
		t1.getT2().setT3(new Test3());
		System.out.println(t1.getT1());
		System.out.println(t1.getT2().getT2());
		System.out.println(t1.getT2().getT3().getT3());*/
		
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*test6.getT().doTest();*/
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
