package test.extrategia01;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ContaTestWeb {

    private ChromeDriver driver;

    public void login(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        driver.get("http://seubarriga.wcaquino.me");
        driver.findElement(By.id("email")).sendKeys("marcos3dt@marcos");
        driver.findElement(By.id("senha")).sendKeys("123");
        driver.findElement(By.tagName("button")).click();
    }

    @Test
    public void inserir(){
        login();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        driver.get("http://seubarriga.wcaquino.me");
        driver.findElement(By.id("email")).sendKeys("marcos3dt@marcos");
        driver.findElement(By.id("senha")).sendKeys("123");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By)

    }

    public void fechar(){
        driver.quit();
    }
}

