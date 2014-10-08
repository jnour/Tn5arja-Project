package tn.nj.sorties.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class Tn5arjaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    

		Entity  poi = new Entity("PointOfInterest");
		poi.setProperty("name","Test 5arja");
		poi.setProperty("address","Riadh El Andalous");
		poi.setProperty("escription","Test Coffe Shop");
//		endP.insertPointOfInterest(poi);
		
		datastore.put(poi);
		

		
		Query query = new Query("PointOfInterest");
		PreparedQuery pq = datastore.prepare(query);
		List<Entity> listPOI = pq.asList(FetchOptions.Builder.withLimit(5));
		
		resp.getWriter().append("\n"+listPOI.toString());



	}
}
