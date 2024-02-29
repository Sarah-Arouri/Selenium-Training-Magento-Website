package supports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

public interface Constants {
	static public WebDriver driver = new ChromeDriver();
	//static public WebDriver driver1 = new EdgeDriver();
	static public String email = "CypressUser@gmail.com";
	static public String password = "test@123";

}
