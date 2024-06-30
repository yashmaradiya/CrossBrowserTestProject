package project;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.java.After;

public class CrossBrowserScript {
	
	WebDriver driver;
	@Parameters("Browser")
	@BeforeTest
	public void openBrowser(String Browser) throws Exception
	{
	if(Browser.equalsIgnoreCase("Edge"))
	{
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	else if (Browser.equalsIgnoreCase("Chrome"))
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	else if (Browser.equalsIgnoreCase("Firefox"))
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	else
		System.out.println("Invalid Browser");
	}
	@Test
	public void openUrl() throws Exception
	{
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a")).click();
		driver.findElement(By.name("firstname")).sendKeys("Rahul");
		driver.findElement(By.name("lastname")).sendKeys("sharma");
		driver.findElement(By.name("reg_email__")).sendKeys("9512269913");
		driver.findElement(By.xpath("//*[@id=\"password_step_input\"]")).sendKeys("Sharma@1999");
		
		Select s = new Select(driver.findElement(By.id("day")));
		Thread.sleep(1000);
		s.selectByVisibleText("16");
		Select s1 = new Select(driver.findElement(By.id("month")));
		Thread.sleep(1000);
		s1.selectByValue("9");
		Select s2 = new Select(driver.findElement(By.id("year")));
		Thread.sleep(1000);
		s2.selectByValue("1998");
		//radio button
		driver.findElement(By.xpath("//input[@value='2']")).click();//for selecting male
		driver.findElement(By.name("websubmit")).click();
	}
	@After
	@Test
	public void runfb() throws Exception
	{
		
		
		//user click on dropdown menu
		driver.findElement(By.xpath("//*[@id=\"scrollview\"]/div/div/div[1]/div/div[3]/div[1]/div[2]/span/div/i")).click();
		
		//user click on downlode file
		driver.findElement(By.xpath("//*[@id=\":r2:\"]")).click();
		
		//user click on downlode button
		driver.findElement(By.xpath("//*[@id=\"facebook\"]/body/div[3]/div[1]/div/div[2]/div/div/div/div/div/div/div[3]/div/div/div/div/div[1]/div/div")).click();
				
	}
	
	public void teardown()
	{
		driver.close();
	}
	

}
