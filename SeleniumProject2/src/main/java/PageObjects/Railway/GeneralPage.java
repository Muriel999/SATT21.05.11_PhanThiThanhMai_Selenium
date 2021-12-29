package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href=\"/Account/Login.cshtml\"]");
    private final By tabLogout = By.xpath("//li//span[text()='My ticket']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By lblConfirmMessage = By.xpath("//div[@id='content']//p");
    private final By lblErrorRegisterMassage = By.xpath("//p[@class=\"message error\"]");
    private final By lblErrorMessage = By.xpath("//p[@class='message error LoginForm']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href=\"/Page/BookTicketPage.cshtml\"]");
    private final By nameLogin = By.xpath("//li[@class='selected']//span");
    private final By tabMyTicket = By.xpath("//li//span[text()='My ticket']");
    private final By tabChangePass = By.xpath("//div[@id='menu']//a[@href=\"/Account/ChangePassword.cshtml\"]");
    private final By lblChangeMessage = By.xpath("//p[@class=\"message success\"]");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href=\"/Account/Register.cshtml\"]");
    private final By lblNextPassword = By.xpath("//li[@class=\"password\"]//label[@class=\"validation-error\"]");
    private final By lblNextPid = By.xpath("//li[@class=\"pid-number\"]//label[@class=\"validation-error\"]");

    //Elements
    protected WebElement getTabLogin(){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout(){
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getLblWelcomeMessage(){
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getLblConfirmMessage() { return Constant.WEBDRIVER.findElement(lblConfirmMessage); }

    protected WebElement getLblErrorRegisterMessage() { return Constant.WEBDRIVER.findElement(lblErrorRegisterMassage); }

    protected WebElement getLblErrorMessage(){
        return Constant.WEBDRIVER.findElement(lblErrorMessage);
    }

    protected WebElement getTabBookTicket(){
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getLblNameLogin(){
        return Constant.WEBDRIVER.findElement(nameLogin);
    }

    protected WebElement getTabMyTicket(){
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    protected WebElement getTabChangePass(){
        return Constant.WEBDRIVER.findElement(tabChangePass);
    }

    protected WebElement getTabRegister(){
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getLblChangeMessage() { return Constant.WEBDRIVER.findElement(lblChangeMessage); }

    protected WebElement getLblNextPassword() { return Constant.WEBDRIVER.findElement(lblNextPassword); }

    protected WebElement getLblNextPid() { return Constant.WEBDRIVER.findElement(lblNextPid); }


    //methods
    public String getWelcomeMessage()
    {
        return this.getLblWelcomeMessage().getText();
    }

    public String getConfirmMessage() { return this.getLblConfirmMessage().getText(); }

    public String getErrorMessage()
    {
        return this.getLblErrorMessage().getText();
    }

    public String getErrorRegisterMessage() { return this.getLblErrorRegisterMessage().getText(); }

    public String getNameLogin() { return this.getLblNameLogin().getText();}

    public Boolean isMyTicket() { return this.getTabMyTicket().isDisplayed(); }

    public Boolean isChangePass() { return this.getTabChangePass().isDisplayed(); }

    public String getChangeMessage() { return this.getLblChangeMessage().getText(); }

    public Boolean isLogout() { return this.getTabLogout().isDisplayed(); }

    public String getNextPassword() { return this.getLblNextPassword().getText(); }

    public String getNextPid() { return this.getLblNextPid().getText(); }

    //Method Login
    public void gotoLoginpage()
    {
        this.getTabLogin().click();
        System.out.println("click tab login");
    }

    //Method BookTicket
    public BookTicketPage gotoBookticket(){
        this.getTabBookTicket().click();
        System.out.println("click tab BookTicket");
        return new BookTicketPage();
    }

    //Method Register
    public void gotoRegisterPage()
    {
        this.getTabRegister().click();
        System.out.println("click tab Register");
    }

    //Method ChangePassword
    public void gotoChangePassword()
    {
        this.getTabChangePass().click();
        System.out.println("click tab Change Password");
    }
}