package netflix.app.web.rest;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import netflix.core.utils.constants.ExceptionConstants;
import netflix.core.utils.exceptions.BadRequestException;
import netflix.core.utils.exceptions.NetflixException;

@Data
@AllArgsConstructor
public class CategoryRest implements Serializable {

	private static final long serialVersionUID = -2684782811267647848L;

	@NotNull
	private String name;

	@NotNull
	private Boolean available;

	public void validate() throws NetflixException {
		if (this.name.length() > 25)
			throw new BadRequestException(ExceptionConstants.BAD_REQUEST_MESSAGE);

	}
}
