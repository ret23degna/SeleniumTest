package selenium.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
  WebDriver driver = new ChromeDriver();

  @BeforeEach
  void begin() {
     driver.get("https://demoqa.com/");
  }
  @ValueSource(strings = {
      "Elements", "Forms", "Alerts, Frame & Windows", "Widgets", "Interactions"
  })
  @ParameterizedTest(name = "В каталоге есть раздле с названием - {0} c рабочей ссылкой перехода в Меню")
  void Cards(String side) throws InterruptedException{
    driver.findElement(By.xpath("//h5[text()='"+side+"']")).click();
    driver.findElement(By.xpath("//div[text()='Please select an item from left to start practice.']"));
    Thread.sleep(5000);
    driver.quit();
  }
  @CsvSource(value = {
      "Вася| Пупкин |qwe@qwe.qwe| 9999999999| Male|1920|May|1|Music|EKB",
      "Петя| Жлобов |asd@asd.asd| 8888888888| Male|1935|April|2|Reading|KGN"

  }, delimiter = '|')
  @ParameterizedTest(name = "Регистрация  - {0} {1}")
  void FirstTestSelenium(String FirstName, String LastName, String UserEmail, String UserNumber,  String Gender, String Year, String Month, String Day, String Hobbies, String Address) throws InterruptedException{
      driver.findElement(By.xpath("//h5[text()='Forms']")).click();
      driver.findElement(By.xpath("//div[@class='element-list collapse show']")).click();
      driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(FirstName);
      driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(LastName);
      driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(UserEmail);
      driver.findElement(By.xpath("//label[text()='"+Gender+"']")).click();
      driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(UserNumber);
      driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
      driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")).click();
      driver.findElement(By.xpath("//option[text()='"+Year+"']")).click();
      driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")).click();
      driver.findElement(By.xpath("//option[text()='"+Month+"']")).click();
      driver.findElement(By.xpath("//div[@class='react-datepicker__week'] //div[text()="+Day+"]")).click();
      driver.findElement(By.xpath("//label[text()='"+Hobbies+"']")).click();
      driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(Address);
      driver.findElement(By.xpath("//button[text()='Submit']")).submit();
      driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']")).click();
      Thread.sleep(5000);
      driver.quit();
  }

  @CsvSource(value = {
      "Вася Пупкин |qwe@qwe.qwe| 9999999999| 888888888888"
  }, delimiter = '|')
  @ParameterizedTest()
  void RegisterBooks(String UserName, String UserEmail, String CurrentAddress, String PermanentAddress) throws InterruptedException{
    driver.findElement(By.xpath("//h5[text()='Elements']")).click();
    driver.findElement(By.xpath("//li[@class='btn btn-light ']")).click();
    driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(UserName);
    driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(UserEmail);
    driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(CurrentAddress);
    driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys(PermanentAddress);
    driver.findElement(By.xpath("//button[text()='Submit']")).click();
    driver.findElement(By.xpath("//p[@id='name']"));
    driver.findElement(By.xpath("//p[@id='email']"));
    driver.findElement(By.xpath("//p[@id='currentAddress']"));
    driver.findElement(By.xpath("//p[@id='permanentAddress']"));
    Thread.sleep(5000);
    driver.quit();
  }
}
