package nl.han.spotitube.alt.spotitube.daos;

import nl.han.spotitube.alt.spotitube.database.Database;
import nl.han.spotitube.alt.spotitube.dtos.UserDTO;
import nl.han.spotitube.alt.spotitube.exceptions.DataAccessException;

public class UserDAO {

	public UserDTO getUser(String username) {

		// Database data = new Database();

		if(username.equals("Dani")) {
			return new UserDTO("Dani", "password123");
		} else if (!username.equals("error")){
			return null;
		} else {
			throw new DataAccessException("user not found");
		}
	}
}