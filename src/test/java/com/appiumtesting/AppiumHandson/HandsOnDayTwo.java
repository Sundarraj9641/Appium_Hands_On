package com.appiumtesting.AppiumHandson;


import org.testng.annotations.Test;
import com.appiumtesting.pageobjectmodel.HandsonDayTwoPageFactory;
import com.appiumtesting.AppiumHandson.GeneralStoreConfiguration;

public class HandsOnDayTwo extends GeneralStoreConfiguration {
	
	HandsonDayTwoPageFactory hdtpf;


	@Test(priority=1)
	public void goToProductPage() throws InterruptedException {
		hdtpf= new HandsonDayTwoPageFactory(driver);
		hdtpf.formPagePositive("India", "Sundarraj");
	}
	
	@Test(priority=2)
	public void enterIncompleteData() throws InterruptedException {
		hdtpf= new HandsonDayTwoPageFactory(driver);
		hdtpf.formPageNegative("India");
	}
	

	@Test(priority=3)
	public void addProductToCart() throws InterruptedException {
		hdtpf= new HandsonDayTwoPageFactory(driver);
		hdtpf.addProduct("India", "Sundarraj", "Air Jordan 1 Mid SE");
	}
	
	@Test(priority=4)
	public void extractAmountInTheCart() throws InterruptedException {
		hdtpf= new HandsonDayTwoPageFactory(driver);
		hdtpf.extractAmount();
	}
	
	@Test(priority=5)
	public void readOnTermsAndConditions() throws InterruptedException {
		hdtpf= new HandsonDayTwoPageFactory(driver);
		hdtpf.termsAndConditions();
	}


}
