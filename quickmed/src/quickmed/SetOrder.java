package quickmed;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbManager.DataStoreDatabaseManager;
import dbManager.Order;

public class SetOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;
   
public SetOrder() {
	super();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  	}
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	Object hourO = request.getParameter("theHourField");
	HttpSession session = request.getSession();
    int id = Integer.parseInt(session.getAttribute("userName").toString());
    System.out.println ("search "+id);
    Order o = DataStoreDatabaseManager.getInstance().getOrderByClientID(id);
    if (o == null) {
        System.out.println ("order not found");
        return;
    }
    int i = Integer.parseInt(hourO.toString());
    o.setHours(i, i+1); 
    System.out.println ("hour : " + i);
    out.println("<script type=\"text/javascript\">"); 
    out.println("window.location.href = 'finalorder.jsp';");
    out.println("</script>");
}

}

