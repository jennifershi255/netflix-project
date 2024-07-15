package Netflix;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class netflixMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		//Declaring and Initializing Random Number Generator
		Random rand = new Random();
		
		//Declaring and Initializing User Input
		Scanner scan = new Scanner(System.in);
		
		//Displays opening for netflix
		System.out.println("\r\n"
				+ "███╗   ██╗███████╗████████╗███████╗██╗     ██╗██╗  ██╗\r\n"
				+ "████╗  ██║██╔════╝╚══██╔══╝██╔════╝██║     ██║╚██╗██╔╝\r\n"
				+ "██╔██╗ ██║█████╗     ██║   █████╗  ██║     ██║ ╚███╔╝ \r\n"
				+ "██║╚██╗██║██╔══╝     ██║   ██╔══╝  ██║     ██║ ██╔██╗ \r\n"
				+ "██║ ╚████║███████╗   ██║   ██║     ███████╗██║██╔╝ ██╗\r\n"
				+ "╚═╝  ╚═══╝╚══════╝   ╚═╝   ╚═╝     ╚══════╝╚═╝╚═╝  ╚═╝\r\n");
		
		Movies movies = new Movies(); //Declaring and Initializing Movies Object
		movies.readMovies(); //Calls on the readMovies method in Movies class
		
		TVShows TVshows = new TVShows(); //Declaring and Initializing TVshows Object
		TVshows.readShows(); //Calls on the readShows method in TVShows class
		
		//Creates an array for the movies/TV shows watched
		Media [] mediaHistory = new Media [10];
		
		//Initializing each object in the array
		for (int i = 0 ; i < mediaHistory.length; i ++) {
			
			mediaHistory[i] = new Media();
			
		}
		
		int historyCount = 0; //counter to keep track of the number of movies/TV shows watched
		
		//Declaring and Initializing Objects for the current movie/TV show selected
		Movies currentMovie = new Movies();
		TVShows currentTV = new TVShows();
		
		User user = new User();

		//While loop that allows the user to navigate netflix
		
		boolean closeApplication = user.login();

		while (closeApplication != true ) { //while user continues to use netflix
		
			//Displays the action movies
			movies.displayAction();
			
			//Displays the children & family movies
			movies.displayChildren();
			
			//Displays the comedy movies
			movies.displayComedy();
			
			//Displays the documentaries
			movies.displayDoc();
			
			//Displays the horror movies
			movies.displayHorror();
			
			//Displays the musicals
			movies.displayMusical();
			
			//Displays the romantic movies
			movies.displayRomance();
			
			//Displays the fantasy movies
			movies.displayFantasy();
			
			//Displays the sports movies
			movies.displaySports();
			//Displays other TV shows
			TVshows.displayShows();
			
			//Displays the anime shows
			TVshows.displayAnime();
			
			//Drop down menu that allows the user to perform different functions in the netflix application
			int choice = 0;
			
			//Boolean variables for the menu
			boolean viewMore = false;
			System.out.println("\n╔═════════════════════════ ≪ °❈° ≫ ═════════════════════════════╗");
			System.out.println("\n\t           What would you like to do?: ");
			System.out.println("\t           1 - Navigate Home Page");
			System.out.println("\t           2 - Search");
			System.out.println("\t           3 - Check History");
			System.out.println("\t           4 - Settings");
			System.out.println("\t           5 - Log out");
System.out.println("\t           6 - Cancel Subscription");

			System.out.println("\n╚═════════════════════════ ≪ °❈° ≫ ═════════════════════════════╝");
			choice = scan.nextInt();
			if(choice == 6){
user.cancelSubscription();
closeApplication = true;

}
			if (choice == 1) { //User Navigates Home Page
				
				while (choice != 12) { //While user does not go back to the home page
					//User picks a category to view
					//Make the menu look nicer afterwards
					System.out.println("╔═════════════════════════ ≪ °❈° ≫ ═════════════════════════════╗");
					System.out.println("\n\t          Select a Category to View!: ");
					System.out.println("\n     1 - Action & Adventure" + "\t\t7 - Romantic");
					System.out.println("     2 - Children & Family" + "\t\t8 - Fantasy");
					System.out.println("     3 - Comedies" + "\t\t\t9 - Sports");
					System.out.println("     4 - Documentaries" + "\t\t\t10 - Shows");
					System.out.println("     5 - Horror" + "\t\t\t\t11 - Anime");
					System.out.println("     6 - Musicals" + "\t\t\t12 - Back to Home Page");
					System.out.println("\n╚═════════════════════════ ≪ °❈° ≫ ═════════════════════════════╝\n");
					
					//Allows the user to select a category to view
					choice = scan.nextInt();
					
					//If statements depending on which category the user wants to view
					if (choice == 1) { // View Action & Adventure
						
						while (choice != 7) { //While user does not go back to the category menu
							
							//Displays the movies in the category
							movies.displayAction();
							
							//Selection of movies menu that allows the user to pick what they want to watch
							System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
							System.out.println("\n\t\t    Select a movie!:");
							System.out.println("\t1 - " + movies.action[0].getTitle());
							System.out.println("\t2 - " + movies.action[1].getTitle());
							System.out.println("\t3 - " + movies.action[2].getTitle());
							System.out.println("\t4 - " + movies.action[3].getTitle());
							System.out.println("\t5 - " + movies.action[4].getTitle());
							System.out.println("\t6 - View More");
							System.out.println("\t7 - Back to Categories");
							System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
							
							//Allows the user to select a movie
							choice = scan.nextInt();
							
							if (choice == 6) { //User chooses to view more movies
								
								//Sets boolean to true to allow the user to view more movies
								viewMore = true;
								
								//While loop that will continue to show the movies with the view more option
								while (viewMore == true) {
									
									//Displays the other 5 movies in the category
									System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
									System.out.println("║                                              𝐀𝐂𝐓𝐈𝐎𝐍 𝐌𝐎𝐕𝐈𝐄𝐒                                                            ║");
									System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
									
									for (int i = 5; i < 10; i++) {
									    System.out.print("║ " + movies.action[i].getTitle() + " ║  ");
									}
									
									System.out.println();
									System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
									
									//Selection of movies menu that allows the user to pick what they want to watch
									System.out.println("\n\n╔═════════════════════ ≪ °❈° ≫ ═════════════════════╗");
									System.out.println("\n\t\t    Select a movie!:");
									System.out.println("\t1 - " + movies.action[5].getTitle());
									System.out.println("\t2 - " + movies.action[6].getTitle());
									System.out.println("\t3 - " + movies.action[7].getTitle());
									System.out.println("\t4 - " + movies.action[8].getTitle());
									System.out.println("\t5 - " + movies.action[9].getTitle());
									System.out.println("\t6 - View Less");
									System.out.println("\t7 - Back to Categories");
									System.out.println("\n╚═════════════════════ ≪ °❈° ≫ ═════════════════════╝");
									
									//Allows the user to pick a movie to watch
									choice = scan.nextInt();
									
									//If statements depending on user's choice for movie selection
									if (choice == 6 || choice == 7) { //Sets boolean to false if user views less or goes back to categories
										viewMore = false;
										
									} else { //User picks a movie
										
										//Calls in action movie selection method
										currentMovie = actionSelection(choice, movies, viewMore);
										
										//Calls in the watch movies method
										historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
										
									}
								}
								
							} else if (choice != 7) { //User selects a movie
								
								//Calls in action movie selection method
								currentMovie = actionSelection(choice, movies, viewMore);
								
								//Calls in the watch movies method
								historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
								
							}
						}
						
					} else if (choice == 2) { // View Children & Family
						
						while (choice != 7) { //While user does not go back to the category menu
							
							//Displays the movies in the category
							movies.displayChildren();
							
							//Selection of movies menu that allows the user to pick what they want to watch
							System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
							System.out.println("\n\t\t    Select a movie!:");
							System.out.println("\t1 - " + movies.children[0].getTitle());
							System.out.println("\t2 - " + movies.children[1].getTitle());
							System.out.println("\t3 - " + movies.children[2].getTitle());
							System.out.println("\t4 - " + movies.children[3].getTitle());
							System.out.println("\t5 - " + movies.children[4].getTitle());
							System.out.println("\t6 - View More");
							System.out.println("\t7 - Back to Categories");
							System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
							
							//Allows the user to select a movie
							choice = scan.nextInt();
							
							if (choice == 6) { //User chooses to view more movies
								
								//Sets boolean to true to allow the user to view more movies
								viewMore = true;
								
								//While loop that will continue to show the movies with the view more option
								while (viewMore == true) {
									
									// View More
								 	System.out.println();
						            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
						    		System.out.println("║                                              𝐂𝐇𝐈𝐋𝐃𝐑𝐄𝐍 𝐌𝐎𝐕𝐈𝐄𝐒                                                         ║");
						    		System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
						    		
						    		for (int i = 5; i < 10; i++) {
						    		    System.out.print("║ " + movies.children[i].getTitle() + " ║  ");
						    		}
						    		System.out.println();
						    		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
									
									//Selection of movies menu that allows the user to pick what they want to watch
									System.out.println("\n\n╔═════════════════════ ≪ °❈° ≫ ═════════════════════╗");
									System.out.println("\n\t\t    Select a movie!:");
									System.out.println("\t1 - " + movies.children[5].getTitle());
									System.out.println("\t2 - " + movies.children[6].getTitle());
									System.out.println("\t3 - " + movies.children[7].getTitle());
									System.out.println("\t4 - " + movies.children[8].getTitle());
									System.out.println("\t5 - " + movies.children[9].getTitle());
									System.out.println("\t6 - View Less");
									System.out.println("\t7 - Back to Categories");
									System.out.println("\n╚═════════════════════ ≪ °❈° ≫ ═════════════════════╝");
									
									//Allows the user to pick a movie to watch
									choice = scan.nextInt();
									
									//If statements depending on user's choice for movie selection
									if (choice == 6 || choice == 7) { //Sets boolean to false if user views less or goes back to categories
										viewMore = false;
										
									} else { //User picks a movie
										
										//Calls in action movie selection method
										currentMovie = childrenSelection(choice, movies, viewMore);
										
										//Calls in the watch movies method
										historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
										
									}
								}
								
							} else if (choice != 7) { //User selects a movie
								
								//Calls in action movie selection method
								currentMovie = childrenSelection(choice, movies, viewMore);
								
								//Calls in the watch movies method
								historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
								
							}
						}
					} else if (choice == 3) { // View Comedy
						
						while (choice != 7) { //While user does not go back to the category menu
							
							//Displays the movies in the category
							movies.displayComedy();
							
							//Selection of movies menu that allows the user to pick what they want to watch
							System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
							System.out.println("\n\t\t    Select a movie!:");
							System.out.println("\t1 - " + movies.comedy[0].getTitle());
							System.out.println("\t2 - " + movies.comedy[1].getTitle());
							System.out.println("\t3 - " + movies.comedy[2].getTitle());
							System.out.println("\t4 - " + movies.comedy[3].getTitle());
							System.out.println("\t5 - " + movies.comedy[4].getTitle());
							System.out.println("\t6 - View More");
							System.out.println("\t7 - Back to Categories");
							System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
							
							//Allows the user to select a movie
							choice = scan.nextInt();
							
							if (choice == 6) { //User chooses to view more movies
								
								//Sets boolean to true to allow the user to view more movies
								viewMore = true;
								
								//While loop that will continue to show the movies with the view more option
								while (viewMore == true) {
									
									// Print the shuffled movies
								 	System.out.println();
						            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
						    		System.out.println("║                                                𝐂𝐎𝐌𝐄𝐃𝐘 𝐌𝐎𝐕𝐈𝐄𝐒                                                         ║");
						    		System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
						    		 
						    		
						    		for (int i = 5; i < 10; i++) {
						    		    System.out.print("║ " + movies.comedy[i].getTitle() + " ║  ");
						    		}
						    		System.out.println();
						    		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
									
									//Selection of movies menu that allows the user to pick what they want to watch
									System.out.println("\n\n╔═════════════════════ ≪ °❈° ≫ ═════════════════════╗");
									System.out.println("\n\t\t    Select a movie!:");
									System.out.println("\t1 - " + movies.comedy[5].getTitle());
									System.out.println("\t2 - " + movies.comedy[6].getTitle());
									System.out.println("\t3 - " + movies.comedy[7].getTitle());
									System.out.println("\t4 - " + movies.comedy[8].getTitle());
									System.out.println("\t5 - " + movies.comedy[9].getTitle());
									System.out.println("\t6 - View Less");
									System.out.println("\t7 - Back to Categories");
									System.out.println("\n╚═════════════════════ ≪ °❈° ≫ ═════════════════════╝");
									
									//Allows the user to pick a movie to watch
									choice = scan.nextInt();
									
									//If statements depending on user's choice for movie selection
									if (choice == 6 || choice == 7) { //Sets boolean to false if user views less or goes back to categories
										viewMore = false;
										
									} else { //User picks a movie
										
										//Calls in action movie selection method
										currentMovie = comedySelection(choice, movies, viewMore);
										
										//Calls in the watch movies method
										historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
										
									}
								}
								
							} else if (choice != 7) { //User selects a movie
								
								//Calls in action movie selection method
								currentMovie = comedySelection(choice, movies, viewMore);
								
								//Calls in the watch movies method
								historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
								
							}
						}
					} else if (choice == 4) { // View Documentary
						
						while (choice != 7) { //While user does not go back to the category menu
							
							//Displays the movies in the category
							movies.displayDoc();
							
							//Selection of movies menu that allows the user to pick what they want to watch
							System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
							System.out.println("\n\t\t    Select a movie!:");
							System.out.println("\t1 - " + movies.documentary[0].getTitle());
							System.out.println("\t2 - " + movies.documentary[1].getTitle());
							System.out.println("\t3 - " + movies.documentary[2].getTitle());
							System.out.println("\t4 - " + movies.documentary[3].getTitle());
							System.out.println("\t5 - " + movies.documentary[4].getTitle());
							System.out.println("\t6 - View More");
							System.out.println("\t7 - Back to Categories");
							System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
							
							//Allows the user to select a movie
							choice = scan.nextInt();
							
							if (choice == 6) { //User chooses to view more movies
								
								//Sets boolean to true to allow the user to view more movies
								viewMore = true;
								
								//While loop that will continue to show the movies with the view more option
								while (viewMore == true) {
									
									// View More
									System.out.println();
							        System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
									System.out.println("║                                                             𝐃𝐎𝐂𝐔𝐌𝐄𝐍𝐓𝐀𝐑𝐘 𝐌𝐎𝐕𝐈𝐄𝐒                                                                 ║");
									System.out.println("║  ---------------------------------------------------------------------------------------------------------------------------------------------    ║");
									
									for (int i = 5; i < 10; i++) {
									    System.out.print("║ " + movies.documentary[i].getTitle() + " ║  ");
									}
									System.out.println();
									System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
									
									//Selection of movies menu that allows the user to pick what they want to watch
									System.out.println("\n\n╔═════════════════════ ≪ °❈° ≫ ═════════════════════╗");
									System.out.println("\n\t\t    Select a movie!:");
									System.out.println("\t1 - " + movies.documentary[5].getTitle());
									System.out.println("\t2 - " + movies.documentary[6].getTitle());
									System.out.println("\t3 - " + movies.documentary[7].getTitle());
									System.out.println("\t4 - " + movies.documentary[8].getTitle());
									System.out.println("\t5 - " + movies.documentary[9].getTitle());
									System.out.println("\t6 - View Less");
									System.out.println("\t7 - Back to Categories");
									System.out.println("\n╚═════════════════════ ≪ °❈° ≫ ═════════════════════╝");
									
									//Allows the user to pick a movie to watch
									choice = scan.nextInt();
									
									//If statements depending on user's choice for movie selection
									if (choice == 6 || choice == 7) { //Sets boolean to false if user views less or goes back to categories
										viewMore = false;
										
									} else { //User picks a movie
										
										//Calls in action movie selection method
										currentMovie = docSelection(choice, movies, viewMore);
										
										//Calls in the watch movies method
										historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
										
									}
								}
								
							} else if (choice != 7) { //User selects a movie
								
								//Calls in action movie selection method
								currentMovie = docSelection(choice, movies, viewMore);
								
								//Calls in the watch movies method
								historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
								
							}
						}
					} else if (choice == 5) { // View Horror
						
						while (choice != 7) { //While user does not go back to the category menu
							
							//Displays the movies in the category
							movies.displayHorror();
							
							//Selection of movies menu that allows the user to pick what they want to watch
							System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
							System.out.println("\n\t\t    Select a movie!:");
							System.out.println("\t1 - " + movies.horror[0].getTitle());
							System.out.println("\t2 - " + movies.horror[1].getTitle());
							System.out.println("\t3 - " + movies.horror[2].getTitle());
							System.out.println("\t4 - " + movies.horror[3].getTitle());
							System.out.println("\t5 - " + movies.horror[4].getTitle());
							System.out.println("\t6 - View More");
							System.out.println("\t7 - Back to Categories");
							System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
							
							//Allows the user to select a movie
							choice = scan.nextInt();
							
							if (choice == 6) { //User chooses to view more movies
								
								//Sets boolean to true to allow the user to view more movies
								viewMore = true;
								
								//While loop that will continue to show the movies with the view more option
								while (viewMore == true) {
									
									// View More
									System.out.println();
							        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
									System.out.println("║                                                   𝐇𝐎𝐑𝐑𝐎𝐑 𝐌𝐎𝐕𝐈𝐄𝐒                                                      ║");
									System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
									 
									for (int i = 5; i < 10; i++) {
									    System.out.print("║ " + movies.horror[i].getTitle() + " ║  ");
									}
									System.out.println();
									System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
									
									//Selection of movies menu that allows the user to pick what they want to watch
									System.out.println("\n\n╔═════════════════════ ≪ °❈° ≫ ═════════════════════╗");
									System.out.println("\n\t\t    Select a movie!:");
									System.out.println("\t1 - " + movies.horror[5].getTitle());
									System.out.println("\t2 - " + movies.horror[6].getTitle());
									System.out.println("\t3 - " + movies.horror[7].getTitle());
									System.out.println("\t4 - " + movies.horror[8].getTitle());
									System.out.println("\t5 - " + movies.horror[9].getTitle());
									System.out.println("\t6 - View Less");
									System.out.println("\t7 - Back to Categories");
									System.out.println("\n╚═════════════════════ ≪ °❈° ≫ ═════════════════════╝");
									
									//Allows the user to pick a movie to watch
									choice = scan.nextInt();
									
									//If statements depending on user's choice for movie selection
									if (choice == 6 || choice == 7) { //Sets boolean to false if user views less or goes back to categories
										viewMore = false;
										
									} else { //User picks a movie
										
										//Calls in action movie selection method
										currentMovie = horrorSelection(choice, movies, viewMore);
										
										//Calls in the watch movies method
										historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
										
									}
								}
								
							} else if (choice != 7) { //User selects a movie
								
								//Calls in action movie selection method
								currentMovie = horrorSelection(choice, movies, viewMore);
								
								//Calls in the watch movies method
								historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
								
							}
						}
					} else if (choice == 6) { // View Musical
						
						while (choice != 7) { //While user does not go back to the category menu
							
							//Displays the movies in the category
							movies.displayMusical();
							
							//Selection of movies menu that allows the user to pick what they want to watch
							System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
							System.out.println("\n\t\t    Select a movie!:");
							System.out.println("\t1 - " + movies.musical[0].getTitle());
							System.out.println("\t2 - " + movies.musical[1].getTitle());
							System.out.println("\t3 - " + movies.musical[2].getTitle());
							System.out.println("\t4 - " + movies.musical[3].getTitle());
							System.out.println("\t5 - " + movies.musical[4].getTitle());
							System.out.println("\t6 - View More");
							System.out.println("\t7 - Back to Categories");
							System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
							
							//Allows the user to select a movie
							choice = scan.nextInt();
							
							if (choice == 6) { //User chooses to view more movies
								
								//Sets boolean to true to allow the user to view more movies
								viewMore = true;
								
								//While loop that will continue to show the movies with the view more option
								while (viewMore == true) {
									
									// Print the shuffled movies
									System.out.println();
							        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
									System.out.println("║                                                   𝐌𝐔𝐒𝐈𝐂𝐀𝐋 𝐌𝐎𝐕𝐈𝐄𝐒                                                      ║");
									System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
									 
									for (int i = 5; i < 10; i++) {
									    System.out.print("║ " + movies.musical[i].getTitle() + " ║  ");
									}
									System.out.println();
									System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
									
									//Selection of movies menu that allows the user to pick what they want to watch
									System.out.println("\n\n╔═════════════════════ ≪ °❈° ≫ ═════════════════════╗");
									System.out.println("\n\t\t    Select a movie!:");
									System.out.println("\t1 - " + movies.musical[5].getTitle());
									System.out.println("\t2 - " + movies.musical[6].getTitle());
									System.out.println("\t3 - " + movies.musical[7].getTitle());
									System.out.println("\t4 - " + movies.musical[8].getTitle());
									System.out.println("\t5 - " + movies.musical[9].getTitle());
									System.out.println("\t6 - View Less");
									System.out.println("\t7 - Back to Categories");
									System.out.println("\n╚═════════════════════ ≪ °❈° ≫ ═════════════════════╝");
									
									//Allows the user to pick a movie to watch
									choice = scan.nextInt();
									
									//If statements depending on user's choice for movie selection
									if (choice == 6 || choice == 7) { //Sets boolean to false if user views less or goes back to categories
										viewMore = false;
										
									} else { //User picks a movie
										
										//Calls in action movie selection method
										currentMovie = musicalSelection(choice, movies, viewMore);
										
										//Calls in the watch movies method
										historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
										
									}
								}
								
							} else if (choice != 7) { //User selects a movie
								
								//Calls in action movie selection method
								currentMovie = musicalSelection(choice, movies, viewMore);
								
								//Calls in the watch movies method
								historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
								
							}
						}
					} else if (choice == 7) { // View Romance
						
						while (choice != 7) { //While user does not go back to the category menu
							
							//Displays the movies in the category
							movies.displayRomance();
							
							//Selection of movies menu that allows the user to pick what they want to watch
							System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
							System.out.println("\n\t\t    Select a movie!:");
							System.out.println("\t1 - " + movies.romance[0].getTitle());
							System.out.println("\t2 - " + movies.romance[1].getTitle());
							System.out.println("\t3 - " + movies.romance[2].getTitle());
							System.out.println("\t4 - " + movies.romance[3].getTitle());
							System.out.println("\t5 - " + movies.romance[4].getTitle());
							System.out.println("\t6 - View More");
							System.out.println("\t7 - Back to Categories");
							System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
							
							//Allows the user to select a movie
							choice = scan.nextInt();
							
							if (choice == 6) { //User chooses to view more movies
								
								//Sets boolean to true to allow the user to view more movies
								viewMore = true;
								
								//While loop that will continue to show the movies with the view more option
								while (viewMore == true) {
									
									// Print the shuffled movies
									System.out.println();
							        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
									System.out.println("║                                                   𝐑𝐎𝐌𝐀𝐍𝐂𝐄 𝐌𝐎𝐕𝐈𝐄𝐒                                                     ║");
									System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
									 
									for (int i = 5; i < 10; i++) {
									    System.out.print("║ " + movies.romance[i].getTitle() + " ║  ");
									}
									System.out.println();
									System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
									
									//Selection of movies menu that allows the user to pick what they want to watch
									System.out.println("\n\n╔═════════════════════ ≪ °❈° ≫ ═════════════════════╗");
									System.out.println("\n\t\t    Select a movie!:");
									System.out.println("\t1 - " + movies.romance[5].getTitle());
									System.out.println("\t2 - " + movies.romance[6].getTitle());
									System.out.println("\t3 - " + movies.romance[7].getTitle());
									System.out.println("\t4 - " + movies.romance[8].getTitle());
									System.out.println("\t5 - " + movies.romance[9].getTitle());
									System.out.println("\t6 - View Less");
									System.out.println("\t7 - Back to Categories");
									System.out.println("\n╚═════════════════════ ≪ °❈° ≫ ═════════════════════╝");
									
									//Allows the user to pick a movie to watch
									choice = scan.nextInt();
									
									//If statements depending on user's choice for movie selection
									if (choice == 6 || choice == 7) { //Sets boolean to false if user views less or goes back to categories
										viewMore = false;
										
									} else { //User picks a movie
										
										//Calls in action movie selection method
										currentMovie = romanceSelection(choice, movies, viewMore);
										
										//Calls in the watch movies method
										historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
										
									}
								}
								
							} else if (choice != 7) { //User selects a movie
								
								//Calls in action movie selection method
								currentMovie = romanceSelection(choice, movies, viewMore);
								
								//Calls in the watch movies method
								historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
								
							}
						}
					} else if (choice == 8) { // View Fantasy
						
						while (choice != 7) { //While user does not go back to the category menu
							
							//Displays the movies in the category
							movies.displayFantasy();
							
							//Selection of movies menu that allows the user to pick what they want to watch
							System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
							System.out.println("\n\t\t    Select a movie!:");
							System.out.println("\t1 - " + movies.fantasy[0].getTitle());
							System.out.println("\t2 - " + movies.fantasy[1].getTitle());
							System.out.println("\t3 - " + movies.fantasy[2].getTitle());
							System.out.println("\t4 - " + movies.fantasy[3].getTitle());
							System.out.println("\t5 - " + movies.fantasy[4].getTitle());
							System.out.println("\t6 - View More");
							System.out.println("\t7 - Back to Categories");
							System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
							
							//Allows the user to select a movie
							choice = scan.nextInt();
							
							if (choice == 6) { //User chooses to view more movies
								
								//Sets boolean to true to allow the user to view more movies
								viewMore = true;
								
								//While loop that will continue to show the movies with the view more option
								while (viewMore == true) {
									
									// View More
									System.out.println();
							        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
									System.out.println("║                                                   𝐅𝐀𝐍𝐓𝐀𝐒𝐘 𝐌𝐎𝐕𝐈𝐄𝐒                                                     ║");
									System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
									 
									for (int i = 5; i < 10; i++) {
									    System.out.print("║ " + movies.fantasy[i].getTitle() + " ║  ");
									}
									System.out.println();
									System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
									
									//Selection of movies menu that allows the user to pick what they want to watch
									System.out.println("\n\n╔═════════════════════ ≪ °❈° ≫ ═════════════════════╗");
									System.out.println("\n\t\t    Select a movie!:");
									System.out.println("\t1 - " + movies.fantasy[5].getTitle());
									System.out.println("\t2 - " + movies.fantasy[6].getTitle());
									System.out.println("\t3 - " + movies.fantasy[7].getTitle());
									System.out.println("\t4 - " + movies.fantasy[8].getTitle());
									System.out.println("\t5 - " + movies.fantasy[9].getTitle());
									System.out.println("\t6 - View Less");
									System.out.println("\t7 - Back to Categories");
									System.out.println("\n╚═════════════════════ ≪ °❈° ≫ ═════════════════════╝");
									
									//Allows the user to pick a movie to watch
									choice = scan.nextInt();
									
									//If statements depending on user's choice for movie selection
									if (choice == 6 || choice == 7) { //Sets boolean to false if user views less or goes back to categories
										viewMore = false;
										
									} else { //User picks a movie
										
										//Calls in action movie selection method
										currentMovie = fantasySelection(choice, movies, viewMore);
										
										//Calls in the watch movies method
										historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
										
									}
								}
								
							} else if (choice != 7) { //User selects a movie
								
								//Calls in action movie selection method
								currentMovie = fantasySelection(choice, movies, viewMore);
								
								//Calls in the watch movies method
								historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
								
							}
						}
					} else if (choice == 9) { // View Sports
						
						while (choice != 7) { //While user does not go back to the category menu
							
							//Displays the movies in the category
							movies.displaySports();
							
							//Selection of movies menu that allows the user to pick what they want to watch
							System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
							System.out.println("\n\t\t    Select a movie!:");
							System.out.println("\t1 - " + movies.sport[0].getTitle());
							System.out.println("\t2 - " + movies.sport[1].getTitle());
							System.out.println("\t3 - " + movies.sport[2].getTitle());
							System.out.println("\t4 - " + movies.sport[3].getTitle());
							System.out.println("\t5 - " + movies.sport[4].getTitle());
							System.out.println("\t6 - View More");
							System.out.println("\t7 - Back to Categories");
							System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
							
							//Allows the user to select a movie
							choice = scan.nextInt();
							
							if (choice == 6) { //User chooses to view more movies
								
								//Sets boolean to true to allow the user to view more movies
								viewMore = true;
								
								//While loop that will continue to show the movies with the view more option
								while (viewMore == true) {
							
									// View More
									System.out.println();
							        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
									System.out.println("║                                                   𝐒𝐏𝐎𝐑𝐓 𝐌𝐎𝐕𝐈𝐄𝐒                                                        ║");
									System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
									 
									for (int i = 5; i < 10; i++) {
									    System.out.print("║ " + movies.sport[i].getTitle() + " ║  ");
									}
									System.out.println();
									System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
									
									//Selection of movies menu that allows the user to pick what they want to watch
									System.out.println("\n\n╔═════════════════════ ≪ °❈° ≫ ═════════════════════╗");
									System.out.println("\n\t\t    Select a movie!:");
									System.out.println("\t1 - " + movies.sport[5].getTitle());
									System.out.println("\t2 - " + movies.sport[6].getTitle());
									System.out.println("\t3 - " + movies.sport[7].getTitle());
									System.out.println("\t4 - " + movies.sport[8].getTitle());
									System.out.println("\t5 - " + movies.sport[9].getTitle());
									System.out.println("\t6 - View Less");
									System.out.println("\t7 - Back to Categories");
									System.out.println("\n╚═════════════════════ ≪ °❈° ≫ ═════════════════════╝");
									
									//Allows the user to pick a movie to watch
									choice = scan.nextInt();
									
									//If statements depending on user's choice for movie selection
									if (choice == 6 || choice == 7) { //Sets boolean to false if user views less or goes back to categories
										viewMore = false;
										
									} else { //User picks a movie
										
										//Calls in action movie selection method
										currentMovie = sportsSelection(choice, movies, viewMore);
										
										//Calls in the watch movies method
										historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
										
									}
								}
								
							} else if (choice != 7) { //User selects a movie
								
								//Calls in action movie selection method
								currentMovie = sportsSelection(choice, movies, viewMore);
								
								//Calls in the watch movies method
								historyCount = watchMovies(currentMovie, mediaHistory, historyCount);
								
							}
						}
					} else if (choice == 10) { // View Shows
						
						while (choice != 7) { //While user does not go back to the category menu
							
							//Displays the movies in the category
							TVshows.displayShows();
							
							//Selection of movies menu that allows the user to pick what they want to watch
							System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
							System.out.println("\n\t\t    Select a movie!:");
							System.out.println("\t1 - " + TVshows.shows[0].getTitle());
							System.out.println("\t2 - " + TVshows.shows[1].getTitle());
							System.out.println("\t3 - " + TVshows.shows[2].getTitle());
							System.out.println("\t4 - " + TVshows.shows[3].getTitle());
							System.out.println("\t5 - " + TVshows.shows[4].getTitle());
							System.out.println("\t6 - View More");
							System.out.println("\t7 - Back to Categories");
							System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
							
							//Allows the user to select a movie
							choice = scan.nextInt();
							
							if (choice == 6) { //User chooses to view more movies
								
								//Sets boolean to true to allow the user to view more movies
								viewMore = true;
								
								//While loop that will continue to show the movies with the view more option
								while (viewMore == true) {
									
									// View More
								 	System.out.println();
									System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
									System.out.println("║                                                  𝐒𝐇𝐎𝐖𝐒                                                               ║");
									System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
									 
									for (int i = 5; i < 10; i++) {
									    System.out.print("║ " + TVshows.shows[i].getTitle() + " ║  ");
									}
									System.out.println();
									System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
									
									//Selection of movies menu that allows the user to pick what they want to watch
									System.out.println("\n\n╔═════════════════════ ≪ °❈° ≫ ═════════════════════╗");
									System.out.println("\n\t\t    Select a movie!:");
									System.out.println("\t1 - " + TVshows.shows[5].getTitle());
									System.out.println("\t2 - " + TVshows.shows[6].getTitle());
									System.out.println("\t3 - " + TVshows.shows[7].getTitle());
									System.out.println("\t4 - " + TVshows.shows[8].getTitle());
									System.out.println("\t5 - " + TVshows.shows[9].getTitle());
									System.out.println("\t6 - View Less");
									System.out.println("\t7 - Back to Categories");
									System.out.println("\n╚═════════════════════ ≪ °❈° ≫ ═════════════════════╝");
									
									//Allows the user to pick a movie to watch
									choice = scan.nextInt();
									
									//If statements depending on user's choice for movie selection
									if (choice == 6 || choice == 7) { //Sets boolean to false if user views less or goes back to categories
										viewMore = false;
										
									} else { //User picks a movie
										
										//Calls in action movie selection method
										currentTV = showsSelection(choice, TVshows, viewMore);
										
										//Calls in the watch movies method
										historyCount = watchTV(currentTV, mediaHistory, historyCount);
										
									}
								}
								
							} else if (choice != 7) { //User selects a movie
								
								//Calls in action movie selection method
								currentTV = showsSelection(choice, TVshows, viewMore);
								
								//Calls in the watch movies method
								historyCount = watchTV(currentTV, mediaHistory, historyCount);
								
							}
						}
					} else if (choice == 11) { // View Anime
						
						while (choice != 7) { //While user does not go back to the category menu
							
							//Displays the movies in the category
							TVshows.displayAnime();
							
							//Selection of movies menu that allows the user to pick what they want to watch
							System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
							System.out.println("\n\t\t    Select a movie!:");
							System.out.println("\t1 - " + TVshows.anime[0].getTitle());
							System.out.println("\t2 - " + TVshows.anime[1].getTitle());
							System.out.println("\t3 - " + TVshows.anime[2].getTitle());
							System.out.println("\t4 - " + TVshows.anime[3].getTitle());
							System.out.println("\t5 - " + TVshows.anime[4].getTitle());
							System.out.println("\t6 - View More");
							System.out.println("\t7 - Back to Categories");
							System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
							
							//Allows the user to select a movie
							choice = scan.nextInt();
							
							if (choice == 6) { //User chooses to view more movies
								
								//Sets boolean to true to allow the user to view more movies
								viewMore = true;
								
								//While loop that will continue to show the movies with the view more option
								while (viewMore == true) {
									
									// View More
								 	System.out.println();
									System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
									System.out.println("║                                                   𝐀𝐍𝐈𝐌𝐄                                                               ║");
									System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
									 
									for (int i = 5; i < 10; i++) {
									    System.out.print("║ " + TVshows.anime[i].getTitle() + " ║  ");
									}
									System.out.println();
									System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
									
									//Selection of movies menu that allows the user to pick what they want to watch
									System.out.println("\n\n╔═════════════════════ ≪ °❈° ≫ ═════════════════════╗");
									System.out.println("\n\t\t    Select a movie!:");
									System.out.println("\t1 - " + TVshows.anime[5].getTitle());
									System.out.println("\t2 - " + TVshows.anime[6].getTitle());
									System.out.println("\t3 - " + TVshows.anime[7].getTitle());
									System.out.println("\t4 - " + TVshows.anime[8].getTitle());
									System.out.println("\t5 - " + TVshows.anime[9].getTitle());
									System.out.println("\t6 - View Less");
									System.out.println("\t7 - Back to Categories");
									System.out.println("\n╚═════════════════════ ≪ °❈° ≫ ═════════════════════╝");
									
									//Allows the user to pick a movie to watch
									choice = scan.nextInt();
									
									//If statements depending on user's choice for movie selection
									if (choice == 6 || choice == 7) { //Sets boolean to false if user views less or goes back to categories
										viewMore = false;
										
									} else { //User picks a movie
										
										//Calls in action movie selection method
										currentTV = animeSelection(choice, TVshows, viewMore);
										
										//Calls in the watch movies method
										historyCount = watchTV(currentTV, mediaHistory, historyCount);
										
									}
								}
								
							} else if (choice != 7) { //User selects a movie
								
								//Calls in action movie selection method
								currentTV = animeSelection(choice, TVshows, viewMore);
								
								//Calls in the watch movies method
								historyCount = watchTV(currentTV, mediaHistory, historyCount);
								
							}
						}
					} 
				}
	
			} else if (choice == 2) { //Search for a Movie
				
				//Asks the user for what they want to search for
				System.out.println("\nEnter a movie or TV show to search for!: ");
				scan.nextLine();
				String search = scan.nextLine();
				
				//Searches for specified movie or TV show
				System.out.println("");
				mediaSearch(search,currentMovie, mediaHistory,historyCount, currentTV);
		
			} else if (choice == 3) { //Checks History
				
				//Calls in method to check the watch history of the user
				checkHistory();
				
				//Asks the user to press enter to finish the movie
				System.out.println("\nPress ENTER to continue!");
				scan.nextLine();
				scan.nextLine();
				
			}else if (choice == 4) { //Settings
				user.changeSettings();
				
				//Asks the user to press enter to go back to home page
				System.out.println("\nPress ENTER to go back to home page!");
				scan.nextLine();
				scan.nextLine();
				
			} else if (choice == 5) { // Logout
				
				System.out.print("Logging out..");
				closeApplication = true;
				
			}


		}
	}
	
	
	public static Movies actionSelection (int choice, Movies movies, boolean viewMore) {
		// Displays the description of the chosen action movie
		// Takes in choice, movies object and a boolean if the user is on the next page of the movie selection
		// Displays description of selected movie and returns movie object
		
		//Declaring a current movie object
		Movies currentMovie = new Movies();
		
		if (viewMore == false) { //Sets current movie object to one of the movies on the first page
			currentMovie = movies.action[choice - 1];
			
		} else if (viewMore == true) { //Sets current movie object to one of the movies on the second page
			currentMovie = movies.action[choice + 4];
		
		}
		
		//Displays information about that movie for first page
		System.out.println("═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		System.out.print("\n\t" + currentMovie.getTitle());
		System.out.print("\n\tYear: " + currentMovie.getYear());
		System.out.print("\n\tDuration: " + currentMovie.getDuration());
		System.out.print("\n\tDescription: " + currentMovie.getDesc());
		System.out.println("\n\n═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		
		//Returns current movie object
		return currentMovie;
			
	}
	
	public static Movies childrenSelection (int choice, Movies movies, boolean viewMore) {
		// Displays the description of the chosen children movie
		// Takes in choice, movies object and a boolean if the user is on the next page of the movie selection
		// Displays description of selected movie and returns movie object
		
		//Declaring a current movie object
		Movies currentMovie = new Movies();
		
		if (viewMore == false) { //Sets current movie object to one of the movies on the first page
			currentMovie = movies.children[choice - 1];
			
		} else if (viewMore == true) { //Sets current movie object to one of the movies on the second page
			currentMovie = movies.children[choice + 4];
		
		}
		
		//Displays information about that movie for first page
		System.out.println("═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		System.out.print("\n\t" + currentMovie.getTitle());
		System.out.print("\n\tYear: " + currentMovie.getYear());
		System.out.print("\n\tDuration: " + currentMovie.getDuration());
		System.out.print("\n\tDescription: " + currentMovie.getDesc());
		System.out.println("\n\n═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		
		//Returns current movie object
		return currentMovie;
			
	}
	
	public static Movies comedySelection (int choice, Movies movies, boolean viewMore) {
		// Displays the description of the chosen comedy movie
		// Takes in choice, movies object and a boolean if the user is on the next page of the movie selection
		// Displays description of selected movie and returns movie object
		
		//Declaring a current movie object
		Movies currentMovie = new Movies();
		
		if (viewMore == false) { //Sets current movie object to one of the movies on the first page
			currentMovie = movies.comedy[choice - 1];
			
		} else if (viewMore == true) { //Sets current movie object to one of the movies on the second page
			currentMovie = movies.comedy[choice + 4];
		
		}
		
		//Displays information about that movie for first page
		System.out.println("═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		System.out.print("\n\t" + currentMovie.getTitle());
		System.out.print("\n\tYear: " + currentMovie.getYear());
		System.out.print("\n\tDuration: " + currentMovie.getDuration());
		System.out.print("\n\tDescription: " + currentMovie.getDesc());
		System.out.println("\n\n═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		
		//Returns current movie object
		return currentMovie;
			
	}
	
	public static Movies docSelection (int choice, Movies movies, boolean viewMore) {
		// Displays the description of the chosen documentary movie
		// Takes in choice, movies object and a boolean if the user is on the next page of the movie selection
		// Displays description of selected movie and returns movie object
		
		//Declaring a current movie object
		Movies currentMovie = new Movies();
		
		if (viewMore == false) { //Sets current movie object to one of the movies on the first page
			currentMovie = movies.documentary[choice - 1];
			
		} else if (viewMore == true) { //Sets current movie object to one of the movies on the second page
			currentMovie = movies.documentary[choice + 4];
		
		}
		
		//Displays information about that movie for first page
		System.out.println("═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		System.out.print("\n\t" + currentMovie.getTitle());
		System.out.print("\n\tYear: " + currentMovie.getYear());
		System.out.print("\n\tDuration: " + currentMovie.getDuration());
		System.out.print("\n\tDescription: " + currentMovie.getDesc());
		System.out.println("\n\n═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		
		//Returns current movie object
		return currentMovie;
			
	}
	
	public static Movies horrorSelection (int choice, Movies movies, boolean viewMore) {
		// Displays the description of the chosen horror movie
		// Takes in choice, movies object and a boolean if the user is on the next page of the movie selection
		// Displays description of selected movie and returns movie object
		
		//Declaring a current movie object
		Movies currentMovie = new Movies();
		
		if (viewMore == false) { //Sets current movie object to one of the movies on the first page
			currentMovie = movies.horror[choice - 1];
			
		} else if (viewMore == true) { //Sets current movie object to one of the movies on the second page
			currentMovie = movies.horror[choice + 4];
		
		}
		
		//Displays information about that movie for first page
		System.out.println("═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		System.out.print("\n\t" + currentMovie.getTitle());
		System.out.print("\n\tYear: " + currentMovie.getYear());
		System.out.print("\n\tDuration: " + currentMovie.getDuration());
		System.out.print("\n\tDescription: " + currentMovie.getDesc());
		System.out.println("\n\n═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		
		//Returns current movie object
		return currentMovie;
			
	}
	
	public static Movies musicalSelection (int choice, Movies movies, boolean viewMore) {
		// Displays the description of the chosen musical movie
		// Takes in choice, movies object and a boolean if the user is on the next page of the movie selection
		// Displays description of selected movie and returns movie object
		
		//Declaring a current movie object
		Movies currentMovie = new Movies();
		
		if (viewMore == false) { //Sets current movie object to one of the movies on the first page
			currentMovie = movies.musical[choice - 1];
			
		} else if (viewMore == true) { //Sets current movie object to one of the movies on the second page
			currentMovie = movies.musical[choice + 4];
		
		}
		
		//Displays information about that movie for first page
		System.out.println("═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		System.out.print("\n\t" + currentMovie.getTitle());
		System.out.print("\n\tYear: " + currentMovie.getYear());
		System.out.print("\n\tDuration: " + currentMovie.getDuration());
		System.out.print("\n\tDescription: " + currentMovie.getDesc());
		System.out.println("\n\n═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		
		//Returns current movie object
		return currentMovie;
			
	}
	public static Movies romanceSelection (int choice, Movies movies, boolean viewMore) {
		// Displays the description of the chosen romance movie
		// Takes in choice, movies object and a boolean if the user is on the next page of the movie selection
		// Displays description of selected movie and returns movie object
		
		//Declaring a current movie object
		Movies currentMovie = new Movies();
		
		if (viewMore == false) { //Sets current movie object to one of the movies on the first page
			currentMovie = movies.romance[choice - 1];
			
		} else if (viewMore == true) { //Sets current movie object to one of the movies on the second page
			currentMovie = movies.romance[choice + 4];
		
		}
		
		//Displays information about that movie for first page
		System.out.println("═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		System.out.print("\n\t" + currentMovie.getTitle());
		System.out.print("\n\tYear: " + currentMovie.getYear());
		System.out.print("\n\tDuration: " + currentMovie.getDuration());
		System.out.print("\n\tDescription: " + currentMovie.getDesc());
		System.out.println("\n\n═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		
		//Returns current movie object
		return currentMovie;
			
	}
	public static Movies fantasySelection (int choice, Movies movies, boolean viewMore) {
		// Displays the description of the chosen fantasy movie
		// Takes in choice, movies object and a boolean if the user is on the next page of the movie selection
		// Displays description of selected movie and returns movie object
		
		//Declaring a current movie object
		Movies currentMovie = new Movies();
		
		if (viewMore == false) { //Sets current movie object to one of the movies on the first page
			currentMovie = movies.fantasy[choice - 1];
			
		} else if (viewMore == true) { //Sets current movie object to one of the movies on the second page
			currentMovie = movies.fantasy[choice + 4];
		
		}
		
		//Displays information about that movie for first page
		System.out.println("═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		System.out.print("\n\t" + currentMovie.getTitle());
		System.out.print("\n\tYear: " + currentMovie.getYear());
		System.out.print("\n\tDuration: " + currentMovie.getDuration());
		System.out.print("\n\tDescription: " + currentMovie.getDesc());
		System.out.println("\n\n═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		
		//Returns current movie object
		return currentMovie;
			
	}
	
	public static Movies sportsSelection (int choice, Movies movies, boolean viewMore) {
		// Displays the description of the chosen sports movie
		// Takes in choice, movies object and a boolean if the user is on the next page of the movie selection
		// Displays description of selected movie and returns movie object
		
		//Declaring a current movie object
		Movies currentMovie = new Movies();
		
		if (viewMore == false) { //Sets current movie object to one of the movies on the first page
			currentMovie = movies.sport[choice - 1];
			
		} else if (viewMore == true) { //Sets current movie object to one of the movies on the second page
			currentMovie = movies.sport[choice + 4];
		
		}
		
		//Displays information about that movie for first page
		System.out.println("═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		System.out.print("\n\t" + currentMovie.getTitle());
		System.out.print("\n\tYear: " + currentMovie.getYear());
		System.out.print("\n\tDuration: " + currentMovie.getDuration());
		System.out.print("\n\tDescription: " + currentMovie.getDesc());
		System.out.println("\n\n═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		
		//Returns current movie object
		return currentMovie;
			
	}
	
	public static TVShows showsSelection (int choice, TVShows TVShows, boolean viewMore) {
		// Displays the description of the chosen TV show
		// Takes in choice, TVShows object and a boolean if the user is on the next page of the TV selection
		// Displays description of selected TV show and returns TVShow object
		
		//Declaring a current movie object
		TVShows currentTV = new TVShows();
		
		if (viewMore == false) { //Sets current movie object to one of the movies on the first page
			currentTV = TVShows.shows[choice - 1];
			
		} else if (viewMore == true) { //Sets current movie object to one of the movies on the second page
			currentTV = TVShows.shows[choice + 4];
		
		}
		
		//Displays information about that movie for first page
		System.out.println("═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		System.out.print("\n\t" + currentTV.getTitle());
		System.out.print("\n\tYear: " + currentTV.getYear());
		System.out.print("\n\tDuration: " + currentTV.getSeason());
		System.out.print("\n\tDescription: " + currentTV.getDesc());
		System.out.println("\n\n═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		
		//Returns current movie object
		return currentTV;
			
	}
	
	public static TVShows animeSelection (int choice, TVShows TVShows, boolean viewMore) {
		// Displays the description of the chosen anime show
		// Takes in choice, TVShows object and a boolean if the user is on the next page of the TV selection
		// Displays description of selected TV show and returns TVShow object
		
		//Declaring a current movie object
		TVShows currentTV = new TVShows();
		
		if (viewMore == false) { //Sets current movie object to one of the movies on the first page
			currentTV = TVShows.anime[choice - 1];
			
		} else if (viewMore == true) { //Sets current movie object to one of the movies on the second page
			currentTV = TVShows.anime[choice + 4];
		
		}
		
		//Displays information about that movie for first page
		System.out.println("═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		System.out.print("\n\t" + currentTV.getTitle());
		System.out.print("\n\tYear: " + currentTV.getYear());
		System.out.print("\n\tDuration: " + currentTV.getSeason());
		System.out.print("\n\tDescription: " + currentTV.getDesc());
		System.out.println("\n\n═══════════════════════ ≪ °❈° ≫ ═══════════════════════");
		
		//Returns current movie object
		return currentTV;
			
	}
	
	public static void mediaSearch(String search, Movies currentMovie, Media [] mediaHistory, int historyCount, TVShows currentTV) {
		// Allows the user to search for a movie
		// Takes a string from the main
		// Returns a statement depending on if the movie was found
		
		//Searches a for a movie
		String find = "“" + search + "”"; // adds quotations around the searched movie to allow the comparison to work correctly
		Movies movies = new Movies();
		TVShows shows = new TVShows();
		Scanner scan = new Scanner(System.in);
		
		movies.readMovies();
		shows.readShows();
		boolean found = false;
		
		// sorting through all the movies
		
		for (int i = 0; i < movies.all.length; i ++) {
			
			if (find.equalsIgnoreCase(movies.all[i].getTitle())) {
				
				System.out.println(movies.all[i].getTitle());
				
				System.out.println(movies.all[i].getYear() + ", " + movies.all[i].getDuration());
				
				System.out.println(movies.all[i].getDesc());
				
				currentMovie = movies.all[i];
				
				watchMovies(currentMovie, mediaHistory, historyCount);
				
				found = true;
		
				break;
				
			}
		}
			
			// sorting through all the TV shows
			
			for (int i = 0; i < shows.all.length; i ++) {
				
			if (find.equalsIgnoreCase(shows.all[i].getTitle())) {
				System.out.println(shows.all[i].getTitle());
				
				System.out.println(shows.all[i].getYear() + ", " + shows.all[i].getSeason());
				
				System.out.println(shows.all[i].getDesc());
				
				currentTV = shows.all[i];
				
				watchTV(currentTV, mediaHistory,historyCount);
				
				found = true;
		
				break;
			}
		}
		
		if (found == false) { //Specified Movie or TV Show not found
			
			System.out.println("Search not found!");
			
			//Asks the user to press enter to go back to main menu
			System.out.println("\nPress ENTER to continue!");
			scan.nextLine();
		}
	
		
	}
	
	public static int watchMovies(Movies currentMovie, Media [] mediaHistory, int historyCount) {
		// Asks the user if they want to watch the current movie that they selected
		// Takes an object array and integer variable from the main
		// Returns the number of movies/TV shows the user has watched
		
		//Declaring and Initializing User Input
		Scanner scan = new Scanner(System.in);
		
		//Asks the user if they would like to watch the movie
		System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
		System.out.println("\n\t\t1 - Watch");
		System.out.println("\t\t2 - Back to Movie Selection");
		System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
		int choice = scan.nextInt();
		
		if (choice == 1) { //User watches movie
			//Adds watched movie object to array
			mediaHistory[historyCount] = currentMovie;
			
			//Adds one to number of watched movies/TV shows history
			historyCount ++;
			
			//Displays a message saying that the user is watching the movie
			System.out.println("\nYou are watching: " + currentMovie.getTitle());
			
			//Adds watched movie to history
			addHistory(mediaHistory, historyCount);
			
			// displays image to indicate watching
			System.out.println("⠀⠀⢀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣄⣀⡀⠀⠀\n"
					+ "⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀\n"
					+ "⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀\n"
					+ "⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆\n"
					+ "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠈⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\n"
					+ "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⢈⣹⣿⣿⣿⣿⣿⣿⣿⡇\n"
					+ "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⢀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\n"
					+ "⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇\n"
					+ "⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀\n"
					+ "⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀\n"
					+ "⠀⠀⠈⠉⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠁⠀⠀");
			
			//Asks the user to press enter to finish the movie
			System.out.println("\nPress ENTER to finish watching the movie!: ");
			scan.nextLine();
			scan.nextLine();
	
		}
		
		//Returns number of movies/TV shows watched for history count
		return historyCount;
		
	}
	
	public static int watchTV(TVShows currentTV, Media [] mediaHistory, int historyCount) {
		// Asks the user if they want to watch the current TV that they selected
		// Takes an object array and integer variable from the main
		// Returns the number of movies/TV shows the user has watched
		
		//Declaring and Initializing User Input
		Scanner scan = new Scanner(System.in);
		
		//Asks the user if they would like to watch the movie
		System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
		System.out.println("\n\t\t1 - Watch");
		System.out.println("\t\t2 - Back to Movie Selection");
		System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
		int choice = scan.nextInt();
		
		if (choice == 1) { //User watches movie
			//Adds watched movie object to array
			mediaHistory[historyCount] = currentTV;
			
			//Adds one to number of watched movies/TV shows history
			historyCount ++;
			
			//Displays a message saying that the user is watching the movie
			System.out.println("\nYou are watching: " + currentTV.getTitle());
			
			// displays image to indicate watching
						System.out.println("⠀⠀⢀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣄⣀⡀⠀⠀\n"
								+ "⠀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀\n"
								+ "⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀\n"
								+ "⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆\n"
								+ "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠈⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\n"
								+ "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⢈⣹⣿⣿⣿⣿⣿⣿⣿⡇\n"
								+ "⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⢀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\n"
								+ "⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇\n"
								+ "⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀\n"
								+ "⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀\n"
								+ "⠀⠀⠈⠉⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠁⠀⠀");
			
			//Adds watched movie to history
			addHistory(mediaHistory, historyCount);
			
			//Asks the user to press enter to finish the movie
			System.out.println("\nPress ENTER to finish watching the show!: ");
			scan.nextLine();
			scan.nextLine();
	
		}
		
		//Returns number of movies/TV shows watched for history count
		return historyCount;
		
	}
	
	public static void addHistory(Media [] mediaHistory, int historyCount) {
		//When a user watches a movie it adds it to a history file
		//
		//
		//Creates a new history file
		// Try-with-resources to ensure the writer is closed properly
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("watch_history.txt", true))) {
            // For loop that writes names from the array into the text file
                writer.write(mediaHistory[(historyCount - 1)].getTitle() + "\n");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
     
        // Clear the mediaHistory array
        for (int i = 0; i < historyCount; i++) {
            mediaHistory[i] = null;
            
            mediaHistory[i] = new Media();
        }
        
	}
	
	public static void checkHistory() {
		// Allows the user to view their watch history
		// N/A
		// Reads from a file and displays the user's watch history
		
		//Displays the user's watch history
		System.out.println("\nWatch History for " + User.prof + ":");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("watch_history.txt"));
			String line;
			
			System.out.println("\n\n╔══════════════════════ ≪ °❈° ≫ ══════════════════════╗");
			while ((line = reader.readLine()) != null) {
				System.out.println("\t\t     " + line + "\n");
			}
			System.out.println("\n╚══════════════════════ ≪ °❈° ≫ ══════════════════════╝");
			reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

