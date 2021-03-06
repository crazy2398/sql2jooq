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
public class SakilaTest0097 extends SakilaTest
{

	@Test
	public void test() throws Exception 
	{
		String sql = "select aes_decrypt(aes_encrypt('abc', 'x'), 'x')";
		
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

Result<Record1<String>> result = create.select( MySQLDSL.aesDecrypt( MySQLDSL.aesEncrypt( DSL.inline( String.valueOf( "abc" ) ), DSL.inline( String.valueOf( "x" ) ) ), DSL.inline( String.valueOf( "x" ) ) ) ).fetch( );

		return result;
	}
}
