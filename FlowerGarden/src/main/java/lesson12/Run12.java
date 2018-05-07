package lesson12;

import java.util.HashMap;

public class Run12 {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put(new CarId(1), new CarModel("lada"));
		hm.put(new CarId(2), new CarModel("mazda"));
		hm.put(new CarId(3), new CarModel("volvo"));
		hm.put(new CarId(4), new CarModel("wv"));

		System.out.println("hm = " + hm + "\n");
		CarId newCar = new CarId(3);

		if (hm.containsKey(newCar))
			System.out.println((CarModel) hm.get(newCar));
		else {
			System.out.println("Key not found: " + newCar);
		}

	}

}
