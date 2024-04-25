package com.appiumtesting.AppiumHandson;


import org.testng.annotations.Test;
import com.appiumtesting.pageobjectmodel.HandsonDayOnePageFactory;
import com.appiumtesting.AppiumHandson.Configuration;

public class HandsOnDayOne extends Configuration {
	
	HandsonDayOnePageFactory hdopf;

//	@BeforeMethod
//	public void landingPage() {
//		((JavascriptExecutor)driver).executeScript("mobile: startActivity", 
//			    ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.ApiDemos"));
//
//	}

	@Test(priority=1)
	public void dragAndDropTheCircle() {
		hdopf= new HandsonDayOnePageFactory(driver);
		hdopf.dragAndDropTheCircle();
	}

	@Test(priority=2)
	public void ScrollAndViewTextClock() throws InterruptedException {
		hdopf= new HandsonDayOnePageFactory(driver);
		hdopf.scrollDownToTextClock("TextClock");
	}
	
	@Test(priority=3)
	public void swipeToSecondImage() throws InterruptedException {
		hdopf= new HandsonDayOnePageFactory(driver);
		hdopf.swipeToSecondImage();
	}
	
	@Test(priority=4)
	public void viewPeopleNames() throws InterruptedException {
		hdopf= new HandsonDayOnePageFactory(driver);
		hdopf.peopleNames();
	}
	
	@Test(priority=5)
	public void enterDataInTextField() throws InterruptedException {
		hdopf= new HandsonDayOnePageFactory(driver);
		hdopf.enterDataIntoText("TextFields", "Sundarraj");
	}

}
