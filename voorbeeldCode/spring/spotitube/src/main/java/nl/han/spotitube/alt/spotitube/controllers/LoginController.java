package nl.han.spotitube.alt.spotitube.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.han.spotitube.alt.spotitube.database.Database;
import nl.han.spotitube.alt.spotitube.dtos.CredentialsDTO;
import nl.han.spotitube.alt.spotitube.dtos.LoginDTO;
import nl.han.spotitube.alt.spotitube.services.LoginService;

@RestController
@RequestMapping
public class LoginController {

	@PostMapping("/login")
	public LoginDTO login(@RequestBody CredentialsDTO credentials) {
		// do something cool
		return new LoginService().login(credentials);
	}
}