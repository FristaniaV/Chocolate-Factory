package chocolatefactory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ChocolateFactory {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<String> nameList = new ArrayList<>();
	ArrayList<String> typeList = new ArrayList<>();
	ArrayList<Integer> priceList = new ArrayList<>();
	ArrayList<String> IDList = new ArrayList<>();
	String name;
	String type;
	Integer price;
	String ID;

	public ChocolateFactory() {
		menu();
		System.out.println("| ");
	}

	public void menu() {
		int choose = 0;

		do {
			System.out.println("Chocolate Factory");
			System.out.println("============");
			System.out.println("1. Create Chocolate");
			System.out.println("2. View Chocolate");
			System.out.println("3. Exit");
			System.out.print(">> ");
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				choose = 0;
			}
			scan.nextLine();
			if (choose == 1) {
				create();
			} else if (choose == 2) {
				view();
			} else if (choose == 3) {
				System.exit(0);
			}
		} while (choose > 3 || choose < 1);
	}

	public void create() {
		String ID = "";
		do {
			System.out.print("Input Chocolate Name [ Lenght must be > 1 Characters] :");
			name = scan.nextLine();

		} while (name.length() < 3);
		nameList.add(name);

		do {
			System.out.print("Input Chocolate Type [ Original | Vanilla | Strawberry | Coffee ]: ");
			type = scan.nextLine();
		} while (!(type.equals("Original")) && !(type.equals("Vanilla")) && !(type.equals("Strawberry"))
				&& !(type.equals("Coffee")));
		typeList.add(type);
		do {
			System.out.print("Input Chocolate Price [Must be between 5000 and 50000]: ");
			price = scan.nextInt();
			scan.nextLine();
		} while (price < 5000 || price > 50000);
		priceList.add(price);

		int randomNumber = rand.nextInt(10);
		int randomNumber2 = rand.nextInt(10);

		ID += "Chocolate";
		ID += (randomNumber + "");
		ID += (randomNumber2 + "");

		System.out.println("Chocolate added!");
		IDList.add(ID);
		System.out.println("Press Enter to Continue...");
		scan.nextLine();
		menu();

	}

	public void view() {
		int choose = 0;

		do {

			System.out.println("1. Update Chocolate");
			System.out.println("2. Delete Chocolate");
			System.out.println("3. Go Back to Main Menu");
			System.out.print(">> ");
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				choose = 0;
			}
			scan.nextLine();
			if (choose == 1) {
				update();
			} else if (choose == 2) {
				delete();
			} else if (choose == 3) {
				menu();
			}
		} while (choose > 3 || choose < 1);

	}

	private void delete() {
		if (nameList.isEmpty()) {
			System.out.println("Chocolate is empty");
			System.out.println();
			menu();
		} else {
			for (int i = 0; i < nameList.size(); i++) {
				for (int j = 0; j < nameList.size() - 1; j++) {
					if (nameList.get(j).compareTo(nameList.get(j + 1)) > 0) {
						String temp;
						int temporary;

						temp = nameList.get(j);
						nameList.set(j, nameList.get(j + 1));
						nameList.set((j + 1), temp);

						temp = typeList.get(j);
						typeList.set(j, typeList.get(j + 1));
						typeList.set((j + 1), temp);

						temporary = priceList.get(j);
						priceList.set(j, priceList.get(j + 1));
						priceList.set((j + 1), temporary);

						temp = IDList.get(j);
						IDList.set(j, IDList.get(j + 1));
						IDList.set((j + 1), temp);
					}
				}
			}
			for (int i = 0; i < nameList.size(); i++) {
				System.out.println((i + 1) + ". " + IDList.get(i) + " - " + nameList.get(i) + "(" + typeList.get(i)
						+ ") | " + priceList.get(i));
			}

			int delIndex;
			do {
				System.out.println("Choose index to delete [1-" + nameList.size() + "]: ");
				delIndex = scan.nextInt();
				scan.nextLine();
			} while (delIndex < 1 || delIndex > nameList.size());

			nameList.remove(delIndex - 1);
			typeList.remove(delIndex - 1);
			priceList.remove(delIndex - 1);

			System.out.println("Chocolate deleted!");

			menu();
		}
	}

	private void update() {
		if (nameList.isEmpty()) {
			System.out.println("Chocolate is empty");
			System.out.println();
			menu();
		} else {
			for (int i = 0; i < nameList.size(); i++) {
				for (int j = 0; j < nameList.size() - 1; j++) {
					if (nameList.get(j).compareTo(nameList.get(j + 1)) > 0) {
						String temp;
						int temporary;

						temp = nameList.get(j);
						nameList.set(j, nameList.get(j + 1));
						nameList.set((j + 1), temp);

						temp = typeList.get(j);
						typeList.set(j, typeList.get(j + 1));
						typeList.set((j + 1), temp);

						temporary = priceList.get(j);
						priceList.set(j, priceList.get(j + 1));
						priceList.set((j + 1), temporary);

						temp = IDList.get(j);
						IDList.set(j, IDList.get(j + 1));
						IDList.set((j + 1), temp);
					}
				}
			}
			for (int i = 0; i < nameList.size(); i++) {
				System.out.println((i + 1) + ". " + IDList.get(i) + " - " + nameList.get(i) + "(" + typeList.get(i)
						+ ") | " + priceList.get(i));
			}

			int updateIndex;

			do {
				System.out.println("Choose index to update [1-" + nameList.size() + "]: ");
				updateIndex = scan.nextInt();
				scan.nextLine();
			} while (updateIndex < 1 || updateIndex > nameList.size());
			do {
				System.out.print("Input Chocolate Name [ Lenght must be > 1 Characters] :");

				nameList.set((updateIndex - 1), name);
				name = scan.nextLine();

			} while (name.length() < 3);
			nameList.add(name);

			do {
				System.out.print("Input Chocolate Type [ Original | Vanilla | Strawberry | Coffee ]: ");
				typeList.set((updateIndex - 1), type);
				type = scan.nextLine();
			} while (!(type.equals("Original")) && !(type.equals("Vanilla")) && !(type.equals("Strawberry"))
					&& !(type.equals("Coffee")));

			do {
				System.out.print("Input Chocolate Price [Must be between 5000 and 50000]: ");
				priceList.set((updateIndex - 1), price);
				price = scan.nextInt();
				scan.nextLine();
			} while (price < 5000 || price > 50000);

			System.out.println();
			menu();

		}

	}

	public static void main(String[] args) {
		new ChocolateFactory();

	}

}
