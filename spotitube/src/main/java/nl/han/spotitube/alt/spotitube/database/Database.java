package nl.han.spotitube.alt.spotitube.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import nl.han.spotitube.alt.spotitube.exceptions.DataAccessException;

public class Database {

	public Connection connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection("jdbc:sqlite:datasource");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class not found");
			throw new DataAccessException(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL Exception");
			throw new DataAccessException(e.getMessage());
		}
	}

	// prepared statement
}