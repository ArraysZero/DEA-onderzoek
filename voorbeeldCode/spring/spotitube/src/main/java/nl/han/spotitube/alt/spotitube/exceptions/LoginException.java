package nl.han.spotitube.alt.spotitube.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.UNAUTHORIZED)  // 401
public class LoginException extends RuntimeException{

	public LoginException(String message) {
		super(message);
	}
}