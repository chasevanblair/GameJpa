package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameObj;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/addGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddGameServlet() {
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GameHelper gh = new GameHelper();
		String gameName = request.getParameter("game");
		double price = Double.parseDouble(request.getParameter("price"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		
		gh.addGame(new GameObj(gameName, price, rating));
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);

	}

}
