import controller.StoreHelper;
import model.StoreDetails;

public class ProgramTester {

	public static void main(String[] args) {


		StoreDetails storeToSee = new StoreDetails("Gamestop", "123 Main Street");
		
		StoreHelper sh = new StoreHelper();
		
		System.out.println(sh.showAllStores().toString());
		
		
	}

}
