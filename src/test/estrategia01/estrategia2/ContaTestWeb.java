package estrategia01.estrategia2;

import com.github.javafaker.Faker;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;



public class ContaTestWeb {
    private Faker faker = new Faker();
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
    public void inserir(){
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Adicionar")).click();
        driver.findElement(By.id("nome")).sendKeys(faker.harryPotter().character());
        driver.findElement(By.tagName("button")).click();
        String msgAlert = driver.findElement(By.xpath("//div[@class = 'alert alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", msgAlert);

    }

    @Test
    public void Cosultar(){
        String conta = inserirConta();
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Listar")).click();
        driver.findElement(By.xpath("//td[contains(text(),'"+conta+"')]/..// a")).click();
        String nomeConta = driver.findElement(By.id("nome")).getAttribute("value");
        Assert.assertEquals(conta, nomeConta);
    }
    @Test
    public void  Alterar(){
        String conta = inserirConta();
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Listar")).click();
        driver.findElement(By.xpath("//td[contains(text(),'"+conta+"')]/..// a")).click();
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys("Alterada");

        driver.findElement(By.tagName("button")).click();
        String msgAlert = driver.findElement(By.xpath("//div[@class = 'alert alert-success']")).getText();
        Assert.assertEquals("Conta alterada com sucesso!", msgAlert);
    }
    @Test
    public void remover(){
        String conta = inserirConta();
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Listar")).click();
        driver.findElement(By.xpath("//td[contains(text(),'"+conta+"')]/..// a[2]")).click();
        String msgAlert = driver.findElement(By.xpath("//div[@class = 'alert alert-success']")).getText();
        Assert.assertEquals("Conta removida com sucesso!", msgAlert);


    }

    private String inserirConta(){
        String registro = faker.harryPotter().character();
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Adicionar")).click();
        driver.findElement(By.id("nome")).sendKeys(registro);
        driver.findElement(By.tagName("button")).click();
        return registro;
    }

    //td[contains(text(),'ContaEstrategicaDeMassa01')]/..// a//td[contains(text(),'ContaEstrategicaDeMassa01')]/..// a
    @After
    public void fechar(){
        driver.quit();
    }
}
