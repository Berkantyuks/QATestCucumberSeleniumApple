package abstractions.utils;

import abstractions.helpers.AbstractHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigateMethods extends AbstractHelper implements UtilsInterface {
    private WebElement element = null;
    private String old_win = null;
    private String lastWinHandle;

    public void navigateToUrl(String url) {
        getDriver().get(url);
    }

    public void scrollToElement(String locatorType, String locatorValue) {
        element = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(locatorType, locatorValue)));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void switchToNewWindow() {
        old_win = getDriver().getWindowHandle();
        for (String winHandle : getDriver().getWindowHandles())
            lastWinHandle = winHandle;
        getDriver().switchTo().window(lastWinHandle);
    }

    public void switchToOldWindow() {
        getDriver().switchTo().window(old_win);
    }

}
