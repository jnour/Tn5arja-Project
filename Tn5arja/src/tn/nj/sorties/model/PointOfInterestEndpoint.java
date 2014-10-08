package tn.nj.sorties.model;

import tn.nj.sorties.model.EMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "pointofinterestendpoint", namespace = @ApiNamespace(ownerDomain = "nj.tn", ownerName = "nj.tn", packagePath = "sorties.model"))
public class PointOfInterestEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listPointOfInterest")
	public CollectionResponse<PointOfInterest> listPointOfInterest(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<PointOfInterest> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr
					.createQuery("select from PointOfInterest as PointOfInterest");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<PointOfInterest>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (PointOfInterest obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<PointOfInterest> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getPointOfInterest")
	public PointOfInterest getPointOfInterest(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		PointOfInterest pointofinterest = null;
		try {
			pointofinterest = mgr.find(PointOfInterest.class, id);
		} finally {
			mgr.close();
		}
		return pointofinterest;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param pointofinterest the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertPointOfInterest")
	public PointOfInterest insertPointOfInterest(PointOfInterest pointofinterest) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsPointOfInterest(pointofinterest)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(pointofinterest);
		} finally {
			mgr.close();
		}
		return pointofinterest;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param pointofinterest the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updatePointOfInterest")
	public PointOfInterest updatePointOfInterest(PointOfInterest pointofinterest) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsPointOfInterest(pointofinterest)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(pointofinterest);
		} finally {
			mgr.close();
		}
		return pointofinterest;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removePointOfInterest")
	public void removePointOfInterest(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		try {
			PointOfInterest pointofinterest = mgr.find(PointOfInterest.class,
					id);
			mgr.remove(pointofinterest);
		} finally {
			mgr.close();
		}
	}

	private boolean containsPointOfInterest(PointOfInterest pointofinterest) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			if(pointofinterest.getId()==null){
				contains = false;
			}else{
				
				PointOfInterest item = mgr.find(PointOfInterest.class,
						pointofinterest.getId());
				if (item == null) {
					contains = false;
				}
			
			}
			
			
			
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
