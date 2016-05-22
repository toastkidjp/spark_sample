package jp.toastkid.api.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import jp.toastkid.api.Config;

import org.junit.Before;
import org.junit.Test;

import spark.Request;
import spark.Response;

/**
 * Test of Hello World app.
 * @author Toast kid
 */
public class HelloTest {

	/** object. */
	private Hello h;

	/**
	 * set up.
	 */
	@Before
	public void setUp() {
		h = new Hello();
	}
	/**
	 * NOP constructor.
	 */
	@Test
	public void testInit() {
		assertNotNull(h);
	}
	/**
	 * @return Route object.
	 */
	@Test
	public void testIndex() throws Exception {
		assertEquals(
			h.index().handle(mock(Request.class), mock(Response.class)).toString(),
			"<title>" + Config.TITLE + "</title><h1>Hello Spark!!</h1>"
			);
	}
}
