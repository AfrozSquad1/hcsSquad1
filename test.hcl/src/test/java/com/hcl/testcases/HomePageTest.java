package com.hcl.testcases;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hcl.base.BaseClass;
import com.hcl.pages.HomePage;

public class HomePageTest extends BaseClass {
	
	Logger log=Logger.getLogger(HomePageTest.class);
	HomePage homepage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initilization();
		homepage=new HomePage();
		log.info("Setup is done Successfully.");
		}
	
	@Test(priority=1)
	public void homePageTitleTest(){
		log.info("Validating Home Page Title.");
		String titleStr=homepage.getPageTitle();
		Assert.assertTrue(titleStr.contains("Healthcare Marketing and Medical Advertising for Doctors, Hospitals, Healthcare"));
	}
	
	@Test(priority=2)
	public void isLogoVisibleTest(){
		Assert.assertTrue(homepage.isLogoVisible());	
	}
	
	@AfterClass
	public void tearDown() {
		log.info("Tear down method called.");
		driver.quit();
	}
}
