package Netflix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Random;

public class Movies extends Media{
	
	 String duration;
	
	 Movies [] all = new Movies[90];
	
	Movies [] action =  new Movies[10];

	 Movies [] children = new Movies[10];

	 Movies [] comedy = new Movies[10];

	 Movies [] documentary = new Movies[10];

	 Movies [] horror = new Movies[10];

	 Movies [] musical = new Movies[10];
 Movies [] romance = new Movies[10];

	 Movies [] fantasy = new Movies[10];

	 Movies [] sport = new Movies[10];
	
	// Constructor method
	
	public Movies () {
		
		super(); // calls on the constructor from the media class
		
		duration = ""; 
		
	}
	
	// modifier method, sets the duration of the movie
	
	public void setDuration(String newDuration) {
		
		duration = newDuration;
	}
	
	// accessor method, returns the 
	public String getDuration() {
		
		return duration;
	}
	
	/* Pre: Must have a text file of movies to read from
	 * Post: All movies are read from the file and separated into categories
	 * Action: Creates arrays for each category, reads movies from a text file and stores the information for each movie into their respective genres arrays,
	 */
	
	public void readMovies() {
		
		int count = 0, countAll = 0;
		
		// initializing arrays
		for (int i = 0; i < all.length; i ++) {
			
			all[i] = new Movies();
		}
		
		for (int i = 0 ; i < action.length; i ++) {
			
			action[i] = new Movies();
			
			children[i] = new Movies();
			
			comedy[i] = new Movies();
			
			documentary[i] = new Movies();
			
			horror[i] = new Movies();
			
			musical[i] = new Movies();
			
			romance[i] = new Movies();
			
			fantasy[i] = new Movies();
			
			sport[i] = new Movies();

		}
			try (BufferedReader reader = new BufferedReader(new FileReader("Movies.txt"))) {
	            String line;
	            
	            reader.readLine();
	           
	            // once the reader reaches the next category it stops and moves on to the next while loop for the next category
	            while ((line = reader.readLine()) != null && count < action.length) {
	            	
	            	String[] parts = line.split("!");
	           
	                    String title = (parts[0].trim());
	                    int year = Integer.parseInt(parts[1].trim());
	                    String duration = (parts[2]);
	                    String descriptoin = (parts[3]);
	                   
	                 // Create a new Movies object
	                    Movies actions = new Movies();
	                    actions.setTitle(title);
	                   
	                    actions.setYear(year);
	                    actions.setDescription(descriptoin);
	                    actions.setDuration(duration);
	                  
	                   
	                 // Assign the movie object to the array
	                    action[count] = actions;
	                    all[countAll] = actions; // adds to an array of all movies
	                    
	                    countAll++;
	                    count++;
	               
	            }
	          
	            count = 0;
	            
	            // creating CHILDREN category
	            
	            reader.readLine();
	            
	            while ((line = reader.readLine()) != null && count < children.length) {
	                
	            	
	            	String[] parts = line.split("!");
	 	           
                    String title = (parts[0].trim());
                    int year = Integer.parseInt(parts[1].trim());
                    String duration = (parts[2]);
                    String descriptoin = (parts[3]);
                   
                 // Create a new Movies object
                    Movies childrens = new Movies();
                    childrens.setTitle(title);
                    childrens.setYear(year);
                    childrens.setDescription(descriptoin);
                    childrens.setDuration(duration);
                  
                 // Assign the movie object to the array
                    children[count] = childrens;
                    all[countAll] = childrens;
                    countAll ++;
                    count++;
	            }
	            
	            count = 0;
	            // creating COMEDIE category
	            reader.readLine();
	            while ((line = reader.readLine()) != null && count < children.length) {
	               

	            	String[] parts = line.split("!");
	 	           
                    String title = (parts[0].trim());
                    int year = Integer.parseInt(parts[1].trim());
                    String duration = (parts[2]);
                    String descriptoin = (parts[3]);
                   
                 // Create a new Movies object
                    Movies comedies = new Movies();
                    comedies.setTitle(title);
                    comedies.setYear(year);
                    comedies.setDescription(descriptoin);
                    comedies.setDuration(duration);
                  
                 // Assign the movie object to the array
                    comedy[count] = comedies;
                    all[countAll] = comedies;
                    countAll ++;
                    count++;
	            }
	            
	            // filling documentary category
	            count = 0;
	            reader.readLine();
	            while ((line = reader.readLine()) != null && count < musical.length) {
	            	
	            	String[] parts = line.split("!");
	 	           
                    String title = (parts[0].trim());
                    int year = Integer.parseInt(parts[1].trim());
                    String duration = (parts[2]);
                    String descriptoin = (parts[3]);
                   
                 // Create a new Movies object
                    Movies docs = new Movies();
                    docs.setTitle(title);
                    docs.setYear(year);
                    docs.setDescription(descriptoin);
                    docs.setDuration(duration);
                  
                 // Assign the movie object to the array
                    documentary[count] = docs;
                    all[countAll] = docs;
                    countAll ++;
                    count++;
	            }
	            
	            count = 0;
	            
	            // filling HORROR category
	            
	            reader.readLine();
	            
	            while ((line = reader.readLine()) != null && count < horror.length) {
	                
	            	
	            	String[] parts = line.split("!");
	 	           
                    String title = (parts[0].trim());
                    int year = Integer.parseInt(parts[1].trim());
                    String duration = (parts[2]);
                    String descriptoin = (parts[3]);
                   
                 // Create a new Movies object
                    Movies horrors = new Movies();
                    horrors.setTitle(title);
                    horrors.setYear(year);
                    horrors.setDescription(descriptoin);
                    horrors.setDuration(duration);
                  
                 // Assign the movie object to the array
                    horror[count] = horrors;
                    all[countAll] = horrors;
                    countAll ++;
                    count++;
	            }
	            
	            count = 0;
	            
	            // filling MUSCIAL category
	            
	            reader.readLine();
	   
	            
	            while ((line = reader.readLine()) != null && count < musical.length) {
	                
	            	
	            	String[] parts = line.split("!");

                    String title = (parts[0].trim());
                    int year = Integer.parseInt(parts[1].trim());
                    String duration = (parts[2]);
                    String descriptoin = (parts[3]);
                   
                 // Create a new Movies object
                    Movies music = new Movies();
                    music.setTitle(title);
                    music.setYear(year);
                    music.setDescription(descriptoin);
                    music.setDuration(duration);
                  
                 // Assign the movie object to the array
                    musical[count] = music;
                    all[countAll] = music;
                    countAll ++;
                    count++;
	            }
	            
	            count = 0;
	            
	            // filling ROMANCE category
	            
	            reader.readLine();
	   
	            
	            while ((line = reader.readLine()) != null && count < romance.length) {
	                
	            	
	            	String[] parts = line.split("!");

                    String title = (parts[0].trim());
                    int year = Integer.parseInt(parts[1].trim());
                    String duration = (parts[2]);
                    String descriptoin = (parts[3]);
                   
                 // Create a new Movies object
                    Movies roms = new Movies();
                    roms.setTitle(title);
                    roms.setYear(year);
                    roms.setDescription(descriptoin);
                    roms.setDuration(duration);
                  
                 // Assign the movie object to the array
                    romance[count] = roms;
                    all[countAll] = roms;
                    countAll ++;
                    count++;
	            }
	            
	            count = 0;
	            
	            // filling FANTASY category
	            
	            reader.readLine();
	   
	            
	            while ((line = reader.readLine()) != null && count < fantasy.length) {
	                
	            	
	            	String[] parts = line.split("!");

                    String title = (parts[0].trim());
                    int year = Integer.parseInt(parts[1].trim());
                    String duration = (parts[2]);
                    String descriptoin = (parts[3]);
                   
                 // Create a new Movies object
                    Movies fant = new Movies();
                    fant.setTitle(title);
                    fant.setYear(year);
                    fant.setDescription(descriptoin);
                    fant.setDuration(duration);
                  
                 // Assign the movie object to the array
                    fantasy[count] = fant;
                    all[countAll] = fant;
                    countAll ++;
                    count++;
	            }
	            
	            count = 0;
	         
	            
	            reader.readLine();
	            
	            while ((line = reader.readLine()) != null && count < sport.length) {
	                
	            	
	            	String[] parts = line.split("!");
	 	           
                    String title = (parts[0].trim());
                    int year = Integer.parseInt(parts[1].trim());
                    String duration = (parts[2]);
                    String descriptoin = (parts[3]);
                   
                 // Create a new Movies object
                    Movies s = new Movies();
                    s.setTitle(title);
                    s.setYear(year);
                    s.setDescription(descriptoin);
                    s.setDuration(duration);
                  
                 // Assign the movie object to the array
                    sport[count] = s;
                    all[countAll] = s;
                    countAll ++;
                    count++;
                    
             
                    
	            }
                    
	            } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
             } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
	
