package quickmed;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
//import com.google.appengine.api.datastore.Entity;
//import com.google.appengine.api.datastore.Key;
//import com.google.appengine.api.datastore.PreparedQuery;
//import com.google.appengine.api.datastore.Query;

import dbManager.DataStoreDatabaseManager;
import dbManager.Drug;
//import dbManager.Order;

public class InventoryServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	 public InventoryServlet()
	    {
		// TODO Auto-generated constructor stub
	        super();
	    }

	        /**
	         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	         */
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                // TODO Auto-generated method stub
	        }

	        /**
	         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	         */
	        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        	response.setContentType("text/html");
	        	PrintWriter out = response.getWriter();
	        		Object nameO = request.getParameter("theNameField");
	                Object MeuhedetPriceO = request.getParameter("theMeuhedetPriceField");
	                Object LeumitPriceO = request.getParameter("theLeumitPriceField");
	                Object ClalitPriceO = request.getParameter("theClalitPriceField");
	                Object MaccabiPriceO = request.getParameter("theMaccabiPriceField");
	                Object HMOlessPriceO = request.getParameter("theHMOlessPriceField");
	                Object quantityO = request.getParameter("thequantityField");
	                System.out.println("the nameO is " + nameO.toString());
	                System.out.println("the MeuhedetPriceO is " + MeuhedetPriceO.toString());
	                System.out.println("the LeumitPriceO is " + LeumitPriceO.toString());
	                System.out.println("the ClalitPriceO is " + ClalitPriceO.toString());
	                System.out.println("the MaccabiPriceO is " + MaccabiPriceO.toString());
	                System.out.println("the HMOlessPriceO is " + HMOlessPriceO.toString());
	                System.out.println("the quantityO is " + quantityO.toString());
	                if (nameO != null && quantityO != null)
	                {
	                        Drug d = new Drug();
	                        d.name = nameO.toString();
	                        d.MeuhedetPrice = Double.parseDouble(MeuhedetPriceO.toString());
	                        d.LeumitPrice = Double.parseDouble(LeumitPriceO.toString());
	                        d.ClalitPrice = Double.parseDouble(ClalitPriceO.toString());
	                        d.MaccabiPrice = Double.parseDouble(MaccabiPriceO.toString());
	                        d.HMOlessPrice = Double.parseDouble(HMOlessPriceO.toString());
	                        d.quantity = Integer.parseInt(quantityO.toString());
	                        d.virtualQuantity = d.quantity;
	                 
	                Drug temp = DataStoreDatabaseManager.getInstance().getDrugByName(d.name);
	                if (temp != null)
	                        {
	                        	d.quantity += temp.quantity;
	                        	d.virtualQuantity += temp.virtualQuantity;
	                        	DataStoreDatabaseManager.getInstance().insertNewDrug(d);
		                        out.println("<script type=\"text/javascript\">");  
		                    	out.println("alert('drug updated successfully');");  
		                    	out.println("history.back();");
		                    	out.println("</script>");
	                        }
	                        else
	                        {
	                        	DataStoreDatabaseManager.getInstance().insertNewDrug(d);
		                        out.println("<script type=\"text/javascript\">");  
		                    	out.println("alert('drug added successfully');");  
		                    	out.println("history.back();");
		                    	out.println("</script>");
	                        }
	                        
	                     
	                }
	                
	        }

}
