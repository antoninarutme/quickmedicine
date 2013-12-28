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
    	PersistenceManager pm = PMF.get().getPersistenceManager();
    	try {
    		javax.jdo.Query query = pm.newQuery(Drug.class);
        	query.setFilter("name == nameParam");
        	query.declareParameters("String nameParam");
        	List<Drug> l = (List<Drug>) query.execute(nameParam);
        	return l.get(0);
    	}
    	catch (Exception e) {
    		return null;
    	}
    }
    
    //return all orders for the same day between fromHour and toHour
    public List<Order> getOrderByHours (int fromHour, int toHour)
    {
    	PersistenceManager pm = PMF.get().getPersistenceManager();
    	javax.jdo.Query query = pm.newQuery(Order.class);
    	query.setFilter("month == Calendar.MONTH && day == Calendar.DAY_OF_MONTH && from >= fromHour && to <= toHour");
    	List<Order> list = (List<Order>) query.execute();
    	return list;
    }
    
    //return the client's order
    public Order getOrderByClientID (int id)
    {
    	PersistenceManager pm = PMF.get().getPersistenceManager();
    	javax.jdo.Query query = pm.newQuery(Order.class);
    	query.setFilter("clientID == id");
    	Order o = (Order) query.execute();
    	return o;
    }

}