package dbManager;

import java.util.List;
import java.util.Calendar;

import javax.jdo.PersistenceManager;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

public final class DataStoreDatabaseManager
 {
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    PersistenceManager pm = PMF.get().getPersistenceManager();
    private DataStoreDatabaseManager() {}
    private static DataStoreDatabaseManager instance = null;
    public static DataStoreDatabaseManager getInstance()
    {
        if (instance == null)
            instance = new DataStoreDatabaseManager();
        return instance;
    }
    
    public void insertNewDrug(Drug newDrug)
    {
            pm.makePersistent(newDrug);
    }
    
    public void insertNewOrder(Order newOrder)
    {
            pm.makePersistent(newOrder);
    }
    
    //return drug if exists
    public Drug getDrugByName (String nameParam)
    {
    	try {
    		javax.jdo.Query query = pm.newQuery(Drug.class);
    		query.setFilter("name.compareTo(nameParam) == 0");
    		Drug d = (Drug) query.execute();
    		return d;
    	}
    	catch (Exception e) {
    		return null;
    	}
    }
    
    //return all orders for the same day between fromHour and toHour
    public List<Order> getOrderByHours (int fromHour, int toHour)
    {
    	try {
    		javax.jdo.Query query = pm.newQuery(Order.class);
    		query.setFilter("month == Calendar.MONTH && day == Calendar.DAY_OF_MONTH && from >= fromHour && to <= toHour");
    		List<Order> list = (List<Order>) query.execute();
    		return list;
    	}
    	catch (Exception e) {
    		return null;
    	}
    }
    
    //return the client's order
    public Order getOrderByClientID (int id)
    {
    	try {
    		javax.jdo.Query query = pm.newQuery(Order.class);
    		query.setFilter("clientID == id");
    		Order o = (Order) query.execute();
    		return o;
    	}
    	catch (Exception e) {
    		return null;
    	}
    }

}