package nl.han.spotitube.alt.spotitube.dtos;

import nl.han.spotitube.alt.spotitube.dtos.TrackListDTO;

public class PlaylistDataDTO {
  
  private int id;
  private String name;
  private boolean owner;
  private TrackListDTO tracks;

  public PlaylistDataDTO(int id, String name, boolean owner, TrackListDTO tracks) {
    this.id = id;
    this.name = name;
    this.owner = owner;
    this.tracks = tracks;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public boolean getOwner() {
    return this.owner;
  }

  public TrackListDTO getTracks() {
    return this.tracks;
  }
}
