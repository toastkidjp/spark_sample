package jp.toastkid.api;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;
import static spark.Spark.stop;

import jp.toastkid.api.common.Status;
import jp.toastkid.api.sample.Hello;
import jp.toastkid.api.sample.WordCloud;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;

/**
 * main.
 * @author Toast kid.
 */
public class Main {
	/** This Web App VIP status. */
	private static final Status status = new Status();
    /**
     * contains routes.
     */
    public static void main(final String[] args) {
        port(Config.PORT);

        // This must be done before route mapping has begun.
        staticFileLocation("/public");
        get("/hello", new Hello().index());
        get("/statusctl", status.statusctl());
        get("/status.html", status.index());
        get("/stop", stopApp());

        final FreeMarkerEngine engine = new FreeMarkerEngine();
        get("/wc", new WordCloud().index(), engine);
        post("/wc", new WordCloud().index(), engine);
    }
    /**
     * stop this application.
     */
    private static Route stopApp() {
		return (request, response) -> {
            stop();
            return null;
        };
    }
}
