package api_learning;

import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

public class Lession16_FillFormScreen {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.android);

        try{
            // Navigate to Forms screen
            MobileElement navFormsScreenBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            navFormsScreenBtnElem.click();

            //Find Forms screen elements
            MobileElement inputFieldElem = appiumDriver.findElement(MobileBy.AccessibilityId("text-input"));
            MobileElement typedResultElem = appiumDriver.findElement(MobileBy.AccessibilityId("input-text-result"));
            MobileElement switchBtn = appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
            MobileElement switchTxt = appiumDriver.findElement(MobileBy.AccessibilityId("switch-text"));
            MobileElement dropDownList = appiumDriver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]"));

            //Navigate to Forms screen
            inputFieldElem.sendKeys("Abc");
            System.out.println("You have typed: " + typedResultElem.getText());
            switchBtn.click();
            System.out.println("Text when turn on button: " + switchTxt.getText());
            dropDownList.click();

            //Find and navigate Dropdown list
            MobileElement dropDownItem =
                    appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Appium is awesome\")"));
            dropDownItem.click();

            // Wait until user is on Forms screen
            WebDriverWait wait1 = new WebDriverWait(appiumDriver, 5);
            wait1.until(ExpectedConditions
                    .visibilityOfElementLocated(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Form component\")")));

            // Get Mobile window Size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate touch points
            int xStartPoint = 50 * screenWidth / 100;
            int xEndPoint = 50 * screenWidth / 100;

            int yStartPoint = 50 * screenHeight / 100;
            int yEndPoint = 10 * screenHeight / 100;

            // Convert coordinates -> PointOption
            PointOption startPoint = new PointOption<>().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption<>().withCoordinates(xEndPoint, yEndPoint);

            // Using TouchAction to swipe
            TouchAction touchAction = new TouchAction(appiumDriver);
            touchAction
                    .longPress(startPoint)
                    .moveTo(endPoint)
                    .release()
                    .perform();

            // Click on Btn-active
            MobileElement activeBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("button-Active"));
            activeBtnElem.click();

            //Verification | Confirm Form dialog
            WebDriverWait wait = new WebDriverWait(appiumDriver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            MobileElement formDialogTitleElem = appiumDriver.findElement(MobileBy.id("android:id/alertTitle"));
            MobileElement formDialogTextElem = appiumDriver.findElement(MobileBy.id("android:id/message"));
            MobileElement askMeLaterBtn = appiumDriver.findElement(MobileBy.id("android:id/button3"));
            MobileElement cancelBtn = appiumDriver.findElement(MobileBy.id("android:id/button2"));
            MobileElement okBtn = appiumDriver.findElement(MobileBy.id("android:id/button1"));

            System.out.println("Title is: " + formDialogTitleElem.getText());
            System.out.println("Text is: " + formDialogTextElem.getText());
            System.out.println("Button 1 is: " + askMeLaterBtn.getText());
            System.out.println("Button 2 is: " + cancelBtn.getText());
            System.out.println("Button 3 is: " + okBtn.getText());

            //Click button OK
            okBtn.click();

            // DEBUG PURPOSE ONLY
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        appiumDriver.quit();
    }
}
