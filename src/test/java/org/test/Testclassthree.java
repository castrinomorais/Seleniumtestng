package org.test;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Testclassthree {

	

	@Test
	public void textBox() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml");
		//Type your Name
		PageFactory.initElements(driver,PageObjects.class);
		PageObjects.typeYourName.sendKeys("Castrino");
		
		//Append Country to this City.
	    PageObjects.appendCountryToThisCity.sendKeys("India");
		
	    //Verify if text box is disabled
		boolean enabledStatus = PageObjects.txtbox.isEnabled();
		System.out.println(enabledStatus);
		
		
		//Clear the typed text
		PageObjects.clearText.clear();
		
		//Retrieve the  text
		String textWithinTheBox =PageObjects. retrieveText.getAttribute("value");
		System.out.println(textWithinTheBox);
		driver.close();
	}
	
	@Test
	public void uploadOperation() {
		WebDriver driver;
		driver =new ChromeDriver();
		// To automate process of upload by sending the filepath of the file to be uploaded in the sendkeys along with
		//.type of the file to be uploaded
		driver.get("https://www.leafground.com/file.xhtml;jsessionid=node010nx464jtc8vzxsmrg4fp0yu9138.node0");
		PageFactory.initElements(driver,PageObjects.class);
		PageObjects.uploadButton.sendKeys("C:\\Users\\DELL\\Downloads\\timetableexams.pdf");
		driver.close();
	}

	@Test
	public void downloadAndValidation() {
		WebDriver driver;
		driver =new ChromeDriver();
		driver.get("https://www.leafground.com/file.xhtml;jsessionid=node010nx464jtc8vzxsmrg4fp0yu9138.node0");
//To automate download file and check if the file is downloaded in the directory or not 		
		PageFactory.initElements(driver,PageObjects.class);
 		PageObjects.downloadButton.click();
		File fileLocation=new File("C:\\Users\\DELL\\Downloads");
		 File[] totalFiles = fileLocation.listFiles();
		 for (File f : totalFiles) {
			if( f.getName().equals("Testleaf Logo")) {
				System.out.println("file has Downloaded");
				break;
			}
			
		}
		 driver.close();
	}
	
	@Test
	public void explicitWait() {
		//Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the specified URL
            driver.get("https://www.leafground.com/waits.xhtml");

            // Initialize WebDriverWait with a timeout of 10 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until the element is visible
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt87:j_idt90")));

            // Find the element and click it
            PageFactory.initElements(driver,PageObjects.class);
    		PageObjects.Iamhere.click();
//         
        } catch (Exception e) {
            // Handle any exceptions that occur during execution
            e.printStackTrace();
        } finally {
            // Close the driver
            driver.close();
        }
    }


@Test
public void hyperLinks() {
	
		WebDriver driver;
		driver =new ChromeDriver();
		driver.navigate().to("https://www.leafground.com/link.xhtml;jsessionid=node010nx464jtc8vzxsmrg4fp0yu9138.node0");
		
		// Take me to Dashboard
		  PageFactory.initElements(driver,PageObjects.class);
  		PageObjects.gotoDashboard.click();
		driver.navigate().back();
		
		//Find the url without clicking 
		 PageFactory.initElements(driver,PageObjects.class);
	  	 String url = PageObjects.findmyDestination.getAttribute("href");
		 System.out.println(url);
		 
		 
		 //To count the number of links 
		 List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		 int countOfLinks = totalLinks.size();
		 System.out.println(countOfLinks);
		 driver.close();

	
}}
