package gudusoft.sql2jooq.sakila.tests;

import static org.junit.Assert.*;
import static gudusoft.db.mysql.sakila.Tables.*;

import java.sql.*;

import org.jooq.*;
import org.jooq.impl.*;
import org.jooq.util.mysql.MySQLDSL;
import org.junit.*;
import org.jooq.types.*;

import gudusoft.db.mysql.sakila.tables.*;
import gudusoft.sql2jooq.sakila.SakilaTest;

/**
 * @author Lukas Eder
 */
@SuppressWarnings({ "unchecked", "rawtypes", "unused", "all" })
public class SakilaTest0036 extends SakilaTest
{

	@Test
	public void test() throws Exception 
	{
		String sql = "select * from (select 1 x) a, (select 2 y) b";
		
		if (sql.toLowerCase().startsWith("select")) 
		{
			assertSame(ctx.fetch(sql), generatedSQL(conn));
		}
		else 
		{
			throw new UnsupportedOperationException("DML is not yet supported");
		}
	}
	
	private static Result generatedSQL( Connection conn )
	{
		DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
Field<Integer> x = DSL.inline( 1 ).as("x");
Table<Record1<Integer>> a = create.select( x ).asTable("a");
Field<Integer> y = DSL.inline( 2 ).as("y");
Table<Record1<Integer>> b = create.select( y ).asTable("b");

Result<Record> result = create.select(  )
	.from( a, b ).fetch( );

		return result;
	}
}
