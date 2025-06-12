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
  // connection
  private Connection getConnection() {
    try {
      return new Database().connect();
    } catch (Exception e) {
      //TODO: handle exception
      throw new DataAccessException("databse connection failed");
    }
  }
  //
  public CredentialsDTO getUser(String username) {
    try (var conn = getConnection()) {
      String sql = "SELECT * FROM User WHERE name = ?";

      var stmt = conn.prepareStatement(sql);
      stmt.setString(1, username);

      var result = stmt.executeQuery();

      if (result.next()) {
        return new CredentialsDTO(result.getString("name"), result.getString("password"));
      }

      return null;
    } catch (SQLException e) {
      //TODO: handle exception
      throw new DataAccessException(e.getMessage());
    }
  }

  public UserDTO getToken(String token) {
    try (var conn = getConnection()) {
      String sql = "SELECT * FROM User WHERE token = ?";

      var stmt = conn.prepareStatement(sql);
      stmt.setString(1, token);

      var result = stmt.executeQuery();

      if (result.next()) {
        return new UserDTO(result.getString("name"), result.getString("token"));
      }

      return null;
    } catch (SQLException e) {
      //TODO: handle exception
      throw new DataAccessException(e.getMessage());
    }
  }

  public boolean addToken(UserDTO user) {
    try (var conn = getConnection()) {
      String sql = "UPDATE User SET token = ? WHERE name = ?";

      var stmt = conn.prepareStatement(sql);
      stmt.setString(1, user.getToken());
      stmt.setString(2, user.getUsername());

      var result = stmt.execute();

      return true;

     } catch (SQLException e) {
      //TODO: handle exception
      throw new DataAccessException(e.getMessage());
    }
  }
}
