package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag;

import models.Suggestshop;
import utils.DBUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            var em = DBUtil.createEntityManager();

            // セッションスコープからメッセージのIDを取得して
            // 該当のIDのメッセージ1件のみをデータベースから取得
            var s = em.find(Suggestshop.class, (Integer) (request.getSession().getAttribute("suggestshop_id")));


		    
            String shopname = request.getParameter("shopname");
            s.setShopname(shopname);

            String star = request.getParameter("star");
            s.setStar(star);
            
            String category = request.getParameter("category");
            s.setCategory(category);
            
            String comment = request.getParameter("comment");
            s.setComment(comment);            

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            s.setUpdated_at(currentTime);

            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();


            // セッションスコープ上の不要になったデータを削除
            request.getSession().removeAttribute("suggestshop_id");

            // indexページへリダイレクト
            response.sendRedirect(request.getContextPath() + "/index");
		}
	}

}
