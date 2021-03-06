
package net.weg.easy.webdriver.catalog;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.TestCase;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExemploTest extends TestCase {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\cryst\\OneDrive\\�rea de Trabalho\\estudantil\\GitHub\\cat-test-system\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testEmail() throws Exception {
		driver.get("http://www.gmail.com.br/");
		//loga no email
		WebElement campoDeEmail = driver.findElement(By.name("identifier"));
		WebElement btnProximaEmail = driver.findElement(By.className("RveJvd"));
		campoDeEmail.sendKeys("testepinguino@gmail.com");
		btnProximaEmail.click();
		
		boolean achouPaginaSenha = driver.getPageSource().contains("testepinguino@gmail.com");

		try {
			(new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.name("password"));
				}
			});
		} catch (Exception e) {
			System.out.println(e);
		}
Thread.sleep(3000);

		WebElement campoDeSenha = driver.findElement(By.name("password"));
		WebElement btnProximaSenha = driver.findElement(By.className("RveJvd"));
		campoDeSenha.sendKeys("coxinha123");
		btnProximaSenha.click();

		//verifica se email abriu
		Thread.sleep(5000);
		boolean achouMailBox = driver.getPageSource().contains("Gmail");
		boolean achouCaixaEntrada = driver.getPageSource().contains("Caixa de entrada");

		//tenta clicar no bot�o escrever
		WebElement btnEscrever = driver.findElement(By.className("z0"));
		Actions builder = new Actions(driver);
		try {
			builder.moveToElement(btnEscrever).build().perform();
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}

		btnEscrever.click();

		Thread.sleep(3000);
//escreve o email
		WebElement campoPara = driver.findElement(By.name("to"));
		WebElement campoAssunto = driver.findElement(By.name("subjectbox"));
		campoPara.sendKeys("testepinguino@gmail.com");
		campoAssunto.sendKeys("Teste de Sistema");

		WebElement campoTexto = driver.findElement(By.xpath("(.//*[@aria-label='Corpo da mensagem'])[2]"));
		campoTexto.click();
		Thread.sleep(2000);
		campoTexto = driver.findElement(By.xpath("(.//*[@aria-label='Corpo da mensagem'])[2]"));
		campoTexto.sendKeys("Selenium webdrive � legal!");
		WebElement btnEnviar = driver.findElement(By.className("gU"));


Thread.sleep(2000);

		btnEnviar.click();

		Thread.sleep(5000);

		//abre o email foi recebido
		WebElement clicarEmailRecebido = driver.findElement(By.className("yW"));

		clicarEmailRecebido.click();

		Thread.sleep(2000);

		//responde o email
		WebElement btnResponder = driver.findElement(By.className("ams"));
		btnResponder.click();

		Thread.sleep(2000);

		WebElement campoResposta = driver.findElement(By.className("Am"));

		campoResposta.sendKeys("Ok, Email lindo. Obrigado");

		WebElement btnEnviarResposta = driver.findElement(By.className("gU"));

		Thread.sleep(1000);

		btnEnviarResposta.click();

		Thread.sleep(2000);




		//verifica a caixa de saida
		WebElement btnCaixaSaida = driver.findElement(By.xpath("//div[@class='TN bzz aHS-bnu']"));

		btnCaixaSaida.click();

		Thread.sleep(2000);

		WebElement emailEnviado = driver.findElement(By.className("yX"));

		emailEnviado.click();

		Thread.sleep(2000);

		//exclui o email

		btnCaixaSaida.click();
		Thread.sleep(2000);

		WebElement checkbox = driver.findElement(By.className("Oz-x3"));

		checkbox.click();



	    assertTrue(achouMailBox);
		assertTrue(achouPaginaSenha);
	    assertTrue(achouCaixaEntrada);

	}





}
