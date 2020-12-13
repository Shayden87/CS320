package test;

import static org.junit.jupiter.api.Assertions.*;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.Appointment;

class AppointmentTest {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			@Test
			void testAppointment() {
				Appointment appointment = new Appointment("52567", LocalDate.of(2021, Month.DECEMBER , 6), "Dinner with Margo");
				assertTrue(appointment.getId().equals("52567"));
				assertTrue(appointment.getDate().equals(LocalDate.of(2021, Month.DECEMBER , 6)));
				assertTrue(appointment.getDescription().equals("Dinner with Margo"));
			}
		
			// Test to determine if illegal argument exception is being thrown for id length greater than 10 //
			@Test
			void testIdTooLong() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					new Appointment("42684657971", LocalDate.of(2021, Month.DECEMBER , 6), "Dinner with Margo");
				});
			}
		
			// Test to determine if illegal argument exception is being thrown for id being null //
			@Test
			void testIdNull() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					new Appointment(null, LocalDate.of(2021, Month.DECEMBER , 6), "Dinner with Margo");
				});
			}
		
			// Test to determine if illegal argument exception is being thrown for name length greater than 20 //
			@Test
			void testDateIsPast() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					new Appointment("52567", LocalDate.of(2015, Month.DECEMBER , 1), "Dinner with Margo");
				});
			}
		
			// Test to determine if illegal argument exception is being thrown for name being null //
			@Test
			void testDateNull() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					new Appointment("52567", null, "Dinner with Margo");
				});
			}
		
			// Test to determine if illegal argument exception is being thrown for description length greater than 50 //
			@Test
			void testDescriptionToLong() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					new Appointment("52567", LocalDate.of(2021, Month.DECEMBER , 1), "Vacation to the Carribean, then head back to New York for Board Meeting with the Partners");
				});
			}
		
			// Test to determine if illegal argument exception is being thrown for description being null //
			@Test
			void testDescriptionNull() {
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					new Appointment("52567", LocalDate.of(2021, Month.DECEMBER , 1), null);
				});
			}
		
			@Test
			public void testToString() {
				Appointment t1 = new Appointment("55502", LocalDate.of(2021, Month.DECEMBER , 6), "Dinner with Margo"); 
					String expected = "Appointment ID: 55502, Date: 2021-12-06, Description: Dinner with Margo\n";
						Assert.assertEquals(expected, t1.toString());
			}
		
			@Test 
			public void equalsFalseTest1() {
				Appointment t1 = new Appointment("Randomly",  LocalDate.of(2021, Month.DECEMBER , 1), "Dinner with Margo");
				Object obj = new Object();
					Assert.assertNotEquals(t1, obj);
			}
		
			@Test 
			public void equalsFalseTest2() {
				Appointment t1 = new Appointment("Randomly",  LocalDate.of(2021, Month.DECEMBER , 1), "Dinner with Margo");
				Appointment t2 = new Appointment("Randoml",  LocalDate.of(2021, Month.DECEMBER , 1), "Dinner with Margo");
					Assert.assertNotEquals(t1, t2);
			}
		
			@Test 
			public void equalsTrueTest() {
				Appointment t1 = new Appointment("Randomly",  LocalDate.of(2021, Month.DECEMBER , 1), "Dinner with Margo");
				Appointment t2 = new Appointment("Randomly",  LocalDate.of(2021, Month.DECEMBER , 1), "Dinner with Margo");
					Assert.assertEquals(t1, t2);
			}
			
		}
