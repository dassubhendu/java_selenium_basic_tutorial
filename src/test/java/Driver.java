import java.io.IOException;

public class Driver {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Hello World");
        MethodRepository mr = new MethodRepository();

         mr.browserApplicationLaunch("chrome", "http://www.automationpractice.pl/index.php?controller=my-account");
        /* mr.loginApplicationAndVerifyValidLogin(); */
        /* mr.sortingSelectionOfDresses(); */
        /* mr.loginWithPropertyFileData(); */
        /* mr.loginWithRobotClass(); */
        /* mr.loginWithImplicitWait(); */
        /* mr.loginValidationWithExplicitWait(); */
        /* mr.scrollDown(); */
        /* mr.iframeHandling(); */
        /* mr.actionClassMouseHandlingLogin(); */
        /* mr.multipleWindowHandling(); */
        /* mr.multipleTabHandling(); */
        /* mr.popupHandling(); */
        /*mr.sendKeysWithJavaScriptExecutor();*/
        mr.dataDrivenExcel();


        /* Thread.sleep(8000);
        mr.closeAllBrowser();*/

    }
}