package com.hcl.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hcl.base.BaseClass;
import com.hcl.utility.ExcelWriter;

public class BrandingPage extends BaseClass {
	
	//WebDriver driver;
	@FindBy(xpath="//a/span[contains(text(),'Branding')]")
	WebElement brandingLink;
	
	@FindBy(xpath="//a/span[contains(text(),'Services')]")
	WebElement servicesLink;
	
	@FindBy(xpath="//h1[contains(text(),'Healthcare Branding Services')]")
	WebElement healthcareBranding;

	@FindBy(xpath="//h2[contains(text(),'Your brand is who you are. Be your best.')]")
	WebElement brandNameFirst;
	
	@FindBy(xpath="//div/p[contains(text(),'Most')]")
	WebElement brandFirstText;

	@FindBy(xpath="//h2[text()='Developing and communicating how and why you’re different.']")
	WebElement brandNameSecond;
	
	@FindBy(xpath="//div/p[contains(text(),'Our branding')]")
	WebElement brandNameSecondText;
	
	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(name="company")
	WebElement company;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="message")
	WebElement message;

	public BrandingPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String getBrandingPageTitle(){
		return driver.getTitle();
	
	}
	
	public boolean verifyBrandingLink(){
		
		return brandingLink.isDisplayed();
	}
	
	public boolean verifyServicesLink(){
	
		return servicesLink.isDisplayed();
	}
	
	
	public void  doClickServices(){
		 servicesLink.click();	
	}
	
	public void doclickBranding(){
		brandingLink.click();
	}
	
	public String getBrandingPageText(){
		return brandNameFirst.getText();
	}
	
	public void addLoginDetails(){
		firstName.sendKeys("firstName");
		lastname.sendKeys("lastname");
		company.sendKeys("company");
		email.sendKeys("email");
		message.sendKeys("message");
	}
	
	public boolean writeIntoBrandingDataToExcel() {
		
		String str=brandNameFirst.getText();
		Object [] brandNameHeading= new Object[] {brandNameFirst.getText()};
		Object [] brandnameFirstContent= new Object[] {brandFirstText.getText()};
		
		try {
			ExcelWriter.writeToExcel(brandNameHeading, brandnameFirstContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}



}
