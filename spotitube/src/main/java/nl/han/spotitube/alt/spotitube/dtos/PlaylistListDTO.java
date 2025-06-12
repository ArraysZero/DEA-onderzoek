package nl.han.spotitube.alt.spotitube.dtos;

public class PlaylistListDTO {
  
  private PlaylistDataDTO[] playlists;

  public PlaylistListDTO(PlaylistDataDTO[] playlists) {
    this.playlists = playlists;
  }

  public PlaylistDataDTO[] getPlaylists() {
    return playlists;
  }
}
