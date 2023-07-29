import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

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
     * Verifying login is successful with valid credentials.
     */
    public void loginWithPropertyFileData(){
        try {
            FileReader reader = new FileReader("./testdata/testdata.properties");
            Properties props=new Properties();
            props.load(reader);
            String username = props.getProperty("email");
            String password = props.getProperty("password");
            WebElement txtEmailAddress = driver.findElement(By.id("email"));
            txtEmailAddress.sendKeys(username);
            WebElement txtPassword = driver.findElement(By.id("passwd"));
            txtPassword.sendKeys(password);
            WebElement btnSignIn = driver.findElement(By.id("SubmitLogin"));
            btnSignIn.click();

            String expPageTitle = "My account - My Shop";
            String actPageTitle = driver.getTitle();

            if(expPageTitle.equals(actPageTitle)){
                System.out.println("Login is successful with valid credentials");
            }else{
                System.out.println("Login is unsuccessful with valid credentials");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Login with Key press using robot class
     */
    public void loginWithRobotClass(){
        try {
            WebElement txtEmailAddress = driver.findElement(By.id("email"));
            txtEmailAddress.sendKeys("subhendudas8014@gmail.com");
            WebElement txtPassword = driver.findElement(By.id("passwd"));
            txtPassword.sendKeys("Gmail@123456");

            Robot robot = new Robot();
            Thread.sleep(4000);
            /* Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_NUM_LOCK, false); */
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(4000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(4000);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(5000);

            String expPageTitle = "My account - My Shop";
            String actPageTitle = driver.getTitle();

            if(expPageTitle.equals(actPageTitle)){
                System.out.println("Login is successful with valid credentials");
            }else{
                System.out.println("Login is unsuccessful with valid credentials");
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedOperationException e){
            throw new RuntimeException(e);
        }

    }

    /**
     * Login with implicit wait
     */
    public void loginWithImplicitWait(){
        try {
            WebElement btnSignInNavBar = driver.findElement(By.xpath("//a[@class='login']"));
            btnSignInNavBar.click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
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
     * Login validation with explicit wait.
     */
    public void loginValidationWithExplicitWait(){
        try {
            WebElement btnSignInNavBar = driver.findElement(By.xpath("//a[@class='login']"));
            btnSignInNavBar.click();
            WebElement txtEmailAddress = driver.findElement(By.id("email"));
            txtEmailAddress.sendKeys("subhendudas8014@gmail.com");
            WebElement txtPassword = driver.findElement(By.id("passwd"));
            txtPassword.sendKeys("Gmail@123456");
            WebElement btnSignIn = driver.findElement(By.id("SubmitLogin"));
            btnSignIn.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='logout']")));

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
     * Implementation of scrolling
     */
    public void scrollDown(){
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.guru99.com/test/guru99home/");
            Thread.sleep(5000);
            WebElement emailTextBox = driver.findElement(By.id("philadelphia-field-email"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", emailTextBox);
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Handling iframe
     */
    public void iframeHandling(){
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.guru99.com/test/guru99home/");
            Thread.sleep(5000);
            driver.switchTo().frame("a077aa5e");

            WebElement imageInIframe = driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", imageInIframe);
            Thread.sleep(4000);
            imageInIframe.click();

            /* driver.switchTo().parentFrame(); */
            driver.switchTo().defaultContent();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Mouse handling using Action Class
     * Login with mouse click on the login button
     */
    public void actionClassMouseHandlingLogin(){
        try {
            WebElement btnSignInNavBar = driver.findElement(By.xpath("//a[@class='login']"));
            btnSignInNavBar.click();
            Thread.sleep(5000);
            WebElement txtEmailAddress = driver.findElement(By.id("email"));
            txtEmailAddress.sendKeys("subhendudas8014@gmail.com");
            WebElement txtPassword = driver.findElement(By.id("passwd"));
            txtPassword.sendKeys("Gmail@123456");
            WebElement btnSignIn = driver.findElement(By.id("SubmitLogin"));
            /* btnSignIn.click(); */
            Actions actions = new Actions(driver);
            actions.click(btnSignIn).build().perform();
            Thread.sleep(4000);

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
     * Multiple window handling
     * https://toolsqa.com/selenium-webdriver/window-handle-in-selenium/
     */

    /**
     * Multiple tab handling
     * https://toolsqa.com/selenium-webdriver/window-handle-in-selenium/
     */

    /**
     * File upload or windows element handling using Autoit
     */

    /**
     * Data table handling is selenium
     * https://www.guru99.com/handling-dynamic-selenium-webdriver.html
     */

    /**
     * Data driven testing using excel poi jar
     */

    /**
     * Broken image handling
     * https://www.seleniumeasy.com/selenium-tutorials/find-broken-images-in-a-webpage-using-webdriver-java
     */

    /**
     * Use of javascript-executor if send keys method will not work
     */

    /**
     * Popup handling
     */




    public void closeBrowser(){
        driver.close();
    }

}
