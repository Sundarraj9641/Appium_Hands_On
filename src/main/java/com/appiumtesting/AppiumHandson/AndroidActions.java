package com.appiumtesting.AppiumHandson;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {

	AndroidDriver driver;
	
	public AndroidActions(AndroidDriver driver) {
		this.driver=driver;
	}

	public void scrollToElement(String location) {
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+location+"\"));"));
	}
	
	public void scrollAndClick(String element) {
		driver.findElement(AppiumBy.androidUIAutomator
				("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+element+"\"));")).click();;
	}
	
	public void longPress(WebElement locator) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)locator).getId(),"duration", 2000));
	}
}
