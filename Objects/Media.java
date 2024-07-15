package Netflix;

public class Media {
	
	 String title;

	 int year;
	
	 String description;


	// Constructor method, sets all variables to a standard initial value
	
	public Media () {
		
		title = "";

		year = 0;
		
		description = "";
	}

	// Modifier methods
	public void setTitle(String newTitle) {
		
		title = newTitle;
	}

	
	public void setYear(int newYear) {
		
		year = newYear;
	}
	
	public void setDescription(String newDescription) {
		
		description = newDescription;
		
	}
	
	//Accessor methods
	public String getTitle() {
		
		return title;
	}
	
	
	public int getYear() {
		
		return year;
	}
	
	public String getDesc () {
		
		return description;
	}
	
	
		
}
