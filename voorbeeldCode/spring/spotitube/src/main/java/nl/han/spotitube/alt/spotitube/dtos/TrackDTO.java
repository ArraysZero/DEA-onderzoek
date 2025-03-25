package nl.han.spotitube.alt.spotitube.dtos;

public class TrackDTO {
  
  private int id;
  private String title;
  private String performer;
  private int duration;
  private String album;
  private int playcount;
  private String publicationDate;
  private String description;
  private boolean offlineAvailable;

  public TrackDTO(int id, String title, String performer, int duration, String album, int playcount, String publicationDate, String description, boolean offlineAvailable) {
    this.id = id;
    this.title = title;
    this.performer = performer;
    this.duration = duration;
    this.album = album;
    this.playcount = playcount;
    this.publicationDate = publicationDate;
    this.description = description;
    this.offlineAvailable = offlineAvailable;
  }
}
