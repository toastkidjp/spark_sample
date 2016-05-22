package jp.toastkid.api.common;

import spark.QueryParamsMap;
import spark.Route;

/**
 * VIP Status controller.
 * @author Toast kid
 */
public class Status {
	/** VIP status is up?. */
	private boolean status;

	/**
	 * init with false.
	 */
	public Status() {
		this(false);
	}

	/**
	 * init with param.
	 */
	public Status(final boolean s) {
		setStatus(s);
	}

	/**
	 * set status.
	 */
	public void setStatus(final boolean s) {
		this.status = s;
	}

	/**
	 * switch VIP status.
	 */
	public Route statusctl() {
		return (req, res) -> {
			final QueryParamsMap map = req.queryMap();
			final String s = map.get("status").value();
			if (s != null) {
				switch (s.toLowerCase()) {
					case "on":
					case "1":
					case "up":
					case "positive":
					case "ok":
					case "true":
						this.status = true;
						break;
					default:
						this.status = false;
						break;
				}
			}
			return "Current VIP status = " + this.status;
		};
	}

	/**
	 * index.
	 * @author Toast kid
	 */
	public Route index() {
		return (req, res) -> {
			if (this.status) {
				return "OK";
			}
			res.status(404);
			return "Not Found";
		};
	}
}
