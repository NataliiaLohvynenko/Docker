package searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchTxt;

    @FindBy(id = "search_button_homepage")
    private WebElement searchBtn;

    @FindBy(css = "a.zcm__link.js-zci-link.js-zci-link--videos")
    private WebElement videosLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 100);
        PageFactory.initElements(driver, this);

    }

    public void goTo() {
        this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keyword) {
    wait.until(ExpectedConditions.visibilityOf(searchTxt));
        this.searchTxt.sendKeys(keyword);
        this.searchBtn.click();
    }

    public void goToVideos(){
        wait.until(ExpectedConditions.visibilityOf(videosLink));
        this.videosLink.click();
    }

    public int getResult(){
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println("Search Result : " + this.allVideos.size());
        return this.allVideos.size();
    }


}
