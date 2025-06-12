package nl.han.spotitube.alt.spotitube.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import nl.han.spotitube.alt.spotitube.database.Database;
import nl.han.spotitube.alt.spotitube.dtos.CredentialsDTO;
import nl.han.spotitube.alt.spotitube.dtos.UserDTO;
import nl.han.spotitube.alt.spotitube.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@PostMapping("")
	public UserDTO login(@RequestBody CredentialsDTO credentials) {
		// do something cool
    //System.out.println(credentials.getUser());
		return new LoginService().login(credentials);
	}
}
