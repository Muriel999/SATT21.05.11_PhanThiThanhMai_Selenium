import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC014 extends TestBase{
    @Test(description = "TC-14:User can book many tickets at a time", dataProviderClass = DataProcessing.class, dataProvider = "dataProviderTC14")
    public void TC14(String data) {
        String[] bookInfoArray = data.split(",");
        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginpage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.gotoBookticket();

        bookTicketPage.selectDepartDate(bookInfoArray[0]);
        bookTicketPage.selectDepartFrom(bookInfoArray[1]);
        bookTicketPage.selectArriveAt(bookInfoArray[2]);
        bookTicketPage.selectSeatType(bookInfoArray[3]);
        bookTicketPage.selectTicketAmount(bookInfoArray[4]);
        bookTicketPage.bookTicketSubmit();

        String actualBookTicketSuccessfullyTitle = bookTicketPage.getTicketBookedSuccessfullyTitle();
        String expectedBookTicketSuccessfullyTitle = "Ticket booked successfully!";

        Assert.assertEquals(actualBookTicketSuccessfullyTitle,expectedBookTicketSuccessfullyTitle,"Title doesn't display when user have booked successfully");

        String actualDepartStation = bookTicketPage.getDepartStation();
        String expectedDepartStation = bookInfoArray[1];

        Assert.assertEquals(actualDepartStation,expectedDepartStation,"Depart Station is not same as Depart Station that user have booked");

        String actualArriveStation = bookTicketPage.getArriveStation();
        String expectedArriveStation = bookInfoArray[2];

        Assert.assertEquals(actualArriveStation,expectedArriveStation, "Arrive Station is not same as Arrive Station that user have booked");

                String actualSeatType = bookTicketPage.getSeatType();
        String expectedSeatType = bookInfoArray[3];

        Assert.assertEquals(bookInfoArray,expectedSeatType,"Seat Type is not same as Seat Type that user have booked");

        String actualDepartDate = bookTicketPage.getDepartDate();
        String expectedDepartDate = bookInfoArray[0];

        Assert.assertEquals(actualDepartDate,expectedDepartDate,"Depart Date is not same as Depart Date that user have booked");

        String actualTicketAmount = bookTicketPage.getBookedTicketAmount();
        String expectedTicketAmount = bookInfoArray[4];

        Assert.assertEquals(actualTicketAmount,expectedTicketAmount,"TicketAmount is not same as Ticket Amount that user have booked");
    }
}

