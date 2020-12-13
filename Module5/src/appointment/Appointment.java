package appointment;

import java.time.LocalDate;
import java.util.Comparator;


public class Appointment {
	
	// Initializing object parameters //
		private String id;
		private LocalDate date;
		private String description;
		
		//constructor//
		public Appointment(String id, LocalDate date, String description) {
			if(id == null || id.length() > 10) {
				throw new IllegalArgumentException("Invalid input");
			}
			if(date == null || date.isBefore(LocalDate.now())) {
				throw new IllegalArgumentException("Invalid date");
			}
			if(description == null || description.length() > 50) {
				throw new IllegalArgumentException("Invalid input");
			}
			this.id = id;
			this.date = date;
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
		
		//Getter for date parameter//
		public LocalDate getDate() {
			return date;
		}
		
		//Setter for date parameter//
		public void setDate(LocalDate date) {
			this.date = date;
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
			
			Appointment a = (Appointment) obj;
			return getId().equals(a.getId());
		}
		
		public static Comparator<Appointment> compareId = new Comparator<Appointment>() {
			
			public int compare(Appointment a1, Appointment a2) {
				return a1.getId().compareTo(a2.getId());
			}
		};
		
		 public String toString() {
		        return "Appointment ID: " + getId() + ", Date: " + getDate() + ", Description: " + getDescription() + "\n";
		    }

}
