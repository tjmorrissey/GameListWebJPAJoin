package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListItemHelper game = new ListItemHelper();
		
		String name = request.getParameter("name");
		String ratingString = request.getParameter("rating");
		String priceString = request.getParameter("price");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListItem itemToUpdate = game.searchForItemById(tempId);
		itemToUpdate.setName(name);
		
		
		try {
			int rating = Integer.parseInt(ratingString);
			itemToUpdate.setRating(rating);
			
			double price = Double.parseDouble(priceString);
			itemToUpdate.setPrice(price);
		}
		catch (NumberFormatException e) {
			System.out.println("Rating must be an Integer.\nPrice must be a Double.");
		}
		
		game.updateItem(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

}
