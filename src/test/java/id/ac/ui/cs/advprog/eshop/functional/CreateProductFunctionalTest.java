package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost:8080}")
    private String testBaseUrl;

    private String createProductUrl;

    @BeforeEach
    void setUpTest() {
        createProductUrl = String.format("http://localhost:%d/product/create", serverPort);
    }

    @Test
    void testCreateNewProduct(ChromeDriver driver) throws Exception {
        // Open the create product page
        driver.get(createProductUrl);

        // Verify page title
        String pageTitle = driver.getTitle();
        assertEquals("Create New Product", pageTitle);

        // Find the input fields and fill them with data
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        nameInput.sendKeys("Test Product");
        quantityInput.sendKeys("25");

        // Submit the form
        submitButton.click();

        // Verify redirection to the product list page (assuming redirection happens)
        String productListUrl = String.format("http://localhost:%d/product/list", serverPort);
        assertEquals(productListUrl, driver.getCurrentUrl());

        // Check if the new product is in the list
        WebElement newProductName = driver.findElement(By.xpath("//td[contains(text(),'Test Product')]"));
        WebElement newProductQuantity = driver.findElement(By.xpath("//td[contains(text(),'25')]"));

        assertTrue(newProductName.isDisplayed());
        assertTrue(newProductQuantity.isDisplayed());
    }
}