package tn.nj.sorties.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF {
	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");

	private EMF() {
	}

	public static EntityManagerFactory get() {
//		if(emfInstance!=null)
//			return emfInstance;
//		else
//			return Persistence
//			.createEntityManagerFactory("transactions-optional");
		return emfInstance;
	}
}