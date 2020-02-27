package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;
import model.StoreDetails;

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
		
		int storeId = Integer.parseInt(request.getParameter("stores"));
		
		//convert inputs to integer, and double
		int rating = Integer.parseInt(ratingSting);
		double price = Double.parseDouble(priceString);
		
		
		ListItem li = new ListItem(name, rating, price);
		
		StoreHelper sh = new StoreHelper();
		StoreDetails sd = new StoreDetails();
		
		sd = sh.searchForStoreById(storeId);
		
		li.setStore(sd);
		
		ListItemHelper game = new ListItemHelper();
		
		game.insertItem(li);
		
		getServletContext().getRequestDispatcher("/addStoreToGameServlet").forward(request, response);
		
	}

}
