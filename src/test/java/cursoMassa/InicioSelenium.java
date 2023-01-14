package cursoMassa;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class InicioSelenium {
	
	public static void main(String[] args) {
//		System.setProperty( " webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		
		driver.get("http://seubarriga.wcaquino.me"); 
		
		driver.findElement(By.id("email")).sendKeys("marcos3dt@marcos");
		driver.findElement(By.id("senha")).sendKeys("123");
		driver.findElement(By.tagName("button")).click();
//		driver.quit();
		
	}
}
