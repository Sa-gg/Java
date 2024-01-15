import java.util.*;

public class SyTravelAndTours {
	static Scanner scan = new Scanner(System.in);
	static Random random = new Random();
	public static void main(String[] args) {
		
		displayLocation();
		System.out.println();
		

		String[][] distances = {
				{"163", "s",},
				{"99.4", "n",},
				{"107", "s",},
				{"39", "s",},
				{"174", "s",},
				{"67", "n",},
				{"137", "s",},
				{"150", "s",},
				{"183", "s",},
				{"23", "n",}
		};
		
		int[] chosenLocation = new int[5];
		for (int i = 0; i < 5; i++) {
			System.out.print("Enter Location " + (i + 1) + ": ");
			int loc = scan.nextInt();
			
			
			
			
			chosenLocation[i] = loc - 1;
			
			
		}
		
		double totalDistance = 0;		
		totalDistance += Double.parseDouble(distances[(chosenLocation[0])][0]);
		
		for (int i = 1; i < chosenLocation.length; i++) {
			
			String previousDirection = distances[(chosenLocation[i-1])][1];
			String currentDirection = distances[(chosenLocation[i])][1];
			
			Double previousDistance = Double.parseDouble(distances[(chosenLocation[i - 1])][0]);
			Double currentDistance = Double.parseDouble(distances[(chosenLocation[i ])][0]);
			
//			CHECK IF SAME DIRECTION
			if (previousDirection == currentDirection) {

//				CHECK IF FORWARD OR BACAKWARDS
				if (previousDistance < currentDistance) {
					totalDistance += (currentDistance - previousDistance);
				} else {
					totalDistance += (previousDistance - currentDistance);
				}
				
			} else {
				totalDistance += (previousDistance + currentDistance);	
			}
			
		}
		
		totalDistance += Double.parseDouble(distances[(chosenLocation[4])][0]);
		
		String[] vehicles = { "Toyota Hi Ace", "Mitsubishi L300", "Suzuki APV", "Foton Transvan", "Nissan Vanette",
	             "Mazda MPV", "Hyundai H-1" };
	    double[] fuelCapacities = { 70, 47, 46, 65, 55, 70, 65 };
	    double[] fuelConsumptions = { 8.0, 9.0, 8.9, 10.0, 8.5, 8.6, 7.6 };
	    double[] rentalFees = { 3000.0, 3600.0, 4000.0, 4400.0, 3000.0, 3600.0, 3200.0 };
		
		displayVehicle();
		System.out.println();
		System.out.print("Pick A Vehicle: ");
		int chosenVehicle = scan.nextInt(); 
		
		System.out.print(" [1] - Yes\n [2] - No\nHire A Driver?: ");
		int hireDriver = scan.nextInt();
		double driverFee = 0;		
		if (hireDriver == 1) {driverFee = 2000;}
		
		System.out.print("Days of Travel: ");
		int days = scan.nextInt();
		
		System.out.print("Fuel Price Per Liter: ");
 		double fuelPrice = scan.nextDouble(); 
 		
 		double deposit = 15000;
 		
 		double totalFuelConsumption = (fuelConsumptions[chosenVehicle - 1] / 100) * totalDistance;
 		double totalFuelCost = totalFuelConsumption * fuelPrice;
 		double totalRentalCost = rentalFees[chosenVehicle - 1] * days;
 		double insuranceCost =  totalRentalCost * .13;
 		double studentsAllowance = 300 * 10 * days;
 		
 		double totalExpenses = deposit + (driverFee * days) + totalFuelCost + totalRentalCost + insuranceCost;
 		double contribution = (totalExpenses - studentsAllowance) / 10;
 		double remAmount = totalExpenses - deposit - studentsAllowance;
 		
 		System.out.println();
		System.out.println("Total Distance Travelled: " + totalDistance + "km");
		System.out.println("Total Fuel Consumption: " + totalFuelConsumption);
		System.out.println("Total Fuel Cost: " + totalFuelCost);
		System.out.println("Total Rental Cost: " + totalRentalCost);
		System.out.println("Insurance Cost: " + insuranceCost);
		System.out.println("Contribution of Each Student: " + contribution);
		System.out.println("Total Expenses: " + totalExpenses);
		System.out.println("Remaining Amount to Pay (Group): " + remAmount);
		
		
				
	}
	
	private static void displayLocation() {
		System.out.println("Locations");
		System.out.println("1. Juliens Wreck, Sipalay City – 163 km");
		System.out.println("2. Suyak Island, Sagay City – 99.4 km");
		System.out.println("3. Mag aso Falls, Kabankalan City – 107km");
		System.out.println("4. Buenos Aires Mountain Resort, Bago City-39km");
		System.out.println("5. Manjuyod White Sandbar, Bais City – 174km");
		System.out.println("6. Lakawon Island, Cadiz City – 67km");
		System.out.println("7. Kennington Hill Nature Park, Municipality of Candoni – 137km");
		System.out.println("8. Danjugan Island Marine Reserve and Sanctuaries, Cauayan City – 150km");
		System.out.println("9. Nabulao Beach and Dive Resort, Sitio Totong, Brgy. Talacagay, Hinoba-an 183km");
		System.out.println("10. Campuestuhan Highland Resort, Talisay City - 23km.");
	}
	
	private static void displayVehicle() {
		System.out.println("________________________________________________________________________");
		System.out.println("     Vehicle         Fuel Capacity      Fuel Consumption      Rental Fee");
		System.out.println("________________________________________________________________________");
		System.out.println("1. Toyota Hi Ace        70L             8.0L/100km           P3,000.00 ");
		System.out.println("2. Mitsubishi L300      47L             9.0L/100km           P3,600.00 ");
		System.out.println("3. Suzuki APV           46L             8.9L/100km           P4,000.00 ");
		System.out.println("4. Foton Transvan       65L              10L/100km           P4,400.00 ");
		System.out.println("5. Nissan Vanette       55L             8.5L/100km           P3,000.00 ");
		System.out.println("6. Mazda MPV            70L             8.6L/100km           P3,600.00 ");
		System.out.println("7. Hyundai H-1          65L             7.6L/100km           P3,200.00 ");
		System.out.println("________________________________________________________________________");
	}
}



