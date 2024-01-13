import java.util.*;

public class SyPlaylist {
	static Scanner scan = new Scanner(System.in);
	static Random random = new Random();
	public static void main(String[] args) {
		
		System.out.print("Enter Playlist Name: ") ;
		String playlistName = scan.next();
		
		System.out.print(" [1] - Random Playlist\n [2] - Customized Playlist\nChoose Type Of Playlist: ");
		int playlistType = scan.nextInt();
		
		while (playlistType != 1 && playlistType != 2) {
			System.err.println("Invalid Input Please Try Again");
			System.out.print(" [1] - Random Playlist\n [2] - Customized Playlist\nChoose Type Of Playlist: ");
			playlistType = scan.nextInt();
		}
		
		System.out.println();
		
		String [][] playlist = {
				{"Blinding Lights", "The Weeknd", "3:20"},
				{"Levitating", "Dua Lipa feat. DaBaby",  "3:23"},
				{"Montero (Call Me By Your Name)", "Lil Nas X",  "2:17"},
				{"Peaches", "Justin Bieber feat. Daniel Caesar, Giveon",  "3:18"},
				{"Stay", "The Kid LAROI, Justin Bieber",  "2:24"},
				{"Good 4 U", "Olivia Rodrigo",  "2:58"},
				{"Save Your Tears", "The Weeknd",  "3:35"},
				{"Butter", "BTS",  "2:45"},
				{"Industry Baby", "Lil Nas X feat. Jack Harlow",  "3:27"},
				{"Deja Vu", "Olivia Rodrigo",  "3:35"},
				{"Kiss Me More", "Doja Cat feat. SZA",  "3:28"},
				{"Permission to Dance", "BTS",  "3:07"},
				{"Mood", "24kGoldn feat. iann dior",  "2:21"},
				{"Bad Habits", "Ed Sheeran",  "3:51"},
				{"Driver's License", "Olivia Rodrigo",  "4:02"},
				{"Fancy Like", "Walker Hayes",  "2:42"},
				{"Astronaut in the Ocean", "Masked Wolf",  "2:13"},
				{"Heartbreak Anniversary", "Giveon",  "3:17"},
				{"You Right", "Doja Cat feat. The Weeknd",  "3:06"},
				{"My Universe", "Coldplay, BTS",  "3:30"},
				{"Essence", "Wizkid feat. Tems",  "4:09"},
				{"Forever After All", "Luke Combs",  "3:53"},
				{"Mood Swings", "Pop Smoke feat. Lil Tjay",  "3:33"},
				{"The Business", "Tiësto",  "2:44"},
				{"Shivers", "Ed Sheeran",  "3:28"},
				{"Heat Waves", "Glass Animals",  "3:58"},
				{"Cold Heart (Pnau Remix)", "Elton John, Dua Lipa",  "3:22"},
				{"Life Goes On", "BTS",  "3:27"},
				{"Arcade", "Duncan Laurence",  "3:04"},
				{"Without You", "The Kid LAROI",  "2:41"},
				{"Beautiful Mistakes", "Maroon 5 feat. Megan Thee Stallion",  "3:47"},
				{"Anyone", "Justin Bieber",  "3:10"},
				{"Vampire", "Olivia Rodrigo",  "4:05"},
				{"Dreams", "Fleetwood Mac",  "4:14"},
				{"Before You Go", "Lewis Capaldi",  "3:35"},
				{"Watermelon Sugar", "Harry Styles",  "2:54"},
				{"Dynamite", "BTS",  "3:19"},
				{"Say So", "Doja Cat",  "3:58"},
				{"Savage Love", "Jawsh 685, Jason Derulo",  "2:51"},
				{"Sour Candy", "Lady Gaga, BLACKPINK",  "2:38"},
				{"WAP", "Cardi B feat. Megan Thee Stallion",  "3:07"},
				{"Holy", "Justin Bieber feat. Chance The Rapper",  "3:32"},
				{"Rockstar", "DaBaby feat. Roddy Ricch",  "3:01"},
				{"Positions", "Ariana Grande",  "2:52"},
				{"Memories", "Maroon 5",  "3:09"},
				{"Sicko Mode", "Travis Scott",  "5:12"},
				{"Sucker", "Jonas Brothers",  "3:01"},
				{"Used to Be Young", "Miley Cyrus",  "3:22"},
				{"Rush", "Troye Sivan",  "3:43"},
				{"Flowers", "Miley Cyrus",  "3:22"}
		};
		
		String[][] numPlaylist = new String[playlist.length][playlist[0].length];
		for (int i = 0; i < playlist.length; i++) {
			numPlaylist[i][0] = String.valueOf((i + 1)) + ". " + playlist[i][0];
			numPlaylist[i][1] = playlist[i][1];
			numPlaylist[i][2] = playlist[i][2];
		
		}; 
		
		
		if (playlistType == 1) {
			
			System.out.print("Enter Number of Track to be Generated: ");
			int numOfTrack = scan.nextInt();
			
			while (numOfTrack < 0) {
				System.err.println("Invalid Input Please Try Again");
				System.out.print("Enter Number of Track to be Generated: ");
				numOfTrack = scan.nextInt();
			}
			
			while (numOfTrack > playlist.length) {
				System.err.println("Maximum Playlist Size Exceeded, Please Try Again");
				System.out.print("Enter Number of Track to be Generated: ");
				numOfTrack = scan.nextInt();
			}
			
			int[] uniqueRandomNumbers = generateUniqueRandomNumbers(numOfTrack, playlist.length);
			
			String[][] randomPlaylist = new String[numOfTrack][3];
			
			for (int i = 0; i < numOfTrack; i++) {	
				randomPlaylist[i][0] = String.valueOf((i + 1)) + ". " + playlist[uniqueRandomNumbers[i]][0];
				randomPlaylist[i][1] = playlist[uniqueRandomNumbers[i]][1];
				randomPlaylist[i][2] = playlist[uniqueRandomNumbers[i]][2];
			}
			
			System.out.println("\nPlaylist Name: " + playlistName);
			displayPlaylist(randomPlaylist);
				
			int minutes = 0;
			int seconds = 0;
			
			for (int i = 0; i < numOfTrack; i++) {
				String[] timeParts = randomPlaylist[i][2].split(":");
				minutes += Integer.parseInt(timeParts[0]);
				seconds += Integer.parseInt(timeParts[1]);	
			}
			
			int addMin = seconds / 60;
			seconds = seconds % 60;
			
			System.out.println("Total Duration (Minutes): "+(minutes + addMin) + ":" + seconds);
			
		} else if (playlistType == 2) {
			displayPlaylist(numPlaylist);
			System.out.println();
			
			
			String[][] storeCustomPlaylist = new String[playlist.length][3];
			
			int songCount = 0;
			
			for (int i = 0; i < playlist.length; i++) {		
				System.out.print("Please Enter the Desired Song Number to Add [Enter 0 to Finish]: ");
				int songNumber = scan.nextInt();
				
				while (songNumber < 0) {
					System.err.println("Invalid Input Please Try Again");
					System.out.print("Please Enter the Desired Song Number to Add [Enter 0 to Finish]: ");
					songNumber = scan.nextInt();
				}
				
				while (songNumber > playlist.length) {
					System.err.println("Maximum Playlist Count is 50. Please Try Again");
					System.out.print("Please Enter the Desired Song Number to Add [Enter 0 to Finish]: ");
					songNumber = scan.nextInt();
				}
				
				if (songNumber == 0) {break;}
				
				storeCustomPlaylist[i][0] = String.valueOf((i + 1)) + ". " + playlist[songNumber - 1][0];
				storeCustomPlaylist[i][1] = playlist[songNumber - 1][1];
				storeCustomPlaylist[i][2] = playlist[songNumber - 1][2];
				
				songCount++;
			}
			
			String[][] customPlaylist = new String[songCount][3];	
			for (int i = 0; i < songCount; i++) {
				customPlaylist[i][0] = storeCustomPlaylist[i][0];
				customPlaylist[i][1] = storeCustomPlaylist[i][1];
				customPlaylist[i][2] = storeCustomPlaylist[i][2];
			}
			
			System.out.println("\nPlaylist Name: " + playlistName);
			displayPlaylist(customPlaylist);
			
			int minutes = 0;
			int seconds = 0;
			
			for (int i = 0; i < customPlaylist.length; i++) {
				String[] timeParts = customPlaylist[i][2].split(":");
				minutes += Integer.parseInt(timeParts[0]);
				seconds += Integer.parseInt(timeParts[1]);	
			}
			
			int addMin = seconds / 60;
			seconds = seconds % 60;
			
			System.out.println("Total Duration (Minutes): " + (minutes + addMin) + ":" + seconds);
			
		} 
		

	}
	
