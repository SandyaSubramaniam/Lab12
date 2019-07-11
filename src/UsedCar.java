public class UsedCar extends Car {

	private double mileage;

	public UsedCar(String make, String model, int year, double price, double mileage) {

		super(make, model, year, price);
		this.mileage = mileage;
	}

	public double getMileage() {

		return mileage;
	}

	@Override
	public String toString() {

		return super.toString() + String.format("(Used) %s miles", getMileage());
	}
}
