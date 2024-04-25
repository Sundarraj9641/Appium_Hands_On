package com.appiumtesting.pageobjectmodel;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.appiumtesting.AppiumHandson.AndroidActions;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class HandsonDayTwoPageFactory extends AndroidActions{

	AndroidDriver driver;
	WebDriverWait wait;
	String itemName;

	public HandsonDayTwoPageFactory(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryDropDown;

	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")
	private WebElement nameField;

	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement gender;

	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopNowButton;

	@AndroidFindBy(xpath="(//android.widget.Toast)[1]")
	private WebElement toastMsg;

	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	private List<WebElement> productList;

	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	private List<WebElement> addToCart;

	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement addToCartLogo;

	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	private WebElement productName;

	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement price;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement conditions;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/alertTitle")
	private WebElement popUp;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement closeButton;


	public void formPagePositive(String country, String name) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(countryDropDown));
		countryDropDown.click();
		AndroidActions aa = new AndroidActions(driver);
		aa.scrollAndClick(country);

		nameField.sendKeys(name);

		if(!gender.isSelected()) {
			gender.click();
		}

		shopNowButton.click();

		Thread.sleep(3000);
	}

	public void formPageNegative(String country) throws InterruptedException {

		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		nameField.clear();
		shopNowButton.click();

		String toastMessage = toastMsg.getText();

		Assert.assertEquals(toastMessage, "Please enter your name");

		Thread.sleep(3000);

	}

	public void addProduct(String country, String name, String itemName) throws InterruptedException {

		countryDropDown.clear();

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(countryDropDown));
		countryDropDown.click();
		scrollAndClick(country);

		nameField.sendKeys(name);

		if(!gender.isSelected()) {
			gender.click();
		}

		shopNowButton.click();

		Thread.sleep(3000);

		scrollToElement(itemName);

		int count = productList.size();

		for(int i =0; i<count; i++) {

			String product = productList.get(i).getText();

			if(product.equalsIgnoreCase(itemName)) {
				addToCart.get(i).click();
			}
		}

		addToCartLogo.click();
		Thread.sleep(2000);
		wait = new WebDriverWait(driver,Duration.ofMillis(3000));
		wait.until(ExpectedConditions.visibilityOfAllElements(productName));
		String product_Name = productName.getText();
		System.out.println("Product Name: " + product_Name );
		Assert.assertEquals(product_Name, itemName);

	}

	public void extractAmount() {

		String amount = price.getText();

		System.out.println("The price of product is: " + amount);

	}

	public void termsAndConditions() throws InterruptedException {
		
		Thread.sleep(2000);
		
		longPress(conditions);
		
		closeButton.click();
		
		Thread.sleep(2000);


	}


}


