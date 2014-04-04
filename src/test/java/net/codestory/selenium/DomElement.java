package net.codestory.selenium;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DomElement {
    private final WebDriver driver;
    private final String selector;
    private final Retry retry;

    DomElement(WebDriver driver, String selector) {
        this.driver = driver;
        this.selector = selector;
        this.retry = new Retry(30, SECONDS);
    }

    public Should should() {
        return new Should(driver, selector, 5, SECONDS);
    }

    public Should shouldWithin(long duration, TimeUnit timeUnit) {
        return new Should(driver, selector, duration, timeUnit);
    }

    // We shouldn't do that
    public String getText() {
        System.out.println(" - " + selector + "." + "getText()");

        return find().getText();
    }

    public void fill(CharSequence text) {
        execute("fill(" + text + ")", element -> element.sendKeys(text));
    }

    public void submit() {
        execute("submit", element -> element.submit());
    }

    public void click() {
        execute("click", (element) -> element.click());
    }

    private void execute(String message, Consumer<WebElement> action) {
        System.out.println(" - " + selector + "." + message);

        retry.execute(() -> find(), action);
    }

    private WebElement find() {
        return driver.findElement(By.cssSelector(selector));
    }
}
