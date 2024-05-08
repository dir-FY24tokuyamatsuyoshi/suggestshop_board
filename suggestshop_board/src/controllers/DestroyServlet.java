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
 * Servlet implementation class DestroyServlet
 */
@WebServlet("/destroy")
public class DestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            var em = DBUtil.createEntityManager();
            
            var s = em.find(Suggestshop.class, (Integer) (request.getSession().getAttribute("suggestshop_id")));
            
            em.getTransaction().begin();
            em.remove(s); // データ削除
            em.getTransaction().commit();
            em.close();
            
            request.getSession().removeAttribute("suggestshop_id");

            // indexページへリダイレクト
            response.sendRedirect(request.getContextPath() + "/index");

            
        }
	}

}
