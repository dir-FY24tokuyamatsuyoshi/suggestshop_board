package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Suggestshop;
import utils.DBUtil;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var em = DBUtil.createEntityManager();
		
		var s = em.find(Suggestshop.class, Integer.parseInt(request.getParameter("id")));
		
		em.close();
		
		request.setAttribute("suggestshop", s);
		request.setAttribute("_token", request.getSession().getId());
		
		request.getSession().setAttribute("suggestshop_id", s.getId());
		
		var rd = request.getRequestDispatcher("WEB-INF/views/suggestshops/edit.jsp");
		rd.forward(request,response);
		
		
	}

}
