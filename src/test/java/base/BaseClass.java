package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected WebDriver driver;

    public BaseClass(WebDriver driver)
    {
        this.driver=driver;
    }
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
