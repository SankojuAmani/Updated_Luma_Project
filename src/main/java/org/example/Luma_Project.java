package org.example;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Luma_Project {

    WebDriver driver;
    WebDriverWait wait;

    public Luma_Project(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    //SearchOption Test case
    By searchbox = By.id("search");
    By search_btn = By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button");
    //Create an Account Test case
    By Create_an_Account = By.linkText("Create an Account");
    By Firstname = By.id("firstname");
    By Lastname = By.id("lastname");
    By Email = By.name("email");
    By Password = By.id("password");
    By ConfirmationPassword = By.id("password-confirmation");
    By Create_btn = By.xpath(".//button[@class=\"action submit primary\"]");
    //Shopping add to cart not selected size & color
    By Tshirt = By.linkText("Radiant Tee");
    By Add_Cart_btn = By.xpath("//*[@id=\"product-addtocart-button\"]/span");
    //Shopping add to cart by selecting size & color
    By Inners = By.linkText("Breathe-Easy Tank");
    By Size = By.xpath(".//div[@id=\"option-label-size-143-item-166\"]");
    By Quantity = By.xpath(".//input[@name=\"qty\"]");
    By Color = By.id("option-label-color-93-item-57");

    //Sign In Page
    By Sign_in_btn = By.linkText("Sign In");
    By Username = By.xpath(".//input[@name=\"login[username]\"]");
    By Pass = By.xpath(".//input[@id=\"pass\"]");
    By Sign_in = By.id("send2");
    //Sign Out Page
    By Drop_Down_Open = By.xpath(".//li[@class=\"customer-welcome\"]");
    By Drop_Down_Close = By.xpath(".//li[@class=\"customer-welcome active\"]");
    By Sign_Out_Btn = By.linkText("Sign Out");
    //I am Addtocart after signIn to the Application
    By Yoga_Frame = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[1]/a/img");
    By Cart_Cross_mark = By.id("btn-minicart-close");


    // Search code
    public void searchingItems(String[] searchInputs) {
        for (String item : searchInputs) {
            WebElement searchBoxElement = driver.findElement(searchbox);
            searchBoxElement.clear();
            searchBoxElement.sendKeys(item);
            driver.findElement(search_btn).click();
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinner")));
        }
    }

    // Create an account code
    public void CreateAccountBtn() throws InterruptedException {
        driver.findElement(Create_an_Account).click();
        driver.findElement(Firstname).sendKeys("Amani");
        driver.findElement(Lastname).sendKeys("Sankoju");
        driver.findElement(Email).sendKeys("amani.sankoju13@gmail.com");
        driver.findElement(Password).sendKeys("Luma@123");
        driver.findElement(ConfirmationPassword).sendKeys("Luma@123");
        driver.findElement(Create_btn).click();
        Thread.sleep(2000);
    }

    // Tshirts if not selected the size, colour and clicked on Add to cart option
    public void MyShoppinginLuma() {
        WebElement tshirtElement = wait.until(ExpectedConditions.elementToBeClickable(Tshirt));
        tshirtElement.click();

        WebElement addCartElement = wait.until(ExpectedConditions.elementToBeClickable(Add_Cart_btn));
        addCartElement.click();

        driver.navigate().back();
    }

    // Tshirts if selected the size, colour and clicked on Add to cart option
    public void ShopinLuma() {
        driver.findElement(Inners).click();
        driver.findElement(Size).click();
        driver.findElement(Color).click();
        driver.findElement(Quantity).clear();
        driver.findElement(Quantity).sendKeys("10");
        driver.findElement(Add_Cart_btn).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinner")));
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a/img")).click();
    }

    //Wrong words search in searchbar
    public void WrongWordSearch(String[] searchInputs) {
        for (String item : searchInputs) {
            WebElement searchBoxElement = driver.findElement(searchbox);
            searchBoxElement.clear();
            searchBoxElement.sendKeys(item);
            driver.findElement(search_btn).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinner")));
        }
    }

    //List of items on the page
    public void ListOfItems() throws InterruptedException {
        WebElement parentElement = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[3]/div/div/ol"));
        List<WebElement> listItems = parentElement.findElements(By.tagName("a"));
        for (WebElement listItem : listItems) {
            String text = listItem.getText().trim();
            if (!text.isEmpty()) {
                System.out.println("List item text: " + text);
                System.out.println("List item text: " + text);
            }
        }

    }
    //Clear the searchbar
    public void SearchandClear() {
        WebElement searchBoxElement = driver.findElement(searchbox);
        searchBoxElement.sendKeys("Abcde");
        wait.until(ExpectedConditions.textToBePresentInElementValue(searchBoxElement, "Abcde"));
        searchBoxElement.clear();
    }
    //Click on the Footer options
    public void FooterOptions() throws InterruptedException {
        driver.findElement(By.linkText("Search Terms")).click();
        driver.findElement(By.linkText("Privacy and Cookie Policy")).click();
        driver.findElement(By.linkText("Advanced Search")).click();
    }
    //Sign_Into_Application
    public void SignintoLuma() {
        driver.findElement(Sign_in_btn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Username));
        driver.findElement(Username).sendKeys("amani.sankoju13@gmail.com");
        driver.findElement(Pass).sendKeys("Luma@123");
        driver.findElement(Sign_in).click();
    }
    //DataProviders
    public void DataProviders(String uname, String password) {
        driver.findElement(Sign_in_btn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Username));
        driver.findElement(Username).sendKeys(uname);
        driver.findElement(Pass).sendKeys(password);
        driver.findElement(Sign_in).click();
    }
    //Sign_Out_From_Application
    public void SignOut() {
        Duration waitTimeout = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver,waitTimeout);
        WebElement DropDownOpen = wait.until(ExpectedConditions.elementToBeClickable(Drop_Down_Open));
        DropDownOpen.click();
        WebElement dropDownCloseElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Drop_Down_Close));
        dropDownCloseElement.isDisplayed();
        WebElement SignOut_Btn = wait.until(ExpectedConditions.elementToBeClickable(Sign_Out_Btn));
        SignOut_Btn.click();
    }
    //Selecting Women Option from Header
    public void MouseActions() {
        Actions action = new Actions(driver);
        WebElement women = driver.findElement(By.xpath(".//nav//ul//li[2]"));
        action.moveToElement(women).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//nav//ul//li[2]//ul//li[1]")));
        WebElement womenTops = driver.findElement(By.xpath(".//nav//ul//li[2]//ul//li[1]"));
        action.moveToElement(womenTops).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//nav//ul//li[2]//ul//li[1]//ul//li[1]")));
        WebElement jacket = driver.findElement(By.xpath(".//nav//ul//li[2]//ul//li[1]//ul//li[1]"));
        action.moveToElement(jacket).click().perform();
    }
    //Selecting Men option from the Header
    public void MenInHeader() {
        Actions action1 = new Actions(driver);
        WebElement men = driver.findElement(By.id("ui-id-5"));
        action1.moveToElement(men).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-18")));
        WebElement menBottoms = driver.findElement(By.id("ui-id-18"));
        action1.moveToElement(menBottoms).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-24")));
        WebElement shorts = driver.findElement(By.id("ui-id-24"));
        action1.moveToElement(shorts).click().perform();
    }
    //Add items to the cart
    public void SignInAddtoCart() {
        driver.findElement(Sign_in_btn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Username));
        driver.findElement(Username).sendKeys("amani.sankoju13@gmail.com");
        driver.findElement(Pass).sendKeys("Luma@123");
        driver.findElement(Sign_in).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Yoga_Frame));
        driver.findElement(Yoga_Frame).click();
        Actions act = new Actions(driver);
        WebElement elisaEverCool = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[8]/div"));
        act.moveToElement(elisaEverCool).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("option-label-size-143-item-168")));
        WebElement sizeMedium = driver.findElement(By.id("option-label-size-143-item-168"));
        act.moveToElement(sizeMedium).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("option-label-color-93-item-58")));
        WebElement colorElisa = driver.findElement(By.id("option-label-color-93-item-58"));
        act.moveToElement(colorElisa).click().perform();
        WebElement qtyInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"qty\"]")));
        qtyInput.clear();
        qtyInput.sendKeys("8");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
        WebElement addCart = driver.findElement(By.id("product-addtocart-button"));
        act.moveToElement(addCart).click().perform();
    }
    //Remove items from the Cart
    public void RemoveFromCart() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement minicartWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("minicart-wrapper")));
        minicartWrapper.click();
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[@class=\"action delete\"]")));
        deleteButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[4]/aside[2]/div[2]/div[1]/div[1]")));
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[4]/aside[2]/div[2]/footer[1]/button[2]")));
        confirmButton.click();
        WebElement cartCrossMark = wait.until(ExpectedConditions.visibilityOfElementLocated(Cart_Cross_mark));
        cartCrossMark.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[2]/a/img")));
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a/img")).click();
   Thread.sleep(2000);
    }
    //Cancel items to remove from the Cart
    public void CancelRemoveFromCart() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(250));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Breathe-Easy Tank")));
        driver.findElement(By.linkText("Breathe-Easy Tank")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("option-label-size-143-item-168")));
        driver.findElement(By.id("option-label-size-143-item-168")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("option-label-color-93-item-57")));
        driver.findElement(By.id("option-label-color-93-item-57")).click();
        WebElement qtyInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name=\"qty\"]")));
        qtyInput.clear();
        qtyInput.sendKeys("5");
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-addtocart-button\"]/span")));
        addToCartButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[2]/a/img")));
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a/img")).click();
        Thread.sleep(1000);
        WebElement minicartWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("minicart-wrapper")));
        minicartWrapper.click();
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[@class=\"action delete\"]")));
        deleteButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[4]/aside[2]/div[2]/div[1]/div[1]")));
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/aside[2]/div[2]/footer/button[1]")));
        confirmButton.click();
        WebElement cartCrossMark = wait.until(ExpectedConditions.visibilityOfElementLocated(Cart_Cross_mark));
        cartCrossMark.click();
    }
    //Incorrect Page Title
    public void IncorrectPageTitle() throws Exception {

        String actualTitle = driver.getTitle();
        String expectedTitle = "LUMA";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page title is correct: " + actualTitle);
        } else {
            System.out.println("Page title is incorrect. Actual title is: " + actualTitle);
        }
    }
    //Correct Page Title
    public void CorrectPageTitle() throws Exception {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Elisa EverCool™ Tee";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page title is correct: " + actualTitle);
        } else {
            System.out.println("Page title is incorrect. Actual title is: " + actualTitle);
        }
    }
    // Broken links check
    public void BrokenLinks() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("a"))); // Wait until all links are visible
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            System.out.println("-----------------");
            System.out.println(url);
            if (url == null || url.isEmpty()) {
                System.out.println("URL is empty.");
                continue;
            }
            try {
                HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.connect();
                if (huc.getResponseCode() >= 400) {
                    System.out.println(url + " is broken");
                } else {
                    System.out.println(url + " is valid");
                }
            } catch (Exception e) {
                System.out.println("Exception occurred while checking link: " + e.getMessage());
            }
        }
    }
    //Taking the screenshot of the Home page
    public void Home_ScreenShot() throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("C:\\Users\\amani\\Desktop\\Tester.Png");
        File directory = new File("C:\\Users\\amani\\Desktop");
        FileUtils.copyFile(SrcFile, DestFile);
    }
    //Click on Forgot your password option
    public void ForgotYourPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(Sign_in_btn));
        driver.findElement(Sign_in_btn).click();

        WebElement forgotPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login-form\"]/fieldset/div[4]/div[2]/a/span")));
        forgotPasswordLink.click();

        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("email_address")));
        emailField.sendKeys("amani.sankoju13@gmail.com");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")));
        submitButton.click();
    }
    //Editing My Account
    public void MyAccountEdit() {
        driver.findElement(Drop_Down_Open).click();

        WebElement dropDownClose = wait.until(ExpectedConditions.visibilityOfElementLocated(Drop_Down_Close));
        dropDownClose.isDisplayed();

        driver.findElement(By.linkText("My Account")).click();

        WebElement editAccountLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[2]/div/div[2]/a[1]/span")));
        editAccountLink.click();

        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
        firstNameField.clear();
        firstNameField.sendKeys("Sankoju");

        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname")));
        lastNameField.clear();
        lastNameField.sendKeys("Amani");

        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")));
        saveButton.click();
    }
    //Filling the Manage Address details
    public void ManageAddresses() {
        driver.findElement(Drop_Down_Open).click();

        WebElement dropDownClose = wait.until(ExpectedConditions.visibilityOfElementLocated(Drop_Down_Close));
        dropDownClose.isDisplayed();

        driver.findElement(By.linkText("My Account")).click();

        WebElement addressLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[5]/div[1]/a/span")));
        addressLink.click();

        WebElement addNewAddressButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[6]/div[1]/button")));
        addNewAddressButton.click();

        // Fill in address details
        driver.findElement(By.id("company")).sendKeys("XYZ");
        driver.findElement(By.id("telephone")).sendKeys("9999999999");
        driver.findElement(By.id("street_1")).sendKeys("SaiRamNagar");
        driver.findElement(By.id("street_2")).sendKeys("ABCD");
        driver.findElement(By.id("street_3")).sendKeys("11-181");
        driver.findElement(By.id("city")).sendKeys("Hyderabad");

        // Select country and region
        Select countryDropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country"))));
        countryDropdown.selectByVisibleText("India");

        Select regionDropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("region_id"))));
        regionDropdown.selectByVisibleText("Telangana");

        driver.findElement(By.id("zip")).sendKeys("500098");
    }
    //Click on My Downloadable Products
    public void MyDownloadableProducts() throws InterruptedException {
        driver.findElement(By.linkText("My Downloadable Products")).click();

    }
    // Enter all payment Details
    public void PaymentDetails() throws Exception {
        try {
            Thread.sleep(2000);
            WebElement minicartWrapper = wait.until(ExpectedConditions.elementToBeClickable(By.className("minicart-wrapper")));
            minicartWrapper.click();

            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a/span")));
            checkoutButton.click();

            WebElement continueToShippingButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[1]/ul/li[1]/button/span")));
            continueToShippingButton.click();

            WebElement continueToPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")));
            continueToPaymentButton.click();


            WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span")));
            placeOrderButton.click();

            WebElement orderConfirmationLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div/div/a")));
            orderConfirmationLink.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Adding the items to the WishList
    public void AddToWishList() {
        try {
            WebElement argusTankLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Argus All-Weather Tank")));
            argusTankLink.click();

            WebElement addToWishListButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[5]/div/a[1]/span")));
            addToWishListButton.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
    // Order the products
    public void MyOrders(){
        try{
        WebElement ordersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]")));
        ordersLink.click();

        WebElement firstOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/a[1]/span")));
        firstOrder.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}






