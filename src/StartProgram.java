//Thomas Morrissey, Feb 5, tjmorrissey1@dmacc.edu

import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addAnItem() {
			
			System.out.println("\nEnter Game Information:");
			System.out.print("Name: ");
			String name = in.nextLine();
			System.out.print("Rating out of 10: ");
			int rating = in.nextInt();
			System.out.print("Price: $");
			double price = in.nextDouble();

			ListItem toAdd = new ListItem(name, rating, price);
			
			lih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("\nEnter the Game to delete: ");
			String name = in.nextLine();
			
			ListItem toDelete = new ListItem(name);
			lih.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
				System.out.print("\nEnter the name of the Game to Edit: ");
				String gameName = in.nextLine();
				
				List<ListItem> foundItems;
				
				foundItems = lih.searchForItemByName(gameName);

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + ": " + l.returnGameDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getName() + " with rating of " + toEdit.getRating() + " for $" + toEdit.getPrice());
				System.out.println("1 : Update Rating");
				System.out.println("2 : Update Price");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Rating(Out of 10): ");
					int newRating = in.nextInt();
					toEdit.setRating(newRating);
				} else if (update == 2) {
					System.out.print("New Price: $");
					double newPrice = in.nextDouble();
					toEdit.setPrice(newPrice);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the Game List! ---");
			while (goAgain) {
				System.out.println("\n\n*  Select a number:");
				System.out.println("*  1 -- Add a Game");
				System.out.println("*  2 -- Edit a Game");
				System.out.println("*  3 -- Delete a Game");
				System.out.println("*  4 -- View the list of Games");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Exiting Program, Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<ListItem> allItems = lih.showAllItems();
			
			System.out.println("\n");
			
			for(ListItem singleItem : allItems){
				System.out.println(singleItem.returnGameDetails());
			}
			

		}

	}