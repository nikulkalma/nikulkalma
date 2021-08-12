import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class demo {
	
	WebDriver driver; 

	@AfterSuite
    void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "92.0.4515.131")
                        .put("URL", "http://testyutika.ziperp.net")
                        .build(),  System.getProperty("user.dir")
                        + "/allure-results/");
    }
	@Test(priority=1)
	@Description("Verify Browser")
	@Epic("Get Browser")
	@Feature("Feature: Get Browser")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Story: Get Browser")
	@Step("Step 1")
	public void openBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test(priority=2)	
	@Description("Verify URL of YUTIKA")
	@Epic("Yutika - URL")
	@Feature("Feature: URL")
	@Severity(SeverityLevel.MINOR)
	@Story("Story: Yutika")
	@Step("URL - Screenshot")
	public void launchZipErp() {
			driver.get("http://testyutika.ziperp.net"); 
	}  
	@Test(priority=3)
	@Description("Verify LogIn Details")
	@Epic("Yutika - Login Page")
	@Feature("Feature: LogIn")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Story: Login Page") 
	@Step("Login - Screenshot")
	public void performLoginAndClick() throws InterruptedException {
			// Log In Page 
			driver.findElement(By.name("UserName")).sendKeys("demo@demo.com");
			driver.findElement(By.name("Password")).sendKeys("123456");
			driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div[2]/button")).click();
			driver.findElement(By.xpath("/html/body/div[1]/header/nav/div/ul/li[3]/a")).click();
	} 
	@Test(priority=7)
	@Description("Add New User in System Administation")
	@Epic("Yutika -  Add New User")
	@Feature("Feature: Add New User") 
	@Severity(SeverityLevel.BLOCKER)
	@Story("Story: Adding New User") 
	@Step("User- Screenshot")
	public void goToSettingCreateNewUser() throws InterruptedException {
			       
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div[4]/div/div[2]/div/ul/li[3]/a")).click();
			Thread.sleep(200);
			driver.findElement(By.xpath("//*[@id=\"BtnAddNewUser\"]")).click();
			driver.findElement(By.name("FullName")).sendKeys("Nikul Kalma");
			driver.findElement(By.id("Address")).sendKeys("410, Demo, Demo Testing Address");
			driver.findElement(By.id("MobileOfficial")).sendKeys("12345678");
			driver.findElement(By.id("EmailAddressOfficial")).sendKeys("demo@demo.com");
			driver.findElement(By.id("MobilePersonal")).sendKeys("987654321");
			driver.findElement(By.id("EmailAddressPersonal")).sendKeys("demo@demo1.com");
			driver.findElement(By.xpath("//*[@id=\"MyDataForm\"]/div/div[7]/div[2]/div/div/div[1]/ins")).click();
	 		driver.findElement(By.xpath("//*[@id=\"ddDesignation\"]/option[7]")).click();
			driver.findElement(By.id("HQName")).sendKeys("Ahmedabad");
			Thread.sleep(200);
			driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]")).click();
			driver.findElement(By.id("BirthdayDate")).click();
			
			
			WebElement element = driver.findElement(By.className("dtp-content"));
			element.getText();
			WebElement elmt = driver.findElement(By.className("dtp-date-view"));
			elmt.getText();
			//get date
			WebElement date = driver.findElement(By.xpath("//*[@id=\"dtp_eVJf3\"]/div/div[1]/div[3]/div[1]/table/tbody"));
			date.getText();
			//get week
			WebElement week = driver.findElement(By.xpath("//*[@id=\"dtp_137GL\"]/div/div[1]/div[3]/div[1]/table/tbody/tr[3]"));
			week.getText();
			//get day select date
			WebElement day = driver.findElement(By.xpath("//*[@id=\"dtp_137GL\"]/div/div[1]/div[3]/div[1]/table/tbody/tr[3]/td[4]"));
			day.getText(); 
			day.click();
			WebElement ok = driver.findElement(By.className("dtp-buttons"));
			ok.getText();
			Thread.sleep(200);
			WebElement bt = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/button[4]"));
			bt.click();
	        
			
			driver.findElement(By.id("UserGroupName")).sendKeys("ADMIN TEST");
			driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]")).click();
			driver.findElement(By.id("EmployeeId")).sendKeys("Nikul01");
			driver.findElement(By.id("OldEmployeeId")).sendKeys("Nikul01");
			driver.findElement(By.id("DeviceId")).sendKeys("123");	   
			driver.findElement(By.id("Psw")).sendKeys("123");
			screenshot();
	}
	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] screenshot() { 
	    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

}
