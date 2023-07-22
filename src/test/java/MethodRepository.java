import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MethodRepository {

    private WebDriver driver;

    /***
     * Browser and application launching using WebDriver manager.
     * Maximising the browser window.
     */
    public void browserApplicationLaunch(String browserName, String url) throws InterruptedException {

    try {
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
    }catch (Exception e){
        System.out.println(e);
    }

    }

    /**
     * Login into application.
     * Verifying login is successful with valid credentials.
     * Below function helps to understand 'Click element and enter text'.
     */
    public void loginApplicationAndVerifyValidLogin(){
        try {
            WebElement btnSignInNavBar = driver.findElement(By.xpath("//a[@class='login']"));
            btnSignInNavBar.click();
            Thread.sleep(5000);
            WebElement txtEmailAddress = driver.findElement(By.id("email"));
            txtEmailAddress.sendKeys("subhendudas8014@gmail.com");
            WebElement txtPassword = driver.findElement(By.id("passwd"));
            txtPassword.sendKeys("Gmail@123456");
            WebElement btnSignIn = driver.findElement(By.id("SubmitLogin"));
            btnSignIn.click();

            String expPageTitle = "My account - My Shop";
            String actPageTitle = driver.getTitle();

            if(expPageTitle.equals(actPageTitle)){
                System.out.println("Login is successful with valid credentials");
            }else{
                System.out.println("Login is unsuccessful with valid credentials");
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * Sorting the selection of dresses.
     * The below function helps to understand how to select item from dropdown.
     */
    public void sortingSelectionOfDresses(){
        WebElement btnDresses = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/a[@title='Dresses']"));
        btnDresses.click();
        WebElement dropDownSortBy = driver.findElement(By.id("selectProductSort"));
        Select st = new Select(dropDownSortBy);
        st.selectByValue("price:desc");
    }

    /**
     * Login with test data and that will be fetched from property file.
     */
    public void loginWithPropertyFileData(){

    }

    public void closeBrowser(){
        driver.close();
    }

}
