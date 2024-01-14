import java.util.*;

public class SyPlaylist {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		
		System.out.print("Enter Playlist Name: ") ;
		String playlistName = scan.next();
		
		System.out.print(" [1] - Random Playlist\n [2] - Customized Playlist\nChoose Type Of Playlist: ");
		int playlistType = scan.nextInt();
		
		while (playlistType != 1 && playlistType != 2) {
			System.err.println("Invalid Input Please Try Again");
			System.out.print(" [1] - Random Playlist\n [2] - Customized Playlist\nChoose Type Of Playlist: ");
			playlistType = scan.nextInt();
		}
		
		String [][] tracks = {
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
		
		
		if (playlistType == 1) {

			System.out.print("Enter Number of Track to be Generated: ");
			int numOfTrack = scan.nextInt();
			
			while (numOfTrack < 0) {
				System.err.println("Invalid Input Please Try Again");
				System.out.print("Enter Number of Track to be Generated: ");
				numOfTrack = scan.nextInt();
			}
			
			while (numOfTrack > tracks.length) {
				System.err.println("Maximum Track Size Exceeded, Please Try Again");
				System.out.print("Enter Number of Track to be Generated: ");
				numOfTrack = scan.nextInt();
			}
			
			int[] uniqueRandomNumbers = generateUniqueRandomNumbers(numOfTrack, tracks.length);
			String[][] randomPlaylist = new String[numOfTrack][3];
			
			for (int i = 0; i < numOfTrack; i++) {	
				randomPlaylist[i][0] = tracks[uniqueRandomNumbers[i]][0];
				randomPlaylist[i][1] = tracks[uniqueRandomNumbers[i]][1];
				randomPlaylist[i][2] = tracks[uniqueRandomNumbers[i]][2];
			}
			
			System.out.println("\nPlaylist Name: " + playlistName);
			displaySongs(randomPlaylist);
			System.out.println("Total Duration (Minutes): " + totalDuration(randomPlaylist));
			
			
		} else if (playlistType == 2) {
			System.out.println("\nAvailable Tracks");
			displaySongs(tracks);
			System.out.println();
			
			String[][] storeCustomPlaylist = new String[tracks.length][3];
			
			int songCount = 0;
			
			for (int i = 0; i < storeCustomPlaylist.length; i++) {		
				
				int songNumber;
				boolean duplicate;				
				
				do {				
					duplicate = false;
					System.out.print("Please Enter the Desired Song Number to Add [Enter 0 to Finish]: ");
					songNumber = scan.nextInt();
					
					while (songNumber < 0) {
						System.err.println("Invalid Input Please Try Again");
						System.out.print("Please Enter the Desired Song Number to Add [Enter 0 to Finish]: ");
						songNumber = scan.nextInt();
					}
					
					while (songNumber > tracks.length) {
						System.err.println("Maximum Playlist Count is 50. Please Try Again");
						System.out.print("Please Enter the Desired Song Number to Add [Enter 0 to Finish]: ");
						songNumber = scan.nextInt();
					}
					
					if (songNumber == 0) {break;}

					for (int j = 0; j < storeCustomPlaylist.length; j++) {
					    if (storeCustomPlaylist[j][0] != null && storeCustomPlaylist[j][0].equals(tracks[songNumber - 1][0])) {
					        duplicate = true;
					        System.err.println("This Song is Already Added in the Playlist. Please Enter Another Song");
					        break;
					    }
					}

				} while (duplicate == true);
							
							
				if (songNumber == 0) {break;}
				
				storeCustomPlaylist[i][0] = tracks[songNumber - 1][0];
				storeCustomPlaylist[i][1] = tracks[songNumber - 1][1];
				storeCustomPlaylist[i][2] = tracks[songNumber - 1][2];
				
				songCount++;
			}
			
			String[][] customPlaylist = new String[songCount][3];	
			
			for (int i = 0; i < songCount; i++) {
				customPlaylist[i][0] = storeCustomPlaylist[i][0];
				customPlaylist[i][1] = storeCustomPlaylist[i][1];
				customPlaylist[i][2] = storeCustomPlaylist[i][2];
			}
			
			System.out.println();
			System.out.println("Playlist Name: " + playlistName);
			displaySongs(customPlaylist);
			System.out.println("Total Duration (Minutes): " + totalDuration(customPlaylist));	
		}
		
		
		
		
		
		scan.close();

	}
	
	private static void displaySongs(String[][] tracks) {
		for (int i = 0; i < tracks.length; i++) {
			System.out.println(String.valueOf(i + 1) + ". " + tracks[i][0] + " - " + tracks[i][1] + " - (" + tracks[i][2] + ")"  );
		}
	}
	
	private static int[] generateUniqueRandomNumbers(int count, int length) {
		Random random = new Random();
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
	
	private static String totalDuration(String[][] playlist) {
		int minutes = 0;
		int seconds = 0;
		
		for (int i = 0; i < playlist.length; i++) {
			String[] timeParts = playlist[i][2].split(":");
			minutes += Integer.parseInt(timeParts[0]);
			seconds += Integer.parseInt(timeParts[1]);	
		}
		
		int addMin = seconds / 60;
		seconds = seconds % 60;
		minutes += addMin;
		
		String totalDuration = "" + minutes + ":" + seconds;
		
		return totalDuration;
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

