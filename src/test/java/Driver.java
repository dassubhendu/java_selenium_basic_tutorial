public class Driver {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World");
        MethodRepository mr = new MethodRepository();

        mr.browserApplicationLaunch("firefox", "http://www.automationpractice.pl/index.php?controller=my-account");
        /* mr.loginApplicationAndVerifyValidLogin(); */
        /* mr.sortingSelectionOfDresses(); */
        /* mr.loginWithPropertyFileData(); */
        /* mr.loginWithRobotClass(); */
        /* mr.loginWithImplicitWait(); */
        /* mr.loginValidationWithExplicitWait(); */
        /* mr.scrollDown(); */
        /* mr.iframeHandling(); */
        /* mr.actionClassMouseHandlingLogin(); */

        Thread.sleep(8000);
        mr.closeBrowser();

    }
}