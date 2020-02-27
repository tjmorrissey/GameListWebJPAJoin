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
 * Servlet implementation class EditStoreServlet
 */
@WebServlet("/editStoreServlet")
public class EditStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StoreHelper store = new StoreHelper();
		
		String name = request.getParameter("storeName");
		String address = request.getParameter("address");
		
		Integer tempId = Integer.parseInt(request.getParameter("storeId"));
		
		StoreDetails storeToUpdate = store.searchForStoreById(tempId);
		
		storeToUpdate.setStoreName(name);
		
		storeToUpdate.setAddress(address);

		
		store.updateStore(storeToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllStoreServlet").forward(request, response);
	}

}
