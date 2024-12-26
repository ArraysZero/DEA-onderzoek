package nl.han.spotitube.alt.spotitube.daos;

import nl.han.spotitube.alt.spotitube.dtos.PlaylistDTO;

public class PlaylistDAO {

	public PlaylistDTO[] getPlaylists() {
		PlaylistDTO[] playlists = new PlaylistDTO[3];

		playlists[0] = new PlaylistDTO(0, "workout", "Dani");
		playlists[1] = new PlaylistDTO(1, "chillen", "Robin");
		playlists[2] = new PlaylistDTO(2, "night drives", "Dani");
		return playlists;
	}
}