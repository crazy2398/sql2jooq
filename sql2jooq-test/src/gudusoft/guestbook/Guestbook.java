/**
 * This class is generated by jOOQ
 */
package gudusoft.guestbook;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.1.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Guestbook extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = -2087745405;

	/**
	 * The singleton instance of <code>guestbook</code>
	 */
	public static final Guestbook GUESTBOOK = new Guestbook();

	/**
	 * No further instances allowed
	 */
	private Guestbook() {
		super("guestbook");
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			gudusoft.guestbook.tables.Posts.POSTS);
	}
}
