package taskClass;

import java.util.Comparator;

public class Task {
	
	// Initializing object parameters //
	private String id;
	private String name;
	private String description;
	
	//constructor//
	public Task(String id, String name, String description) {
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid input");
		}
		if(name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid input");
		}
		if(description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid input");
		}
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	//Getter for id parameter//
	public String getId() {
		return id;
	}
	
	//Setter for id parameter//
	public void setId(String id) {
		this.id = id;
	}
	
	//Getter for name parameter//
	public String getName() {
		return name;
	}
	
	//Setter for id parameter//
	public void setName(String name) {
		this.name = name;
	}
		
	
	//Getter for description parameter//
	public String getDescription() {
		return description;
	}
	//Setter for id parameter//
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if(this.getClass() != obj.getClass())
			return false;
		
		Task a = (Task) obj;
		return getId().equals(a.getId());
	}
	
	public static Comparator<Task> compareId = new Comparator<Task>() {
		
		public int compare(Task a1, Task a2) {
			return a1.getId().compareTo(a2.getId());
		}
	};
	
	 public String toString() {
	        return "Task ID: " + getId() + ", Name: " + getName() + ", Description: " + getDescription() + "\n";
	    }

}
