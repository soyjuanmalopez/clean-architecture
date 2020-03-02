package netflix.app.utils;

import java.io.Serializable;

public interface RepositoryConverter<T extends Serializable, P extends Serializable> {

	default T mapToTable(final P persistenceObject) {
		throw new UnsupportedOperationException();
	}

	default P mapToEntity(final T tableObject) {
		throw new UnsupportedOperationException();
	}

}