	/* Pre: Must have action movies stored in an array
	 * Post: Action movies are displayed in a random order
	 * Action: Randomly shuffles the array of action movies by swapping random indexes, then printing the movies 
	 */
	
	public void displayAction() {
		
		Random r = new Random();
		
		boolean[] actionSelected = new boolean[action.length]; // Initialize array to track selected movies
	
		// Shuffle the action movies array
		for (int i = 0; i < action.length; i++) {
		    int randomIndex;
		    do {
		        randomIndex = r.nextInt(action.length);
		    } while (actionSelected[randomIndex]); // Check if movie at randomIndex has already been selected
		    actionSelected[randomIndex] = true; // Mark movie at randomIndex as selected
		    Movies temp = action[i];
		    action[i] = action[randomIndex];
		    action[randomIndex] = temp;
		}
		// Print the shuffled movies
		System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║                                              𝐀𝐂𝐓𝐈𝐎𝐍 𝐌𝐎𝐕𝐈𝐄𝐒                                                            ║");
		System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
		 
		for (int i = 0; i < 5; i++) {
		    System.out.print("║ " + action[i].getTitle() + " ║  ");
		}
		System.out.println();
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
	            
	}
	
	/* Pre: Must have children movies stored in an array
	 * Post: Children movies are displayed in a random order
	 * Action: Randomly shuffles the array of children movies by swapping random indexes, then printing the movies 
	 */
	
