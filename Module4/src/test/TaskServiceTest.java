package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskClass.Task;
import taskService.TaskService;

class TaskServiceTest {
	
	public static List<Task>Tasks = new ArrayList<>();

	@Test
	public void testTaskServiceAddTask() {
		TaskService services = new TaskService();
		Task a = new Task("00001", "Pick up Kids", "Kids get off school at 3PM");
		Task b = new Task("00002", "Go to Grocery", "Need Milk, Bread, and Cereal");
		Task c = new Task("00003", "File Paperwork", "Alphabetically and Chronologically");
		assertEquals(true, services.addTask(a));
		assertEquals(true, services.addTask(b));
		assertEquals(true, services.addTask(c));
	}
	
	@Test
	void testTaskServiceIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Task task = new Task("55502100000", "Contact Client", "Enables Client contact through the system");
		addTask(task);
		});
	}
	
	@Test
	void testTaskServiceIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Task task = new Task(null, "Contact Client", "Enables Client contact through the system");
		addTask(task);
		});
	}
	
	@Test
	void testTaskServiceNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Task task = new Task("55501", "Enter new Client into the System", "Enters new client information into the system");
		addTask(task);
		});
	}
	
	@Test
	void testTaskServiceNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Task task = new Task("55501", null, "Enters new client information into the system");
		addTask(task);
		});
	}
	
	@Test
	void testTaskServiceDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Task task = new Task("55501", "Contact Client", "Enables Client contact through the system again and again and again and again");
		addTask(task);
		});
	}
	
	@Test
	void testTaskServiceDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> {
		Task task = new Task("55501", "Contact Client", null);
		addTask(task);
		});
	}
	
	@Test
	void testTaskServiceIdExists() {
		Task task = new Task("55501", "Enter Clients", "Enters new client information into the system");
		addTask(task);
		System.out.println("Entries remaining " + Tasks.size());
	}
	
	@Test
	void testTaskServiceUpdateTask() {
		TaskService services = new TaskService();
		Task a = new Task("00004", "Take out trash", "Include recyclibles");
		Task b = new Task("00005", "Clean room", "Make sure to dust all surfaces");
		Task c = new Task("00006", "Wash Clothes", "Seperate colors from whites");
		assertEquals(true, services.addTask(a));
		assertEquals(true, services.addTask(b));
		assertEquals(true, services.addTask(c));
		
		assertEquals(true, services.update("00004", "Take out trash", "Do not include recyclibles"));
		assertEquals(true, services.update("00006", "Wash Clothes", "Seperate colors from whites, bleach whites"));
	
	}
	@Test
	void testContactServiceDeleteTask() {
		TaskService services = new TaskService();
		Task a = new Task("00007", "Cook Dinner", "Lasagne and Broccoli");
		Task b = new Task("00008", "Do Dishes", "Pre-Rinse and make sure to put away");
		Task c = new Task("00009", "Homework", "Start Lesson 4 for Microbiology");
		assertEquals(true, services.addTask(a));
		assertEquals(true, services.addTask(b));
		assertEquals(true, services.addTask(c));
		
		assertEquals(true, services.deleteTask("00009"));
		assertEquals(true, services.deleteTask("00008"));	
	}
	
	@Test
    public void testToString() {
        Task t1 = new Task("55502", "Contact Client", "Enables Client contact through the system"); 
        String expected = "Task ID: 55502, Name: Contact Client, Description: Enables Client contact through the system\n";
        Assert.assertEquals(expected, t1.toString());
    }
	
	@Test 
	public void equalsFalseTest1() {
	    Task t1 = new Task("Randomly", "Entered", "Test Answers");
	    Object obj = new Object();
	    Assert.assertNotEquals(t1, obj);
	}
	
	@Test 
	public void equalsFalseTest2() {
	    Task t1 = new Task("Randomly", "Entered", "Test Answers");
	    Task t2 = new Task("Randoml", "Entered", "Test Answers");
	    Assert.assertNotEquals(t1, t2);
	}
	
	@Test 
	public void equalsTrueTest() {
		Task t1 = new Task("Randomly", "Entered", "Test Answers");
	    Task t2 = new Task("Randomly", "Entered", "Test Answers");
	    Assert.assertEquals(t1, t2);
	}
	 
	public int getIndex(Task task) {
	     int index = Collections.binarySearch(Tasks, task, Task.compareId);
	     return index;
	    }
	 
	 public boolean addTask(Task task) {
		 int index = getIndex(task);
		 
		 if(index < 0 && validateId(task.getId()) && validateName(task.getName()) && validateDescription(task.getDescription())) {
			 Tasks.add(task);
			 return true;
		 }
		 
		 return false;
	 }
	 
	 public void deleteTask(String id) {
		 int index = getIndex(new Task(id,"",""));
		 
		 if(index >= 0)
			 Tasks.remove(index);
	 }
	 
	 public boolean validateId(String id) {
		 if(id != null && id.length() <= 10)
			 return true;
		 
		 return false;
	 }
	 public boolean validateName(String name) {
		 if(name != null && name.length() <= 20)
			 return true;
		 
		 return false;
	 }
	 public boolean validateDescription(String description) {
		 if(description != null && description.length() <= 50)
			 return true;
		 
		 return false;
	 }
	 
	 
		

}
