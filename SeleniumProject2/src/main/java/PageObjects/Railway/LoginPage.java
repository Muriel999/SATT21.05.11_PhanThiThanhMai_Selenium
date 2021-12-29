package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends GeneralPage {
    //Locators
    private final By txtUsername = By.xpath("//input[@id=\"username\"]");
    private final By txtPassword = By.xpath("//input[@id=\"password\"]");
    private final By btnLogin = By.xpath("//input[@value='login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    //Elements
    public WebElement getTxtUsername() { return Constant.WEBDRIVER.findElement(txtUsername); }

    public WebElement getTxtPassword()
    {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getBtnLogin()
    {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLblLoginErrorMsg()
    {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }


    public void login(String username, String password)
    {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void loginNumber(int n, String Username, String Password)
    {
        int i=0;
        while(i<n){
            LoginPage loginPage = new LoginPage();
            loginPage.gotoLoginpage();
            loginPage.login(Username,Password);

            String actualMsg = loginPage.getErrorMessage();
            String expectedMsg = "Invalid username or password. Please try again.";
            Assert.assertEquals(actualMsg,expectedMsg,"Error message is not displayed as expected");
            i++;
            if(i>=n){
                String errorMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
                Assert.assertEquals(actualMsg,errorMsg,"Error message is not displayed as expected");
            }
        }
    }

}