package nl.han.spotitube.alt.spotitube.services;

import nl.han.spotitube.alt.spotitube.daos.PlaylistDAO;
import nl.han.spotitube.alt.spotitube.dtos.PlayListUserDTO;
import nl.han.spotitube.alt.spotitube.dtos.PlaylistDTO;
import nl.han.spotitube.alt.spotitube.dtos.PlaylistListDTO;

public class PlaylistService {

	public PlaylistListDTO getAllPlaylists(String user) {
		PlaylistDTO[] playlists = new PlaylistDAO().getPlaylists();

		PlaylistListDTO result = new PlaylistListDTO(new PlayListUserDTO[playlists.length]);

		for (int i = 0; i < playlists.length; i++) {
			result.getPlaylists()[i] = new PlayListUserDTO(
				playlists[i].getId(), 
				playlists[i].getName(), 
				user.equals(playlists[i].getOwner()),
				playlists[i].getTracks()
				);
		}

		return result;
	}
}