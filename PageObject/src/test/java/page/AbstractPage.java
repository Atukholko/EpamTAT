package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class AbstractPage {

    protected final int WAIT_TIMEOUT_SECONDS = 20;
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, WAIT_TIMEOUT_SECONDS), this);
    }

    protected abstract AbstractPage openPage(String url);
}