	private static void displayPlaylist(String[][] playlist) {
		System.out.println(String.format("| %-33s | %-43s |   %10s    |", "Song Title", "Artist(s)", "Duration"));
		for (int i = 0; i < playlist.length; i++) {
			formatPlaylist(playlist[i][0], playlist[i][1], playlist[i][2]);
		}
	} 
	
	
	private static void formatPlaylist(String title, String artist, String duration) {
		String formattedCombo = String.format("| %-33s | %-43s | %10s      |", title, artist, duration);
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println(formattedCombo);
	}
	
	private static int[] generateUniqueRandomNumbers(int count, int length) {
		if (count > (length + 1)) {
            throw new IllegalArgumentException("Cannot generate more unique numbers than the range allows.");
        }
		
		int[] uniqueRandomNumbers = new int[count];
		
		for (int i = 0; i < count; i++) {
	
			int uniqueNumber;
			boolean isUnique;
			
			do {
				uniqueNumber = random.nextInt(length);
				isUnique = true;
				for (int j = 0; j < i; j++) {
					
					if (uniqueRandomNumbers[j] == uniqueNumber) {
						isUnique = false;
						break;
					}
				}
				
			} while (!isUnique);
			
			uniqueRandomNumbers[i] = uniqueNumber;
		
		}
		
		return uniqueRandomNumbers;
		
	}
}
