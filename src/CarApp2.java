import java.util.ArrayList;
import java.util.Scanner;

public class CarApp2 {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		int choice = 0;
		ArrayList<Car> cars = createListOfCars();
		int exitChoice = 0;
		do {
			for (int i = 0; i < cars.size(); i++) {
				System.out.println(i + 1 + ". " + displayCar(cars.get(i)));
			}
			exitChoice = cars.size() + 1;
			System.out.println(exitChoice + ". " + "Quit");
			choice = Validator.getInt(scnr, "Which car would you like to buy?");
			if (choice < cars.size() + 1) {
				buyCar(cars, choice, scnr);
			}
		} while (choice != exitChoice);
		System.out.println("Goodbye!");
		scnr.close();
	}

	private static String displayCar(Car car) {

		String result = String.format("%-15s %-15s %-15s $%-15s", car.getMake(), car.getModel(), car.getYear(),
				car.getPrice());
		if (car instanceof UsedCar) {
			UsedCar usedCar = (UsedCar) car;
			result = result + String.format("(Used) %s miles", usedCar.getMileage());
		}
		return result;
	}

	private static void buyCar(ArrayList<Car> cars, int choice, Scanner scnr) {

		System.out.println(displayCar(cars.get(choice - 1)));
		String strChoice = Validator.getString(scnr, "Would you like to buy to buy this car?");
		if (strChoice.equalsIgnoreCase("Y")) {
			cars.remove(choice - 1);
			System.out.println("Excellent! Out Finance Department will be in touch shortly.");
		}
	}

	private static ArrayList<Car> createListOfCars() {

		ArrayList<Car> cars = new ArrayList<>();
		cars.add(new Car("Ford", "Mustang", 2000, 67890.90));
		cars.add(new Car("GM", "Truck", 2000, 67890.90));
		cars.add(new Car("Chrysler", "300", 2000, 67890.90));
		cars.add(new UsedCar("Honda", "Civic", 2000, 67890.90, 35987.55));
		cars.add(new UsedCar("Toyota", "Civic", 2000, 67890.90, 35987.55));
		cars.add(new UsedCar("Volkswagen", "Civic", 2000, 67890.90, 35987.55));
		return cars;
	}
}
