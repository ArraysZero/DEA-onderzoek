package nl.han.spotitube.alt.spotitube.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Database error")  // 500
public class DataAccessException extends RuntimeException {

	public DataAccessException(String message){
		super(message);
	}
}