package netflix.app.utils;

import java.io.Serializable;

public interface RestConverter<R extends Serializable, E extends Serializable> {

	default E mapToEntity(final R rest) {
		throw new UnsupportedOperationException();
	}

	default R mapToRest(final E entity) {
		throw new UnsupportedOperationException();
	}
}
