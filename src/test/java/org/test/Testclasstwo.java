package org.test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Testclasstwo {
	
	@Test
	public void windowHandlesExercise() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Click  openbutton  a new window opens and we click the browser icon in the child window.
				String parentwindow = driver.getWindowHandle();
				PageFactory.initElements(driver, PageObjects.class);
				PageObjects.openbutton.click();
				Set<String> allwindowhandles = driver.getWindowHandles();
				for (String wh : allwindowhandles) {
					if(!wh.equals(parentwindow)) {
						driver.switchTo().window(wh);
						
					}
					PageFactory.initElements(driver, PageObjects.class);
					PageObjects.browser.click();
					driver.close();
					
	}
	}
	
	@Test
	public void windowHandlesExercisetwo() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// parent window contains window handle value of the parent
		String parentwindow = driver.getWindowHandle();
		
		//Clicking the openmultipleButton opens child window 
		PageFactory.initElements(driver, PageObjects.class);
		PageObjects.openmultipleButton.click();
		
		//allwindowhandles set contain the window handle values of all the windows opened 
		Set<String> allwindowhandles = driver.getWindowHandles();
		// we use size method over the set to count the number of window handles values of the windows opened stored in the set
		int numberofwindows = allwindowhandles.size();
		
	//	The value returned by the size method stored in a variable is printed and also all windowhandle values are also printed
		System.out.println(numberofwindows);
		System.out.println(allwindowhandles);
		driver.quit();
	}
	
	@Test
	public void seleniumIframes() {
		//To click a button inside an iframe and get the text 
				WebDriver driver;
				driver =new ChromeDriver();
				driver.get("https://www.leafground.com/frame.xhtml");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.switchTo().frame(0);
				PageFactory.initElements(driver, PageObjects.class);
				PageObjects.clickMebuttonTwo.click();
				String textvalue = PageObjects.clickMebuttonTwo.getText();
				System.out.println(textvalue);
				driver.quit();
	}
	@Test
	public void numberOfFramesInWebpage() {
		// To find the number of iframes
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    List<WebElement> frames = driver.findElements(By.tagName("iframe"));
	    int totalframes = frames.size();
		System.out.println("The total number of frames in webpage "+     +totalframes);
		driver.close();
	}
	
	@Test
	public void checkBox() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.leafground.com/checkbox.xhtml");
		//Select a basic checkbox
		PageFactory.initElements(driver,PageObjects.class);
		
		PageObjects.basicCheckbox.click();
		
		//Selecting multiple checkboxes
		
		PageObjects.javaCheckbox.click();
		
		PageObjects.pythonCheckbox.click();
		 
		 //To Select a toggle switch slider

		PageObjects.toogleSwitch.click();
		 
		 //To verify if the check box is disabled 
		 boolean enabledStatusOfCheckbox= PageObjects.disabledCheckbox.isEnabled();
		System.out.println(enabledStatusOfCheckbox);
		driver.close();
		 
	}
	
	@Test
	public void seleniumRadioButtons() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Selecting a radio button
		 PageFactory.initElements(driver,PageObjects.class);
		 PageObjects.fireFoxRadioButton.click();
		
		
	 //Status of the radio button safari in the Find default selection radio button
	  PageFactory.initElements(driver,PageObjects.class);
	  boolean selectionStatusOfSafari = PageObjects.Safari.isSelected();	
	  boolean displayStatusOfSafari = PageObjects.Safari.isDisplayed();
	  boolean enabledStatusOfSafari = PageObjects.Safari.isEnabled();

     System.out.println(selectionStatusOfSafari);
     System.out.println(displayStatusOfSafari);
     System.out.println(enabledStatusOfSafari);
     driver.close();
	}

}
