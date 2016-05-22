package jp.toastkid.api.sample;

import jp.toastkid.api.Config;
import spark.Route;

/**
 * Hello World app.
 * @author Toast kid
 */
public class Hello {
	/**
	 * NOP constructor.
	 */
	public Hello() {
		// NOP.
	}
	/**
	 * @return Route object.
	 */
	public Route index() {
		return (request, response) -> {
			return "<title>" + Config.TITLE + "</title><h1>Hello Spark!!</h1>";
		};
	}
}
