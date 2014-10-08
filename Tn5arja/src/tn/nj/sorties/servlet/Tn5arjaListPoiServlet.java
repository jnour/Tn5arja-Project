package tn.nj.sorties.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.nj.sorties.model.PointOfInterest;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class Tn5arjaListPoiServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException,IOException {
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    
		
		Query query = new Query("PointOfInterest");
		PreparedQuery pq = datastore.prepare(query);
		List<Entity> entities = pq.asList(FetchOptions.Builder.withLimit(5));
		
		List<PointOfInterest> listPOI = new ArrayList<PointOfInterest>();
		for (Entity entity : entities) {
			listPOI.add(new PointOfInterest(entity));
		}
		
		req.setAttribute("listPoi", listPOI);
		// Redirection vers la page hello.jsp
		getServletContext().getRequestDispatcher("/jsp/poi_list.jsp").forward(req, resp);
		
		
//		resp.getWriter().append("\n"+listPOI.toString());



	}
}
