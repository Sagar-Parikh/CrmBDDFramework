package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class NewContactPage extends TestBase{

	TestUtil testUtil;
		
	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']")
	WebElement newContactLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	WebElement homePageLink;
	
	public NewContactPage() {
		PageFactory.initElements(driver, this);
		testUtil = new TestUtil();
	}
	
	public HomePage clickOnHomePageLink() {
		testUtil.javaScripExecutorClick(homePageLink);
		return new HomePage();
	}
	
	
	
	
}