	public void displayChildren() {
		
		Random r = new Random();
	
			boolean[] childrenSelected = new boolean[children.length];
			
			for (int i = 0; i < children.length; i++) {
			    int randomIndex;
			    do {
			        randomIndex = r.nextInt(children.length);
			    } while (childrenSelected[randomIndex]); // Check if movie at randomIndex has already been selected
			    childrenSelected[randomIndex] = true; // Mark movie at randomIndex as selected
			    Movies temp = children[i];
			    children[i] = children[randomIndex];
			    children[randomIndex] = temp;
			}
				// Print the shuffled movies
			 	System.out.println();
	            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
	    		System.out.println("║                                              𝐂𝐇𝐈𝐋𝐃𝐑𝐄𝐍 𝐌𝐎𝐕𝐈𝐄𝐒                                                         ║");
	    		System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
	    		 
	    		for (int i = 0; i < 5; i++) {
	    		    System.out.print("║ " + children[i].getTitle() + " ║  ");
	    		}
	    		System.out.println();
	    		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
	    	            
			 
	}
	/* Pre: Must have comedy movies stored in an array
	 * Post: Comedy movies are displayed in a random order
	 * Action: Randomly shuffles the array of comedy movies by swapping random indexes, then printing the movies 
	 */
	public void displayComedy() {
		
			Random r = new Random();
			
			boolean[] comedySelect = new boolean[comedy.length];
			
			for (int i = 0; i < comedy.length; i++) {
			    int randomIndex;
			    do {
			        randomIndex = r.nextInt(comedy.length);
			    } while (comedySelect[randomIndex]); // Check if movie at randomIndex has already been selected
			    comedySelect[randomIndex] = true; // Mark movie at randomIndex as selected
			    Movies temp = comedy[i];
			    comedy[i] = comedy[randomIndex];
			    comedy[randomIndex] = temp;
			}
			
				// Print the shuffled movies
				 	System.out.println();
		            System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
		    		System.out.println("║                                                𝐂𝐎𝐌𝐄𝐃𝐘 𝐌𝐎𝐕𝐈𝐄𝐒                                                         ║");
		    		System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
		    		 
		    		
		    		for (int i = 0; i < 5; i++) {
		    		    System.out.print("║ " + comedy[i].getTitle() + " ║  ");
		    		}
		    		System.out.println();
		    		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
		    	            
	}
	
