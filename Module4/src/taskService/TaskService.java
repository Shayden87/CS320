package taskService;

import java.util.ArrayList;
import java.util.List;

import taskClass.Task;

public class TaskService {

	public static List<Task>Tasks = new ArrayList<>();
	
	public boolean addTask(Task task) {
		
		boolean validateTask = false;
		for (Task obj : Tasks) {
			if(obj.equals(task)) {
				validateTask = true;
			}
		}
		if (!validateTask) {
			Tasks.add(task);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteTask(String id) {
		for (Task obj : Tasks) {
			if(obj.getId().equals(id)) {
				Tasks.remove(obj);
			return true;
			}
		}
		return false;
	}
		
	public boolean update(String id, String name, String description) {
		for (Task obj: Tasks) {
			if(obj.getId().equals(id)) {
				if(id != null && id.length() <= 10)
				obj.setId(id);
				if(name != null && name.length() <= 20)
				obj.setName(name);
				if(description != null && description.length() <= 50)
				obj.setDescription(description);
				return true;
			}
		}
		return false;	
			
	}
}
