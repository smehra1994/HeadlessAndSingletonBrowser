package Classes;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SingletonBrowserTest{

	@BeforeClass
	public void setup()
	{
		SingletonBrowser.initialize();   //singleton pattron we are not allowing multiple instances of login class
	}
	
	@Test(priority=1)
	public void VerifyTitle()
	{
		String title=SingletonBrowser.driver.getTitle();
		System.out.println("Title is :" + title);
		Assert.assertEquals(title, "Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
	}
	
	@Test(priority=2)
	public void VerifyLogo()
	{
		
		Assert.assertEquals(SingletonBrowser.driver.findElement(By.xpath("//span[@class='hmsprite logo']")).isDisplayed(),true);
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		SingletonBrowser.quit();
	}
	

}
