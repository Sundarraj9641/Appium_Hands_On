package com.appiumtesting.pageobjectmodel;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class HandsonDayThreePageFactory {

	AndroidDriver driver;
	WebDriverWait wait;
	String itemName;

	public HandsonDayThreePageFactory(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@FindBy(id="ctl00_MainContent_username")
	private WebElement userName;

	@FindBy(id="ctl00_MainContent_password")
	private WebElement password;

	@FindBy(xpath="//*[@id=\"ctl00_MainContent_login_button\"]")
	private WebElement loginButton;

	@FindBy(xpath="//a[@href='Process.aspx']")
	private WebElement order;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
	private WebElement quantityField;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtUnitPrice")
	private WebElement priceField;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtDiscount")
	private WebElement discountField;
	
	@FindBy(xpath="//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/ol[1]/li[5]/input[2]")
	private WebElement calculateButton;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtName")
	private WebElement customerNameField;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
	private WebElement streetField;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
	private WebElement cityField;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
	private WebElement stateField;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
	private WebElement zipcodeField;

	@FindBy(xpath="//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]")
	private WebElement card;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
	private WebElement cardNoField;
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
	private WebElement exprDateField;

	@FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
	private WebElement proceedButton;
	
	@FindBy(xpath="//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")
	private WebElement confirmation;
	
	@FindBy(xpath="//a[@href='Default.aspx']")
	private WebElement allOrders;
	
	@FindBy(xpath="//*[@id=\"ctl00_logout\"]")
	private WebElement logoutButton;
	
	


	public void login(String usrname, String pwd) throws InterruptedException {
		userName.sendKeys(usrname);
		password.sendKeys(pwd);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click();", loginButton);
		Thread.sleep(2000);
	}
	
	public void order() throws InterruptedException {
		order.click();
		Thread.sleep(2000);
	}
	
	public void orderInfo(String quantity, String price, String discount, String name, String street, String city, String state, String pincode, String cardNo, String expdate) throws InterruptedException {
		
		quantityField.clear();
		quantityField.sendKeys(quantity);
		priceField.clear();
		priceField.sendKeys(price);
		discountField.clear();
		discountField.sendKeys(discount);
		calculateButton.click();
		
		customerNameField.sendKeys(name);
		streetField.sendKeys(street);
		cityField.sendKeys(city);
		stateField.sendKeys(state);
		zipcodeField.sendKeys(pincode);
		
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click();", card);
	
		cardNoField.sendKeys(cardNo);
		exprDateField.sendKeys(expdate);
		
		
		JavascriptExecutor jsExecutor1 = (JavascriptExecutor)driver;
		jsExecutor1.executeScript("arguments[0].click();", proceedButton);
		
		
		
		Thread.sleep(3000);
		String msg = confirmation.getText();
		
		Assert.assertEquals(msg, "New order has been successfully added.");
		
		Thread.sleep(2000);
		
	}

	public void viewOrders() throws InterruptedException {
		allOrders.click();
		Thread.sleep(2000);
	}
	
	public void exit() throws InterruptedException {
		logoutButton.click();
		Thread.sleep(4000);
	}


}


