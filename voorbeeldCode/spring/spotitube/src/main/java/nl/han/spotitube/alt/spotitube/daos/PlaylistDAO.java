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
        playlists.add(new PlaylistDTO(result.getInt("id"), result.getString("name"), result.getString("owner"), (new PlaylistTracks().getTracksOnPlaylist(result.getInt("id")))));
      }

      return playlists.toArray(new PlaylistDTO[playlists.size()]);

    } catch (SQLException e) {
      //TODO: handle exception
      throw new DataAccessException(e.getMessage());
    }
  }

  public void deletePlaylist(int playlist) {
    
    try (Connection conn = new Database().connect()) {
      String sql = "DELETE FROM Playlist WHERE id = ?";

      var stmt = conn.prepareStatement(sql);
      stmt.setInt(1, playlist);

      var result = stmt.execute();
    } catch (SQLException e) {
      throw new DataAccessException(e.getMessage());
    }
  }

  public void addPlaylist(PlaylistDTO playlist) {
    
    try (Connection conn = new Database().connect()) {
      String sql = "INSERT INTO Playlist (id, name, owner) VALUES (?, ?, ?)";

      var stmt = conn.prepareStatement(sql);
      stmt.setInt(1, playlist.getId());
      stmt.setString(2, playlist.getName());
      stmt.setString(3, playlist.getOwner());

      var result = stmt.execute();
    } catch (SQLException e) {
      throw new DataAccessException(e.getMessage());
    }
}
}
