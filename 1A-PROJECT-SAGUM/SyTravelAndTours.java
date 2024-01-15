import java.util.*;

public class SyTravelAndTours {
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		String[][] locations = {
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
		int[] chosenLocations = new int[5];
		
		displayLocation();
		System.out.println();
		
		for (int i = 0; i < chosenLocations.length; i ++) {
			
			boolean duplicate;
			int loc;
			
			do {
				duplicate = false;
				System.out.print("Enter Location " + (i + 1) + ": ");
				loc = scan.nextInt();
				
				while (loc <= 0 || loc > locations.length) {
					System.err.println("Please choose a number between 1 and " + locations.length);
					System.out.print("Enter Location " + (i + 1) + ": ");
					loc = scan.nextInt();
				}
				
				for (int j = 0; j < chosenLocations.length; j++) {		
					if (chosenLocations[j] != 0 && chosenLocations[j] == loc) {
						System.err.println("This location has already been selected. Please choose a different one.");
						duplicate = true;
						break;
					}	
					
					
				}
				
			} while (duplicate);
			
			chosenLocations[i] = loc;		
		}
		
		for (int i = 0; i < chosenLocations.length; i++) { 
			chosenLocations[i] = (chosenLocations[i] - 1); 
		}
	
		double totalDistance = 0;	
		
		totalDistance += Double.parseDouble(locations[(chosenLocations[0])][0]);
		for (int i = 1; i < chosenLocations.length; i++) {
			String previousDirection = locations[(chosenLocations[i-1])][1];
			String currentDirection = locations[(chosenLocations[i])][1];			
			Double previousDistance = Double.parseDouble(locations[(chosenLocations[i - 1])][0]);
			Double currentDistance = Double.parseDouble(locations[(chosenLocations[i])][0]);

			if (previousDirection == currentDirection) {
				
				if (previousDistance < currentDistance) {
					totalDistance += (currentDistance - previousDistance);
				} else {
					totalDistance += (previousDistance - currentDistance);
				}
				
			} else {
				totalDistance += (previousDistance + currentDistance);	
			}
			
		}
		totalDistance += Double.parseDouble(locations[(chosenLocations[4])][0]);
		
		String[] vehicles = { "Toyota Hi Ace", "Mitsubishi L300", "Suzuki APV", "Foton Transvan", "Nissan Vanette",
	             "Mazda MPV", "Hyundai H-1" };
	    double[] fuelConsumptions = { 8.0, 9.0, 8.9, 10.0, 8.5, 8.6, 7.6 };
	    double[] rentalFees = { 3000.0, 3600.0, 4000.0, 4400.0, 3000.0, 3600.0, 3200.0 };
		
		displayVehicle();
		System.out.println();

		int chosenVehicle, hireDriver;
		
		System.out.print("Pick A Vehicle: ");
		chosenVehicle = scan.nextInt(); 
		
		while (chosenVehicle < 1 || chosenVehicle > vehicles.length) {
			System.err.println("Please pick a number between 1 and " + vehicles.length);
			System.out.print("Pick A Vehicle: ");
			chosenVehicle = scan.nextInt(); 
		}
		
		System.out.print(" [1] - Yes\n [2] - No\nHire A Driver?: ");
		hireDriver = scan.nextInt();
		
		while (hireDriver != 1 && hireDriver != 2) {
			System.err.println("Please choose a number between 1 and 2");
			System.out.print(" [1] - Yes\n [2] - No\nHire A Driver?: ");
			hireDriver = scan.nextInt();
		}
			
		System.out.print("Days of Travel: ");
		int days = scan.nextInt();
		
		while (days < 1) {
			System.err.println("Invalid Entry, Minimum Days of travel must be one. Please try again");
			System.out.print("Days of Travel: ");
			days = scan.nextInt();
		}
		
		System.out.print("Fuel Price Per Liter: ");
 		double fuelPrice = scan.nextDouble(); 
 		
 		scan.close();
 		
 		double driverFee = hireDriver == 1 ? 2000 : 0;	
 		double deposit = 15000;
 		
 		double totalFuelConsumption = (fuelConsumptions[chosenVehicle - 1] / 100) * totalDistance;
 		double totalFuelCost = totalFuelConsumption * fuelPrice;
 		double totalRentalCost = rentalFees[chosenVehicle - 1] * days;
 		double insuranceCost =  totalRentalCost * .13;
 		double studentsAllowance = 300 * 10 * days;
 		
 		double totalExpenses = (driverFee * days) + totalFuelCost + totalRentalCost + insuranceCost;
 		double contribution = (totalExpenses - studentsAllowance) / 10;
 		double remAmount = totalExpenses - deposit - studentsAllowance;
 		
 		System.out.println();
		System.out.printf("Total Distance Travelled: %,.2fkm%n", totalDistance);
		System.out.printf("Total Fuel Consumption: %,.2fL%n", totalFuelConsumption);
		System.out.printf("Total Fuel Cost: Php %,.2f%n", totalFuelCost);
		System.out.printf("Total Rental Cost: Php %,.2f%n", totalRentalCost);
		System.out.printf("Insurance Cost: Php %,.2f%n", insuranceCost);
		System.out.printf("Students Allowance: Php %,.2f%n", studentsAllowance);
		System.out.printf("Contribution of Each Student: Php %,.2f%n", contribution);
		System.out.printf("Total Expenses: Php %,.2f%n", totalExpenses);
		
		if (remAmount > 0) {
			System.out.printf("Remaining Amount to Pay: Php %,.2f", remAmount);
		} else {
			System.out.printf("Remaining Amount to Refund: Php %,.2f", (remAmount * -1));
		}
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
		System.out.println("     Vehicle         Fuel Capacity      Fuel Consumption     Rental Fee ");
		System.out.println("________________________________________________________________________");
		System.out.println("1. Toyota Hi Ace        70L             8.0L/100km           P3,000.00  ");
		System.out.println("2. Mitsubishi L300      47L             9.0L/100km           P3,600.00  ");
		System.out.println("3. Suzuki APV           46L             8.9L/100km           P4,000.00  ");
		System.out.println("4. Foton Transvan       65L              10L/100km           P4,400.00  ");
		System.out.println("5. Nissan Vanette       55L             8.5L/100km           P3,000.00  ");
		System.out.println("6. Mazda MPV            70L             8.6L/100km           P3,600.00  ");
		System.out.println("7. Hyundai H-1          65L             7.6L/100km           P3,200.00  ");
		System.out.println("________________________________________________________________________");
	}
}

/*
LEADER: SAGUM, PATRICK
MEMBERS: 
        AGRIAM, REBEJOE
        GAYUMA, JEREMIAH
        GENOLOS, JHAMELA NICOLE
        GUANZON, JURRIEL
*/


