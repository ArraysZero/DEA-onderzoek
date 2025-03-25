package nl.han.spotitube.alt.spotitube.services;

import nl.han.spotitube.alt.spotitube.daos.PlaylistDAO;
import nl.han.spotitube.alt.spotitube.dtos.*;

public class PlaylistService {

  PlaylistDAO playlistDAO = new PlaylistDAO();

	public PlaylistListDTO getAllPlaylists(String user) {
    var playlists = playlistDAO.getAllPlaylists();

    var playlistList = new PlaylistListDTO(new PlaylistDataDTO[playlists.length]);

    int i = 0;

    for (PlaylistDTO playlist : playlists) {
      playlistList.getPlaylists()[i] = new PlaylistDataDTO(playlist.getId(), playlist.getName(), ((user.equals(playlist.getOwner())) ? true : false), new TrackListDTO(playlist.getTracks()));
      i++;
    }

	  return playlistList;
	}
	//
	// public PlaylistListDTO deletePlaylist(String user, int playlist) {
	//   return null;
	// }
	//
	// public PlaylistListDTO addPlaylist(PlaylistDTO playlist, String user) {
	//
	//   return null;
	// }
}
