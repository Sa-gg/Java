import java.util.*;
public class garbageCollector {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Day (1 for MON,WED,FRI), (2 for TUES,THURS), (3 - SAT), (4 - SUN): ");
		int day = scan.nextInt();
		switch (day) {
		case 1: System.out.println("'Only Non-Biodegradable Waste will be Collected'"); break;
		case 2: System.out.println("'Only Biodegradable Waste will be Collected'"); break;
		case 3: System.out.println("'No Garbage Pickup Today'"); return;
		case 4: System.out.println("'All Garbage is Collected'"); break;
		default: System.out.println("'Invalid Number'"); break; 
		}
		
		System.out.print("Enter Number of Households: ");
		int numOfHousehold = scan.nextInt();
		
		int count = 0;
		double weightPerHouse = 0, totalWeight = 0;
		while (numOfHousehold > 0) {
			count++;
			System.out.print("Household #" + count + " Enter Weight of Garbage in Kg: ");
			weightPerHouse = scan.nextDouble();
			totalWeight += weightPerHouse;
			numOfHousehold--;
		}
		double trips = totalWeight / 14000;
		trips += trips > (int) trips ? 1 : 0;
		
		System.out.println("Total Trips: " + (int) trips);
		System.out.println("Total Weight: " + (int) (totalWeight / 1000) + "Tons & " + (totalWeight % 1000) + "Kg");
		
		scan.close();
		

	}

}
