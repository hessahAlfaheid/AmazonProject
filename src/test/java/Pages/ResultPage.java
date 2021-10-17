package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ResultPage {
	WebDriver  driver;
	By resulintList= By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']");
	
	
	public ResultPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void getSearchResult() {
		
		List<WebElement> getData =  driver.findElements(resulintList);
		
		System.out.println("Total No. of Product : " + getData.size());
		
		for(WebElement e : getData) {
			System.out.println(e.getText());
		}
	}
}
