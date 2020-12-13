package appointmentService;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import appointment.Appointment;


public class AppointmentService {
	
public static List<Appointment>Appointments = new ArrayList<>();
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

public boolean addAppointment(Appointment appointment) {
		
		boolean validateAppointment = false;
		for (Appointment obj : Appointments) {
			if(obj.equals(appointment)) {
				validateAppointment = true;
			}
		}
		if (!validateAppointment) {
			Appointments.add(appointment);
			return true;
		} else {
			return false;
		}
		
	}
public boolean update(String id, LocalDate date, String description) {
	for (Appointment obj: Appointments) {
		if(obj.getId().equals(id)) {
			if(id != null && id.length() <= 10)
			obj.setId(id);
			if(date != null && date.isBefore(LocalDate.now()))
			obj.setDate(date);
			if(description != null && description.length() <= 50)
			obj.setDescription(description);
			return true;
		}
	}
	return false;	
}
	
	public boolean deleteAppointment(String id) {
		for (Appointment obj : Appointments) {
			if(obj.getId().equals(id)) {
				Appointments.remove(obj);
			return true;
			}
		}
		return false;
	}
	

}
