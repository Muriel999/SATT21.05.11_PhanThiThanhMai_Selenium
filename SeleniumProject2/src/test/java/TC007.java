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

public class TC007 {
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

    @Test (description = "TC07 - User can create new account\n" )
    public void TC07(){
        HomePage homePage = new HomePage();
        homePage.open();

        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterPage();

        String Email = randomAlphanumeric(1,22)+"@gmail.com";
        String Password = randomAlphanumeric(8,64);

        System.out.println("Email: " + Email);
        System.out.println("Password: " + Password);

        registerPage.register(Email, Password, Password, "1234567890");

        String actualMsg = registerPage.getConfirmMessage();
        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg,expectedMsg,"Register failed");
    }
}
