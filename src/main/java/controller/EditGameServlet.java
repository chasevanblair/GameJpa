package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameObj;

/**
 * Servlet implementation class EditGameServlet
 */
@WebServlet("/editGameServlet")
public class EditGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//find game for parameter gameToEdit then process the inputs
		GameHelper gh = new GameHelper();
		double newPrice = Double.parseDouble(request.getParameter("price"));
		int newRating = Integer.parseInt(request.getParameter("rating"));
		GameObj editedGame = new GameObj(request.getParameter("title"), newPrice, newRating);
		gh.editGame(editedGame);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);

	}

}
