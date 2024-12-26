package nl.han.spotitube.alt.spotitube.dtos;

public class PlaylistListDTO {

	private PlayListUserDTO[] playlists;

	public PlaylistListDTO(PlayListUserDTO[] playlists) {
		this.playlists = playlists;
	}

	public PlayListUserDTO[] getPlaylists() {
		return playlists;
	}

	public void setPlaylists(PlayListUserDTO[] playlists) {
		this.playlists = playlists;
	}

	
	
}