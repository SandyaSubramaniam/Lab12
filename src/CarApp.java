import java.util.ArrayList;
import java.util.Scanner;

public class CarApp {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		char userChoice = 'y';
		System.out.println("Welcome to the Grand Circus Motors admin console!");
		ArrayList<Car> cars = new ArrayList<>();
		do {
			int numchoice = Validator.getInt(scnr, "How many cars are you entering: ");
			System.out.println(numchoice);
			for (int i = 0; i < numchoice; i++) {
				String make = Validator.getString(scnr, "Enter Car #" + (i + 1) + " Make: ");
				String model = Validator.getString(scnr, "Enter Car #" + (i + 1) + " Model: ");
				int year = Validator.getInt(scnr, "Enter Car #" + (i + 1) + " Year: ");
				double price = Validator.getDouble(scnr, "Enter Car #" + (i + 1) + " Price: ");
				cars.add(new Car(make, model, year, price));
			}
			System.out.println("Current Inventory: ");
			System.out.printf("%-15s %-15s %-15s %-15s\n", "Make", "Model", "Year", "Price");
			System.out.printf("%-15s\n", "==============================================================");
			for (int i = 0; i < cars.size(); i++) {
				System.out.printf("%-15s %-15s %-15s %-15s\n", cars.get(i).getMake(), cars.get(i).getModel(),
						cars.get(i).getYear(), "$" + cars.get(i).getPrice());
			}
			System.out.println("Would you like to continue (y/n)?");
			userChoice = scnr.next().charAt(0);
		} while ((userChoice == 'Y') || (userChoice == 'y'));
		scnr.close();
	}
}
