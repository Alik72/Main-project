package kz.stqa.pft.newproect;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ClassCreationTests {
    FirefoxDriver wd;
    private boolean acceptNextAlert = true;
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }
    
    @Test
    public void ClassCreationTests() {
        wd.get("http://212.42.103.149:8070/Workflow/login");
        wd.findElement(By.id("login")).click();
        wd.findElement(By.id("login")).clear();
        wd.findElement(By.id("login")).sendKeys("user1");
        wd.findElement(By.id("pwd")).click();
        wd.findElement(By.id("pwd")).sendKeys("1");
        wd.findElement(By.id("enter")).click();
        //ul[@id=\'navigation\']/li/div[@class=\"hitarea expandable-hitarea\"]
        wd.findElement(By.xpath("//ul[@id=\'navigation\']/li/div[@class=\"hitarea expandable-hitarea\"]")).click();
        wd.findElement(By.xpath("(//div[@class=\"hitarea expandable-hitarea\"])[1]")).click();
        wd.findElement(By.xpath("(//b[contains(text(),\'создать\')])")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Создать новый процесс[\\s\\S]$"));

        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        new Select(wd.findElement(By.id("npa_select"))).selectByVisibleText("Закон РК О введении в действие Кодекса РК?«О таможенном деле в РК»");
        wd.findElement(By.xpath("(//li[@name='1'])[2]")).click();
        wd.findElement(By.id("close_npa")).click();


        new Select(wd.findElement(By.id("fSECURITY_ID"))).selectByVisibleText("Совершенно Секретно. Особая Папка");
        wd.findElement(By.id("fCLASS_NAME")).clear();
        wd.findElement(By.id("fCLASS_NAME")).sendKeys("Автомобили");
        wd.findElement(By.id("fTARGET")).clear();
        wd.findElement(By.id("fTARGET")).sendKeys("Регистрация автомобилей");
        wd.findElement(By.id("fANALITIC_VALUE")).clear();
        wd.findElement(By.id("fANALITIC_VALUE")).sendKeys("Очень полезная");
        wd.findElement(By.id("fDESCRIPTION")).clear();
        wd.findElement(By.id("fDESCRIPTION")).sendKeys("Автомобили");
        wd.findElement(By.id("tab-class-classification")).click();
        wd.findElement(By.xpath("//input[@id=\"fBASECLASS\"]")).click();
        wd.findElement(By.xpath("//a[@title=\"1\"]/preceding-sibling::span[@class=\"dynatree-expander\"]")).click();
        wd.findElement(By.xpath("//*[@title=\"33\"]")).click();
        wd.findElement(By.xpath("//*[@title=\"105\"]")).click();
        wd.findElement(By.xpath("//a [@id=\"tab-class-properties\"]")).click();
        wd.findElement(By.cssSelector("div.hitarea.expandable-hitarea")).click();
        wd.findElement(By.cssSelector("div.hitarea.expandable-hitarea")).click();
        wd.findElement(By.linkText("создать")).click();
        if (!wd.findElement(By.xpath("//select[@id='npa_select']//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//select[@id='npa_select']//option[2]")).click();
        }
        wd.findElement(By.id("close_npa")).click();
        if (!wd.findElement(By.xpath("//select[@id='fSECURITY_ID']//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//select[@id='fSECURITY_ID']//option[2]")).click();
        }
        wd.findElement(By.id("fCLASS_NAME")).click();
        wd.findElement(By.id("fCLASS_NAME")).clear();
        wd.findElement(By.id("fCLASS_NAME")).sendKeys("автомобиль сверхбыстрый");
        wd.findElement(By.id("fCLASS_NAME")).click();
        wd.findElement(By.id("fCLASS_NAME")).clear();
        wd.findElement(By.id("fCLASS_NAME")).sendKeys("автомобиль сверхбыстрый");
        wd.findElement(By.id("fTARGET")).click();
        wd.findElement(By.id("fTARGET")).clear();
        wd.findElement(By.id("fTARGET")).sendKeys("появление нового авто");
        wd.findElement(By.id("fANALITIC_VALUE")).click();
        wd.findElement(By.id("fANALITIC_VALUE")).clear();
        wd.findElement(By.id("fANALITIC_VALUE")).sendKeys("высокая");
        wd.findElement(By.id("fDESCRIPTION")).click();
        wd.findElement(By.id("fDESCRIPTION")).clear();
        wd.findElement(By.id("fDESCRIPTION")).sendKeys("автомобиль сверхбыстрый");
        wd.findElement(By.id("tab-class-classification")).click();
        wd.findElement(By.id("fBASECLASS")).click();
        wd.findElement(By.cssSelector("span.dynatree-expander")).click();
        wd.findElement(By.xpath("//ul[@class='dynatree-container']/li/ul/li[1]/span/span[1]")).click();
        wd.findElement(By.xpath("//ul[@class='dynatree-container']/li/ul/li[1]/ul/li/span/span[1]")).click();
        wd.findElement(By.linkText("Автомобили легковые")).click();
        wd.findElement(By.id("tab-class-properties")).click();
        new Actions(wd).doubleClick(wd.findElement(By.xpath("//tr[@id='propedit_tr_new']/td[4]"))).build().perform();
        wd.findElement(By.cssSelector("button.print-unvisible.hover")).click();
        wd.findElement(By.xpath("//div[@id='ufd-container']//li[.='Вещественный']")).click();
        if (!wd.findElement(By.xpath("//select[@id='edit_fldtype']//option[2]")).isSelected()) {
            wd.findElement(By.xpath("//select[@id='edit_fldtype']//option[2]")).click();
        }
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = wd.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }






    //@AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
