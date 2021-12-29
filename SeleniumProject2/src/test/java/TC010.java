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

public class TC010 {
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

    @Test (description = "TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"\n" )
    public void TC10(){
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterPage();

        String Email = randomAlphanumeric(1,22)+"@gmail.com";
        String Password = randomAlphanumeric(8,64);

        System.out.println("Email: " + Email);
        System.out.println("Password: " + Password);

        registerPage.register(Email, Password, "khonggiongpassword", "1234567890");

        String actualMsg = registerPage.getErrorRegisterMessage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg,expectedMsg,"Error message do not display.");
    }
}
