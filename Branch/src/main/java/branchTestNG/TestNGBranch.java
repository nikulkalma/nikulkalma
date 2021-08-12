package branchTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class TestNGBranch {
	
	WebDriver driver;

	@Test(priority=1)
	@Description("Verify Browser")
	public void openBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority=2)	
	@Description("Verify URL- ZipErp")
	public void launchZipErp() {
			driver.get("http://app.accusol.com/ZipERP"); 
	}
	
	@Test(priority=3)
	@Description("Verify LogIn Details")
	public void performLoginAndClick() {
			// Log In Page 
			driver.findElement(By.name("EnterpriseId")).sendKeys("ziperp_0001");
			driver.findElement(By.name("UserId")).sendKeys("nikulkalma");
			driver.findElement(By.name("Password")).sendKeys("123456");
			driver.findElement(By.xpath("//*[@id=\"lnkLogin\"]")).click();
			//this.takeSnapShot(driver, "c://test.png")
			System.out.println();
			
	}
	@Test(priority=4)
	@Description("Verify Setting Page.")
	public void moveToSetting() {
		
		driver.findElement(By.xpath("//*[@id=\"TenantTBL\"]/tbody/tr[3]/td/label")).click();
		driver.findElement(By.xpath("//*[@id=\"hidemenu3\"]/ul/li[4]/a")).click();
		
	}  
	@Test(priority=5)
	@Description("Verify Branch Page")
	public void moveToBranchDetails() {
		 
		driver.findElement(By.xpath("//*[@id=\"GeneralSettings\"]/section/div/div[3]/div[1]/div[2]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ext-gen1018\"]/div[1]/div[1]/section/div/div[1]/div[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"ParentTenantId\"]/option[24]")).click();
		driver.findElement(By.name("Code")).sendKeys("BoAt-SGH");		
		driver.findElement(By.name("Name")).sendKeys("BoAt-SGH"); 
		driver.findElement(By.name("Address")).sendKeys("SG Highway");
	}
	 
}

