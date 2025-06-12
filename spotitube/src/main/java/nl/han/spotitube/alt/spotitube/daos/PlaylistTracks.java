package nl.han.spotitube.alt.spotitube.daos;

import java.util.ArrayList;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import nl.han.spotitube.alt.spotitube.database.Database;
import nl.han.spotitube.alt.spotitube.dtos.*;

import nl.han.spotitube.alt.spotitube.exceptions.*;


public class PlaylistTracks {
  //
  public TrackDTO[] getTracksOnPlaylist(int playlistId) {
    
    try (Connection conn = new Database().connect()) {
      
      String sql = "SELECT trackId FROM TrackOnPlaylist WHERE playlistId = ?";

      var stmt = conn.prepareStatement(sql);

      stmt.setInt(1, playlistId);
      var result = stmt.executeQuery();

      ArrayList<Integer> trackIds = new ArrayList();
      while (result.next()) {
        trackIds.add(result.getInt("trackId"));
      }

      int[] tracks = trackIds.stream().mapToInt(Integer::intValue).toArray();
      return new TrackDAO().getTracklist(tracks);
    } catch (SQLException e) {
      //TODO: handle exception
      throw new DataAccessException(e.getMessage());
    }
  }

  public TrackDTO[] getAvailableTracks(int playlistId) {
    
    try (Connection conn = new Database().connect()) {
      String sql = "SELECT * FROM Track WHERE id NOT IN (SELECT trackId FROM TrackOnPlaylist WHERE playlistId = ?)";

      var stmt = conn.prepareStatement(sql);

      stmt.setInt(1, playlistId);
      var result = stmt.executeQuery();

      ArrayList<TrackDTO> tracks = new ArrayList();
      while (result.next()) {
        tracks.add(new TrackDTO(result.getInt("id"),
                result.getString("title"),
                result.getString("performer"),
                result.getInt("duration"),
                result.getString("album"),
                result.getInt("playcount"),
                result.getString("publicationDate"),
                result.getString("description"),
                ((result.getInt("offlineAvailable") == 1) ? true : false)
              ));
      }

      return tracks.toArray(new TrackDTO[tracks.size()]);
    } catch (SQLException e) {
      //TODO: handle exception
      throw new DataAccessException(e.getMessage());
    }
  }

  public void addTrackToPlaylist(int playlistId, int trackId) {
    
    try (Connection conn = new Database().connect()) {
      String sql = "INSERT INTO TrackOnPlaylist (trackId, playlistId) VALUES (?, ?)";
      var stmt = conn.prepareStatement(sql);

      stmt.setInt(1, trackId);
      stmt.setInt(2, playlistId);

      stmt.execute();
    } catch (SQLException e) {
      //TODO: handle exception
      throw new DataAccessException(e.getMessage());
    }
  }
  
  public void deleteTrackFromPlaylist(int playlistId, int trackId) {

    try (Connection conn = new Database().connect()) {
      String sql = "DELETE FROM TrackOnPlaylist WHERE playlistId = ? AND trackId = ?";
      var stmt = conn.prepareStatement(sql);

      stmt.setInt(1, playlistId);
      stmt.setInt(2, trackId);

      stmt.execute();
    } catch (SQLException e) {
      //TODO: handle exception
      throw new DataAccessException(e.getMessage());
    }
  }
}
