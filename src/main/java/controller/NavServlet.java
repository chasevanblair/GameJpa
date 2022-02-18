package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameObj;

/**
 * Servlet implementation class NavServlet
 */
@WebServlet("/navServlet")
public class NavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String choice = request.getParameter("doThisToItem");
		String path = "/index.html";
		GameHelper gh = new GameHelper();

		if(choice.equals("edit")) {
			request.setAttribute("gameToEdit", request.getParameter("selTitle"));
			path = "/edit-game.jsp";
		}else if(choice.equals("delete")) {
			try {
			gh.delGame(gh.getGame(request.getParameter("selTitle")).get(0));
			}catch(IndexOutOfBoundsException e) {
				System.out.println("valid game not selected");
				path = "/viewGamesServlet";
			}
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}
