import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SuperAgi {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("lg soundbar");
        searchBox.submit();




        List<WebElement> productElements = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        ArrayList<WebElement> productList = new ArrayList<>(productElements);
        Thread.sleep(2000);

        String priceText;
        for (WebElement s : productList) {



            WebElement productName = s.findElement(By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']"));
            String fullText= productName.getText();
            try {
                WebElement productPrice = s.findElement(By.xpath(".//span[@class='a-price-whole']"));
                 priceText = productPrice.getText();
            }
            catch (NoSuchElementException e) {

                priceText = "0";
            }


            String Name = fullText.split(",")[0];
            System.out.println(Name + " " + " price is " + priceText);
        }
    }
}
