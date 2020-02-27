package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StoreDetails;

/**
 * Servlet implementation class NavigationStoreServlet
 */
@WebServlet("/navigationStoreServlet")
public class NavigationStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationStoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StoreHelper store = new StoreHelper();
		String act = request.getParameter("doThisToStore");
		
		//Where to redirect to, will only change if wanting to add
		String path = "/viewAllStoreServlet";
		
		if(act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("storeId"));
				StoreDetails storeToDelete = store.searchForStoreById(tempId);
				store.deleteStore(storeToDelete);
			}
			catch (NumberFormatException e) {
				System.out.println("Forgot to select a store");
			}
		}
		else if(act.equals("Edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("storeId"));
				StoreDetails storeToEdit = store.searchForStoreById(tempId);
				request.setAttribute("storeToEdit", storeToEdit);
				path = "/edit-store.jsp";
			}
			catch (NumberFormatException e){
				System.out.println("Forgot to select a store");
			}
		}
		else if(act.equals("Add")) {
			path = "/add-store.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
