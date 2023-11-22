import java.util.Scanner;

public class SyTravelandTours {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter Budget for Food Meal Expenses: Php ");
		double foodMeal = scan.nextDouble();
		
		double total = foodMeal / .1090;
		
		System.out.printf("%nVehicle Expenses: Php %,.2f", (total * 0.4350));
		System.out.printf("%nTotal Monthly Budget: Php %,.2f", (total * 0.8620));
		System.out.printf("%nSalary of Each Employee's: Php %,.2f", (total * 0.2830 / 4.0));
		System.out.printf("%nEmployees clothing expenses: Php %,.2f", (total * 0.0350 * .20));
		
		scan.close();
	}

}
