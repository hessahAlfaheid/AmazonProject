package TestScript;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.Homepage;
import Pages.ResultPage;

public class Test {


	public static void main(String[] args) {

		final String driverPath="driver/chromedriver.exe";
		WebDriver driver= null;
		Homepage Homepage= null;
		ResultPage resultpage = null;
		

		System.setProperty("webdriver.chrome.driver", driverPath); // Add the path for the driver 
		driver = new ChromeDriver();
		driver.get("https://www.amazon.sa/?language=en_AE");// go the URL 
		driver.manage().window().maximize();// maximize the window
		driver.manage().timeouts().implicitlyWait(4500, TimeUnit.MILLISECONDS);
		Homepage=new Homepage(driver);
		String[] searchValues= Homepage.JDBCSetupForAmazonDB();
		((Homepage) Homepage).search(searchValues);
		resultpage = new ResultPage(driver);
		resultpage= new ResultPage(driver);
		resultpage.getSearchResult();
		driver.manage().timeouts().implicitlyWait(19, TimeUnit.SECONDS);
		driver.close();
		
		
	}

}
