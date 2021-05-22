package pl.margawel.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class registerNewUser {
    WebDriver driver;

    @Given("wejdz na strone (.*)")
    public void openUrl(String url) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("w polu Email address wpisuje (.*)")
    public void inputEmail(String email) {
        WebElement inputEmailElement = driver.findElement(By.id("email_create"));
        inputEmailElement.clear();
        inputEmailElement.sendKeys(email);
    }
    @And("klika przycisk Creata an account")
    public void createAccount() {
        WebElement submit = driver.findElement(By.id("SubmitCreate"));
        submit.click();
    }

    @And("^w polu Tilte zaznacz pole Pan$")
    public void setTitle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement title = driver.findElement(By.id("id_gender1"));
        title.click();
    }

    @And("^w polu First Name wpisz (.*)$")
    public void setFirstName(String firstName) {
        WebElement firstNameElement = driver.findElement(By.id("customer_firstname"));
        firstNameElement.sendKeys(firstName);

    }

    @And("^w polu Last Name wpisz (.*)$")
    public void setLastName(String lastName) {
        WebElement lastNameElement = driver.findElement(By.id("customer_lastname"));
        lastNameElement.sendKeys(lastName);
    }

    @And("^w polu Password wpisz (.*)$")
    public void setPassword(String password) {
        WebElement passwordElement = driver.findElement(By.id("passwd"));
        passwordElement.sendKeys(password);
    }

    @And("^w polu Data of Birth 1 pole zaznacz (.*) 2 pole zaznacz (.*) 3 pole zaznacz (.*)$")
    public void setDataOfBrith(String day, String month, String year) {
        Select daySelect = new Select(driver.findElement(By.id("days")));
        daySelect.selectByValue(day);
        Select monthSelect = new Select(driver.findElement(By.id("months")));
        monthSelect.selectByValue(month);
        Select yearSelect = new Select(driver.findElement(By.id("years")));
        yearSelect.selectByValue(year);

    }

    @And("kliknij Register")
    public void register(){
        WebElement submit = driver.findElement(By.id("submitAccount"));
        submit.click();
    }

    @Then("Otwiera sie strona My Account")
    public void myAccountSite(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement myAccount = driver.findElement(By.xpath("//*[@class='page-heading']"));
        if (!myAccount.isEnabled()){
            Assert.fail("Błąd rejestracji");
        }

    }
}
