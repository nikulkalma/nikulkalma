package ItemMaster;

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
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class ItemMaster {

	WebDriver driver;
	
	@AfterSuite
    void setAllureEnvironment() 
	{
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "92.0.4515.131")
                        .put("URL", "http://app.accusol.com/ZipERP/")
                        .build(),  System.getProperty("user.dir")
                        + "/allure-results/");
	}
	@Test(priority=1)
	@Description("Verify Browser")
	@Epic("Get Browser")
	@Feature("Feature: Get Browser")
	@Story("Story: Get Browser")
	@Step("Step 1")
	public void openBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority=2)	
	@Description("Verify URL- ZipErp")
	@Epic("ZipErp - URL")
	@Feature("Feature: URL")
	@Story("Story: Get URL")
	@Step("Step 2 Wirh screenshot")
	public void launchZipErp() 
	{
			driver.get("http://app.accusol.com/ZipERP"); 
			screenshot();
	}
	 
	@Test(priority=3)
	@Description("Verify LogIn Details")
	@Epic("Login Page")
	@Feature("Feature: LogIn")
	@Story("Story: Login Page") 
	@Step("Step 3 Wirh screenshot ")
	public void performLoginAndClick() throws InterruptedException 
	{		//Login Detail.
			driver.findElement(By.name("EnterpriseId")).sendKeys("ziperp_0001");
			driver.findElement(By.name("UserId")).sendKeys("nikulkalma");
			driver.findElement(By.name("Password")).sendKeys("1236");
			driver.findElement(By.xpath("//*[@id=\"lnkLogin\"]")).click();
	
			Thread.sleep(500);
				
			WebElement element = driver.findElement(By.xpath("//*[@id=\"lblErrorMessage\"]"));
			
			if (element.isDisplayed())
			{
				System.out.println("LogIn Failed. Please Add Valid LogIn Details");
				driver.navigate().to("http://app.accusol.com/ZipERP");
			}
			else 
			{
				System.out.println("LogIn Succssed.");
				driver.findElement(By.xpath("//*[@id=\"TenantTBL\"]/tbody/tr[2]/td")).click();
			}
			screenshot();
	} 
	@Test(priority=4)   
	@Description("Verify Item Page Detail")
	@Epic("Inventory - Item")
	@Feature("Feature: Item Page")
	@Story("Story: Item Page")
	@Step("Step 4 Wirh screenshot")
	public void moveToItemPage() 
	{
		driver.findElement(By.xpath("//*[@id=\"hidemenu4\"]/section/ul/li[5]/a/i[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"hidemenu4\"]/section/ul/li[5]/ul/li[11]/a")).click();
		screenshot();
	} 
	@Test(priority=5)
	@Description("Verify Item Details")
	@Epic("Create New Item")
	@Feature("Feature: Item Test")
	@Story("Story: Add Item")
	@Step("Step 5 with Screeenshot")
	public void performItemTest() throws InterruptedException 
	{
		driver.findElement(By.xpath("//*[@id=\"ext-gen1018\"]/div[1]/div[1]/section/div/div[1]/div[2]/a")).click();
		driver.findElement(By.name("Code")).clear();
		driver.findElement(By.name("Code")).sendKeys("airdopes281");
		driver.findElement(By.name("Name")).sendKeys("BoAt Airdopes-281");
		driver.findElement(By.xpath("//*[@id=\"Unit\"]/option[2]")).click();
		driver.findElement(By.name("Remarks")).sendKeys("BoAt");
		driver.findElement(By.name("Description")).sendKeys("BoAt Airdopes-281"); 
		driver.findElement(By.xpath("//*[@id=\"BrandId\"]/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"AdConfigTab\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"lnkSelectDefPurchaseAccount\"]")).click();
		driver.findElement(By.name("filtAccName")).sendKeys("Purchase A/c.");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"tblAccPopupGrid\"]/div/table/tbody")).click();
		driver.findElement(By.xpath("//*[@id=\"lnkSelectDefSalesAccount\"]")).click();
		driver.findElement(By.name("filtAccName")).sendKeys("Sales A/c.");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"tblAccPopupGrid\"]/div/table/tbody/tr")).click();
		screenshot();
	 
	}
	@Test(priority=6)
	@Attachment(value = "Screenshot", type = "image/png")
	public byte[] screenshot() 
	{ 
	    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}