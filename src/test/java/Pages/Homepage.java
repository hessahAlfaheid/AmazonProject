package Pages;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Homepage {
	String getRsult[]= new String[2]; 
	Statement stmt;
	WebDriver driver; 
	By categoryDDL = By.xpath("//*[@id=\"searchDropdownBox\"]");
	By searchBar= By.xpath("//*[@id=\"twotabsearchtextbox\"]");
	By submit= By.xpath("//*[@id=\"nav-search-submit-button\"]");
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		}

	public String[] JDBCSetupForAmazonDB() {
		try {
			// The driver class for the mysql database is  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/searchbox","root","");

			
			// Retrieve products list from the db 
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from product");
			
			// Print and fetch query result in array
			while(rs.next()){
				System.out.println("Category: "+ rs.getString(1)+" , Product: "+ rs.getString(2));
				getRsult[0] =rs.getString(1);
				getRsult[1] = rs.getString(2);
			}
		}
		catch(ClassNotFoundException e) {
			System.out.print("The class is not found"+e.getException());
			
		}
		catch(SQLException e){
			System.out.println("Sql Exception");
			e.printStackTrace();
		}
		
		return getRsult;
	}
	
	public void search(String[] getRsult) {
		
		WebElement category = driver.findElement(categoryDDL);
		Select selectOption = new Select(category);
		selectOption.selectByVisibleText(getRsult[0]);
		
		WebElement searchValue = driver.findElement(searchBar);
		searchValue.sendKeys(getRsult[1]);
		
		WebElement search =driver.findElement(submit);
		search.click();
		
	}
}
