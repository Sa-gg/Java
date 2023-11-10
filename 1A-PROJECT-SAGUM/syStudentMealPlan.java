package midtermProject;
import java.util.*;

public class syStudentMealPlan {
	static Scanner scan = new Scanner(System.in);
	static Random random = new Random();
			
	public static void main(String[] args) {

		System.out.print("Enter Queue Number: ");
		int qNum = scan.nextInt();
		
		int randomPrize = random.nextInt(3); 
		int randomCashGift = random.nextInt(3);
		
		String prize = ""; 
		double cashGift = 0;
		
		switch (randomPrize) {
		case 0: prize = "50% discounts on all meals"; break;
		case 1: prize = "Buy 1 take 1 on all meals. "; break;
		case 2: switch (randomCashGift) {
			case 0: cashGift = 300; break;
			case 1: cashGift = 500; break;
			case 2: cashGift = 1000; break;
			}
			prize = "20% discounts on all meals + a " + cashGift + " cash gift."; break;
		}
		
		if (qNum <= 100) {
			System.out.print("Congratulations! You won " + prize);
		} else {
			System.out.print("Sorry you are not eligible for the raffle.");
		}
		
//		MENU LIST
		System.out.println("Please Choose Your Order\n");
		System.out.println("============================================================================================================");
		System.out.println(String.format("%56s", "MENU LIST"));
		System.out.println("============================================================================================================");
		System.out.println("Combo Meal Package 1: Classic Burgers and Fries                                                 Php 109.99");
		System.out.println("  *Cheeseburgers, French Fries, Medium Soft Drinks");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Combo Meal Package 2: Chicken Lovers                                                            Php 240.99");
		System.out.println("  *Crispy Chicken Sandwiches, Grilled Chicken Wraps, Chicken Nuggets, Small Vanilla Milkshake");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Combo Meal Package 3: Vegetarian Delight                                                        Php 130.99");
		System.out.println("  *Veggie Burgers, Garden Salads, Sweet Potato Fries, Bottled Waters");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Combo Meal Package 4: Tex-Mex Fiesta                                                            Php 135.99");
		System.out.println("  *Beef Burritos, Chicken Quesadillas, Nachos with Cheese, Medium Soft Drinks (Lemon-Lime Soda)");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Combo Meal Package 5: Breakfast for Lunch                                                       Php 150.99");
		System.out.println("  *Breakfast Biscuits (e.g., sausage, egg, and cheese), Hash Browns, Bottled Orange Juices");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Combo Meal Package 6: Spicy Selection                                                           Php 200.99");
		System.out.println("  *Spicy Chicken Sandwiches, Jalapeño Poppers, Medium Soft Drinks (Cola)");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Combo Meal Package 7: Asian Fusion                                                              Php 189.99");
		System.out.println("  *Teriyaki Chicken Rice Bowls, Vegetable Spring Rolls, Bottled Green Teas");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Combo Meal Package 8: Fish and Chips                                                            Php 170.99");
		System.out.println("  *Fish Sandwiches, Onion Rings, Medium Soft Drinks (Cola)");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Combo Meal Package 9: Wrap It Up                                                                Php 156.99");
		System.out.println("  *Chicken Caesar Wraps, Veggie Wraps, Sweet Potato Fries, Bottled Waters");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("Combo Meal Package 10: Pizza Party                                                              Php 250.99");
		System.out.println("  *Large Pepperoni Pizzas, Large Cheese Pizzas, Garlic Knots, Cans of Soda (various flavors)");
		System.out.println("------------------------------------------------------------------------------------------------------------\n");
		
		System.out.print("Enter Your Order: ");
		int order = scan.nextInt();
		System.out.print("Quantity: ");
		int quantity = scan.nextInt();
		
		if ((order >= 1 && order <= 10) && (quantity >= 1))  {
			
			double total = 0, remainingCashGift = 0;
			switch (order) {
			case 1: total = quantity * 109.99; break;
			case 2: total = quantity * 240.99; break;
			case 3: total = quantity * 130.99; break;
			case 4: total = quantity * 135.99; break;
			case 5: total = quantity * 150.99; break;
			case 6: total = quantity * 200.99; break;
			case 7: total = quantity * 189.99; break;
			case 8: total = quantity * 170.99; break;
			case 9: total = quantity * 156.99; break;
			case 10: total = quantity * 250.99; break;
			}
			
			if (qNum <= 100) {
				switch (randomPrize) {
				case 0: total *= .50; break;
				case 1: quantity *= 2; break;
				case 2: total = (total * .80) - cashGift;
						if (total < 0) {
						remainingCashGift = total * (-1);
						total = 0;
						}		
				}
			}
			
			System.out.println("Number of Meals to be Served: " + quantity);
			System.out.println("Total Amount to Pay: " + "Php " + String.format("%.2f", total));
			if (randomPrize == 2) {
				System.out.println("Total Remaining Cash Gift: Php " + String.format("%.2f", remainingCashGift));
			}
			
		} else {
			System.err.println("Invalid Entry");
		}
		

	}	
}

//LEADER: SAGUM, PATRICK
//MEMBERS: 
// 	AGRIAM, REBEJOE
//	GAYUMA, JEREMIAH
//	GENOLOS, JHAMELA NICOLE
//	GUANZON, JURRIEL

	
	
