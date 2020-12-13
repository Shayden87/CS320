package test;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import appointmentService.AppointmentService;


class AppointmentServiceTest {

	public static List<Appointment>Appointments = new ArrayList<>();

	@Test
	public void testContactServiceAddAppointment() {
		AppointmentService services = new AppointmentService();
		Appointment a = new Appointment("00001", LocalDate.of(2021, Month.DECEMBER , 1), "Coffee with Brian");
		Appointment b = new Appointment("00002", LocalDate.of(2021, Month.DECEMBER , 3), "Coffee with Allison");
		Appointment c = new Appointment("00003", LocalDate.of(2021, Month.DECEMBER , 4), "Coffee with Sabrina");
		assertEquals(true, services.addAppointment(a));
		assertEquals(true, services.addAppointment(b));
		assertEquals(true, services.addAppointment(c));
	}
	
	@Test
	void testAppointmentIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Appointment appointment = new Appointment("55502100000", LocalDate.of(2021, Month.DECEMBER , 1), "Business Meeting with share holders");
		addAppointment(appointment);
		});
	}
	
	@Test
	void testAppointmentIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Appointment appointment = new Appointment(null, LocalDate.of(2021, Month.DECEMBER , 1), "Pickup Parents from Airport");
		addAppointment(appointment);
		});
	}
	
	@Test
	void testAppointmentDateInPast() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Appointment appointment = new Appointment("55501", LocalDate.of(2015, Month.DECEMBER , 1), "Pickup Dry-cleaning");
		addAppointment(appointment);
		});
	}
	
	@Test
	void testAppointmentDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Appointment appointment = new Appointment("55501", null, "Investment Opportunity Meeting");
		addAppointment(appointment);
		});
	}
	
	@Test
	void testAppointmentDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Appointment appointment = new Appointment("55501", LocalDate.of(2021, Month.DECEMBER , 1), "Vacation to the Carribean, then head back to New York for Board Meeting with the Partners");
		addAppointment(appointment);
		});
	}
	
	@Test
	void testAppointmentDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Appointment appointment = new Appointment("55501", LocalDate.of(2021, Month.DECEMBER , 1), null);
		addAppointment(appointment);
		});
	}
	
	@Test
	void testAppointmentServiceIdExists() {
		Appointment appointment = new Appointment("55501", LocalDate.of(2021, Month.DECEMBER , 1), "Vacation to the Carribean");
		addAppointment(appointment);
		System.out.println("Entries remaining " + Appointments.size());
	}
	
	@Test
	void testContactServiceUpdateAppointment() {
		AppointmentService services = new AppointmentService();
		Appointment a = new Appointment("00004", LocalDate.of(2021, Month.DECEMBER , 5), "Coffee with Kristen");
		Appointment b = new Appointment("00005", LocalDate.of(2021, Month.DECEMBER , 6), "Coffee with Carlos");
		Appointment c = new Appointment("00006", LocalDate.of(2021, Month.DECEMBER , 7), "Coffee with Dennis");
		assertEquals(true, services.addAppointment(a));
		assertEquals(true, services.addAppointment(b));
		assertEquals(true, services.addAppointment(c));
		
		assertEquals(true, services.update("00005", LocalDate.of(2021, Month.DECEMBER , 6), "Dinner with Carlos"));
		assertEquals(true, services.update("00006", LocalDate.of(2021, Month.DECEMBER , 7), "Dinner with Dennis"));
	
	}
	@Test
	void testContactServiceDeleteAppointment() {
		AppointmentService services = new AppointmentService();
		Appointment a = new Appointment("00007", LocalDate.of(2021, Month.DECEMBER , 8), "Meeting with Carla");
		Appointment b = new Appointment("00008", LocalDate.of(2021, Month.DECEMBER , 9), "Meeting with Joe");
		Appointment c = new Appointment("00009", LocalDate.of(2021, Month.DECEMBER , 10), "Meeting with Ashley");
		assertEquals(true, services.addAppointment(a));
		assertEquals(true, services.addAppointment(b));
		assertEquals(true, services.addAppointment(c));
		
		assertEquals(true, services.deleteAppointment("00009"));
		assertEquals(true, services.deleteAppointment("00008"));	
	}
	@Test
	public void testToString() {
		 Appointment t1 = new Appointment("55502", LocalDate.of(2020, Month.DECEMBER , 12), "Dinner with Margo"); 
	     String expected = "Appointment ID: 55502, Date: 2020-12-12, Description: Dinner with Margo\n";
	     Assert.assertEquals(expected, t1.toString());
	}
	@Test 
	public void equalsFalseTest1() {
		 Appointment t1 = new Appointment("Randomly", LocalDate.of(2020, Month.DECEMBER , 12), "Dinner with Margo");
		 Object obj = new Object();
		 Assert.assertNotEquals(t1, obj);
	}
	@Test 
	public void equalsFalseTest2() {
		Appointment t1 = new Appointment("Randomly", LocalDate.of(2020, Month.DECEMBER , 12), "Dinner with Margo");
		Appointment t2 = new Appointment("Randoml", LocalDate.of(2020, Month.DECEMBER , 12), "Dinner with Margo");
		Assert.assertNotEquals(t1, t2);
	}
	@Test 
	public void equalsTrueTest() {
		Appointment t1 = new Appointment("Randomly", LocalDate.of(2020, Month.DECEMBER , 12), "Dinner with Margo");
		Appointment t2 = new Appointment("Randomly", LocalDate.of(2020, Month.DECEMBER , 12), "Dinner with Margo");
		Assert.assertEquals(t1, t2);
	}
		
	public int getIndex(Appointment appointment) {
	     int index = Collections.binarySearch(Appointments, appointment, Appointment.compareId);
	     return index;
	    }
	 
	 public boolean addAppointment(Appointment appointment) {
		 int index = getIndex(appointment);
		 
		 if(index < 0 && validateId(appointment.getId()) && validateDate(appointment.getDate()) && validateDescription(appointment.getDescription())) {
			 Appointments.add(appointment);
			 return true;
		 }
		 
		 return false;
	 }
	 
	 public boolean validateId(String id) {
		 if(id != null && id.length() <= 10)
			 return true;
		 
		 return false;
	 }
	 public boolean validateDate(LocalDate date) {
		 if(date != null && date.isBefore(LocalDate.now()))
			 return true;
		 
		 return false;
	 }
	 public boolean validateDescription(String description) {
		 if(description != null && description.length() <= 50)
			 return true;
		 
		 return false;
	 }
	 
	
	
}
