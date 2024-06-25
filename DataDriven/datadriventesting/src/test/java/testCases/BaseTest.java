package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	/*if we have common methods for all class then we can write it here just to avoid rewritting code for all classes
	like setUp(),tearDown(), passing random data methods
	*/
	public WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) throws IOException {
		
		//Configuring properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		prop= new Properties();
		prop.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		switch (br) {
		case "chrome": driver = new ChromeDriver();
			break;
		case "edge": driver=new EdgeDriver();
		
		case "firefox" : driver=new FirefoxDriver();
		
		default: System.out.println("Invalid Browser");
			return;
		}
		
		
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://tutorialsninja.com/demo/\r\n");
		driver.get(prop.getProperty("appUrl"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	
	/*org.apache.commons.lang3
		Class RandomStringUtils
	We you above class to generate random data for test registration functionality
	for that we add dependence in pom.xml
	<dependency>
		    <groupId>org.apache.commons</groupId>
		    <artifactId>commons-lang3</artifactId>
		    <version>3.14.0</version>
	</dependency>
	
	<dependency>
		    <groupId>commons-io</groupId>
		    <artifactId>commons-io</artifactId>
		    <version>2.16.1</version>
	</dependency>
	*/
	
	
	//for first name,lastname,email
	public String randomString() {
		
		String generateString = RandomStringUtils.randomAlphabetic(10);
		return generateString ;
		
	}
	//for phone number
	public String randomeNumber() {
		String generateNumber = RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}
	
	//for combination password
	public String randAlphaNumeric()
	{
		String alpha = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return(alpha+num);
	}
	
	
	
}
