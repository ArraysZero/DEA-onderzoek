package nl.han.spotitube.alt.spotitube.services;

import nl.han.spotitube.alt.spotitube.daos.UserDAO;
//import nl.han.spotitube.alt.spotitube.dtos.CredentialsDTO;
//import nl.han.spotitube.alt.spotitube.dtos.LoginDTO;
import nl.han.spotitube.alt.spotitube.dtos.*;
import nl.han.spotitube.alt.spotitube.exceptions.DataAccessException;
import nl.han.spotitube.alt.spotitube.exceptions.LoginException;

public class LoginService {

	UserDAO userDAO = new UserDAO();

	public UserDTO login(CredentialsDTO credentials) throws LoginException, DataAccessException {

		//CredentialsDTO user = new UserDAO().getUser(credentials.getUser());

    //System.out.println(credentials.getUser());

    if (credentials.getPassword().equals(userDAO.getUser(credentials.getUser()).getPassword())) {
      var user = new UserDTO(credentials.getUser(), genToken());

      userDAO.addToken(user);
      return user;
    }

    throw new LoginException("username or password incorrect");
  }

	public UserDTO checkToken(String token) {
	  var user = userDAO.getToken(token);

    if (user != null) {
      return user;
    }

    throw new LoginException("token does not exist");
	}

  private String genToken() {
    return ((int) (Math.random() * 1000)) + "-" + ((int) (Math.random() * 1000)) + "-" + ((int) (Math.random() * 1000)) + "-" + ((int) (Math.random() * 1000));
  }
}
