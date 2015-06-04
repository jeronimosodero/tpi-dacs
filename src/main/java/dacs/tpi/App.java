package dacs.tpi;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	private static final String PERSISTENCE_UNIT_NAME = "tpidacs";

	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	}
}
