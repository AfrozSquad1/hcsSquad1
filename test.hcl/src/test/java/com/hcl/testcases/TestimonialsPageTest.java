package com.hcl.testcases;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hcl.base.BaseClass;
import com.hcl.pages.TestimonialsPage;

public class TestimonialsPageTest extends BaseClass {
	

	Logger log=Logger.getLogger(HomePageTest.class);
	TestimonialsPage testimonialPage;
	
	public TestimonialsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		testimonialPage=new TestimonialsPage();
		log.info("Setup is done Successfully.");
		}
	
	@Test
	public void homePageTitleTest(){
		log.info("Validating Home Page Title.");
		String titleStr=testimonialPage.getPageTitle();
		Assert.assertTrue(titleStr.contains("Marketing Client Testimonials - Healthcare Success</"));
	}
	
	@Test
	public void getNameOfClientTest(){
		List<String> listStr=testimonialPage.getNameOfClient();
		
		Assert.assertTrue(listStr.get(0).contains("Michael"));
		Assert.assertTrue(listStr.get(0).contains("Jonathan"));
		}
	
	
	@Test
	public void writeClientTextIntoFileTest() {
		boolean filecreated=testimonialPage.writeClientTextIntoFile();
		Assert.assertTrue(filecreated);
		
	
}
	
	@AfterMethod
	public void tearDown() {
		log.info("Tear down method called.");
		driver.quit();
	}

}
