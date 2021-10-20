package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Appointment;

/*
 * Test the Appointment class via testing whether an appointment can be created, updated,
 * 		and deleted.
 */
public class AppointmentTest {

	public String id, description;
	public String tooLongId, tooLongDescription;
	public Date date, pastDate;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setup() {
		id = "1234567890";
		description = "The appointment description area cannot be left blank.";
		date = new Date(2030, Calendar.OCTOBER, 20);
		tooLongId = "1111222233334444555566667777888899990000";
		tooLongDescription = 
				"This description is way, way, way too long to be a description in this program.";
		pastDate = new Date(0);
	}
	
	@Test
	void testUpdateAppointmentId() {
		Appointment appointment = new Appointment();
		assertThrows(IllegalArgumentException.class,
				() -> appointment.updateAppointmentId(null));
		assertThrows(IllegalArgumentException.class,
				() -> appointment.updateAppointmentId(tooLongId));
		appointment.updateAppointmentId(id);
		assertEquals(id, appointment.getAppointmentDate());
	}
	
	@Test
	void testGetAppointmentId() {
		Appointment appointment = new Appointment(id);
		assertNotNull(appointment.getAppointmentId());
		assertEquals(appointment.getAppointmentId().length(), 10);
		assertEquals(id, appointment.getAppointmentId());
	}
	
	@Test
	void testUpdateDate() {
		Appointment appointment = new Appointment();
		assertThrows(IllegalArgumentException.class,
				() -> appointment.updateDate(null));
		assertThrows(IllegalArgumentException.class,
				() -> appointment.updateDate(pastDate));
	}
	
	@Test
	void testGetAppointmentDate() {
		Appointment appointment = new Appointment(id, date);
		assertNotNull(appointment.getAppointmentDate());
		assertEquals(date, appointment.getAppointmentDate());
	}
	
	@Test
	void testUpdateDescription() {
		Appointment appointment = new Appointment();
		assertThrows(IllegalArgumentException.class,
				() -> appointment.updateDescription(null));
		assertThrows(IllegalArgumentException.class,
				() -> appointment.updateDescription(tooLongDescription));
		appointment.updateDescription(description);
		assertEquals(description, appointment.getDescription());
	}
	
	@Test
	void testGetDescription() {
		Appointment appointment = new Appointment(id, date, description);
		assertNotNull(appointment.getDescription());
		assertTrue(appointment.getDescription().length() <= 50);
		assertEquals(description, appointment.getDescription());
	}
}
