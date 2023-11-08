package midtermProject;
import java.util.*;

public class syMysteryBoxes {
	static Scanner scan = new Scanner(System.in);
	static Random random = new Random();
	public static void main(String[] args) {
		
		System.out.println("List of Mystery Boxes: \n 1. Mystery Box A (Php 8,000) \n 2. Mystery Box B (Php 5,000)");
		System.out.print("Enter 1 or 2 to choose the type of mystery boxes: ");
		int mysteryBoxType = scan.nextInt();
		
		if (mysteryBoxType != 1 && mysteryBoxType != 2) {
			System.err.println("Sorry, you have entered an invalid number");
		} else {
			int rdm = random.nextInt(10);
			String prize = "";
			double mysteryBoxPrice = 0;
			double price = 0;
			
			if (mysteryBoxType == 1) {
				mysteryBoxPrice = 8000;
				
				switch (rdm) {
				case 0: prize = "Diamond Necklace"; price = 20000; break;
				case 1: prize = "Watch"; price = 15000; break;
				case 2: prize = "Wine"; price = 8000; break;
				case 3: prize = "Bag"; price = 10000; break;
				case 4: prize = "Shoes"; price = 9000; break;
				case 5: prize = "Ring"; price = 15000; break;
				case 6: prize = "Clothes"; price = 10000; break;
				case 7: prize = "5 Star Hotel Accomodation"; price = 18000; break;
				case 8: prize = "Perfume"; price = 11000; break;
				case 9: prize = "Make Up"; price = 17000; break;
				}
			}  else if (mysteryBoxType == 2) {
				mysteryBoxPrice = 5000;

				switch (rdm) {
				case 0: prize = "Mobile Phone"; price = 10000; break;
				case 1: prize = "Gaming Credits"; price = 9000; break;
				case 2: prize = "Headset"; price = 5000; break;
				case 3: prize = "Speaker"; price = 8000; break;
				case 4: prize = "Keyboard & Mouse Set"; price = 5500; break;
				case 5: prize = "Microphone"; price = 6000; break;
				case 6: prize = "Graphic Tablet"; price = 9000; break;
				case 7: prize = "Monitor"; price = 6000; break;
				case 8: prize = "Gaming Chair"; price = 7000; break;
				case 9: prize = "SSD Hard Disk"; price = 9000;
				}
				
			}	
			System.out.println("You got a " + prize.toUpperCase());
			System.out.println("Profit: Php "+ (price - mysteryBoxPrice)); 
		}
	} 
}

//LEADER: SAGUM, PATRICK
//MEMBERS: 
//	AGRIAM, REBEJOE
//	GAYUMA, JEREMIAH
//	GENOLOS, JHAMELA NICOLE
//	GUANZON, JURRIEL

