package com.hcl.pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hcl.base.BaseClass;
import com.hcl.utility.FileWriterExample;

public class TestimonialsPage extends BaseClass {
	
	
	@FindBy(xpath="//a/span[contains(text(),'About Us')]")
	WebElement aboutLink;
	
	@FindBy(xpath="//a/span[contains(text(),'Testimonials')]")
	WebElement testimonials;
	
	
	@FindBy(xpath="//p/strong[contains(text(),'Michael S')]")
	WebElement clientFirst;

	@FindBy(xpath="//div/p/em[contains(text(),'The Healthcare Success team has proven')]")
	WebElement clientFirstText;
	
	@FindBy(xpath="//p/strong[contains(text(),'Jonathan Calure')]")
	WebElement clientSecond;
	
	@FindBy(xpath="//div/p/em[contains(text(),'Healthcare Success has provided us (1) Spectacular TV')]")
	WebElement clientSecondText;
		
	

	
	public TestimonialsPage(){
		PageFactory.initElements(driver, this);
	}

	
	public void doClickaboutLink(){
		aboutLink.click();	
	}
	
	public void doclicktestimonials(){
		testimonials.click();
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	
	}
	public List<String> getNameOfClient(){
		List<String> strList=new ArrayList<String>();
		strList.add(clientFirst.getText());
		strList.add(clientSecond.getText());
		
		System.out.println(clientFirst.getText());
		System.out.println(clientSecond.getText());

		
		return strList;
	}

	public String getTextOfClient(){
		String str=clientFirstText.getText();
		
		return str;
	}
	
	public boolean writeClientTextIntoFile(){
		FileWriterExample.writeOnTextFile(getTextOfClient());
		
		return true;
		
	}

}
