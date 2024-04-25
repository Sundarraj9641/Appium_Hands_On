package com.appiumtesting.AppiumHandson;


import org.testng.annotations.Test;

import com.appiumtesting.pageobjectmodel.HandsonDayFourPageFactory;


public class HandsOnDayFour extends Guru99Base {
	
	HandsonDayFourPageFactory hdfpf;


	@Test(priority=1)
	public void loginPage() throws InterruptedException {
		hdfpf= new HandsonDayFourPageFactory(driver);
		hdfpf.login("mngr568478", "hAjYgun");
	}
	
	@Test(priority=2)
	public void WithdrawalInvaildData() throws InterruptedException {
		hdfpf= new HandsonDayFourPageFactory(driver);
		hdfpf.withdrawalNegative("1234567898", "2000", "Invalid Acc No");
	}
	
	@Test(priority=3)
	public void newCustomer() throws InterruptedException {
		hdfpf= new HandsonDayFourPageFactory(driver);
		hdfpf.customer("Sundarraj","2000-04-03","HSR Bangalore", "Bangalore", "Karnataka", "560103", "8783206513", "RajSundar@66732");
	}
	
	@Test(priority=4)
	public void newAccount() throws InterruptedException {
		hdfpf= new HandsonDayFourPageFactory(driver);
		hdfpf.account("10000");
		
	}
	
	@Test(priority=5)
	public void WithdrawalVaildData() throws InterruptedException {
		hdfpf= new HandsonDayFourPageFactory(driver);
		hdfpf.withdrawalPositive("3000", "Rs.3000 only");
		
	}
	
	@Test(priority=6)
	public void logout() throws InterruptedException {
		hdfpf= new HandsonDayFourPageFactory(driver);
		hdfpf.exit();
		
	}
}
