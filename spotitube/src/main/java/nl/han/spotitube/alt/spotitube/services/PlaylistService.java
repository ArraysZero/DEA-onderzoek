package nl.han.spotitube.alt.spotitube.services;

import nl.han.spotitube.alt.spotitube.daos.PlaylistDAO;
import nl.han.spotitube.alt.spotitube.daos.PlaylistTracks;
import nl.han.spotitube.alt.spotitube.dtos.*;

public class PlaylistService {

  PlaylistDAO playlistDAO = new PlaylistDAO();

	public PlaylistListDTO getAllPlaylists(String user) {
    var playlists = playlistDAO.getAllPlaylists();

    var playlistList = new PlaylistListDTO(new PlaylistDataDTO[playlists.length]);

    int i = 0;

    for (PlaylistDTO playlist : playlists) {
      playlistList.getPlaylists()[i] = new PlaylistDataDTO(playlist.getId(), 
          playlist.getName(), 
          ((user.equals(playlist.getOwner())) ? true : false), 
          new TrackListDTO(playlist.getTracks()));
      i++;
    }

	  return playlistList;
	}

	 public PlaylistListDTO deletePlaylist(String user, int playlistId) {

     playlistDAO.deletePlaylist(playlistId);

     return getAllPlaylists(user);
	 }

   public PlaylistListDTO addPlaylist(PlaylistDTO playlist) {

     playlist.setId((int) ((Math.random()) * 10000));
     playlistDAO.addPlaylist(playlist);

     return getAllPlaylists(playlist.getOwner());
   }


   public PlaylistListDTO editPlaylist(PlaylistDTO playlist) {
     playlistDAO.editPlaylist(playlist);
     
     return getAllPlaylists(playlist.getOwner());
   }

   public TrackListDTO getTracksOnPlaylist(int playlistId) {
     return new TrackListDTO(new PlaylistTracks().getTracksOnPlaylist(playlistId));
   }

   public TrackListDTO addTrackToPlaylist(int playlistId, int trackId) {

     new PlaylistTracks().addTrackToPlaylist(playlistId, trackId);

     return new TrackListDTO(new PlaylistTracks().getTracksOnPlaylist(playlistId));
   }

   public TrackListDTO deleteTrackFromPlaylist (int playlistId, int trackId) {
     
     new PlaylistTracks().deleteTrackFromPlaylist(playlistId, trackId);
     
     return new TrackListDTO(new PlaylistTracks().getTracksOnPlaylist(playlistId));
   }
}
