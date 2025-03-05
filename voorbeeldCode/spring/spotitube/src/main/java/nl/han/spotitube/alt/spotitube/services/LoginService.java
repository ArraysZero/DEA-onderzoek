package nl.han.spotitube.alt.spotitube.services;

import nl.han.spotitube.alt.spotitube.daos.UserDAO;
import nl.han.spotitube.alt.spotitube.dtos.CredentialsDTO;
import nl.han.spotitube.alt.spotitube.dtos.LoginDTO;
import nl.han.spotitube.alt.spotitube.dtos.UserDTO;
import nl.han.spotitube.alt.spotitube.exceptions.DataAccessException;
import nl.han.spotitube.alt.spotitube.exceptions.LoginException;

public class LoginService {

	UserDAO userDAO = new UserDAO();

	public LoginDTO login(CredentialsDTO credentials) throws LoginException, DataAccessException {

		UserDTO user = new UserDAO().getUser(credentials.getUser());

		if (user != null && credentials.getPassword().equals(user.getPassword())) {
			return new LoginDTO(credentials.getUser(), "1024-abcd-4096-wxyz");
		} else {
			throw new LoginException("username or password incorrect");
		}
	}

	public UserDTO checkToken(String token) {
		if (token.equals("1024-abcd-4096-wxyz")) {
			return new UserDAO().getUser("Dani");
		}
		throw new LoginException("token does not exist");
	}
}
