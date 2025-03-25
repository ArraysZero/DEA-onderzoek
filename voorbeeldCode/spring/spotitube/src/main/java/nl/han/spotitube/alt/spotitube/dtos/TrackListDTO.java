package nl.han.spotitube.alt.spotitube.dtos;

public class TrackListDTO {
  
  private TrackDTO[] tracks;

  public TrackListDTO(TrackDTO[] tracks) {
    this.tracks = tracks;
  }
  
  public TrackDTO[] getTracks() {
    return this.tracks;
  }
}
