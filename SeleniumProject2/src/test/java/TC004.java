import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC004 {
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
    @Test
    public void TC04(){
        System.out.println("TC04 - User can log into Railway with valid username and password\n");

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.open();

        LoginPage loginPage = new LoginPage();

        String actuaMsg = loginPage.getNameLogin();
        System.out.println(actuaMsg);
        String expectedMsg = "Login";
        Assert.assertEquals(actuaMsg,expectedMsg,"Welcome message is not displayed as expected");

    }
}
