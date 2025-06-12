package nl.han.spotitube.alt.spotitube.daos;

import java.util.ArrayList;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import nl.han.spotitube.alt.spotitube.database.Database;
import nl.han.spotitube.alt.spotitube.dtos.*;

import nl.han.spotitube.alt.spotitube.exceptions.*;

public class TrackDAO {
  
  public TrackDTO[] getTracklist(int[] trackIds) {
    
    try (var conn = new Database().connect()) {
      String sql = "SELECT * FROM Track";

      var stmt = conn.prepareStatement(sql);

      var result = stmt.executeQuery();

      TrackDTO[] tracks = new TrackDTO[trackIds.length];
      int i = 0;

      while (result.next()) {
        for (int trackId : trackIds) {
          if (result.getInt("id") == trackId) {
            tracks[i] = new TrackDTO(trackId, result.getString("title"), result.getString("performer"), result.getInt("duration"), result.getString("album"), result.getInt("playcount"), result.getString("publicationDate"), result.getString("description"), ((result.getInt("offlineAvailable") == 1) ? true : false));
            i++;
          }
        }
      }
      
      return tracks;
    } catch (SQLException e) {
      //TODO: handle exception
      throw new DataAccessException(e.getMessage());
    }
  }
}
