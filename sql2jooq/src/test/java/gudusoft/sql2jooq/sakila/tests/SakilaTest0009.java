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
public class SakilaTest0009 extends SakilaTest
{

	@Test
	public void test() throws Exception 
	{
		String sql = "select city.city, country.country "
+ "from city join country on city.country_id = country.country_id";
		
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

Result<Record2<String, String>> result = create.select( City.CITY.CITY_, Country.COUNTRY.COUNTRY_ )
	.from( City.CITY )
	.join( Country.COUNTRY ).on( City.CITY.COUNTRY_ID.equal( Country.COUNTRY.COUNTRY_ID ) ).fetch( );

		return result;
	}
}
