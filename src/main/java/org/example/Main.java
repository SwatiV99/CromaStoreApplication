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
        HOTC();
        DIP();
        OFD();
        DELIVERED();

        driver.quit();
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
    public static void READY_TO_PICK() {
        WebElement EnterOrderNumberForRTP = driver.findElement(By.id(ORDER_NUMBER_FOR_RTS));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        EnterOrderNumberForRTP.click();
        EnterOrderNumberForRTP.sendKeys(ORDER_NUMBER);
        System.out.println("Entered Order Number");
        driver.findElement(By.xpath(SEARCH_ORDER_NUMBER_FOR_RTS)).click();
        driver.findElement(By.xpath(CLICK_ON_PICK_ORDER_BUTTON)).click();
        System.out.println("Order is Picked");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait for up to 10 seconds
        WebElement PickAllOKButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PICK_OK_BUTTON)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PickAllOKButton.click();
        driver.findElement(By.xpath(FINISH_PICK_BUTTON)).click();
        System.out.println("Order is in Ready to Ship Status");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    private static void READY_TO_SHIP() {
        driver.findElement(By.xpath(BACK_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(VIEW_ALL_SHIPMENT_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(FILTER_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(CLICK_ON_ORDER_NUMBER_IN_FILTER)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(TYPE_ORDER_NUMBER)).sendKeys(ORDER_NUMBER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(APPLY_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(CLICK_ON_SHIPMENT_NUMBER)).click();
        System.out.println("Order is now Ready for Packing");
    }
    public static void PACK() {
        driver.findElement(By.xpath(CONTINUE_PACKING)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(UPDATE_CARRIER_AND_VOLUMETRICS_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.xpath(UPDATE_CARRIER_AND_VOLUMETRICS_OK_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(FINISH_PACKING_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Order is Packed");
    }
    public static void CONNECT_TO_CARRIER() throws AWTException {
        driver.findElement(By.xpath(PRINT_AWB_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        System.out.println("Printed AWB");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String originalTab = driver.getWindowHandle();
        driver.findElement(By.xpath(PRINT_INVOICE_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().window(originalTab);
        String originalTitle = driver.getTitle();
        System.out.println("Title of the original tab: " + originalTitle);
        driver.findElement(By.xpath(CONNECT_TO_CARRIER_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(CONNECT_TO_CARRIER_OK_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(CLICK_ON_DONE_BUTTON)).click();
    }
    private static void HOTC() {
        driver.findElement(By.xpath(VIEW_ALL_SHIPMENT_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(FILTER_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(CLICK_ON_ORDER_NUMBER_IN_FILTER)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(TYPE_ORDER_NUMBER)).sendKeys(ORDER_NUMBER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(ORDER_CHANNEL_EXPAND)).click();
        driver.findElement(By.xpath(ORDER_CHANNEL_DROPDOWN)).click();
        driver.findElement(By.xpath(ORDER_CHANNEL_VALUE)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(ORDER_TYPE_EXPAND)).click();
        driver.findElement(By.xpath(ORDER_TYPE_DROPDOWN)).click();
        driver.findElement(By.xpath(ORDER_TYPE_VALUE)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(SHIPMENT_NUMBER_EXPAND)).click();
        driver.findElement(By.xpath(TYPE_SHIPMENT_NUMBER)).sendKeys(SHIPMENT_NO);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(STATUS_EXPAND)).click();
        driver.findElement(By.xpath(STATUS_DROPDOWN)).click();
        driver.findElement(By.xpath(STATUS_VALUE)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(CARRIER_EXPAND)).click();
        driver.findElement(By.xpath(CARRIER_DROPDOWN)).click();
        driver.findElement(By.xpath(CARRIER_VALUE)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(ORDER_DATE_EXPAND)).click();
        driver.findElement(By.xpath(CLICK_ORDER_DATE_FROM)).click();
        driver.findElement(By.xpath(SELECT_DATE_FROM)).click();
        driver.findElement(By.xpath(CLICK_ORDER_DATE_TO)).click();
        driver.findElement(By.xpath(SELECT_DATE_TO)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       /* driver.findElement(By.xpath(ESTIMATED_DELIVERY_DATE_EXPAND)).click();
        driver.findElement(By.xpath(ESTIMATED_DELIVERY_DATE_FROM)).click();
        driver.findElement(By.xpath(DELIVERY_FROM_DATE)).click();
        driver.findElement(By.xpath(ESTIMATED_DELIVERY_DATE_TO)).click();
        driver.findElement(By.xpath(DELIVERY_TO_DATE)).click();
        Thread.sleep(4000);*/
        driver.findElement(By.xpath(PIN_CODE_EXPAND)).click();
        driver.findElement(By.xpath(TYPE_PIN_CODE)).sendKeys(PIN_CODE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(CITY_EXPAND)).click();
        driver.findElement(By.xpath(TYPE_CITY)).sendKeys(CITY);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(LP_MODE_EXPAND)).click();
        driver.findElement(By.xpath(LP_MODE_DROPDOWN)).click();
        driver.findElement(By.xpath(LP_MODE_VALUE)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(APPLY_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(SELECT_CHECK_BOX)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(HANDOVER_SHIPMENTS_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(HANDOVER_SHIPMENTS_OK_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    private static void DIP() {
        driver.findElement(By.xpath(FILTER_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(STATUS_DROPDOWN)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(CLICK_ON_HOTC)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(APPLY_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(SELECT_CHECK_BOX)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(DELIVERY_IN_PROGRESS_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(DELIVERY_IN_PROGRESS_OK_BUTTON)).click();
    }
    private static void OFD() {
        driver.findElement(By.xpath(FILTER_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(STATUS_DROPDOWN)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(CLICK_ON_DIP)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(APPLY_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(SELECT_CHECK_BOX)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(OUT_FOR_DELIVER_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(OUT_FOR_DELIVERY_OK_BUTTON)).click();
    }
    private static void DELIVERED() {
        driver.findElement(By.xpath(FILTER_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(STATUS_DROPDOWN)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(CLICK_ON_OUT_FOR_DELIVERY)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(APPLY_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(SELECT_CHECK_BOX)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(DELIVERED_BUTTON)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(DELIVERED_OK_BUTTON)).click();
    }
}