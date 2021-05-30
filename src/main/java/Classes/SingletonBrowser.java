package Classes;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SingletonBrowser {
	public static WebDriver driver;

	/*
	 * This is a singleton pattern.u just need to initialize ur webdriver only once
	 * . If webdriver is initialized it will not come inside second if loop
	 */
	
	public static void initialize() {
		String browserName = "chrome";
		if (driver == null);     //if u run initialoze method again after 5 lines of code, it will check the driver and since its not null it will not launch browser
		{
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C://Users/sanka/Documents/ChromeDriverEXE/new/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "C://Users/sanka/Documents/FireFoxEXE/geckodriver.exe");
				driver = new FirefoxDriver();
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("https://www.rediff.com/");

		}
	}
	
	public static void quit() {
		driver.close();
	}

}