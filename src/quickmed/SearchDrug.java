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
            else if (d.getQuantity() == 0) {
            	out.println("<script type=\"text/javascript\">");  
            	out.println("alert('Sorry, drug not in stock.');");  
            	out.println("history.back();");
            	out.println("</script>"); 
            }
            else if (d.getQuantity() < quantity) {
            	out.println("<script type=\"text/javascript\">");  
            	out.println("alert('Sorry, not enough drug in stock.');"); 
            	out.println("history.back();");
            	out.println("</script>"); 
            }
            else {
            	HttpSession session =  request.getSession();
            	if (session.getAttribute("userName") == null) {
                	out.println("<script type=\"text/javascript\">"); 
            		out.println("alert('Drug in stock, please open a session if you want to order.');");
                	out.println("</script>");
            		response.sendRedirect("qm.jsp");
            		return;
            	}
            	else {
                	out.println("<script type=\"text/javascript\">"); 
                	out.println("alert('Drug in stock, added to basket.');");
                	out.println("</script>");
                	int id = Integer.parseInt(session.getAttribute("userName").toString());
                	Order o = DataStoreDatabaseManager.getInstance().getOrderByClientID(id);
                	o.add(nameO.toString(), quantity);
                	response.sendRedirect("qm.jsp");
                	return;
            	}
            }
        }	
    }
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

}

