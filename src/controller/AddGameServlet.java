package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class AddGameServlet
 */
@WebServlet("/addGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String ratingSting = request.getParameter("rating");
		String priceString = request.getParameter("price");
		
		//convert inputs to integer, and double
		int rating = Integer.parseInt(ratingSting);
		double price = Double.parseDouble(priceString);
		
		
		ListItem li = new ListItem(name, rating, price);
		ListItemHelper game = new ListItemHelper();
		
		game.insertItem(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
