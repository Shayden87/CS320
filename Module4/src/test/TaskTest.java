package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import taskClass.Task;

public class TaskTest {

	// Test that we can create new task object through Task class //
	@Test
	void testTask() {
		Task task = new Task("52567", "Change Order", "changes customer order");
		assertTrue(task.getId().equals("52567"));
		assertTrue(task.getName().equals("Change Order"));
		assertTrue(task.getDescription().equals("changes customer order"));
	}
	
	// Test to determine if illegal argument exception is being thrown for id length greater than 10 //
	@Test
	void testIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("42684657971", "Change Order", "changes customer order");
		});
	}
	
	// Test to determine if illegal argument exception is being thrown for id being null //
	@Test
	void testIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Change Order", "changes customer order");
		});
	}
	
	// Test to determine if illegal argument exception is being thrown for name length greater than 20 //
	@Test
	void testNameToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("52567", "Change Order in the Sytem", "changes customer order");
		});
	}
	
	// Test to determine if illegal argument exception is being thrown for name being null //
	@Test
	void testNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("52567", null, "changes customer order");
		});
	}
	
	// Test to determine if illegal argument exception is being thrown for description length greater than 50 //
	@Test
	void testDescriptionToLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("52567", "Change Order", "changes customer order to account for the request made");
		});
	}
	
	// Test to determine if illegal argument exception is being thrown for description being null //
	@Test
	void testDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("52567", "Change Order", null);
		});
	}
	
	@Test
    public void testToString() {
        Task t1 = new Task("55502", "Contact Client", "Enables Client contact through the system"); 
        String expected = "Task ID: 55502, Name: Contact Client, Description: Enables Client contact through the system\n";
        Assert.assertEquals(expected, t1.toString());
    }
	
	@Test public void equalsFalseTest1() {
	    Task t1 = new Task("Randomly", "Entered", "Test Answers");
	    Object obj = new Object();
	    Assert.assertNotEquals(t1, obj);
	}
	
	@Test public void equalsFalseTest2() {
	    Task t1 = new Task("Randomly", "Entered", "Test Answers");
	    Task t2 = new Task("Randomly", "Entered", "Test Answers");
	    Assert.assertNotEquals(t1, t2);
	}
	
	@Test public void equalsTrueTest() {
		Task t1 = new Task("Randomly", "Entered", "Test Answers");
	    Task t2 = new Task("Randomly", "Entered", "Test Answers");
	    Assert.assertEquals(t1, t2);
	}
	
	

}
