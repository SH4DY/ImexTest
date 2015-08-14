package com.shady.imextest.runners;

import com.shady.imextest.modelimplementations.ImexTest;
import com.shady.imextest.observers.GraphStreamObserver;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphwalker.core.event.Observer;
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

/**
 * Created by shady on 14/08/15.
 */
public class GraphStreamApplication {

    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui.renderer",
                "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        Graph graph = new SingleGraph("GraphWalker MeetUp");
        graph.display(true);
        Executor executor = new TestExecutor(ImexTest.class);
        Observer observer = new GraphStreamObserver(graph);
        executor.getMachine().addObserver(observer);
        Result result = executor.execute();
        System.out.println("Done: [" + result.getCompletedCount() + "," + result.getFailedCount() + "]");
    }
}