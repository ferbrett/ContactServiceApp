package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Task;

public class TaskTest {

	public String id, name, description;
	public String tooLongId, tooLongName, tooLongDescription;
	
	/*
	 * Setup conditions.
	 */
	@BeforeEach
	void setup() {
		id = "1234567890";
		name = "This is Twenty Chars";
		description = "The task object must have a required description.";
		tooLongId = "111222333444555666777888999000";
		tooLongName = "This name is too long to be a task name";
		tooLongDescription = 
				"The description must not be longer than fifty characters. This description is way longer than that!";
	}
	
	/*
	 * "Get" Tests
	 */
	@Test
	void getTaskIdTest() {
		Task task = new Task(id);
		Assertions.assertEquals(id,  task.getTaskId());
	}
	
	@Test
	void getNameTest() {
		Task task = new Task(id, name);
		Assertions.assertEquals(name,  task.getName());
	}
	
	@Test 
	void getDescriptionTest() {
		Task task = new Task(id, name, description);
		Assertions.assertEquals(description, task.getDescription());
	}
	
	/*
	 * "Set" Tests
	 */
	@Test
	void setNameTest() {
		Task task = new Task();
		task.setName(name);
		Assertions.assertEquals(name, task.getName());
	}
	
	@Test
	void setDescriptionTest() {
		Task task = new Task();
		task.setDescription(description);
		Assertions.assertEquals(description, task.getDescription());
	}
	
	/*
	 * Exception Tests
	 */
	@Test
	void TaskIdTooLongTest() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()
					-> new Task(tooLongId));
	}
	
	@Test
	void setTooLongNameTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class,
				()
					-> task.setName(tooLongName));
	}
	
	@Test
	void setTooLongDescriptionTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class,
				() 
					-> task.setDescription(tooLongDescription));
	}
	
	@Test
	void TaskIdNullTest() {
		Assertions.assertThrows(IllegalArgumentException.class,
				()
					-> new Task(null));
	}
	
	@Test
	void TaskNameNullTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class,
				()
					-> task.setName(null));
	}
	
	@Test
	void TaskDescriptionNullTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class,
				() 
					-> task.setDescription(null));
	}
}
