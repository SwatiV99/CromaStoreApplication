package org.example;

import Constants.ShortPath;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import static Constants.ShortPath.*;

public class Main {
    static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) throws InterruptedException, AWTException {
        driver.get(ShortPath.PORT);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        LOGIN();
        READY_TO_PICK();
        READY_TO_SHIP();
        PACK();
        CONNECT_TO_CARRIER();




    }

    public static void LOGIN() {
        WebElement Username = driver.findElement(By.id(USERNAME));
        Username.click();
        Username.sendKeys(SHIP_NODE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement Password = driver.findElement(By.xpath(PASSWORD));
        Password.click();
        Password.sendKeys(SHIP_NODE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement LOGIN_BUTTON = driver.findElement(By.xpath(LOGIN));
        LOGIN_BUTTON.click();
        System.out.println("Logged In to Store Application");
    }
    public static void READY_TO_PICK() throws InterruptedException {
        WebElement EnterOrderNumberForRTP = driver.findElement(By.id(ORDER_NUMBER_FOR_RTS));
        Thread.sleep(4000);
        EnterOrderNumberForRTP.click();
        EnterOrderNumberForRTP.sendKeys(ORDER_NUMBER);
        System.out.println("Entered Order Number");
        driver.findElement(By.xpath(SEARCH_ORDER_NUMBER_FOR_RTS)).click();
        driver.findElement(By.xpath(CLICK_ON_PICK_ORDER_BUTTON)).click();
        System.out.println("Order is Picked");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait for up to 10 seconds
        WebElement PickAllOKButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PICK_OK_BUTTON)));
        Thread.sleep(4000);
        PickAllOKButton.click();
        driver.findElement(By.xpath(FINISH_PICK_BUTTON)).click();
        System.out.println("Order is in Ready to Ship Status");
        Thread.sleep(10000);
    }
    private static void READY_TO_SHIP() throws InterruptedException {
        driver.findElement(By.xpath(BACK_BUTTON)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(VIEW_ALL_SHIPMENT_BUTTON)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(FILTER_BUTTON)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(CLICK_ON_ORDER_NUMBER_IN_FILTER)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(TYPE_ORDER_NUMBER)).sendKeys(ORDER_NUMBER);
        Thread.sleep(4000);
        driver.findElement(By.xpath(APPLY_BUTTON)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(CLICK_ON_SHIPMENT_NUMBER)).click();
        System.out.println("Order is now Ready for Packing");
    }
    public static void PACK() throws InterruptedException {
        driver.findElement(By.xpath(CONTINUE_PACKING)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(UPDATE_CARRIER_AND_VOLUMETRICS_BUTTON)).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath(UPDATE_CARRIER_AND_VOLUMETRICS_OK_BUTTON)).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(FINISH_PACKING_BUTTON)).click();
        Thread.sleep(20000);
        System.out.println("Order is Packed");
    }
    public static void CONNECT_TO_CARRIER() throws InterruptedException, AWTException {
        driver.findElement(By.xpath(PRINT_AWB_BUTTON)).click();
        Thread.sleep(4000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        System.out.println("Printed AWB");
        Thread.sleep(2000);
        String originalTab = driver.getWindowHandle();
        driver.findElement(By.xpath(PRINT_INVOICE_BUTTON)).click();
        Thread.sleep(2000);
        System.out.println("Printed Invoice");
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }

        String printInvoiceTitle = driver.getTitle();
        System.out.println("Title of the new tab: " + printInvoiceTitle);
        Thread.sleep(2000);
        driver.switchTo().window(originalTab);
        String originalTitle = driver.getTitle();
        System.out.println("Title of the original tab: " + originalTitle);
        driver.findElement(By.xpath(CONNECT_TO_CARRIER_BUTTON)).click();
        driver.findElement(By.xpath(CONNECT_TO_CARRIER_OK_BUTTON)).click();
        driver.findElement(By.xpath(CLICK_ON_DONE_BUTTON)).click();


    }

    private static void HOTC() throws InterruptedException {
        driver.findElement(By.xpath(BACK_BUTTON)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(VIEW_ALL_SHIPMENT_BUTTON)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(FILTER_BUTTON)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(CLICK_ON_ORDER_NUMBER_IN_FILTER)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(TYPE_ORDER_NUMBER)).sendKeys(ORDER_NUMBER);
        Thread.sleep(4000);
        driver.findElement(By.xpath(APPLY_BUTTON)).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath(CLICK_ON_SHIPMENT_NUMBER)).click();
        System.out.println("Order is now Ready for Packing");
    }
}