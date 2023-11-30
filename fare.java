import java.util.Scanner;

public class fare {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter Vehicle Type [1] - Taxi, [2] - Jeepney: ");
		int vehicle = scan.nextInt(); 
		System.out.print("Enter Total Number of Passengers: ");
		int passengers = scan.nextInt();
		System.out.print("Enter Number of Regular Passengers: ");
		int regPassengers = scan.nextInt();
		System.out.print("Enter Number of Special Passengers (Students | Senior | PWD): ");
		int specPassengers = scan.nextInt();
		System.out.print("Enter Distance in (km): ");
		int distance = scan.nextInt();
		scan.close();
		System.out.println("Total Fare: " + fare(vehicle, passengers, regPassengers, specPassengers, distance));
		
	}
	
	public static double fare(int vehicle, int totalPassengers, int regular, int special, int distance) {
		double fare = 0;
		if (vehicle == 1) {
			fare = totalPassengers * 60;
			fare += distance > 4 ? (distance - 4) * 20 * totalPassengers : 0;
		} else if (vehicle == 2 ) {
			fare = (regular * 11) + (special * 10);
			fare += distance > 4 ? ((distance - 4) * 1.15 * regular) + ((distance - 4) * 0.92 * special): 0;
		}
		return fare;
	}

}