	/* Pre: Must have documentary movies stored in an array
	 * Post: Documentary movies are displayed in a random order
	 * Action: Randomly shuffles the array of documentary movies by swapping random indexes, then printing the movies 
	 */
	
	public void displayDoc() {
		
		Random r = new Random();
		
			boolean[] docSelect = new boolean[documentary.length];
			
			for (int i = 0; i < documentary.length; i++) {
			    int randomIndex;
			    do {
			        randomIndex = r.nextInt(documentary.length);
			    } while (docSelect[randomIndex]); // Check if movie at randomIndex has already been selected
			    docSelect[randomIndex] = true; // Mark movie at randomIndex as selected
			    Movies temp = documentary[i];
			    documentary[i] = documentary[randomIndex];
			    documentary[randomIndex] = temp;
			}
			

			// Print the shuffled action movies
		System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║                                                             𝐃𝐎𝐂𝐔𝐌𝐄𝐍𝐓𝐀𝐑𝐘 𝐌𝐎𝐕𝐈𝐄𝐒                                                                 ║");
		System.out.println("║  ---------------------------------------------------------------------------------------------------------------------------------------------    ║");
		
		for (int i = 0; i < 5; i++) {
		    System.out.print("║ " + documentary[i].getTitle() + " ║  ");
		}
		System.out.println();
		System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
	       
	}

	/* Pre: Must have horror movies stored in an array
	 * Post: Horror movies are displayed in a random order
	 * Action: Randomly shuffles the array of horror movies by swapping random indexes, then printing the movies 
	 */
	
	public void displayHorror() {
		
		Random r = new Random();
	
			boolean[] horrorSelect = new boolean[horror.length];
			
			for (int i = 0; i < horror.length; i++) {
			    int randomIndex;
			    do {
			        randomIndex = r.nextInt(horror.length);
			    } while (horrorSelect[randomIndex]); // Check if movie at randomIndex has already been selected
			    horrorSelect[randomIndex] = true; // Mark movie at randomIndex as selected
			    Movies temp = horror[i];
			    horror[i] = horror[randomIndex];
			    horror[randomIndex] = temp;
			}
			
			// printing the movies
			System.out.println();
	        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("║                                                   𝐇𝐎𝐑𝐑𝐎𝐑 𝐌𝐎𝐕𝐈𝐄𝐒                                                      ║");
			System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
			 
			for (int i = 0; i < 5; i++) {
			    System.out.print("║ " + horror[i].getTitle() + " ║  ");
			}
			System.out.println();
			System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
		      
	}
	

	/* Pre: Must have musical movies stored in an array
	 * Post: Musical movies are displayed in a random order
	 * Action: Randomly shuffles the array of musical movies by swapping random indexes, then printing the movies 
	 */
	
	
	public void displayMusical() {
		

		Random r = new Random();
	
			
			boolean[] musicalSelect = new boolean[action.length];

			for (int i = 0; i < musical.length; i++) {
			    int randomIndex;
			    do {
			        randomIndex = r.nextInt(musical.length);
			    } while (musicalSelect[randomIndex]); // Check if movie at randomIndex has already been selected
			    musicalSelect[randomIndex] = true; // Mark movie at randomIndex as selected
			    Movies temp = musical[i];
			    musical[i] = musical[randomIndex];
			    musical[randomIndex] = temp;
			}
// print the shuffled movies
			System.out.println();
	        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("║                                                   𝐌𝐔𝐒𝐈𝐂𝐀𝐋 𝐌𝐎𝐕𝐈𝐄𝐒                                                      ║");
			System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
			 
			for (int i = 0; i < 5; i++) {
			    System.out.print("║ " + musical[i].getTitle() + " ║  ");
			}
			System.out.println();
			System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
	}

