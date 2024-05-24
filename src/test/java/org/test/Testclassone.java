package org.test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Testclassone {

	
	@Test
	public void seleniumAlerts() {
		WebDriver driver;
		driver=new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node01giy7aarhjuxb5abrss1elho9671082.node0");
		// To click the ok button in an simple alert dialog box
		PageFactory.initElements(driver,PageObjects.class);
		PageObjects.simplealertButton.click();
		Alert a=driver.switchTo().alert();
		a.accept();
	    driver.close();
	
	}
 
	@Test
	public void seleniumPromptAlerts() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node01giy7aarhjuxb5abrss1elho9671082.node0");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//To input a text and click ok button in an prompt alert dialog box
		PageFactory.initElements(driver, PageObjects.class);
		PageObjects.promptalertButton.click();
		Alert as = driver.switchTo().alert();
		as.sendKeys("Please cofirm your account");
		as.accept();
		driver.close();
	}
	
	
	@Test
	public void brokenLink() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		// To check a link is broken or not 
		PageFactory.initElements(driver, PageObjects.class);
		PageObjects.AmIBroken.click();
		String brokenValue = driver.getTitle();
		if(brokenValue.contains("404")) {
			System.out.println("Is a broken Link");
		}
		else {
			System.out.println("Not a Broken Link");
		}
		driver.close();
	}
	
	@Test
	public void screenShot() throws Exception {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/dashboard.xhtml");
		// To perform screenshot operation using FileHandler
        TakesScreenshot ts=(TakesScreenshot)  driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File des= new File("D:Screenshot.png");
        FileHandler.copy(source, des);
        driver.close();
	}
	
	@Test
	public void waysToReloadWebPage() throws IOException, Exception {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.get("https://www.guru99.com/upload-download-file-selenium-webdriver.html");
		
	//	Reload a page using location.reload and history.go
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("location.reload()");
		js.executeScript("history.go(0)");
	
		//Reload a page using Robot class
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_F5);
		rt.keyRelease(KeyEvent.VK_F5);
		driver.close();
		
	}
	
	@Test
	public void scrollaWebPage() {
		WebDriver driver;
		driver =new ChromeDriver();
	    driver.get("https://www.worldometers.info/geography/flags-of-the-world/");
//		To scroll down the page by 455 pixels 
	    JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,455)", " ");
		
//		//To scroll Up by 455 pixels
	   JavascriptExecutor jk= (JavascriptExecutor)driver;
        jk.executeScript("window.scroll(0,-455)", " ");
		
//		//To extreme bottom of the page “document.body.scrollHeight” returns the complete height of the body(i.e webpage)
		
	    JavascriptExecutor ja= (JavascriptExecutor)driver;
	    ja.executeScript("window.scroll(0,document.body.scrollHeight)", " ");
		
//	To extreme top of the page 
	    JavascriptExecutor jf= (JavascriptExecutor)driver;
	   jf.executeScript("window.scroll(0,0)", " ");
	    driver.close();
		 
	}
	
	@Test
	public void seleniumDropDown() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		PageFactory.initElements(driver, PageObjects.class);
		
		// To select the options in the dropdown using selectByIndex and selectByVisibleText
		Select sc= new  Select(PageObjects.favoriteautomationtool);
		sc.selectByIndex(0);
		sc.selectByVisibleText("Selenium");
		
		// To get the count of number of options in dropdown and to print it 
		List<WebElement> optionslist = sc.getOptions();
		int numberofoptions = optionslist.size();
		System.out.println(numberofoptions);
		driver.close();
		
	}
}
