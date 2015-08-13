package com.shady.imextest;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.condition.TimeDuration;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.test.TestBuilder;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
public class ImexTest extends ExecutionContext implements ModellLogisch{
    public final static Path MODEL_PATH = Paths.get("com/shady/imextest/ModellLogisch.graphml");

    @Test
    public void runSmokeTest() {
//        new TestBuilder()
//                .setModel(MODEL_PATH)
//                .setContext(new ImexTest())
//                .setPathGenerator(new AStarPath(new ReachedVertex("v_Proposal_0")))
//                .setStart("v_OnPage")
//                .execute();

        new TestBuilder()
                .addModel(MODEL_PATH,
                new ImexTest().setPathGenerator(new RandomPath(new ReachedVertex("v_Proposal_0"))))
                .execute();
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

    }

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

    @Override
    public void e_EnterCredibility() {

    }

    @Override
    public void v_Zinsentwicklung() {

    }


    @Override
    public void v_Wieviel() {

    }

    @Override
    public void e_ClickUnwichtig() {

    }

    @Override
    public void e_ClickSteigend() {

    }

    @Override
    public void v_ZinsentwicklungPersoenlich() {

    }

    @Override
    public void v_PLZPrompt() {

    }

    @Override
    public void e_ClickWichtig() {

    }

    @Override
    public void e_ClickStartProposal() {

    }

    @Override
    public void v_Proposal() {

    }


    @Override
    public void e_ClickSinkend() {

    }

    @Override
    public void e_ClickGleichbleibend() {

    }

    @Override
    public void v_Ausgaben() {

    }

    @Override
    public void v_OnPage() {
        System.out.println("OnPage");
    }

    @Override
    public void e_ClickSehrWichtig() {

    }

    @Override
    public void e_ClickAusgabenJa() {

    }

    @Override
    public void e_ClickPersoenlichNein() {

    }



    @Override
    public void e_ClickPersoenlichJa() {

    }

    @Override
    public void e_EnterPLZ() {

    }


    @Override
    public void v_PlanbareKosten() {

    }

    @Override
    public void e_ClickAusgabenNein() {

    }
}
