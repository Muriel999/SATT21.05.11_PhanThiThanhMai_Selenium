import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

public class TC006 {
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

    @Test (description ="TC06 - Additional pages display once user logged in\n" )
    public void TC06(){
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginpage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        Assert.assertEquals(Optional.of(loginPage.isLogout()), Optional.of(true), "Tab 'Logout' do not display");
        Assert.assertEquals(Optional.of(loginPage.isChangePass()), Optional.of(true), "Tab 'Change password' do not display");
        Assert.assertEquals(Optional.of(loginPage.isMyTicket()), Optional.of(true), "Tab 'My ticket' do not display");
    }
}
