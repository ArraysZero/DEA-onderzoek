package nl.han.spotitube.alt.spotitube.dtos;

import nl.han.spotitube.alt.spotitube.dtos.TrackDTO;

public class PlaylistDTO {
  
  private int id;
  private String name;
  private String owner;
  private TrackDTO[] tracks;

  public PlaylistDTO(int id, String name, String owner, TrackDTO[] tracks) {
    this.id = id;
    this.name = name;
    this.owner = owner;
    this.tracks = tracks;
  }

  public PlaylistDTO(int id, String name, String owner) {
    this.id = id;
    this.name = name;
    this.owner = owner;
    this.tracks = new TrackDTO[0];
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getOwner() {
    return owner;
  }

  public TrackDTO[] getTracks() {
    return tracks;
  }
}
