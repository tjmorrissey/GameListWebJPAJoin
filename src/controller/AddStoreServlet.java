package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StoreDetails;

/**
 * Servlet implementation class AddStoreServlet
 */
@WebServlet("/addStoreServlet")
public class AddStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String storeName = request.getParameter("storeName");
		String address = request.getParameter("address");
		
		StoreDetails sd = new StoreDetails(storeName, address);
		StoreHelper store = new StoreHelper();
		
		store.insertStore(sd);
		
		getServletContext().getRequestDispatcher("/add-store.html").forward(request, response);
	}

}
