package abstractions.utils;

import abstractions.helpers.AbstractHelper;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;


public class InputMethods extends AbstractHelper implements UtilsInterface {

    /**
     * Method to enter text into text field and hit enter
     * @param locatorType : String : Locator type (id, name, class, xpath, css)
     * @param text       : String : Text value to enter in field : NOT NULL
     * @param locatorValue : String : Locator value
     */
    public void enterTextAndHitEnter(String locatorType, @NotNull String  text, String locatorValue) {
        getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(locatorType, locatorValue)));
        WebElement element = getDriver().findElement(selectElementByType.getelementbytype(locatorType, locatorValue));
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    /**
     * Method to enter text into text field
     * @param locatorType : String : Locator type (id, name, class, xpath, css)
     * @param text       : String : Text value to enter in field : NOT NULL
     * @param locatorValue : String : Locator value
     */
    public void enterText(String locatorType, @NotNull String text, String locatorValue) {
        getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(locatorType, locatorValue)));
        WebElement element = getDriver().findElement(selectElementByType.getelementbytype(locatorType, locatorValue));
        element.sendKeys(text);
    }

    /**
     * Method to clear text of text field
     * @note not nullable
     * @param locatorType : String : Locator type (id, name, class, xpath, css)
     * @param locatorValue : String : Locator value
     */
    public void clearText(String locatorType, String locatorValue) {
        getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(locatorType, locatorValue)));
        getDriver().findElement(selectElementByType.getelementbytype(locatorType, locatorValue)).clear();
    }

    /**
     * Method to toggle check-box status
     * @note not nullable
     * @param locatorType : String : Locator type (id, name, class, xpath, css)
     * @param locatorValue : String : Locator value
     */
    public void toggleCheckbox(String locatorType, String locatorValue) {
        getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(locatorType, locatorValue))).click();
    }

    /**
     * Method to select radio button
     * @note not nullable
     * @param locatorType : String : Locator type (id, name, class, xpath, css)
     * @param locatorValue : String : Locator value
     */
    public void selectRadioButton(String locatorType, String locatorValue) {
        WebElement radioButton = getDriverWait().waitShort()
                .until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(locatorType, locatorValue)));
        if (!radioButton.isSelected())
            radioButton.click();
    }


}
