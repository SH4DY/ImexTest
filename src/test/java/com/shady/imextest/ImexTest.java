package com.shady.imextest;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * Diese Klasse beinhaltet alle Kanten und Knoten aus dem entsprechenden logischen Modell des
 * Hypothekarrechners. Im Modell sind es 51 Knoten und 66 Kanten. Im Code sind es aber deutlich
 * weniger Methoden.
 * Created by shady on 11/08/15.
 */
public class ImexTest extends ExecutionContext implements ModellLogisch {
    public final static Path MODEL_PATH = Paths.get("com/shady/imextest/ModellLogisch.graphml");
    private WebDriver driver;

    @Test
    public void runSmokeTest() {
        TestBuilder tb = new TestBuilder()
                .addModel(MODEL_PATH,
                        new ImexTest().setPathGenerator(new RandomPath(new ReachedVertex("v_Proposal_0"))));

        Result result = tb.execute();
        System.out.println("Done: [" + result.getErrors().toString() + "," + result.getFailedCount() + "]");
    }

//    @Test
//    public void runFunctionalTest() {
//        new TestBuilder()
//                .setModel(MODEL_PATH)
//                .setContext(new ImexTest())
//                .setPathGenerator(new RandomPath(new EdgeCoverage(100)))
//                .setStart("e_Init")
//                .execute();
//    }
//
//    @Test
//    public void runStabilityTest() {
//        new TestBuilder()
//                .setModel(MODEL_PATH)
//                .setContext(new ImexTest())
//                .setPathGenerator(new RandomPath(new TimeDuration(30, TimeUnit.SECONDS)))
//                .setStart("e_Init")
//                .execute();
//    }

    @Override
    public void e_init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        try {
//            driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }


    @Override
    public void v_OnPage() {
        driver.get("https://www.raiffeisen.ch/rch/de/privatkunden/hypotheken/wohneigentum-kaufen/wieviel-eigenheim-kann-ich-mir-leisten.html");
    }


    @Override
    public void v_PLZPrompt() {
    }

    @Override
    public void e_EnterPLZ() {
        WebElement searchBox = driver.findElement(By.className("dropdown-toggle"));
        searchBox.sendKeys("6900");

        WebElement btn = driver.findElement(By.partialLinkText("Lugano"));
        btn.click();
    }

    @Override
    public void v_Wieviel() {

    }

    @Override
    public void e_EnterCredibility() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.id("financingObject.initialCost")).clear();
        driver.findElement(By.id("financingObject.initialCost")).sendKeys("100000");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Now perform ACTION!!!");

        WebElement element = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div/div[3]/div[3]/div/div[2]/a"));

        Actions actions = new Actions(driver);

        actions.moveToElement(element).click().perform();
    }

    @Override
    public void e_ClickStartProposal() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("body > div.perspective > div.viewport > div.parbase.consultantflyin > div > div > div > div.content.ng-scope > div > div.par.parsys > div.parbase.linkbutton.section > a")).click();
    }

    @Override
    public void e_ClickUnwichtig() {
        driver.findElement(By.linkText("unwichtig")).click();
    }

    @Override
    public void e_ClickWichtig() {
        driver.findElement(By.linkText("wichtig")).click();
    }

    @Override
    public void e_ClickSehrWichtig() {
        driver.findElement(By.linkText("sehr wichtig")).click();
    }

    @Override
    public void e_ClickSinkend() {
        driver.findElement(By.linkText("sinkend")).click();
    }

    @Override
    public void e_ClickGleichbleibend() {
        driver.findElement(By.linkText("gleichbleibend")).click();
    }

    @Override
    public void e_ClickSteigend() {
        driver.findElement(By.linkText("steigend")).click();
    }

    @Override
    public void e_ClickAusgabenJa() {
        driver.findElement(By.linkText("ja")).click();
    }
    @Override
    public void e_ClickAusgabenNein() {
        driver.findElement(By.linkText("nein")).click();
    }

    @Override
    public void e_ClickPersoenlichJa() {
        driver.findElement(By.linkText("ja")).click();
    }

    @Override
    public void e_ClickPersoenlichNein() {
        driver.findElement(By.linkText("nein")).click();
    }

    /*
    Die folgenden Knoten repräsentieren die Endzustände. Mit dieser Art
    der Modellierung muss in ihnen nur sehr wenig Code für Überprüfungen
    untergebracht werden.
     */
    @Override
    public void v_Proposal_0() {
    }

    @Override
    public void v_Proposal_0_Libor() {
    }

    @Override
    public void v_Proposal_1() {
    }

    @Override
    public void v_Proposal_1_Libor() {
    }

    @Override
    public void v_Proposal_2() {
    }

    @Override
    public void v_Proposal_2_Libor() {
    }

    @Override
    public void v_Proposal_3() {
    }

    @Override
    public void v_Proposal_3_Libor() {
    }

    @Override
    public void v_Proposal_4() {
    }

    @Override
    public void v_Proposal_4_Libor() {
    }

    @Override
    public void v_Proposal_5() {
    }

    @Override
    public void v_Proposal_5_Libor() {
    }

    @Override
    public void v_Proposal_6() {
    }

    @Override
    public void v_Proposal_6_Libor() {
    }

    @Override
    public void v_Proposal_7() {
    }

    @Override
    public void v_Proposal_7_Libor() {
    }

    @Override
    public void v_Proposal_8() {
    }

    @Override
    public void v_Proposal_8_Libor() {
    }

    /*
    Dies sind die Knoten (Zustände) der 4 Fragen. Denkbar wären hier
    Prüfungen ob Elemente richtig positioniert sind.
     */
    @Override
    public void v_Zinsentwicklung() {

    }


    @Override
    public void v_ZinsentwicklungPersoenlich() {

    }


    @Override
    public void v_Proposal() {

    }



    @Override
    public void v_Ausgaben() {

    }

    @Override
    public void v_PlanbareKosten() {

    }


}
