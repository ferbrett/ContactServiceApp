package main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
 * Create Task Service object in which the following functions are provided:
 * 
 * (1) Create new task
 * (2) Update task
 * (3) Delete task
 */
public class TaskService {

	public final List<Task> taskList = new ArrayList<>();
	
	public String newUniqueId() {
		return UUID.randomUUID().toString().substring(
				0, Math.min(toString().length(), 10));
	}
	
	public Task searchForTask(String id) throws Exception {
		int index = 0;
		while (index < taskList.size()) {
			if (id.equals(taskList.get(index).getTaskId())) {
				return taskList.get(index);
			}
			index++;
		}
		throw new Exception("The task doesn't exist.");
	}
	
	public void newTask() {
		Task task = new Task(newUniqueId());
		taskList.add(task);
	}
	
	public void newTask(String name) {
		Task task = new Task(newUniqueId(), name);
		taskList.add(task);
	}
	
	public void newTask(String name, String description) {
		Task task = new Task(newUniqueId(), name, description);
		taskList.add(task);
	}
	
	public void deleteTask(String id) throws Exception {
		taskList.remove(searchForTask(id));
	}
	
	public void updateName(String id, String name) throws Exception {
		searchForTask(id).setName(name);
	}
	
	public void updateDescription(String id, String description) throws Exception {
		searchForTask(id).setDescription(description);
	}
	
	public List<Task> getTaskList() {
		return taskList;
	}
}
