package abstractions.utils;

import abstractions.utils.expectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.NoSuchElementException;

public class DriverWaits {
    private final Logger logger = LoggerFactory.getLogger(DriverWaits.class);

    private final DriverManager driverManager;

    public DriverWaits(DriverManager driverManager) {
        this.driverManager = driverManager;
    }


    /**
     * wait for element visible by element
     */
    public void waitForElementVisible(WebElement element) {
        try {
            waitLong().until(new VisibilityOfElement(element));
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element visible by locator
     */
    public void waitForElementVisible(By locator) {
        try {
            waitLong().until(new VisibilityOfElementByLocator(locator));
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element Invisible by locator
     */
    public void waitForElementInVisible(By locator) {
        try {
            new InvisibilityOfElementByLocator(locator);
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element Invisible by locator
     */
    public void waitForElementInVisible(WebElement element) {
        try {
            new InvisibilityOfElement(element);
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element clickable by element
     */
    public void waitForElementClickable(WebElement element) throws NoSuchFieldException {
        try {
            new ClickabilityOfElement(element);
        } catch (Exception t) {
            throw new NoSuchFieldException("could not interact with the element " + element);
        }
    }

    /**
     * wait for element clickable by locator
     */
    public void waitForElementClickable(By locator) throws NoSuchFieldException {
        try {
            new ClickabilityOfElementByLocator(locator);
        } catch (Exception t) {
            throw new NoSuchFieldException("could not interact with the element by locator " + locator);
        }
    }

    public Wait<WebDriver> waitLong() {
        return new FluentWait<>(driverManager.getDriver())
                .withTimeout(Duration.ofSeconds(Constants.timeoutLong))
                .pollingEvery(Duration.ofMillis(Constants.pollingLong))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public Wait<WebDriver> waitShort() {
        return new FluentWait<>(driverManager.getDriver())
                .withTimeout(Duration.ofSeconds(Constants.timeoutShort))
                .pollingEvery(Duration.ofMillis(Constants.pollingShort))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }


    public void waitUntilJSReady() {
        final ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driverManager.getDriver())
                .executeScript("return document.readyState")
                .toString()
                .equals("complete");

        boolean jsReady = ((JavascriptExecutor) driverManager.getDriver()).executeScript("return document.readyState")
                .toString().equals("complete");

        if (!jsReady) {
            waitLong().until(jsLoad);
        }
    }

    public void waitForJQueryLoad() {
        final ExpectedCondition<Boolean> jQueryLoad = driver -> (
                (Long) ((JavascriptExecutor) driverManager.getDriver()).executeScript("return jQuery.active") == 0);

        boolean jqueryReady = (Boolean) ((JavascriptExecutor) driverManager.getDriver()).executeScript("return jQuery.active==0");

        if (!jqueryReady) {
            waitLong().until(jQueryLoad);
        }
    }
}
