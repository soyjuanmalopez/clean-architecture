package netflix.core.category;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category implements Serializable {

	private static final long serialVersionUID = -5611389089964568317L;

	private Long id;

	private String name;

	private Boolean available;

	
	
}
