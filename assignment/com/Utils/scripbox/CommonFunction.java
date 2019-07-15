package com.Utils.scripbox;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunction {
	 public static WebDriver driver;		
	
		public static String dateformat() {
		    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		    //get current date time with Date()
			Date date = new Date();
			Calendar c = Calendar.getInstance();
	    	c.setTime(date);
	    	c.add(Calendar.DATE, 2);
	    	date = c.getTime();
	    	 // Now format the date
	    	String dateCal= dateFormat.format(date);
	        return dateCal;
		    }
		
	    public static String dateformat1() {
		        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		        //get current date time with Date()
		    	Date date = new Date();
		    	Calendar c = Calendar.getInstance();
		    	c.setTime(date);
		    	c.add(Calendar.DATE, 5);
		    	date = c.getTime();
		    	 // Now format the date
		    	String dateCal= dateFormat.format(date);
		        return dateCal;
		        }

}
