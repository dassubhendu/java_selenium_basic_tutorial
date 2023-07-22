import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MethodRepository {

    private WebDriver driver;

    /***
     * Browser and application launching using WebDriver manager.
     * Maximising the browser window.
     */
    public void browserApplicationLaunch(String browserName, String url) throws InterruptedException {

        if(browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        if(browserName.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }

        driver.get(url);
        Thread.sleep(10000);
    }

}
