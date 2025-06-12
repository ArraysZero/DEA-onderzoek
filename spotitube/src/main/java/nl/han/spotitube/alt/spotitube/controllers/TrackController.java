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
import nl.han.spotitube.alt.spotitube.services.TrackService;

@RestController
@RequestMapping
public class TrackController {
  // track controller
  private LoginService loginService = new LoginService();

  @GetMapping("/tracks")
  public TrackListDTO getAvailableTracks(@RequestParam String token, @RequestParam int forPlaylist) {
    var user = loginService.checkToken(token);

    return new TrackService().getAvailableTracks(forPlaylist);
  }
}
