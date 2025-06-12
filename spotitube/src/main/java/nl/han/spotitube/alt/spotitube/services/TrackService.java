package nl.han.spotitube.alt.spotitube.services;

import nl.han.spotitube.alt.spotitube.daos.PlaylistTracks;

import nl.han.spotitube.alt.spotitube.dtos.TrackListDTO;

public class TrackService {
  // track service
  public TrackListDTO getAvailableTracks(int playlist) {
    return new TrackListDTO(new PlaylistTracks().getAvailableTracks(playlist));
  }
}
