package main;

import java.util.Date;

/*
 * Create Appointment class with Appointment objects containing different attributes.
 * 
 * Users must enter valid IDs and descriptions for each appointment.
 */
public class Appointment {

	final public byte APPOINTMENT_ID_LENGTH = 10;
	final public byte APPOINTMENT_DESCRIPTION_LENGTH = 50;
	final public String INITIALIZER = "INITIAL";
	public String appointmentId;
	public Date appointmentDate;
	public String description;
	
	public Appointment() {
		Date today = new Date();
		appointmentId = INITIALIZER;
		appointmentDate = today;
		description = INITIALIZER;
	}
	
	public Appointment(String id) {
		Date today = new Date();
		updateAppointmentId(id);
		appointmentDate = today;
		description = INITIALIZER;
	}
	
	public Appointment(String id, Date date) {
		updateAppointmentId(id);
		updateDate(date);
		description = INITIALIZER;
	}
	
	public Appointment(String id, Date date, String description) {
		updateAppointmentId(id);
		updateDate(date);
		updateDescription(description);
	}
	
	public void updateAppointmentId(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Appointment ID can't be null.");
		} else if (id.length() > APPOINTMENT_ID_LENGTH) {
			throw new IllegalArgumentException("Appointment ID can't exceed " +
					APPOINTMENT_ID_LENGTH + " characters.");
		} else {
			this.appointmentId = id;
		}
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public void updateDate(Date date) {
		if (date == null) {
			throw new IllegalArgumentException("Appointment name can't be null.");
		} else if (date.before(new Date())) {
			throw new IllegalArgumentException("Can't make appointment in the past.");
		} else {
			this.appointmentDate = date;
		}
	}
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	
	public void updateDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("Appointment description can't be null.");
		} else if (description.length() > APPOINTMENT_DESCRIPTION_LENGTH) {
			throw new IllegalArgumentException("Appointment description can't exceed " +
					APPOINTMENT_DESCRIPTION_LENGTH + " characters.");
		} else {
			this.description = description;
		}
	}
	
	public String getDescription() {
		return description;
	}
}
