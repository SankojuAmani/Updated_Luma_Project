package org.example;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Test_Luma_Project {
    WebDriver driver;

    @BeforeTest
    public void beforetest() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test(priority = -3)
    public void ListOfElements() throws Exception {
        Luma_Project page = new Luma_Project(driver);
        page.ListOfItems();
    }
    @Test(priority = 1)
    public void VerifyMouseActions() throws InterruptedException {
        Luma_Project page = new Luma_Project(driver);
        page.MouseActions();
    }
    @Test(priority = 2)
    public void VerifyMenActions() throws InterruptedException {
        Luma_Project page = new Luma_Project(driver);
        page.MenInHeader();
    }

    @Test(priority = 3)
    public void CreateAccount() throws InterruptedException {
        Luma_Project page = new Luma_Project(driver);
        page.CreateAccountBtn();
    }

    @Test(priority = 4)
    public void SearchOperation() throws InterruptedException {
        Luma_Project page = new Luma_Project(driver);
        String[] searchInputs = {"Radiant Tee", "Breath-Easy Tank", "Fusion Backpack"};
        page.searchingItems(searchInputs);
    }
    @Test(priority = 5)
    public void VerifySearchwithWrongWords() throws InterruptedException {
        Luma_Project page = new Luma_Project(driver);
        String[] searchInputs = {"HeroHoodie", "PushItMessengerBag"};
        page.WrongWordSearch(searchInputs);
    }

    @Test(priority = 6)
    public void VerifySignOut() throws InterruptedException {
        Luma_Project page = new Luma_Project(driver);
        page.SignintoLuma();
        page.SignOut();

    }

    @Test(priority = 7)
    public void CapturingHomePage() throws Exception {
        Luma_Project page = new Luma_Project(driver);
        page.Home_ScreenShot();
    }

    @Test(priority = 8)
    public void VerifyMyShoppinginLuma() throws Exception{
        Luma_Project page = new Luma_Project(driver);
        page.MyShoppinginLuma();
    }
    @Test(priority = 9)
    public void VerifyShopinLuma() throws Exception{
        Luma_Project page = new Luma_Project(driver);
        page.ShopinLuma();
    }
    @Test(priority = 10)
    public void VerifyAddToCart() throws Exception{
        Luma_Project page = new Luma_Project(driver);
        page.SignInAddtoCart();
    }

    @Test(priority = 11)
    public void VerifyRemoveFromCart() throws Exception{
        Luma_Project page = new Luma_Project(driver);
        page.RemoveFromCart();

    }

    @Test(priority = 12)
    public void VerifyCancelFromCart() throws Exception {
        Luma_Project page = new Luma_Project(driver);
        page.CancelRemoveFromCart();
    }

    @Test(priority = 13)
    public void VerifyInCorrectPageTitle() throws Exception {
        Luma_Project page = new Luma_Project(driver);
        page.IncorrectPageTitle();
    }
    @Test(priority = 14)
    public void VerifyCorrectPageTitle() throws Exception {
        Luma_Project page = new Luma_Project(driver);
        page.CorrectPageTitle();
    }
    @Test(enabled = false)
    public void VerifyBrokenLinks() throws Exception {
        Luma_Project page = new Luma_Project(driver);
        page.BrokenLinks();
    }
    @Test(dataProvider = "Userinfo",priority = -2)
    public void VerifyDataProviders(String uname, String password) throws Exception {
        Luma_Project page = new Luma_Project(driver);
        page.DataProviders(uname,password);
    }
    @DataProvider(name="Userinfo")
    public Object[][] testCredentials()
    {
        Object[][] cred = new Object[2][2];
        cred[0][0] = "abc@gmail.com";
        cred[0][1] = "Luma@123";
        cred[1][0] = "xyz@gmail.com";
        cred[1][1] = "Luma@123";
        return cred;
    }
    @Test(priority = -1)
    public void VerifyForgotPassword() throws Exception {
        Luma_Project page = new Luma_Project(driver);
        page.ForgotYourPassword();
    }
    @Test(priority = 15)
    public void VerifySearchandClear() throws Exception {
        Luma_Project page = new Luma_Project(driver);
        page.SearchandClear();
    }
    @Test(priority = 16)
    public void VerifyFooterLinks() throws Exception {
        Luma_Project page = new Luma_Project(driver);
        page.FooterOptions();
    }
    @Test(priority = 17)
    public void VerifyMyAccountEdit() throws Exception {
        Luma_Project page = new Luma_Project(driver);
        page.MyAccountEdit();
    }
    @Test(priority = 18)
    public void VerifyAddressDetails() throws Exception {
        Luma_Project page = new Luma_Project(driver);
        page.ManageAddresses();
    }
    @Test(priority = 19)
    public void VerifyPaymentDetails() throws Exception{
        Luma_Project page = new Luma_Project(driver);
        page.PaymentDetails();
    }
    @Test(priority = 20)
    public void VerifyMyWishList() throws Exception{
        Luma_Project page = new Luma_Project(driver);
        page.AddToWishList();
    }
    @Test(priority = 21)
    public void VerifyMyOrders() throws Exception{
        Luma_Project page = new Luma_Project(driver);
        page.MyOrders();
    }
    @AfterTest
    public void aftertest() {
        driver.quit();
    }

}


