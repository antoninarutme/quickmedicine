package quickmed;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbManager.Order;

public class OpenSession extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public OpenSession() {
    	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
        Object idO = request.getParameter("theIdField");
        Object hmoO = request.getParameter("theHmoField");
        System.out.println("the idO is " + idO.toString());
        System.out.println("the hmoO is " + hmoO.toString());
        if (idO != null && hmoO != null) {
            int id;
            try {
            	id = Integer.parseInt(idO.toString());
            }
            catch (NumberFormatException e) {
            	id = 0;
            }
            if (id <= 0) {
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Invalid id!');"); 
                out.println("history.back();");
                out.println("</script>");
            }
            else {
            	HttpSession session = request.getSession();
            	session.setAttribute("userName", idO.toString());
            	Order o = new Order(id, hmoO.toString());
            	response.sendRedirect("myorder.jsp");
            	return;
            }
         }
    }

}
