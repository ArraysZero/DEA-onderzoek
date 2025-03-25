package nl.han.spotitube.alt.spotitube.daos;

import java.util.ArrayList;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import nl.han.spotitube.alt.spotitube.database.Database;
import nl.han.spotitube.alt.spotitube.dtos.*;

import nl.han.spotitube.alt.spotitube.exceptions.*;

public class PlaylistDAO {
  
  public PlaylistDTO[] getAllPlaylists() {
    
    try (Connection conn = new Database().connect()) {
      String sql = "SELECT * FROM Playlist";

      var stmt = conn.prepareStatement(sql);

      var result = stmt.executeQuery();

      ArrayList<PlaylistDTO> playlists = new ArrayList();

      while (result.next()) {
        playlists.add(new PlaylistDTO(result.getInt("id"), result.getString("name"), result.getString("owner")));
      }

      return playlists.toArray(new PlaylistDTO[playlists.size()]);

    } catch (SQLException e) {
      //TODO: handle exception
      throw new DataAccessException(e.getMessage());
    }
  }
}
