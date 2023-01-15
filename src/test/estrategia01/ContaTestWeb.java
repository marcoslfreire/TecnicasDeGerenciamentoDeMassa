package estrategia01;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTestWeb {

    private ChromeDriver driver;
    @Before
    public void login(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        driver.get("http://seubarriga.wcaquino.me");
        driver.findElement(By.id("email")).sendKeys("marcos3dt@marcos");
        driver.findElement(By.id("senha")).sendKeys("123");
        driver.findElement(By.tagName("button")).click();
    }
    @Test
    public void test_01_inserir(){
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Adicionar")).click();
        driver.findElement(By.id("nome")).sendKeys("ContaEstrategicaDeMassa01");
        driver.findElement(By.tagName("button")).click();
        String msgAlert = driver.findElement(By.xpath("//div[@class = 'alert alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", msgAlert);

    }
    @Test
    public void  test_02_Cosultar(){
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Listar")).click();
        driver.findElement(By.xpath("//td[contains(text(),'ContaEstrategicaDeMassa01')]/..// a")).click();
        String nomeConta = driver.findElement(By.id("nome")).getAttribute("value");
        Assert.assertEquals("ContaEstrategicaDeMassa01", nomeConta);
    }
    @Test
    public void  test_03_Alterar(){
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Listar")).click();
        driver.findElement(By.xpath("//td[contains(text(),'ContaEstrategicaDeMassa01')]/..// a")).click();
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys("ContaEstrategicaDeMassa01_ALTERADA");

        driver.findElement(By.tagName("button")).click();
        String msgAlert = driver.findElement(By.xpath("//div[@class = 'alert alert-success']")).getText();
        Assert.assertEquals("Conta alterada com sucesso!", msgAlert);
    }
    @Test
    public void text_04_remover(){
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Listar")).click();
        driver.findElement(By.xpath("//td[contains(text(),'ContaEstrategicaDeMassa01')]/..// a[2]")).click();
        String msgAlert = driver.findElement(By.xpath("//div[@class = 'alert alert-success']")).getText();
        Assert.assertEquals("Conta removida com sucesso!", msgAlert);


    }

    //td[contains(text(),'ContaEstrategicaDeMassa01')]/..// a//td[contains(text(),'ContaEstrategicaDeMassa01')]/..// a
    @After
    public void fechar(){
        driver.quit();
    }
}
