package tn.nj.sorties.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.nj.sorties.model.PointOfInterest;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

@SuppressWarnings("serial")
public class Tn5arjaPoiServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException,IOException {
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    
		Long id = null;
		String errorMsg = null;
		if(req.getParameter("id")!=null){
			try {
				id = Long.valueOf(req.getParameter("id"));
			} catch (Exception e) {
				errorMsg =  "ID POI INCORRECT.";
			}
			
		}
			
		
		if(id==null || errorMsg!=null || id==0){
			req.setAttribute("erreur",errorMsg);
			// Redirection vers le formulaire form.jsp
			getServletContext().getRequestDispatcher("/jsp/poi.jsp").forward(req, resp);
		}else{
			Key grpKey = KeyFactory.createKey("PointOfInterest", id);
			
			Filter idFilter =
					  new FilterPredicate(Entity.KEY_RESERVED_PROPERTY,
					                      FilterOperator.EQUAL,
					                      grpKey);

			Query query = new Query("PointOfInterest").setFilter(idFilter);

			PreparedQuery pq = datastore.prepare(query);
			Entity entity = pq.asSingleEntity();			
			PointOfInterest poi = new PointOfInterest(entity);
			req.setAttribute("poi", poi);
			getServletContext().getRequestDispatcher("/jsp/poi.jsp").forward(req, resp);
			
			
//			resp.getWriter().append("\n"+entity.toString());
		}
		



	}
}
