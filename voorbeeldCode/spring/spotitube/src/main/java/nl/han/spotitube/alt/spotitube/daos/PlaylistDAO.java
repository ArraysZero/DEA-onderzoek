package nl.han.spotitube.alt.spotitube.daos;

import java.util.ArrayList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import nl.han.spotitube.alt.spotitube.database.Database;
import nl.han.spotitube.alt.spotitube.exceptions.DataAccessException; 

import nl.han.spotitube.alt.spotitube.dtos.PlaylistDTO;

public class PlaylistDAO {

	public PlaylistDTO[] getPlaylists() {
    
    try (Connection conn = new Database().connect()) {
			String sql = "SELECT * FROM Playlist";
			PreparedStatement stmt = conn.prepareStatement(sql);

  		var result = stmt.executeQuery();

      ArrayList<PlaylistDTO> playlists = new ArrayList<PlaylistDTO>();
			while (result.next()) {
				playlists.add(new PlaylistDTO(result.getInt("id"), result.getString("name"), result.getString("owner")));
      } 

      return playlists.toArray(new PlaylistDTO[playlists.size()]);
    } catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}  
  }

  public PlaylistDTO getPlaylist(int id) {
    try (Connection conn = new Database().connect()) {
			String sql = "SELECT * FROM Playlist WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);

  		var result = stmt.executeQuery();

			if (result.next()) {
				return new PlaylistDTO(result.getInt("id"), result.getString("name"), result.getString("owner"));
      } else {
        throw new DataAccessException("playlist does not exist");
      } 

     } catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
  }

  public void deletePlaylist(int id) {
    try (Connection conn = new Database().connect()) {
			String sql = "DELETE FROM Playlist WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);

  		var result = stmt.execute();

     } catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
  }
}
