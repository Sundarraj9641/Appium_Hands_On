package com.appiumtesting.AppiumHandson;


import org.testng.annotations.Test;

import com.appiumtesting.pageobjectmodel.HandsonDayThreePageFactory;


public class HandsOnDayThree extends BrowserTestingBase {
	
	HandsonDayThreePageFactory hdtepf;


	@Test(priority=1)
	public void loginPage() throws InterruptedException {
		hdtepf= new HandsonDayThreePageFactory(driver);
		hdtepf.login("Tester", "test");
	}
	
	@Test(priority=2)
	public void orderPage() throws InterruptedException {
		hdtepf= new HandsonDayThreePageFactory(driver);
		hdtepf.order();
	}
	
	@Test(priority=3)
	public void orderInfoPage() throws InterruptedException {
		hdtepf= new HandsonDayThreePageFactory(driver);
		hdtepf.orderInfo("5", "125", "5", "Sundarraj", "HSR", "Bangalore", "Karnataka", "560102", "123456789012", "06/27");
	}
	
	@Test(priority=4)
	public void viewAllOrders() throws InterruptedException {
		hdtepf= new HandsonDayThreePageFactory(driver);
		hdtepf.viewOrders();
	}
	
	@Test(priority=5)
	public void logOut() throws InterruptedException {
		hdtepf= new HandsonDayThreePageFactory(driver);
		hdtepf.exit();
	}
	
	

}
