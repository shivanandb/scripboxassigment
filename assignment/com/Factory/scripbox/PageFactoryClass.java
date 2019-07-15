package com.Factory.scripbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageFactoryClass {
	WebDriver driver;

	@FindBy (xpath="//h1[text()='Flight Ticket Booking']")
	WebElement titleText;
	
	
    @FindBy(id="gosuggest_inputSrc")
    WebElement inputSrc;

    @FindBy(id="gosuggest_inputDest")
    WebElement inputDest;    

    @FindBy(xpath="(//i[@class='hypflt-calendar blueGrey padR5 ico20'])[1]")
    WebElement Departure;
   
    @FindBy(xpath="(//i[@class='hypflt-calendar blueGrey padR5 ico20'])[2]")
    WebElement Return;
   
    @FindBy(id="gi_search_btn")
    WebElement Search;
    
  //initElements method to create all WebElements
    public PageFactoryClass(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this); }
    
    public void setinputSrc(String strUserName){
   	inputSrc.sendKeys(strUserName);
	 }

    public WebElement inputSrc(){
	return inputSrc;  }
    
    public WebElement inputDest(){
	return inputDest;  }
    
    
    public void setinputDest(String strPassword){
   	inputDest.sendKeys(strPassword); }
    
  //  Clicking Onward calendar
    public void clickDeparture(){
   	Departure.click(); }  
    
    //Clicking Return calendar
    public void clickReturn(){
   	Return.click();  } 

    //Clicking Search Button
    public void clickSearch(){
   	Search.click();  } 

    //Get the title of Page
    public String getTitle(){
    return titleText.getText();  }

}
