package nl.han.spotitube.alt.spotitube.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import nl.han.spotitube.alt.spotitube.database.Database;
import nl.han.spotitube.alt.spotitube.dtos.CredentialsDTO;
import nl.han.spotitube.alt.spotitube.dtos.UserDTO;
import nl.han.spotitube.alt.spotitube.exceptions.DataAccessException;

public class UserDAO {

	public UserDTO getUser(String username) {

		try (Connection conn = new Database().connect()) { String sql = "SELECT * FROM User WHERE name = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
  		var result = stmt.executeQuery();
			if (result.next()) {
				return new UserDTO(result.getString("name"), result.getString("password"));
      } else {
				return null;
			}
		} catch (SQLException e) {
      System.out.println("SQLException" + e);
			throw new DataAccessException(e.getMessage());
		}
	}
}
