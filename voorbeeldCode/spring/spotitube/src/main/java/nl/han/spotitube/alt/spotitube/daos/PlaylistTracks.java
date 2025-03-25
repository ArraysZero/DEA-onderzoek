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
        System.out.println("add track to " + playlistId);
        trackIds.add(result.getInt("trackId"));
      }

      //System.out.println("platlist: " playlistId + " ->");
      //for (int i = 0; i < trackIds.size(); i++) {
      //  System.out.println(trackIds.get(i));
      //}

      int[] tracks = trackIds.stream().mapToInt(Integer::intValue).toArray();
      return new TrackDAO().getTracklist(tracks);
    } catch (SQLException e) {
      //TODO: handle exception
      throw new DataAccessException(e.getMessage());
    }
  }
}
