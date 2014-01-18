package dbManager;

import java.util.List;
import java.util.Calendar;

import javax.jdo.PersistenceManager;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Key;

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
    
    public void insertNewOrderedDrug(OrderedDrug newOrderedDrug)
    {
            pm.makePersistent(newOrderedDrug);
    }
    
    //return drug if exists
    public Drug getDrugByName (String nameParam)
    {
    	PersistenceManager pm = PMF.get().getPersistenceManager();
    	try {
    		javax.jdo.Query query = pm.newQuery(Drug.class);
        	query.setFilter("name == nameParam");
        	query.declareParameters("String nameParam");
        	List<Drug> list = (List<Drug>) query.execute(nameParam);
        	return list.get(0);
    	}
    	catch (Exception e) {
    		return null;
    	}
    }
    
    //return all orders for the same day between fromHour and toHour
    public List<Order> getOrderByHours (int fromHour, int toHour)
    {
    	PersistenceManager pm = PMF.get().getPersistenceManager();
    	try {
    		javax.jdo.Query query = pm.newQuery(Order.class);
    		query.setFilter("month == Calendar.MONTH && day == Calendar.DAY_OF_MONTH && from >= fromHour && to <= toHour");
    		query.declareParameters("int fromHour, int toHour");
    		List<Order> list = (List<Order>) query.execute(fromHour, toHour);
    		return list;
    	}
    	catch (Exception e) {
    		return null;
    	}
    }
    
    //return the client's order
    public Order getOrderByClientID (int id)
    {
    	PersistenceManager pm = PMF.get().getPersistenceManager();
    	javax.jdo.Query query = pm.newQuery(Order.class);
    	query.setFilter("clientID == id");
    	query.declareParameters("int id");
    	List<Order> list = (List<Order>) query.execute (id);
    	if (!list.isEmpty())
        	return list.get(0);
        else
        	return null;
    }
    
    public List<Order> getAllOrders ()
    {
    	PersistenceManager pm = PMF.get().getPersistenceManager();
    	javax.jdo.Query query = pm.newQuery(Order.class);
    	List<Order> list = (List<Order>) query.execute ();
    	return list;
    }
}