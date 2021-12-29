import Common.Constant.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class TC009 {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", "src/Executables/chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().setSize(new Dimension(1080, 720));
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test (description = "TC09 - User can change password\n" )
    public void TC09(){
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginpage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String newPassword = randomAlphanumeric(8,64);
        System.out.println("New password: " + newPassword);

        ChangePasswordPage changepassPage = new ChangePasswordPage();
        changepassPage.gotoChangePassword();
        String actualMsg = changepassPage.changePassword(Constant.PASSWORD,newPassword).getChangeMessage();
        String expectedMsg = "Your password has been updated!";
        Assert.assertEquals(actualMsg,expectedMsg,"Can not update password.");

        changepassPage.changePassword(newPassword,Constant.PASSWORD);
    }
}
