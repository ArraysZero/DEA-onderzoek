package nl.han.spotitube.alt.spotitube.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.han.spotitube.alt.spotitube.dtos.*;
import nl.han.spotitube.alt.spotitube.services.LoginService;
import nl.han.spotitube.alt.spotitube.services.PlaylistService;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

  private LoginService loginService = new LoginService();

	@GetMapping("")
	public PlaylistListDTO getPlaylists(@RequestParam String token) {
		// do something
		UserDTO user = new LoginService().checkToken(token);

    System.out.println("token acceoted");

    return new PlaylistService().getAllPlaylists(user.getUsername());
	}

	@DeleteMapping("/{id}")
	public PlaylistListDTO removePlaylist(@RequestParam String token, @PathVariable int id) {
    UserDTO user = new LoginService().checkToken(token);

		return new PlaylistService().deletePlaylist(user.getUsername(), id);
	}

  @PostMapping("")
  public PlaylistListDTO addPlaylist(@RequestParam String token, @RequestBody PlaylistDTO playlist) {
    UserDTO user = new LoginService().checkToken(token);

    return new PlaylistService().addPlaylist(playlist);
  }

  @PutMapping("/{id}")
  public PlaylistListDTO editPlaylist(@RequestParam String token, @PathVariable int id, @RequestBody PlaylistDTO playlist) {
    UserDTO user = new LoginService().checkToken(token);

    return new PlaylistService().editPlaylist(playlist);
  }

  @GetMapping("/{id}/tracks")
  public TrackListDTO getTracksOnPlaylist(@RequestParam String token, @PathVariable int id) {
    UserDTO user = new LoginService().checkToken(token);

    return new PlaylistService().getTracksOnPlaylist(id);
  }

  @PostMapping("/{id}/tracks")
  public TrackListDTO addTrackToPlaylist(@PathVariable int id, @RequestParam String token, @RequestBody PlaylistDTO playlist) {
    UserDTO user = new LoginService().checkToken(token);

    return new PlaylistService().addTrackToPlaylist(id, playlist.getId());
  }

  @DeleteMapping("/{playlistId}/tracks/{trackId}")
  public TrackListDTO deleteTrackFromPlaylist(@PathVariable int playlistId, @PathVariable int trackId, @RequestParam String token) {
    UserDTO user = new LoginService().checkToken(token);

    return new PlaylistService().deleteTrackFromPlaylist(playlistId, trackId);
  }
}
