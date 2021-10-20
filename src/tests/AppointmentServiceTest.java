package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.AppointmentService;

/*
 * Test the Appointment Service functions via creating and deleting appointments.
 */
public class AppointmentServiceTest {

	public String id, description, tooLongDescription;
	public Date date, pastDate;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setup() {
		id = "1234567890";
		description = "The description of the appointment goes here.";
		date = new Date(2030, Calendar.OCTOBER, 20);
		tooLongDescription = 
				"This description is way, way, way too long to be a description for an appointment.";
		pastDate = new Date(0);
	}
	
	@Test
	void testNewAppointment() {
		AppointmentService service = new AppointmentService();
		
		service.newAppointment();
		assertNotNull(service.getAppointmentList().get(0).getAppointmentId());
		assertNotNull(service.getAppointmentList().get(0).getAppointmentDate());
		assertNotNull(service.getAppointmentList().get(0).getDescription());
		
		service.newAppointment(date);
		assertNotNull(service.getAppointmentList().get(1).getAppointmentId());
		assertEquals(date, service.getAppointmentList().get(1).getAppointmentDate());
		assertNotNull(service.getAppointmentList().get(1).getDescription());
		
		service.newAppointment(date, description);
		assertNotNull(service.getAppointmentList().get(2).getAppointmentId());
		assertEquals(date, service.getAppointmentList().get(2).getAppointmentDate());
		assertEquals(description, service.getAppointmentList().get(2).getDescription());
		
		assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
						service.getAppointmentList().get(1).getAppointmentId());
		assertNotEquals(service.getAppointmentList().get(0).getAppointmentId(),
						service.getAppointmentList().get(2).getAppointmentId());
		assertNotEquals(service.getAppointmentList().get(1).getAppointmentId(),
						service.getAppointmentList().get(2).getAppointmentId());
		
		assertThrows(IllegalArgumentException.class,
				() -> service.newAppointment(pastDate));
		assertThrows(IllegalArgumentException.class,
				() -> service.newAppointment(date, tooLongDescription));
	}
	
	@Test
	void deleteAppointment() throws Exception {
		AppointmentService service = new AppointmentService();
		
		service.newAppointment();
		service.newAppointment();
		service.newAppointment();
		
		String firstId = service.getAppointmentList().get(0).getAppointmentId();
		String secondId = service.getAppointmentList().get(1).getAppointmentId();
		String thirdId = service.getAppointmentList().get(2).getAppointmentId();
		
		assertNotEquals(firstId, secondId);
		assertNotEquals(firstId, thirdId);
		assertNotEquals(secondId, thirdId);
		assertNotEquals(id, firstId);
		assertNotEquals(id, secondId);
		assertNotEquals(id, thirdId);
		
		assertThrows(Exception.class,
				() -> service.deleteAppointment(id));
		
		service.deleteAppointment(firstId);
		assertThrows(Exception.class,
				() -> service.deleteAppointment(firstId));
		assertNotEquals(firstId, service.getAppointmentList().get(0).getAppointmentId());
	}
}