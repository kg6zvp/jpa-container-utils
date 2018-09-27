package eisiges.jpa_container_utils;

import java.util.ServiceLoader;

import javax.persistence.PersistenceException;
import javax.persistence.spi.PersistenceProvider;

public class PersistenceUtils {

	public static String getDefaultPersistenceProviderClassName() {
		return getDefaultPersistenceProvider().getClass().getName();
	}

	public static PersistenceProvider getDefaultPersistenceProvider() {
			ServiceLoader<PersistenceProvider> sl = ServiceLoader.load(PersistenceProvider.class);
			if(!sl.iterator().hasNext())
				throw new PersistenceException("Cannot find any " + PersistenceProvider.class.getName() + " service on the classpath");
			return sl.iterator().next();
	}
}
