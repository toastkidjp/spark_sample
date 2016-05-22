package jp.toastkid.api.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import jp.toastkid.api.common.Status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Test of Status.
 * @author Toast kid
 */
public class StatusTest {
	/** object. */
	private Status s;

	/**
	 * set up.
	 */
	@Before
	public void setUp() {
		s = new Status();
	}
	/**
	 * test NOP constructor.
	 */
	@Test
	public void testInit() {
		assertNotNull(s);
		assertFalse((boolean) Whitebox.getInternalState(s, "status"));
	}
	/**
	 * test param construcr.
	 */
	@Test
	public void testInitWithParam() {
		final Status status = new Status(true);
		assertNotNull(status);
		assertTrue((boolean) Whitebox.getInternalState(status, "status"));
	}
	/**
	 * test setStatus.
	 */
	@Test
	public void testSetStatus() {
		assertNotNull(s);
		s.setStatus(true);
		assertTrue((boolean) Whitebox.getInternalState(s, "status"));
	}
	/**
	 * @return Route object.
	 */
	@Test
	public void testIndex() throws Exception {
		final Request  req = mock(Request.class);
		final Response res = mock(Response.class);
		final Object   o   = s.index().handle(req, res);
		assertEquals("Not Found", o.toString());
		verify(res).status(404);

		s.setStatus(true);
		final Object   o1   = s.index().handle(req, res);
		assertEquals("OK", o1.toString());
	}
}
