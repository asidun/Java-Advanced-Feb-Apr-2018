package lesson12;

public class CarId {
	int carId;

	CarId(int n) {
		carId = n;
	}

	public int hashCode() {
		return carId;
	}

	public boolean equals(Object o) {
		return (o instanceof CarId) && (carId == ((CarId) o).carId);
	}

}
