import java.util.List;
import java.util.Scanner;

import controller.GameHelper;
import model.GameObj;


/**
 * @author Chase Van Blair - crvanblair
 * CIS175 - Fall 2021
 * Feb 2, 2022
 */

public class Main {
	static Scanner in = new Scanner(System.in);
	static GameHelper gh = new GameHelper();
	
	private static void addGame() {
		System.out.print("Enter a title: ");
		String title = in.nextLine();
		System.out.print("Enter a price: ");
		double price = Double.parseDouble(in.nextLine());
		System.out.print("Enter a rating %: ");
		int rating = Integer.parseInt(in.nextLine());
		GameObj toAdd = new GameObj(title, price, rating);
		gh.addGame(toAdd);
	}
	
	private static void editGame() {
		System.out.print("Enter a title: ");
		String title = in.nextLine();
		
		List<GameObj> tempList = gh.getGame(title);
		GameObj tempGame = tempList.get(0);

		if(!tempList.isEmpty()) {
			System.out.println("Found game: " + tempGame.toString());
			System.out.print("Select to edit title(1), price(2), rating(3): ");
			String choice = in.nextLine();
			//change title
			if(choice.equals("1")) {
				System.out.print("Enter new title: ");
				tempGame.setTitle(in.nextLine());
			}else if(choice.equals("2")) {
				//change price
				System.out.print("Enter new price: ");
				tempGame.setPrice(in.nextDouble());
			}else if(choice.equals("3")) {
				//change rating
				System.out.print("Enter new rating (do not include \"%\" symbol): ");
				tempGame.setRatingPercent(in.nextInt());
			}
		}
		else {
			//default if empty list
			System.out.print("No game with title: " + title);
		}
		gh.editGame(tempGame);
	
	}
	
	private static void deleteGame() {
		System.out.print("Enter a title: ");
		String title = in.nextLine();
		
		List<GameObj> tempList = gh.getGame(title);
		if(!tempList.isEmpty()) {
			gh.delGame(tempList.get(0));
			System.out.println("Game deleted.");
		}
		else
			System.out.println("No game with found with title: " + title);
	}
	
	private static void viewGames() {
		for(GameObj g : gh.getAllGames())
			System.out.println(g.toString() + "\n");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean cont = true;
		System.out.println("You are now viewing our game selection.");
		while (cont) {
			System.out.println("--------------");
			System.out.println("1: View game catalog.");
			System.out.println("2: Add to game catalog.");
			System.out.println("3: Delete from game catalog.");
			System.out.println("4: Edit an entry in the game catalog.");
			System.out.println("5: Quit viewing catalog.");
			System.out.print("Select which option to execute: ");
			
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				viewGames();
			} else if (selection == 2) {
				addGame();
			} else if (selection == 3) {
				deleteGame();
			} else if (selection == 4) {
				editGame();
			} else {
				gh.cleanup();
				System.out.println("Thanks for viewing, come again.");
				cont = false;
			}

		}

		
	}
}
	
