package quickmed;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbManager.DataStoreDatabaseManager;
import dbManager.Drug;
import dbManager.Order;
import dbManager.OrderedDrug;

public class SearchDrug extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    public SearchDrug() {
    	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	Object nameO = request.getParameter("theNameField");
        Object quantityO = request.getParameter("theQuantityField");
        if (nameO != null && quantityO != null) {
        	Drug d = DataStoreDatabaseManager.getInstance().getDrugByName(nameO.toString());
            int quantity;
            try {
            	quantity = Integer.parseInt(quantityO.toString());
            }
            catch (NumberFormatException e) {
            	quantity = 0;
            }
            if (d == null) {
            	out.println("<script type=\"text/javascript\">");  
            	out.println("alert('Drug not found!');"); 
            	out.println("history.back();");
            	out.println("</script>");
            }
            else if (quantity <= 0) {
            	out.println("<script type=\"text/javascript\">");  
            	out.println("alert('Invalid quantity!');");
            	out.println("history.back();");
            	out.println("</script>");
            }
            else if (!(d.isInInventory())) {
            	out.println("<script type=\"text/javascript\">");  
            	out.println("alert('Sorry, drug not in stock.');");  
            	out.println("history.back();");
            	out.println("</script>"); 
            }
            else if (!(d.enoughInInventory(quantity))) {
            	out.println("<script type=\"text/javascript\">");  
            	out.println("alert('Sorry, not enough drug in stock.');"); 
            	out.println("history.back();");
            	out.println("</script>"); 
            }
            else {
				HttpSession session = request.getSession();
            	if (session.getAttribute("userName") == null) {
                	out.println("<script type=\"text/javascript\">"); 
            		out.println("alert('Drug in stock, please open a session if you want to order.');");
            		out.println("window.location.href = 'qm.jsp';");
                	out.println("</script>");
                	System.out.println ("Drug in stock, please open a session if you want to order.");
            	}
            	else {
                	out.println("<script type=\"text/javascript\">"); 
                	out.println("alert('Drug in stock, added to basket.');");
                	out.println("</script>");
                	int id = Integer.parseInt(session.getAttribute("userName").toString());
                	System.out.println ("search "+id);
                	Order o = DataStoreDatabaseManager.getInstance().getOrderByClientID(id);
                	if (o == null) {
                		System.out.println ("order not found");
                		return;
                	}
                	OrderedDrug od = new OrderedDrug(d.getName(), d.getPrice(o.HMO) * quantity, quantity);
                	o.add(od);
                	d.order(quantity);
                 	out.println("<script type=\"text/javascript\">"); 
                	out.println("window.location.href = 'medpage.jsp';");
                	out.println("</script>");
            	}
            }
        }	
    }
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}

