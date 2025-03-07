package nl.han.spotitube.alt.spotitube.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.han.spotitube.alt.spotitube.dtos.PlaylistListDTO;
import nl.han.spotitube.alt.spotitube.dtos.UserDTO;
import nl.han.spotitube.alt.spotitube.services.LoginService;
import nl.han.spotitube.alt.spotitube.services.PlaylistService;

@RestController
@RequestMapping
public class PlaylistController {

	@GetMapping("/playlists")
	public PlaylistListDTO getPlaylists(@RequestParam String token) {
		// do something
		UserDTO user = new LoginService().checkToken(token);

		return new PlaylistService().getAllPlaylists(user.getUser());
	}

	@DeleteMapping("/playlists/{id}")
	public PlaylistListDTO removePlaylist(@RequestParam String token, @PathVariable int id) {
    UserDTO user = new LoginService().checkToken(token);

		return new PlaylistService().deletePlaylist(user.getUser(), id);
	}

  @PostMapping("/playlists")
  public PlaylistListDTO addPlaylist(@RequestParam String token) {
    UserDTO user = new LoginService().checkToken(token);

    return null;
  }
}