	/* Pre: Must have romance movies stored in an array
	 * Post: Romance movies are displayed in a random order
	 * Action: Randomly shuffles the array of romance movies by swapping random indexes, then printing the movies 
	 */
	
	public void displayRomance() {
		

		Random r = new Random();
			
			boolean[] romanceSelect = new boolean[romance.length];

			for (int i = 0; i < romance.length; i++) {
			    int randomIndex;
			    do {
			        randomIndex = r.nextInt(romance.length);
			    } while (romanceSelect[randomIndex]); // Check if movie at randomIndex has already been selected
			    romanceSelect[randomIndex] = true; // Mark movie at randomIndex as selected
			    Movies temp = romance[i];
			    romance[i] = romance[randomIndex];
			    romance[randomIndex] = temp;
			}
// print the shuffled movies
			System.out.println();
	        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("║                                                   𝐑𝐎𝐌𝐀𝐍𝐂𝐄 𝐌𝐎𝐕𝐈𝐄𝐒                                                     ║");
			System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
			 
			for (int i = 0; i < 5; i++) {
			    System.out.print("║ " + romance[i].getTitle() + " ║  ");
			}
			System.out.println();
			System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

	}

	/* Pre: Must have fantasy movies stored in an array
	 * Post: Fantasy movies are displayed in a random order
	 * Action: Randomly shuffles the array of fantasy movies by swapping random indexes, then printing the movies 
	 */
	
	public void displayFantasy() {
		

		Random r = new Random();
	
			boolean[] fantasySelect = new boolean[fantasy.length];

			for (int i = 0; i < fantasy.length; i++) {
			    int randomIndex;
			    do {
			        randomIndex = r.nextInt(fantasy.length);
			    } while (fantasySelect[randomIndex]); // Check if movie at randomIndex has already been selected
			    fantasySelect[randomIndex] = true; // Mark movie at randomIndex as selected
			    Movies temp = fantasy[i];
			    fantasy[i] = fantasy[randomIndex];
			    fantasy[randomIndex] = temp;
			}
			
			// print the shuffled movies
			System.out.println();
	        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("║                                                   𝐅𝐀𝐍𝐓𝐀𝐒𝐘 𝐌𝐎𝐕𝐈𝐄𝐒                                                     ║");
			System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
			 
			for (int i = 0; i < 5; i++) {
			    System.out.print("║ " + fantasy[i].getTitle() + " ║  ");
			}
			System.out.println();
			System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

	}
	

	/* Pre: Must have sport movies stored in an array
	 * Post: Sports movies are displayed in a random order
	 * Action: Randomly shuffles the array of sport movies by swapping random indexes, then printing the movies 
	 */
	
	
	public void displaySports() {

		Random r = new Random();
	
			boolean[] sportsSelect = new boolean[sport.length];

			for (int i = 0; i < sport.length; i++) {
			    int randomIndex;
			    do {
			        randomIndex = r.nextInt(sport.length);
			    } while (sportsSelect[randomIndex]); // Check if movie at randomIndex has already been selected
			    sportsSelect[randomIndex] = true; // Mark movie at randomIndex as selected
			    Movies temp = sport[i];
			    sport[i] = sport[randomIndex];
			    sport[randomIndex] = temp;
			}
			// print shuffled movies
			System.out.println();
	        System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
			System.out.println("║                                                   𝐒𝐏𝐎𝐑𝐓 𝐌𝐎𝐕𝐈𝐄𝐒                                                        ║");
			System.out.println("║  ------------------------------------------------------------------------------------------------------------------    ║");
			 
			for (int i = 0; i < 5; i++) {
			    System.out.print("║ " + sport[i].getTitle() + " ║  ");
			}
			System.out.println();
			System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");

		}
}
