package com.hcl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hcl.base.BaseClass;



public class HomePage extends BaseClass {
	
	@FindBy(xpath="//div/a[@class='brand header-logo']")
	WebElement healthcareSuccessLogo;
	
	
	public HomePage(){
			PageFactory.initElements(driver, this);
	}
	
	
	
	public String getPageTitle(){
		return driver.getTitle();
	
	}
	
	public boolean isLogoVisible(){
		return healthcareSuccessLogo.isDisplayed();
		}
	
	
	

}
