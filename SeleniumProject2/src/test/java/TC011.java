import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class TC011 {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", "src/Executables/chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().setSize(new Dimension(1080, 1080));
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test (description = "TC11 - User can't create account while password and PID fields are empty\n")
    public void TC11(){
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterPage();

        String Email = randomAlphanumeric(1,22)+"@gmail.com";
        System.out.println("Email: " + Email);

        registerPage.register(Email, null, null, null);

        String actualMsg = registerPage.getErrorRegisterMessage();
        String actualMsgNextPassword = registerPage.getNextPassword();
        String actualMsgNextPid = registerPage.getNextPid();

        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedMsgNextPassword = "Invalid password length";
        String expectedMsgNextPid = "Invalid ID length";

        Assert.assertEquals(actualMsg,expectedMsg,"Error message do not display.");
        Assert.assertEquals(actualMsgNextPassword,expectedMsgNextPassword,"Error message do not display on next 'Password' filed.");
        Assert.assertEquals(actualMsgNextPid,expectedMsgNextPid,"Error message do not display on next 'PID/Passport Number' filed.");

    }
}