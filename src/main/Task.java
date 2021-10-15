package main;

/*
 * Create Task object and attributes of the object
 * 
 * Includes getter and setter methods for each attribute
 */
public class Task {
	
	public String taskId;
	public String name;
	public String description;
	
	public Task() {
		taskId = "INITIAL";
		name = "INITIAL";
		description = "INITIAL DESCRIPTION";
	}
	
	public Task(String taskId) {
		checkTaskId(taskId);
		name = "INITIAL";
		description = "INITIAL DESCRIPTION";
	}
	
	public Task(String taskId, String name) {
		checkTaskId(taskId);
		setName(name);
		description = "INITIAL DESCRIPTION";
	}
	
	public Task(String taskId, String name, String description) {
		checkTaskId(taskId);
		setName(name);
		setDescription(description);
	}
	
	public final String getTaskId() {
		return taskId;
	}
	
	public final String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException(
					"Task name is invalid. Be sure that it is shorter than 20 characters and not left blank.");
		} else {
			this.name = name;
		}
	}
	
	public final String getDescription() {
		return description;
	}
	
	public void setDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException(
					"Task description is invalid. Be sure that it is shorter than 50 characters and not left blank.");
		} else {
			this.description = taskDescription;
		}
	}
	
	public void checkTaskId(String taskId) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException(
					"Error: The task ID was left blank or is longer than 10 characters.");
		} else {
			this.taskId = taskId;
		}
	}
}