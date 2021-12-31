import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A QueryExecutor object can be used to send SQL commands and queries to a
 * MySQL database server and for printing the results of queries. This
 * class is written as a simple tutorial example. It takes no account of
 * issues such as security and efficiency.
 * 
 * @author John MacCormick
 * @version December 2021
 *
 */
public class QueryExecutor {
	private static final String MYSQL_USER = "root";

	// Important note: in any real-world application, passwords would not
	// be stored in the source code.
	private static final String MYSQL_PASSWORD = "";

	private static final String MYSQL_IP_ADDRESS = "127.0.0.1";
	private static final String MYSQL_PORT_NUMBER = "3306";
	private static final String MYSQL_DATABASE_NAME = "wine";

	Connection connection = null;

	/**
	 * Construct a new QueryExecutor object and connect it to the desired
	 * MySQL database, as specified by the class constants such as
	 * MYSQL_IP_ADDRESS, MYSQL_PORT_NUMBER, etc.
	 */
	public QueryExecutor() {
		Properties connectionProperties = new Properties();
		connectionProperties.put("user", MYSQL_USER);
		connectionProperties.put("password", MYSQL_PASSWORD);

		// Connect to MySQL
		try {
			connection = DriverManager.getConnection(
					"jdbc:" + "mysql" + "://" + MYSQL_IP_ADDRESS + ":"
							+ MYSQL_PORT_NUMBER + "/",
					connectionProperties);
		} catch (SQLException e) {
			handleSQLException(e);
		}
		System.out.println("Successfully connected to mysql.");

		// Switch to using the desired database
		execute("use " + MYSQL_DATABASE_NAME);
		System.out.format("Using database '%s'.\n\n", MYSQL_DATABASE_NAME);
	}

	private void handleSQLException(SQLException e) {
		e.printStackTrace();
		System.exit(0);
	}

	private void printResultSet(ResultSet resultSet) {
		final String separator = " | ";
		System.out.println("Result set:");
		try {
			ResultSetMetaData md = resultSet.getMetaData();
			int numCols = md.getColumnCount();

			// print column labels
			for (int i = 1; i <= numCols; i++) {
				System.out.print(md.getColumnLabel(i));
				if (i < numCols) {
					System.out.print(separator);
				}
			}
			System.out.println();

			// print contents of each row returned
			int rowCounter = 0;
			while (resultSet.next()) {
				rowCounter++;
				StringBuilder sb = new StringBuilder();
				for (int i = 1; i <= numCols; i++) {
					String result = resultSet.getString(i);
					sb.append(result);
					if (i < numCols) {
						sb.append(separator);
					}
				}
				System.out.println(sb);
			}
			System.out.println("Number of rows: " + rowCounter);

		} catch (SQLException e) {
			handleSQLException(e);
		}
	}

	/**
	 * Print a message to the console, describing the SQL query that has
	 * just been executed. Long queries are truncated and the query is
	 * reformatted to make the message more readable.
	 * 
	 * @param query The SQL query that has just been executed.
	 */
	private void printExecutionMessage(String query) {
		final int maxLen = 55;
		String truncated_query;
		if (query.length() > maxLen) {
			truncated_query = query.substring(0, maxLen) + "...";
		} else {
			truncated_query = query;
		}
		// Eliminate newlines and consecutive spaces
		truncated_query = truncated_query.replace('\n', ' ').trim()
				.replaceAll(" +", " ");

		System.out.format("Executed the query \"%s\"\n", truncated_query);
	}

	/**
	 * Send an SQL command to the database server. This method is used for
	 * sending commands that do not return results. For queries that return
	 * results, use executeQuery().
	 * 
	 * @param sqlString The SQL command to be executed.
	 */
	public void execute(String sqlString) {
		try (Statement statement = connection.createStatement()) {
			statement.execute(sqlString);
		} catch (SQLException e) {
			handleSQLException(e);
		}
		printExecutionMessage(sqlString);
	}

	/**
	 * Send an SQL query to the database server. This method is used for
	 * sending queries that return results. For commands that do not return
	 * results, use execute().
	 * 
	 * @param query The SQL query to be executed.
	 */
	public void executeQuery(String query) {
		try (Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery(query);
			printExecutionMessage(query);
			printResultSet(resultSet);
		} catch (SQLException e) {
			handleSQLException(e);
		}
	}

	public static void main(String[] args) {
		QueryExecutor qe = new QueryExecutor();

		// This is an example of how to execute a query.
		qe.executeQuery("SELECT * FROM `supplier`");
	}
}
