package netflix.core.utils.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class BadRequestException extends NetflixException{

	private static final long serialVersionUID = -5330068136795055851L;

	public BadRequestException(final String message) {
		super(HttpStatus.BAD_REQUEST.value(), message);
	}

}
