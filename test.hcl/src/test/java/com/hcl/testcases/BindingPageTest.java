package com.hcl.testcases;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hcl.base.BaseClass;
import com.hcl.pages.BrandingPage;

public class BindingPageTest extends BaseClass {

	
	Logger log=Logger.getLogger(HomePageTest.class);
	BrandingPage brandingPage;
	
	public BindingPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initilization();
		brandingPage=new BrandingPage();
		log.info("Setup is done Successfully.");
		}
	
	@Test(priority=3)
	public void brandingTitleTest(){
		log.info("Validating Home Page Title.");
		String titleStr=brandingPage.getBrandingPageTitle();
		Assert.assertTrue(titleStr.contains("Marketing Client Testimonials - Healthcare Success</"));
	}
	
	@Test(priority=4)
	public void verifyBrandingLinkTest(){
		log.info("Validating Home Page Title.");
		boolean validatedBrandingLink=brandingPage.verifyBrandingLink();
		Assert.assertTrue(validatedBrandingLink);
		log.info("Assertion is over.");
	}
	
	@Test(priority=5)
	public void verifyServicesLinkTest(){
		log.info("Validating Home Page Title.");
		boolean validatedServiceLink=brandingPage.verifyServicesLink();
		Assert.assertTrue(validatedServiceLink);
		log.info("Assertion is over.");
	}
	
	@Test(priority=6)
	public void addLoginDetails(){
		brandingPage.addLoginDetails();
		
		
	}
	
	
	@Test(priority=7)
	public void getBrandingPageTextText() {
		String str=brandingPage.getBrandingPageText();
		Assert.assertTrue(str.contains("Most doctors and executives now recognize that healthcare branding is vital"));
	}
	
	
	@Test(priority=8)
	public void writeIntoBrandingDataToExcelTest(){
		Assert.assertTrue(brandingPage.writeIntoBrandingDataToExcel());
		
	}
	@AfterClass
	public void tearDown() {
		log.info("Tear down method called.");
		driver.quit();
	}
}
